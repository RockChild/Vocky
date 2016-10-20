package voc.ps.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
@Entity
@Table
public class WeekWord extends AbstractWord{

    public WeekWord(){
        super();
    }

    public WeekWord(Word word) {
        super(word);
    }

    @Override
    public String toString() {
        return "WeekWord{" +
                ", id=" + getId() +
                ", word=" + getWord() +
                ", addedDate=" + getAddedDate() +
                ", shouldBeChecked=" + getShouldBeChecked() +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractWord word = (WeekWord) o;

        return getWord().equals(word.getWord());

    }

}
