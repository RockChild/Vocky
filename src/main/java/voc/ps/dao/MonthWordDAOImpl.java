package voc.ps.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import voc.ps.model.AbstractWord;
import voc.ps.model.MonthWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 10/20/2016.
 */
public class MonthWordDAOImpl implements MonthWordDAO {

    private static final Logger logger = LoggerFactory.getLogger(MonthWordDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addWord(MonthWord monthWord) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(monthWord);
        logger.info("MonthWord saved successfully, MonthWord Details="+ monthWord);
    }

    @Override
    public void updateWord(MonthWord monthWord) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(monthWord);
        logger.info("MonthWord updated successfully, MonthWord Details="+ monthWord);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AbstractWord> listWords() {
        Session session = this.sessionFactory.getCurrentSession();
        List<AbstractWord> monthWordList = session.createQuery("from MonthWord").list();
        for(AbstractWord monthWord : monthWordList){
            logger.info("Word List::"+ monthWord);
        }
        return monthWordList;
    }

    @Override
    public MonthWord getWordById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        MonthWord monthWord = (MonthWord) session.load(MonthWord.class, id);
        logger.info("MonthWord loaded successfully, MonthWord details="+ monthWord);
        return monthWord;
    }

    @Override
    public void deleteWord(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        MonthWord monthWord = (MonthWord) session.load(MonthWord.class, id);
        if(null != monthWord){
            session.delete(monthWord);
        }
        logger.info("MonthWord deleted successfully, monthWord details="+ monthWord);
    }
}
