package voc.ps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import voc.ps.model.AbstractWord;
import voc.ps.model.Word;
import voc.ps.utils.ELanguages;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@RestController
public class NavigateController extends AbstractController {

    private static final String OPTION_MONTH = "optionMonth";
    private static final String OPTION_WEEK = "optionWeek";
    private final Logger logger = LoggerFactory.getLogger(NavigateController.class);


    @RequestMapping(value = "/checkList")
    public ModelAndView check() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("checkList");
        modelAndView.addObject(OPENED_PAGE, OPTION_CHECK);
        recalculateWordsCountForCheck();
        if (weekWordsForCheck != "0") {
            modelAndView.addObject("weekWordsList", getWordsForCheck(weekWordService));
        }
        if (monthWordsForCheck != "0") {
            modelAndView.addObject("monthWordsList", getWordsForCheck(monthWordService));
        }
        return addWordsIndexesToModel(modelAndView);
    }


    @RequestMapping(value = "/vocabulary")
    public ModelAndView goToVocabularyPage() {
        ModelAndView modelAndView = new ModelAndView(VOCABULARY);
        return addWordsIndexesToModel(getSetupModelForVocabulary(new Word(), modelAndView));
    }

    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView home(
            @CookieValue(value = "language", required = false) String languageCookie,
            @RequestParam(value = "languageOption", required = false) String language, HttpServletResponse response) {
        logger.debug("home() is executed");
        ModelAndView modelAndView = new ModelAndView("home");
        if (StringUtils.isEmpty(language) && StringUtils.isEmpty(languageCookie)) {
            return getIndexModel();
        } else {
            if (StringUtils.isEmpty(languageCookie) || language != languageCookie) {
                Cookie cookie = new Cookie("language", null==language?languageCookie:language);
                response.addCookie(cookie);
            }
            recalculateWordsCountForCheck();
            modelAndView.addObject(OPENED_PAGE, "optionHome");
            return addWordsIndexesToModel(modelAndView);
        }
    }

    @RequestMapping(value = {"/", "/index", "/logout"}, method = RequestMethod.GET)
    public ModelAndView index(HttpServletResponse response) {
        Cookie cookie = new Cookie("language", "");
        response.addCookie(cookie);
        return getIndexModel();
    }

    @RequestMapping(value = "/month")
    public ModelAndView monthWords(@RequestParam(value = "languageOption", required = false) String language) {
//        checkDatesForWeekWords();
        ModelAndView modelAndView = getWordsModelAndView(OPTION_MONTH, monthWordService.listWords());
        return modelAndView;
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public
    @ResponseBody
    List<String> testGetAjax(@RequestParam("text") String text) {
        System.out.println(text);
        return Arrays.asList(text, text);
    }

    @RequestMapping(value = "/week")
    public ModelAndView weekWords() {
        ModelAndView modelAndView = getWordsModelAndView(OPTION_WEEK, weekWordService.listWords());
        return modelAndView;
    }

    private ModelAndView getIndexModel() {
        ModelAndView modelAndView = new ModelAndView("index");
        logger.debug("index() is executed");
        modelAndView.addObject("title", "Greetings Master");
        modelAndView.addObject("languages", ELanguages.values());
        return modelAndView;
    }

    private ModelAndView getWordsModelAndView(String optionMonth, List<AbstractWord> attributeValue) {
        ModelAndView modelAndView = new ModelAndView(WORDS);
        modelAndView.addObject(OPENED_PAGE, optionMonth);
        modelAndView.addObject("listWords", attributeValue);
        return addWordsIndexesToModel(modelAndView);
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