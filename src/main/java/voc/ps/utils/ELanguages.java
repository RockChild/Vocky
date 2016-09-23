package voc.ps.utils;

/**
 * Created by pavlo.shtefanesku on 9/12/2016.
 */
public enum ELanguages {
    ENGLISH("English"),
    POLISH("Polish");

    private String language;

    ELanguages(String language) {
        this.language = language;
    }
    @Override
    public String toString() {
        return this.language;
    }
}
