package voc.ps.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import voc.ps.dao.WeekWordDAO;
import voc.ps.model.AbstractWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
@Service
public class WeekWordServiceImpl implements WeekWordService {

    private WeekWordDAO weekWordDAO;

    public void setWeekWordDAO(WeekWordDAO weekWordDAO) {
        this.weekWordDAO = weekWordDAO;
    }
    @Override
    @Transactional
    public void addWord(AbstractWord p) {
        weekWordDAO.addWord(p);
    }

    @Override
    @Transactional
    public void updateWord(AbstractWord p) {
        weekWordDAO.updateWord(p);
    }

    @Override
    @Transactional
    public List<AbstractWord> listWords() {
        return weekWordDAO.listWords();
    }

    @Override
    @Transactional
    public AbstractWord getWordById(int id) {
        return weekWordDAO.getWordById(id);
    }

    @Override
    @Transactional
    public void removeWord(int id) {
        weekWordDAO.deleteWord(id);
    }

    @Override
    @Transactional
    public AbstractWord getWeekWordByWordId(int id) {
        for (AbstractWord weekWord: listWords()) {
            if (weekWord.getWord().getId() == id) {
                return weekWord;
            }
        }
        return null;
    }
}
