package voc.ps.dao;

import voc.ps.model.AbstractWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 10/20/2016.
 */
public interface MonthWordDAO {
    void addWord(AbstractWord word);
    void updateWord(AbstractWord weekWord);
    List<AbstractWord> listWords();
    AbstractWord getWordById(int id);
    void deleteWord(int id);
}
