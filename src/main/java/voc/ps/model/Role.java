package voc.ps.model;

import javax.persistence.*;

/**
 * Created by pavlo.shtefanesku on 9/22/2016.
 */
@Entity
@Table
public class Role {
    public Role(String name, String description, Word word) {
        this.name = name;
        this.description = description;
        this.word = word;
    }

    private String name;
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "word_id")
    private Word word;

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", word=" + word +
                '}';
    }

    public Role() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

}
