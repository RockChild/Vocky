package voc.ps.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import voc.ps.dao.AbsctractDao;
import voc.ps.dao.WordDao;
import voc.ps.model.SimpleWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/19/2016.
 */
@Repository("wordDao")
@Transactional
public class WordDaoImpl extends AbsctractDao implements WordDao{


    public void saveWord(SimpleWord word) {
        persist(word);
    }

    @SuppressWarnings("unchecked")
    public List<SimpleWord> findAllWords() {
        Criteria criteria = getSession().createCriteria(SimpleWord.class);
        return criteria.list();
    }

    public void deleteWord(SimpleWord word) {
        delete(word);
    }

    public SimpleWord findWordById(int id) {
        Criteria criteria = getSession().createCriteria(SimpleWord.class);
        criteria.add(Restrictions.eq("id", id));
        return (SimpleWord) criteria.uniqueResult();
    }

    public void updateWord(SimpleWord word) {
        update(word);
    }
}
