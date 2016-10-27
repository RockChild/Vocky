package voc.ps.service;

import voc.ps.model.AbstractWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
public interface WeekWordService extends SuperWordService {

    void addWord(AbstractWord word);

    AbstractWord getTempWordByWordId(int id);

    AbstractWord getWordById(int id);

    List<AbstractWord> listWords();

    void removeWord(int id);

    void updateWord(AbstractWord word);
}
