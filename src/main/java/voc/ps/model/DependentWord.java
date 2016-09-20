package voc.ps.model;

import javax.persistence.*;

/**
 * Created by pavlo.shtefanesku on 9/20/2016.
 */
@Entity
@Table
public class DependentWord extends AbstractDependentWord{

    public DependentWord() {
    }

    public SimpleWord getWord() {
        return word;
    }

    public void setWord(SimpleWord word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "DependentWord{" +
                "id=" + id +
                ", word=" + word +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DependentWord that = (DependentWord) o;

        return word.equals(that.word);

    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}
