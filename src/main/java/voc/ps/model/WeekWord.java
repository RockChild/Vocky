package voc.ps.model;

import javax.persistence.*;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
@Entity
@Table
public class WeekWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "word_id", unique = true, nullable = false)
    private Word word;
    private Boolean shouldBeChecked;

    public WeekWord() {
    }

    public WeekWord(Word word) {
        this.word = word;
        this.shouldBeChecked = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeekWord weekWord = (WeekWord) o;

        return word.equals(weekWord.word);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getShouldBeChecked() {
        return shouldBeChecked;
    }

    public void setShouldBeChecked(Boolean shouldBeChecked) {
        this.shouldBeChecked = shouldBeChecked;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public String toString() {
        return "WeekWord{" +
                ", id=" + id +
                ", word=" + word +
                ", shouldBeChecked=" + shouldBeChecked +
                '}';
    }

}
