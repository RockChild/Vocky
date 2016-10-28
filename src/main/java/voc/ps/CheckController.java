package voc.ps;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import voc.ps.model.AbstractWord;
import voc.ps.model.MonthWord;
import voc.ps.model.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by pavlo.shtefanesku on 10/26/2016.
 */
@Controller
public class CheckController extends AbstractController {

    @RequestMapping(value = "/checkWeekWords")
    public ModelAndView checkWeekWords() {
        return getModelForCheckForm(getWordsForCheck(weekWordService), "weekWord");
    }

    @RequestMapping(value = "/checkMonthWords")
    public ModelAndView checkMonthWords() {
        return getModelForCheckForm(getWordsForCheck(monthWordService), "monthWord");
    }

    @RequestMapping(value = "/validateWeekWord")
    public String validateWeekWord(
            @RequestParam(value = "word")String word, @RequestParam(value = "translationSelect") String translation) {
        Word word4Check = wordService.getWordByWord(word);
        if (null!=word4Check) {
            if (word4Check.getTranslation().intern().equals(translation)) {
                final AbstractWord weekWord = weekWordService.getTempWordByWordId(word4Check.getId());
                if (null!=weekWord) {
                    weekWordService.removeWord(weekWord.getId());
                    final MonthWord monthWord = new MonthWord(word4Check);
                    monthWord.setAddedDate(weekWord.getAddedDate());
                    monthWordService.addWord(monthWord);
                }
            }
        }
        return "redirect:/checkWeekWords";
    }

    @RequestMapping(value = "/validateMonthWord")
    public String validateMonthWord(
            @RequestParam(value = "word")String word, @RequestParam(value = "translationSelect") String translation) {
        Word word4Check = wordService.getWordByWord(word);
        if (null!=word4Check) {
            if (word4Check.getTranslation().intern().equals(translation)) {
                final AbstractWord monthWord = monthWordService.getTempWordByWordId(word4Check.getId());
                if (null!=monthWord) {
                    monthWordService.removeWord(monthWord.getId());
                }
                word4Check.setInProgress(false);
                word4Check.setLearned(true);
                wordService.updateWord(word4Check);
            }
        }
        return "redirect:/checkMonthWords";

    }

    private ModelAndView getModelForCheckForm(List<AbstractWord> wordsForCheck, String checkFlag) {
        ModelAndView model = new ModelAndView("checkForm");
        model.addObject(OPENED_PAGE, OPTION_CHECK);
        if (null == wordsForCheck || wordsForCheck.isEmpty()) {
            model.addObject("error", "You learned all words.");
            return addWordsIndexesToModel(model);
        } else if (!wordsForCheck.isEmpty()) {
            Collections.shuffle(wordsForCheck);
            final Word word4Check = wordsForCheck.get(0).getWord();
            model.addObject("word4Check", word4Check.getWord());
            model.addObject("translationList", getRandomTranslationsList(word4Check.getTranslation()));
        }
        model.addObject("checking", checkFlag);
        return addWordsIndexesToModel(model);
    }

    private List<String> getRandomTranslationsList(String includedTranslation) {
        List<Word> wordList = wordService.listWords();
        Collections.shuffle(wordList);

        int expectedNum = 5;
        int minIndex = 0;
        if (wordList.size() > expectedNum) {
            minIndex = ThreadLocalRandom.current().nextInt(0, wordList.size() - expectedNum);
        } else {
            expectedNum = wordList.size();
        }
        List<String> resultList = new ArrayList<>(expectedNum);
        for (int i = minIndex; expectedNum > 0; i++, expectedNum--) {
            resultList.add(wordList.get(i).getTranslation());
        }
        if (!resultList.contains(includedTranslation)) {
            resultList.set(0, includedTranslation);
        }
        Collections.shuffle(resultList);
        return resultList;
    }
}
