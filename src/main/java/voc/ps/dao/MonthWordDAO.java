package voc.ps.dao;

import voc.ps.model.AbstractWord;
import voc.ps.model.MonthWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 10/20/2016.
 */
public interface MonthWordDAO {
    void addWord(MonthWord word);
    void updateWord(MonthWord weekWord);
    List<AbstractWord> listWords();
    MonthWord getWordById(int id);
    void deleteWord(int id);
}
