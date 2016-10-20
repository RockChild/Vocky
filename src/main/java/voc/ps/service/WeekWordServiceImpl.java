package voc.ps.service;

import voc.ps.dao.TempWordDAO;
import voc.ps.model.AbstractWord;
import voc.ps.model.WeekWord;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
public class WeekWordServiceImpl implements WeekWordService {

    private TempWordDAO tempWordDAO;

    public void setTempWordDAO(TempWordDAO tempWordDAO) {
        this.tempWordDAO = tempWordDAO;
    }
    @Override
    @Transactional
    public void addWeekWord(WeekWord p) {
        tempWordDAO.addWord(p);
    }

    @Override
    @Transactional
    public void updateWeekWord(WeekWord p) {
        tempWordDAO.updateWord(p);
    }

    @Override
    @Transactional
    public List<AbstractWord> listWeekWords() {
        return tempWordDAO.listWords();
    }

    @Override
    @Transactional
    public AbstractWord getWeekWordById(int id) {
        return tempWordDAO.getWordById(id);
    }

    @Override
    @Transactional
    public void removeWeekWord(int id) {
        tempWordDAO.deleteWord(id);
    }

    @Override
    @Transactional
    public AbstractWord getWeekWordByWordId(int id) {
        for (AbstractWord weekWord:listWeekWords()) {
            if (weekWord.getWord().getId() == id) {
                return weekWord;
            }
        }
        return null;
    }
}
