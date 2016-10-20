package voc.ps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import voc.ps.model.Word;
import voc.ps.utils.ELanguages;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WelcomeController extends AbstractController{

    private static final String OPTION_WEEK = "optionWeek";

    private static final String OPTION_CATEGORY = "optionCategory";
    private static final String OPTION_MONTH = "optionMonth";

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);


    @RequestMapping(value = "/category")
    public ModelAndView categories() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("categories");
        modelAndView.addObject(OPENED_PAGE, OPTION_CATEGORY);
        return modelAndView;
    }



    @RequestMapping(value = "/vocabulary")
    public ModelAndView goToVocabularyPage() {
        ModelAndView modelAndView = new ModelAndView(VOCABULARY);
        return getSetupModelForVocabulary(new Word(), modelAndView);
    }

    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView home(
            @CookieValue(value = "language", defaultValue = "English") String languageCookie,
            @RequestParam(value = "languageOption", required = false) String language, HttpServletResponse response) {
        logger.debug("home() is executed");
        ModelAndView modelAndView = new ModelAndView("home");
        if (StringUtils.isEmpty(language)) {
            language = languageCookie;
        }
        Cookie cookie = new Cookie("language", language);
        response.addCookie(cookie);
        modelAndView.addObject(OPENED_PAGE, "optionHome");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        logger.debug("index() is executed");
        modelAndView.addObject("title", "Greetings Master");
        modelAndView.addObject("languages", ELanguages.values());
        return modelAndView;
    }

    @RequestMapping(value = "/month")
    public ModelAndView monthWords() {
        ModelAndView modelAndView = new ModelAndView("words");
//        checkDatesForWeekWords();
        modelAndView.addObject(OPENED_PAGE, OPTION_MONTH);
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

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public String testGetAjax(@RequestParam("text") String text) {
        System.out.println(text);
        return text;
    }

    @RequestMapping(value = "/week")
    public ModelAndView weekWords() {
        ModelAndView modelAndView = new ModelAndView("words");
//        checkDatesForWeekWords();
        modelAndView.addObject(OPENED_PAGE, OPTION_WEEK);
        modelAndView.addObject("listWords", weekWordService.listWeekWords());
        return modelAndView;
    }



//    private void checkDatesForWeekWords() {
//        Map<WeekWord, Word> weekWordToWord = new HashMap<WeekWord, Word>();
//        for (WeekWord weekWord : weekWordService.listWords()) {
//            weekWordToWord.put(weekWord, wordService.getWordById(weekWord.getWord().getId()));
//        }
//        for (WeekWord weekWord : WordValidator.checkWeekDates(weekWordToWord)) {
//            weekWordService.updateWord(weekWord);
//        }
//    }

}