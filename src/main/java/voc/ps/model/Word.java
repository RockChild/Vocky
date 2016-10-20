package voc.ps.model;

import javax.persistence.*;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 *
 * @author pankaj
 */
@Entity
@Table
public class Word {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String word;
    private String translation;
    private String category;
    private boolean inProgress;
    private boolean learned;
    @OneToOne(mappedBy = "word")
    private WeekWord weekWord;

    public Word() {
    }

    public Word(String word, String translation, String category) {

        this.word = word;
        this.translation = translation;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        if (!getWord().equals(word1.getWord())) return false;
        if (!getTranslation().equals(word1.getTranslation())) return false;
        if (isInProgress()!=word1.isInProgress()) return false;
        return getCategory().equals(word1.getCategory());

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public boolean isLearned() {
        return learned;
    }

    public void setLearned(boolean learned) {
        this.learned = learned;
    }

    @Override
    public String toString() {
        return "id=" + id + ", word=" + word + ", category=" + category +
                ", is in progress:" + inProgress + ", learned:" + learned;
    }
}
