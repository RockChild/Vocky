package voc.ps;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import voc.ps.model.AbstractWord;
import voc.ps.model.WeekWord;
import voc.ps.model.Word;
import voc.ps.service.SuperWordService;

@Controller
public class WordController extends AbstractController {


    @RequestMapping("/word/add")
    public ModelAndView addWord(@ModelAttribute("word") Word word,
                                @RequestParam(value = "addAsWeekWord", required = false) Boolean setWordAsWeekWord,
                                BindingResult result) {

        ModelAndView modelAndView = new ModelAndView(VOCABULARY);
        if (isWordValid(word, result, modelAndView)) {
            if (wordService.wordExist(word)) {
                modelAndView.addObject(ERROR,
                        String.format("The word %s already exist. Please add another one or update existing", word.getWord()));
            } else {
                wordService.addWord(word);
                if (null != setWordAsWeekWord && setWordAsWeekWord) {
                    word.setInProgress(true);
                    wordService.updateWord(word);
                    addWeekWord(word);
                }
            }
        }
        return addWordsIndexesToModel(getSetupModelForVocabulary(word, modelAndView));
    }

    @RequestMapping(value = "/word/edit")
    public ModelAndView editWord(@ModelAttribute("word") Word word,
                                 @RequestParam(value = "addAsWeekWord", required = false) Boolean setWordAsWeekWord,
                                 BindingResult result) {
        ModelAndView modelAndView = new ModelAndView(VOCABULARY);
        if (isWordValid(word, result, modelAndView)) {
            if (word.getId() > 0) {
                boolean inProgressFlag = null != setWordAsWeekWord && setWordAsWeekWord;
                word.setInProgress(inProgressFlag);
                if (word.equals(wordService.getWordById(word.getId()))) {
                    modelAndView.addObject(ERROR, String.format("Word %s already exist. No change was made.", word.getWord()));
                } else if (word.isInProgress() ^ wordService.getWordById(word.getId()).isInProgress()) {
                    if (word.isInProgress()) {
                        addWeekWord(word);
                    } else {
                        weekWordService.removeWord(weekWordService.getTempWordByWordId(word.getId()).getId());
                    }
                }
                wordService.updateWord(word);
            }
        }
        return addWordsIndexesToModel(getSetupModelForVocabulary(word, modelAndView));
    }

    @RequestMapping("/monthWord/remove/{id}")
    public String removeMonthWord(@PathVariable("id") String idText) {
        //TODO unset inProgress for Word
        removeTempWord(idText, monthWordService);
        return "redirect:/month";
    }

    @RequestMapping("/weekWord/remove/{id}")
    public String removeWeekWord(@PathVariable("id") String idText) {
        //TODO unset inProgress for Word
        removeTempWord(idText, weekWordService);
        return "redirect:/week";
    }

    @RequestMapping("/word/remove/{id}")
    public String removeWord(@PathVariable("id") String idText) {
        try {
            int id = Integer.parseInt(idText);
            AbstractWord tempWord = weekWordService.getTempWordByWordId(id);
            if (tempWord != null) {
                weekWordService.removeWord(tempWord.getId());
            }
            tempWord = monthWordService.getTempWordByWordId(id);
            if (tempWord != null) {
                monthWordService.removeWord(tempWord.getId());
            }
            if (null != wordService.getWordById(id)) {
                wordService.removeWord(id);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        recalculateWordsCountForCheck();
        return "redirect:/vocabulary";
    }

    private void addWeekWord(Word word) {
        final WeekWord weekWord = new WeekWord(word);
        weekWord.setCurrentDate();
        weekWordService.addWord(weekWord);
    }

    private boolean isWordValid(Word word, BindingResult result, ModelAndView modelAndView) {
        validator.validate(word, result);
        if (result.hasErrors()) {
            modelAndView.addObject(ERROR, "All fields are required");
            return false;
        }
        return true;
    }

    private void removeTempWord(String idText, SuperWordService tempWordService) {
        try {
            int id = Integer.parseInt(idText);
            AbstractWord abstractWord = tempWordService.getWordById(id);
            if (abstractWord != null) {
                final Word word = wordService.getWordById(abstractWord.getWord().getId());
                word.setInProgress(false);
                wordService.updateWord(word);
                tempWordService.removeWord(abstractWord.getId());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            recalculateWordsCountForCheck();
        }
    }


}
