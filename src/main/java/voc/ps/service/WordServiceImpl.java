package voc.ps.service;

import java.util.List;

import voc.ps.dao.WordDAO;
import voc.ps.model.Word;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WordServiceImpl implements WordService {
	
	private WordDAO wordDAO;

	public void setWordDAO(WordDAO wordDAO) {
		this.wordDAO = wordDAO;
	}

	@Override
	@Transactional
	public void addWord(Word p) {
		this.wordDAO.addWord(p);
	}

	@Override
	@Transactional
	public void updateWord(Word p) {
		this.wordDAO.updateWord(p);
	}

	@Override
	@Transactional
	public List<Word> listWords() {
		return this.wordDAO.listWords();
	}

	@Override
	@Transactional
	public Word getWordById(int id) {
		return this.wordDAO.getWordById(id);
	}

	@Override
	@Transactional
	public void removeWord(int id) {
		this.wordDAO.removeWord(id);
	}

}
