package voc.ps.dao;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.criterion.Restrictions;
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
	public void addWord(Word word) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(word);
		logger.info("Word saved successfully, Word Details="+word);
	}

	@Override
	public void updateWord(Word word) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(word);
		logger.info("Word updated successfully, Word Details="+word);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Word> listWords() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Word> wordsList = session.createQuery("from Word").list();
		for(Word word : wordsList){
			logger.info("Word List::"+word);
		}
		return wordsList;
	}

	@Override
	public Word getWordById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Word word = (Word) session.load(Word.class, new Integer(id));
			logger.info("Word loaded successfully, Word details=" + word);
			return word;
		} catch (ObjectNotFoundException e) {
			logger.warn("Word couldn't be found by id [" + id + "]");
		}
		return null;

	}

	@Override
	public Word getWordByWord(String wordValue) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Word.class);
		return (Word) criteria.add(Restrictions.eq("word", wordValue)).uniqueResult();
	}

	@Override
	public void removeWord(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Word word = (Word) session.load(Word.class, id);
		if(null != word){
			session.delete(word);
		}
		logger.info("Word deleted successfully, word details="+word);
	}

}
