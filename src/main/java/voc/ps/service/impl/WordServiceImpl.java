package voc.ps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import voc.ps.dao.WordDao;
import voc.ps.model.SimpleWord;
import voc.ps.service.WordService;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/19/2016.
 */
@Service("wordService")
@Transactional
public class WordServiceImpl implements WordService {

    @Autowired
    WordDao dao;


    public void saveWord(SimpleWord simpleWord) {
        dao.saveWord(simpleWord);
    }

    public List<SimpleWord> findAllWords() {
        return dao.findAllWords();
    }

    public void deleteWordById(int id) {
        dao.deleteWord(dao.findWordById(id));
    }

    public SimpleWord findById(int id) {
        return dao.findWordById(id);
    }

    public void updateWord(SimpleWord simpleWord) {
        dao.updateWord(simpleWord);
    }
}
