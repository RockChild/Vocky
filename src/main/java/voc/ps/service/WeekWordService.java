package voc.ps.service;

import voc.ps.model.AbstractWord;
import voc.ps.model.WeekWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
public interface WeekWordService {
    void addWeekWord(WeekWord p);
    void updateWeekWord(WeekWord p);
    List<AbstractWord> listWeekWords();
    AbstractWord getWeekWordById(int id);
    void removeWeekWord(int id);
    AbstractWord getWeekWordByWordId(int id);
}
