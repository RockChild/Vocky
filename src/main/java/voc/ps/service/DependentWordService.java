package voc.ps.service;

import voc.ps.model.DependentWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/20/2016.
 */
public interface DependentWordService {
    void saveWord(DependentWord simpleWord);

    void deleteWordById(int id);

    void updateWord(DependentWord simpleWord);

    List<DependentWord> findAllWords();

    DependentWord findById(int id);

    DependentWord findByWordId(int wordId);

}
