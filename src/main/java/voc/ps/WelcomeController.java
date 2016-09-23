package voc.ps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import voc.ps.model.Word;
import voc.ps.service.WordService;
import voc.ps.utils.ELanguages;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    private ModelAndView modelAndView = new ModelAndView();
    private WordService wordService;

    @Autowired
    @Qualifier(value="wordService")
    public void setWordService(WordService wordService) {
        this.wordService = wordService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        Word word = new Word();
        word.setWord("mvc simpleWord");
        wordService.addWord(word);
        logger.debug("index() is executed");
        modelAndView.setViewName("index");
        modelAndView.addObject("title", "Greetings Master");
        modelAndView.addObject("languages", ELanguages.values());
        return modelAndView;
    }


    @RequestMapping(value = "/home", method = { RequestMethod.GET, RequestMethod.POST})
    public ModelAndView home(
            @CookieValue(value = "language", defaultValue = "English") String languageCookie,
            @RequestParam(value = "languageOption", required = false) String language, HttpServletResponse response) {
        logger.debug("home() is executed");
        if (StringUtils.isEmpty(language)) {
            language = languageCookie;
        }
        Cookie cookie = new Cookie("language", language);
        response.addCookie(cookie);
        modelAndView.setViewName("home");
        modelAndView.addObject("openedPage", "optionHome");
        return modelAndView;
    }

    @RequestMapping(value = "/week")
    public ModelAndView weekWords() {
        modelAndView.setViewName("words");
        modelAndView.addObject("openedPage", "optionWeek");
        return modelAndView;
    }

    @RequestMapping(value = "/month")
    public ModelAndView monthWords() {
        modelAndView.setViewName("words");
        modelAndView.addObject("openedPage", "optionMonth");
        return modelAndView;
    }
    @RequestMapping(value = "/category")
    public ModelAndView categories() {
        modelAndView.setViewName("categories");
        modelAndView.addObject("openedPage", "optionCategory");
        return modelAndView;
    }
    @RequestMapping(value = "/add")
    public ModelAndView addWords() {
        modelAndView.setViewName("add");
        modelAndView.addObject("openedPage", "optionAdd");
        return modelAndView;
    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        logger.debug("hello() is executed");
        modelAndView.setViewName("index");
        modelAndView.addObject("title", "Greetings master");
        modelAndView.addObject("msg", "User");
        return modelAndView;
    }
}