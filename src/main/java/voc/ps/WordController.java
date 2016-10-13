package voc.ps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import voc.ps.model.Word;
import voc.ps.service.WeekWordService;
import voc.ps.service.WordService;

@Controller
public class WordController {

    private WordService wordService;
    private WeekWordService weekWordService;

    @Autowired()
    @Qualifier(value = "weekWordService")
    public void setWeekWordService(WeekWordService rs) {
        this.weekWordService = rs;
    }

    @Autowired()
    @Qualifier(value = "wordService")
    public void setWordService(WordService ps) {
        this.wordService = ps;
    }

    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = "/words", method = RequestMethod.GET)
    public String listWords(Model model) {
        final Word word = wordService.listWords().get(0);
        model.addAttribute("word", new Word());
        model.addAttribute("listWords", this.wordService.listWords());
        model.addAttribute("listWeekWords", weekWordService.listWeekWords());
        return "word";
    }

    //For add and update word both
    @RequestMapping(value = "/word/add", method = RequestMethod.POST)
    public String addWord(@ModelAttribute("word") Word p) {

        if (p.getId() == 0) {
            //new word, add it
            this.wordService.addWord(p);
        } else {
            //existing word, call update
            this.wordService.updateWord(p);
        }

        return "redirect:/words";

    }

    @RequestMapping("/remove/{id}")
    public String removeWord(@PathVariable("id") int id) {

        this.wordService.removeWord(id);
        return "redirect:/words";
    }

    @RequestMapping("/edit/{id}")
    public String editWord(@PathVariable("id") int id, Model model) {
        model.addAttribute("word", this.wordService.getWordById(id));
        model.addAttribute("listWords", this.wordService.listWords());
        return "word";
    }
}
