package voc.ps.service;

import voc.ps.dao.WeekWordDAO;
import voc.ps.model.WeekWord;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
public class WeekWordServiceImpl implements WeekWordService {

    private WeekWordDAO weekWordDAO;

    public void setWeekWordDAO(WeekWordDAO weekWordDAO) {
        this.weekWordDAO = weekWordDAO;
    }
    @Override
    @Transactional
    public void addWeekWord(WeekWord p) {
        weekWordDAO.addWeekWord(p);
    }

    @Override
    @Transactional
    public void updateWeekWord(WeekWord p) {
        weekWordDAO.updateWeekWord(p);
    }

    @Override
    @Transactional
    public List<WeekWord> listWeekWords() {
        return weekWordDAO.listWeekWords();
    }

    @Override
    @Transactional
    public WeekWord getWeekWordById(int id) {
        return weekWordDAO.getWeekWordById(id);
    }

    @Override
    @Transactional
    public void removeWeekWord(int id) {
        weekWordDAO.removeWeekWord(id);
    }
}
