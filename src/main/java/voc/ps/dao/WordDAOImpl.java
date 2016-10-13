package voc.ps.dao;

import voc.ps.model.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordDAOImpl implements WordDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(WordDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addWord(Word p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Word saved successfully, Word Details="+p);
	}

	@Override
	public void updateWord(Word p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Word updated successfully, Word Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Word> listWords() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Word> wordsList = session.createQuery("from Word").list();
		for(Word p : wordsList){
			logger.info("Word List::"+p);
		}
		return wordsList;
	}

	@Override
	public Word getWordById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Word p = (Word) session.load(Word.class, new Integer(id));
		logger.info("Word loaded successfully, Word details="+p);
		return p;
	}

	@Override
	public void removeWord(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Word p = (Word) session.load(Word.class, id);
		if(null != p){
			session.delete(p);
		}
		logger.info("Word deleted successfully, word details="+p);
	}

}
