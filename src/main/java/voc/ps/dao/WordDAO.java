package voc.ps.dao;

import voc.ps.model.Word;

import java.util.List;

public interface WordDAO {

	void addWord(Word p);
	void updateWord(Word p);
	List<Word> listWords();
	Word getWordById(int id);
	Word getWordByWord(String wordValue);
	void removeWord(int id);
}
