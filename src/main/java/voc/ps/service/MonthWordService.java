package voc.ps.service;

import voc.ps.model.AbstractWord;
import voc.ps.model.MonthWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 10/20/2016.
 */
public interface MonthWordService {

    void addWord(MonthWord word);

    AbstractWord getMonthWordByWordId(int id);

    MonthWord getWordById(int id);

    List<AbstractWord> listWords();

    void removeWord(int id);

    void updateWord(MonthWord word);
}
