package voc.ps.service;

import voc.ps.model.AbstractWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
public interface WeekWordService {
    void addWord(AbstractWord word);
    void updateWord(AbstractWord word);
    List<AbstractWord> listWords();
    AbstractWord getWordById(int id);
    void removeWord(int id);
    AbstractWord getWeekWordByWordId(int id);
}
