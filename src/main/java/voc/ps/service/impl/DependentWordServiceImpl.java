package voc.ps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voc.ps.dao.DependentWordDao;
import voc.ps.model.DependentWord;
import voc.ps.service.DependentWordService;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/20/2016.
 */
@Service("dependentWordService")
public class DependentWordServiceImpl implements DependentWordService {

    @Autowired
    DependentWordDao dao;

    public void saveWord(DependentWord dependentWord) {
        dao.saveWord(dependentWord);
    }

    public void deleteWordById(int id) {
        dao.deleteWord(findById(id));
    }

    public void updateWord(DependentWord dependentWord) {
        dao.updateWord(dependentWord);
    }

    public List<DependentWord> findAllWords() {
        return dao.findAllWords();
    }

    public DependentWord findById(int id) {
        return dao.findWordById(id);
    }

    public DependentWord findByWordId(int wordId) {
        return dao.findWordByWordId(wordId);
    }
}
