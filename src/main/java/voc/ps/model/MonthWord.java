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

    @Override
    public int hashCode() {
        int hash = 13 * (this.getWord().getWord().isEmpty()?32:this.getWord().getWord().hashCode());
        hash = hash + (null==this.getAddedDate()?13:getAddedDate().hashCode())*13;
        hash = hash + getId()*13;
        hash = hash + getShouldBeChecked().hashCode()*13;

        return hash;
    }

}
