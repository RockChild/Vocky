package voc.ps.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by pavlo.shtefanesku on 10/17/2016.
 */
@Entity
@Table
public class MonthWord extends AbstractWord {

    public MonthWord() {
        super();
    }

    public MonthWord(Word word) {
        super(word);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractWord word = (MonthWord) o;

        return getWord().equals(word.getWord());

    }

    @Override
    public String toString() {
        return "MonthWord{" +
                ", id=" + getId() +
                ", word=" + getWord() +
                ", addedDate=" + getAddedDate() +
                ", shouldBeChecked=" + getShouldBeChecked() +
                '}';
    }
}
