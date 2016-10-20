package voc.ps.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import voc.ps.model.AbstractWord;
import voc.ps.model.WeekWord;

import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
public class WeekWordDAOImpl implements WeekWordDAO {

    private static final Logger logger = LoggerFactory.getLogger(WeekWordDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addWord(AbstractWord weekWord) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(weekWord);
        logger.info("WeekWord saved successfully, WeekWord Details="+ weekWord);
    }

    @Override
    public void updateWord(AbstractWord weekWord) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(weekWord);
        logger.info("WeekWord updated successfully, WeekWord Details="+ weekWord);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AbstractWord> listWords() {
        Session session = this.sessionFactory.getCurrentSession();
        List<AbstractWord> weekWordList = session.createQuery("from WeekWord").list();
        for(AbstractWord weekWord : weekWordList){
            logger.info("Word List::"+ weekWord);
        }
        return weekWordList;
    }

    @Override
    public WeekWord getWordById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        WeekWord weekWord = (WeekWord) session.load(WeekWord.class, id);
        logger.info("WeekWord loaded successfully, WeekWord details="+ weekWord);
        return weekWord;
    }

    @Override
    public void deleteWord(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        WeekWord weekWord = (WeekWord) session.load(WeekWord.class, id);
        if(null != weekWord){
            session.delete(weekWord);
        }
        logger.info("WeekWord deleted successfully, weekWord details="+ weekWord);
    }
}
