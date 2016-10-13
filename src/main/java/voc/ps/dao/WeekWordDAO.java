package voc.ps.dao;
import voc.ps.model.WeekWord;


import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
public interface WeekWordDAO {
    void addWeekWord(WeekWord weekWord);
    void updateWeekWord(WeekWord weekWord);
    List<WeekWord> listWeekWords();
    WeekWord getWeekWordById(int id);
    void removeWeekWord(int id);
}
