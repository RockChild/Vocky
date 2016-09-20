package voc.ps.dao;

import voc.ps.model.DependentWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/20/2016.
 */
public interface DependentWordDao {
    void saveWord(DependentWord word);

    List<DependentWord> findAllWords();

    void deleteWord(DependentWord word);

    DependentWord findWordById(int id);

    DependentWord findWordByWordId(int wordId);

    void updateWord(DependentWord word);}
