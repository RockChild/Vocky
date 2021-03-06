package voc.ps.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import voc.ps.dao.MonthWordDAO;
import voc.ps.model.AbstractWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 10/20/2016.
 */
@Service
public class MonthWordServiceImpl implements MonthWordService{

    private MonthWordDAO monthWordDAO;

    public void setMonthWordDAO(MonthWordDAO monthWordDAO) {
        this.monthWordDAO = monthWordDAO;
    }

    @Override
    @Transactional
    public void addWord(AbstractWord word) {
        monthWordDAO.addWord(word);
    }

    @Override
    @Transactional
    public void updateWord(AbstractWord word) {
        monthWordDAO.updateWord(word);
    }

    @Override
    @Transactional
    public List<AbstractWord> listWords() {
        return monthWordDAO.listWords();
    }

    @Override
    @Transactional
    public AbstractWord getWordById(int id) {
        return monthWordDAO.getWordById(id);
    }

    @Override
    @Transactional
    public void removeWord(int id) {
        monthWordDAO.deleteWord(id);
    }

    @Override
    @Transactional
    public AbstractWord getTempWordByWordId(int id) {
        for (AbstractWord word: listWords()) {
            if (word.getWord().getId() == id) {
                return word;
            }
        }
        return null;
    }
}
