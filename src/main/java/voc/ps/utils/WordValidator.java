package voc.ps.utils;

import org.joda.time.LocalDate;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import voc.ps.model.AbstractWord;
import voc.ps.model.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavlo.shtefanesku on 9/28/2016.
 */
public class WordValidator implements Validator {


    public static List<AbstractWord> getTempWordsForUpdateAfterDateCheck(List<AbstractWord> tempWords, int daysForLearning) {
        List<AbstractWord> resultList = new ArrayList<>();
        final LocalDate todayDate = new LocalDate();
        tempWords.stream().filter(weekWord -> !weekWord.getShouldBeChecked()).forEach(weekWord -> {
            final LocalDate checkDate = weekWord.getAddedDate().plusDays(daysForLearning);
            if (checkDate.isBefore(todayDate) || checkDate.equals(todayDate)) {
                weekWord.setShouldBeChecked(true);
                resultList.add(weekWord);
            }
        });
        return resultList;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Word.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(null==o) {
            errors.rejectValue("word", "Word is NULL");
        } else if(o instanceof Word ) {
            if (((Word) o).getWord().isEmpty()) {
                errors.rejectValue("word", "Word should have word value");
            } else if (((Word) o).getTranslation().isEmpty()) {
                errors.rejectValue("word", "Word should have translation value");
            } else if (((Word) o).getCategory().isEmpty()) {
                errors.rejectValue("word", "Word should have category value");
            }
        }
    }
}
