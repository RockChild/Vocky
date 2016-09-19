package voc.ps.dao;

import voc.ps.model.SimpleWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/19/2016.
 */
public interface WordDao {
    void saveWord(SimpleWord word);

    List<SimpleWord> findAllWords();

    void deleteWord(SimpleWord word);

    SimpleWord findWordById(int id);

    void updateWord(SimpleWord word);
}
