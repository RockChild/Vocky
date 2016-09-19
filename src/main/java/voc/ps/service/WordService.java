package voc.ps.service;

import voc.ps.model.SimpleWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/19/2016.
 */
public interface WordService {
    void saveWord(SimpleWord simpleWord);

    List<SimpleWord> findAllWords();

    void deleteWordById(int id);

    SimpleWord findById(int id);

    void updateWord(SimpleWord simpleWord);
}
