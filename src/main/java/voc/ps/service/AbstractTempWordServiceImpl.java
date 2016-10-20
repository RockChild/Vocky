package voc.ps.service;

import voc.ps.model.AbstractWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 10/20/2016.
 */
public abstract class AbstractTempWordServiceImpl {
    abstract void addWord(AbstractWord word);

    abstract AbstractWord getMonthWordByWordId(int id);

    abstract AbstractWord getWordById(int id);

    abstract List<AbstractWord> listWords();

    abstract void removeWord(int id);

    abstract void updateWord(AbstractWord word);
}
