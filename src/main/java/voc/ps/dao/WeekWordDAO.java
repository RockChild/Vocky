package voc.ps.dao;
import voc.ps.model.AbstractWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
public interface WeekWordDAO {
    void addWord(AbstractWord word);
    void updateWord(AbstractWord weekWord);
    List<AbstractWord> listWords();
    AbstractWord getWordById(int id);
    void deleteWord(int id);
}
