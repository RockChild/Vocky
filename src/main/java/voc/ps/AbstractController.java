package voc.ps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import voc.ps.model.AbstractWord;
import voc.ps.model.Word;
import voc.ps.service.MonthWordService;
import voc.ps.service.SuperWordService;
import voc.ps.service.WeekWordService;
import voc.ps.service.WordService;
import voc.ps.utils.WordValidator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pavlo.shtefanesku on 10/20/2016.
 */
public abstract class AbstractController {

    protected static final String ERROR = "error";
    protected static final String OPENED_PAGE = "openedPage";
    protected static final String OPTION_CHECK = "optionCheck";
    protected static final String VOCABULARY = "vocabulary";
    protected static final String WORDS = "words";
    protected static final WordValidator validator = new WordValidator();
    protected static String monthWordsForCheck = "0";
    protected static String weekWordsForCheck = "0";
    protected WeekWordService weekWordService;
    protected MonthWordService monthWordService;
    protected WordService wordService;

    @Autowired
    @Qualifier(value = "monthWordService")
    public void setMonthWordService(MonthWordService monthWordService) {
        this.monthWordService = monthWordService;
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

    protected ModelAndView addWordsIndexesToModel(ModelAndView model) {
        model.addObject("weekNum4Check", weekWordsForCheck);
        model.addObject("monthNum4Check", monthWordsForCheck);
        return model;
    }

    protected ModelAndView getSetupModelForVocabulary(Word word, ModelAndView modelAndView) {
        modelAndView.addObject("listWords", wordService.listWords());
        modelAndView.addObject("word", word);
        modelAndView.addObject(OPENED_PAGE, "optionVocabulary");
        return modelAndView;
    }

    protected int getTempWordsForCheckNum(SuperWordService service) {
        return getWordsForCheck(service).size();
    }

    protected List<AbstractWord> getWordsForCheck(SuperWordService service) {
        return service.listWords().stream().filter(AbstractWord::getShouldBeChecked).collect(Collectors.toList());
    }

    protected void recalculateWordsCountForCheck() {
        weekWordsForCheck = String.valueOf(getTempWordsForCheckNum(weekWordService));
        monthWordsForCheck = String.valueOf(getTempWordsForCheckNum(monthWordService));
    }
}
