package voc.ps.utils;

import org.joda.time.LocalDate;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import voc.ps.model.WeekWord;
import voc.ps.model.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by pavlo.shtefanesku on 9/28/2016.
 */
public class WordValidator implements Validator {


    public static List<WeekWord> checkWeekDates(Map<WeekWord, Word> weekWordToWordMap) {
        List<WeekWord> resultList = new ArrayList<WeekWord>();
        for(Map.Entry<WeekWord, Word> weekWordToWord : weekWordToWordMap.entrySet()) {
            final LocalDate addedDate = weekWordToWord.getValue().getAddedDate();
            if(null!=addedDate&&(!weekWordToWord.getKey().getShouldBeChecked())) {
                final LocalDate edgeDate = new LocalDate().minusDays(7);
                if (edgeDate.isAfter(addedDate) || edgeDate.equals(addedDate)) {
                    weekWordToWord.getKey().setShouldBeChecked(true);
                    resultList.add(weekWordToWord.getKey());
                }
            }
        }
        return resultList;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Word.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(o instanceof Word ) {
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
