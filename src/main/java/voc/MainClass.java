package voc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import voc.ps.configuration.AppConfig;
import voc.ps.model.DependentWord;
import voc.ps.model.SimpleWord;
import voc.ps.service.DependentWordService;
import voc.ps.service.WordService;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/19/2016.
 */
public class MainClass {

    public static void main( String[] args )
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        WordService ws = (WordService) context.getBean("wordService");
        DependentWordService dws = (DependentWordService) context.getBean("dependentWordService");

        //save
        SimpleWord word1 = new SimpleWord();
        word1.setWord("1st word");
        ws.saveWord(word1);
        //save
        SimpleWord word2 = new SimpleWord();
        word2.setWord("2nd word");
        ws.saveWord(word2);
        //save
        SimpleWord word3 = new SimpleWord();
        word3.setWord("3d word");
        ws.saveWord(word3);
        //all
        List<SimpleWord> allSimpleWords = ws.findAllWords();
        System.out.println(allSimpleWords);

        //update & findById
        SimpleWord wordX = ws.findById(allSimpleWords.get(0).getId());
        wordX.setWord("the very first word");
        ws.updateWord(wordX);

        //dependentWord - save
        DependentWord dependentWord1 = new DependentWord();
        dependentWord1.setWord(wordX);
        dws.saveWord(dependentWord1);
        //save
        DependentWord dependentWord2 = new DependentWord();
        dependentWord2.setWord(ws.findAllWords().get(2));
        dws.saveWord(dependentWord2);

        //list all
        System.out.println(dws.findAllWords());

        ws.deleteWordById(allSimpleWords.get(1).getId());
        allSimpleWords = ws.findAllWords();
        System.out.println(allSimpleWords);
        context.close();
    }
}
