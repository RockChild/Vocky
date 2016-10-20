package voc.ps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import voc.ps.model.AbstractWord;
import voc.ps.model.MonthWord;
import voc.ps.model.WeekWord;
import voc.ps.model.Word;

@Controller
public class WordController extends AbstractController{


    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = "/words", method = RequestMethod.GET)
    public String listWords(Model model) {
        final Word word = wordService.listWords().get(0);
        model.addAttribute("word", new Word());
        model.addAttribute("listWords", this.wordService.listWords());
        model.addAttribute("listWords", weekWordService.listWords());
        return "word";
    }

    //For add and update word both
    @RequestMapping(value = "/word/addd", method = RequestMethod.POST)
    public String addWordOld(@ModelAttribute("word") Word p) {

        if (p.getId() == 0) {
            //new word, add it
            this.wordService.addWord(p);
        } else {
            //existing word, call update
            this.wordService.updateWord(p);
        }

        return "redirect:/words";

    }

    @RequestMapping("/edit/{id}")
    public String editWordOld(@PathVariable("id") int id, Model model) {
        model.addAttribute("word", wordService.getWordById(id));
        model.addAttribute("listWords", wordService.listWords());
        return "vocabulary";
    }

    @RequestMapping("/fucking/bullshit")
    public ModelAndView fuck() {
        ModelAndView modelAndView = new ModelAndView(VOCABULARY);
        return modelAndView;
    }

    @RequestMapping("/word/add")
    public ModelAndView fuck(@ModelAttribute("word") Word word,
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
        return getSetupModelForVocabulary(word, modelAndView);
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
                        weekWordService.removeWord(weekWordService.getWeekWordByWordId(word.getId()).getId());
                    }
                }
                wordService.updateWord(word);
            }
        }
        return getSetupModelForVocabulary(word, modelAndView);
    }

    @RequestMapping("/word/remove/{id}")
    public String removeWord(@PathVariable("id") String  idText) {
        try {
            int id = Integer.parseInt(idText);
            AbstractWord weekWord = weekWordService.getWeekWordByWordId(id);
            if (weekWord != null) {
                weekWordService.removeWord(weekWord.getId());
            }
            if (null!=wordService.getWordById(id)) {
                wordService.removeWord(id);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "redirect:/vocabulary";
    }

    private void addWeekWord(Word word) {
        final WeekWord weekWord = new WeekWord(word);
        weekWord.setCurrentDate();
        weekWordService.addWord(weekWord);

        final MonthWord monthWord = new MonthWord(word);
        monthWord.setCurrentDate();
        monthWordService.addWord(monthWord);

    }

    private boolean isWordValid(Word word, BindingResult result, ModelAndView modelAndView) {
        validator.validate(word, result);
        if (result.hasErrors()) {
            modelAndView.addObject(ERROR, "All fields are required");
            return false;
        }
        return true;
    }


}
