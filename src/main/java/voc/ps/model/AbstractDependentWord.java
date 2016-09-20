package voc.ps.model;

import javax.persistence.*;

/**
 * Created by pavlo.shtefanesku on 9/20/2016.
 */
@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
public class AbstractDependentWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @OneToOne
    @JoinColumn(name="word_id")
    protected SimpleWord word;

    public SimpleWord getWord() {
        return word;
    }

    public void setWord(SimpleWord word) {
        this.word = word;
    }
}
