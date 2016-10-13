package voc.ps.service;

import voc.ps.model.WeekWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
public interface WeekWordService {
    void addWeekWord(WeekWord p);
    void updateWeekWord(WeekWord p);
    List<WeekWord> listWeekWords();
    WeekWord getWeekWordById(int id);
    void removeWeekWord(int id);
}
