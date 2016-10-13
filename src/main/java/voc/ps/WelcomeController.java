package voc.ps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import voc.ps.model.WeekWord;
import voc.ps.model.Word;
import voc.ps.service.WeekWordService;
import voc.ps.service.WordService;
import voc.ps.utils.ELanguages;
import voc.ps.utils.WordValidator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WelcomeController {

    private final static String OPTION_WEEK = "optionWeek";
    private final static String OPENED_PAGE = "openedPage";
    private final static String OPTION_CATEGORY = "optionCategory";
    private final static String OPTION_MONTH = "optionMonth";
    private final static WordValidator validator = new WordValidator();
    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    private ModelAndView modelAndView = new ModelAndView();
    private WordService wordService;
    private WeekWordService weekWordService;

    @RequestMapping(value = "/addWord")
    public ModelAndView addNewWord(
//            @RequestParam(value = "word") String word,
//            @RequestParam(value = "translation") String translation,
//            @RequestParam(value = "category") String category,
            @ModelAttribute("word") Word wordModel,
            @RequestParam(value = "addNew", required = false) Boolean addnew,
            @RequestParam(value = "addAsWeekWord", required = false) Boolean setWordAsWeekWord,
            BindingResult result) {
        if(null==wordModel) {
            wordModel = new Word("some word", "wome translation", "category" );
        }
        validator.validate(wordModel, result);
        if (result.hasErrors()) {
            setAddModel();
            modelAndView.addObject("error", "You missed some field to fill");
            return modelAndView;
        }
        if (wordService.doesWordExist(wordModel)) {
            setAddModel();
            modelAndView.addObject("error",
                    String.format("The word %s already exist. Please add another one or update existing", wordModel.getWord()));
            return modelAndView;
        } else {
            wordService.addWord(wordModel);
            if(null!=setWordAsWeekWord && setWordAsWeekWord) {
                wordModel.setCurrentDate();
                wordService.updateWord(wordModel);
                weekWordService.addWeekWord(new WeekWord(wordModel));
            }
        }
        if (null != addnew && addnew) {
            setAddModel();
        } else {
            setWordsModel(OPTION_WEEK);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/category")
    public ModelAndView categories() {
        modelAndView.setViewName("categories");
        modelAndView.addObject(OPENED_PAGE, OPTION_CATEGORY);
        return modelAndView;
    }

    @RequestMapping(value = "/add")
    public ModelAndView goToAddWords() {
        setAddModel();
        return modelAndView;
    }

//    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
//    public ModelAndView hello(@PathVariable("name") String name) {
//        logger.debug("hello() is executed");
//        modelAndView.setViewName("index");
//        modelAndView.addObject("title", "Greetings master");
//        modelAndView.addObject("msg", "User");
//        return modelAndView;
//    }

    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView home(
            @CookieValue(value = "language", defaultValue = "English") String languageCookie,
            @RequestParam(value = "languageOption", required = false) String language, HttpServletResponse response) {
        logger.debug("home() is executed");
        if (StringUtils.isEmpty(language)) {
            language = languageCookie;
        }
        Cookie cookie = new Cookie("language", language);
        response.addCookie(cookie);
        setHomeModel();
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        logger.debug("index() is executed");
        modelAndView.setViewName("index");
        modelAndView.addObject("title", "Greetings Master");
        modelAndView.addObject("languages", ELanguages.values());
        return modelAndView;
    }

    @RequestMapping(value = "/month")
    public ModelAndView monthWords() {
        setWordsModel(OPTION_MONTH);
        return modelAndView;
    }

    @Autowired
    @Qualifier(value = "weekWordService")
    public void setWeekWordService(WeekWordService weekWordService) {
        this.weekWordService = weekWordService;
    }

    @Autowired
    @Qualifier(value = "wordService")
    public void setWordService(WordService wordService) {
        this.wordService = wordService;
    }

    @RequestMapping(value = "/week")
    public ModelAndView weekWords() {
        setWordsModel(OPTION_WEEK);
        modelAndView.addObject("listWords", weekWordService.listWeekWords());
        return modelAndView;
    }

    private void setAddModel() {
        modelAndView.setViewName("add");
        modelAndView.addObject(OPENED_PAGE, "optionAdd");
    }

    private void setHomeModel() {
        modelAndView.setViewName("home");
        modelAndView.addObject(OPENED_PAGE, "optionHome");
    }

    private void setWordsModel(String activeOption) {
        checkDatesForWeekWords();
        modelAndView.setViewName("words");
        modelAndView.addObject(OPENED_PAGE, activeOption);
    }

    private void checkDatesForWeekWords() {
        Map<WeekWord, Word> weekWordToWord = new HashMap<WeekWord, Word>();
        for(WeekWord weekWord : weekWordService.listWeekWords()) {
            weekWordToWord.put(weekWord, wordService.getWordById(weekWord.getWord().getId()));
        }
        for(WeekWord weekWord : WordValidator.checkWeekDates(weekWordToWord)) {
            weekWordService.updateWeekWord(weekWord);
        }
    }
}