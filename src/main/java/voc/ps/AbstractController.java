package voc.ps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import voc.ps.model.Word;
import voc.ps.service.MonthWordService;
import voc.ps.service.WeekWordService;
import voc.ps.service.WordService;
import voc.ps.utils.WordValidator;

/**
 * Created by pavlo.shtefanesku on 10/20/2016.
 */
public abstract class AbstractController {

    protected static final String OPENED_PAGE = "openedPage";
    protected static final WordValidator validator = new WordValidator();
    protected static final String ERROR = "error";
    protected static final String VOCABULARY = "vocabulary";
    protected static final String WORDS = "words";
    protected WeekWordService weekWordService;
    protected MonthWordService monthWordService;
    protected WordService wordService;

    @Autowired
    @Qualifier(value = "weekWordService")
    public void setWeekWordService(WeekWordService weekWordService) {
        this.weekWordService = weekWordService;
    }

    @Autowired
    @Qualifier(value = "monthWordService")
    public void setMonthWordService(MonthWordService monthWordService) {
        this.monthWordService = monthWordService;
    }

    @Autowired
    @Qualifier(value = "wordService")
    public void setWordService(WordService wordService) {
        this.wordService = wordService;
    }

    protected ModelAndView getSetupModelForVocabulary(Word word, ModelAndView modelAndView) {
        modelAndView.addObject("listWords", wordService.listWords());
        modelAndView.addObject("word", word);
        modelAndView.addObject(OPENED_PAGE, "optionVocabulary");
        return modelAndView;
    }
}
