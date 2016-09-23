package voc.ps.dao;

import voc.ps.model.Word;

import java.util.List;

public interface WordDAO {

	public void addWord(Word p);
	public void updateWord(Word p);
	public List<Word> listWords();
	public Word getWordById(int id);
	public void removeWord(int id);
}
