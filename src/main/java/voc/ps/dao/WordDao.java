package voc.ps.dao;

import voc.ps.model.Word;

import java.util.List;

public interface WordDAO {

	void addWord(Word p);
	void updateWord(Word p);
	List<Word> listWords();
	Word getWordById(int id);
	void removeWord(int id);
}
