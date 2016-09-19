package voc.ps.model;

import javax.persistence.*;

/**
 * Created by pavlo.shtefanesku on 9/19/2016.
 */
@Entity
@Table
public class SimpleWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String word;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "SimpleWord{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleWord that = (SimpleWord) o;

        return word.equals(that.word);

    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}
