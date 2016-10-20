package voc.ps.service;

import voc.ps.model.Word;

import java.util.List;

public interface WordService {

	void addWord(Word p);
	void updateWord(Word p);
	List<Word> listWords();
	Word getWordById(int id);
	void removeWord(int id);
	boolean wordExist(Word word);
	
}
