package voc.ps.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;

/**
 * Created by pavlo.shtefanesku on 10/17/2016.
 */
@MappedSuperclass
public class AbstractWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "word_id", unique = true, nullable = false)
    private Word word;
    private Boolean shouldBeChecked;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate addedDate;

    public AbstractWord(Word word) {
        this.word = word;
        this.shouldBeChecked = false;
    }

    public AbstractWord() {
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
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

    public void setCurrentDate() {
        this.addedDate = new LocalDate();
    }
}
