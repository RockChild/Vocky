package voc.ps.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import voc.ps.dao.AbsctractDao;
import voc.ps.dao.DependentWordDao;
import voc.ps.model.DependentWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/20/2016.
 */
@Repository("dependentWord")
@Transactional
public class DependentWordDaoImpl extends AbsctractDao implements DependentWordDao {
    public void saveWord(DependentWord word) {
        persist(word);
    }

    public void deleteWord(DependentWord word) {
        delete(word);
    }

    public List<DependentWord> findAllWords() {
        Criteria criteria = getSession().createCriteria(DependentWord.class);
        return criteria.list();
    }

    public DependentWord findWordById(int id) {
        Criteria criteria = getSession().createCriteria(DependentWord.class);
        criteria.add(Restrictions.eq("id", id));
        return (DependentWord) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public DependentWord findWordByWordId(int wordId) {
        Criteria criteria = getSession().createCriteria(DependentWord.class);
        criteria.add(Restrictions.eq("wordId", wordId));
        return (DependentWord) criteria.uniqueResult();
    }

    public void updateWord(DependentWord word) {
        update(word);
    }
}
