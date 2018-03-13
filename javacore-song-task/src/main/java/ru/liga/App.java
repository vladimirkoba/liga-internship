package ru.liga;

import ru.liga.songtask.content.Content;
import ru.liga.songtask.domain.Note;
import ru.liga.songtask.domain.NoteSign;
import ru.liga.songtask.domain.SimpleMidiFile;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Всего нот: 15
 * <p>
 * <p>
 * <p>
 * Анализ диапазона:
 * верхняя: E4
 * нижняя: F3
 * диапазон: 11
 * <p>
 * Анализ длительности нот (мс):
 * 4285: 10
 * 2144: 5
 * <p>
 * Анализ нот по высоте:
 * E4: 3
 * D4: 3
 * A3: 3
 * G3: 3
 * F3: 3
 * sort from top to bottom
 * <p>
 * Анализ интервалов:
 * 2: 9
 * 5: 3
 * 11: 2
 */
public class App {
    public static void main(String[] args) {
        SimpleMidiFile simpleMidiFile = new SimpleMidiFile(Content.ZOMBIE);
        System.out.println("Количество нот: " + simpleMidiFile.vocalNoteList().size());
        System.out.println("Длительность (сек): " + simpleMidiFile.durationMs() / 1000);
        System.out.println("**********************************");
        findRange(simpleMidiFile);
        System.out.println("**********************************");
        findDuration(simpleMidiFile);
        System.out.println("**********************************");
        analizeByHeight(simpleMidiFile);
        System.out.println("**********************************");
    }

    /** Find high and low note, and find range */
    private static void findRange(SimpleMidiFile midiFile) {
        NoteSign high = midiFile.vocalNoteList().stream().map(Note::sign).max(NoteSign::moreThanInSemitones).get();
        NoteSign low = midiFile.vocalNoteList().stream().map(Note::sign).min(NoteSign::moreThanInSemitones).get();

        System.out.println("Верхняя: " + high.getNoteName() + " " + high.getFrequencyHz() + "\n"
                + "Нижняя: " + low.getNoteName() + " " + low.getFrequencyHz() + "\n"
        + "Диапазон: " + String.valueOf(high.getMidi() - low.getMidi()));
    }

    /** analize durations of note */
    private static void findDuration(SimpleMidiFile midiFile){
        Map<Long,Integer> result = new HashMap<>();

        midiFile.vocalNoteList().forEach(note -> {
            Long duration = note.durationTicks();

            if (result.containsKey(duration))
                result.compute(duration, (aLong, integer) -> ++integer);
            else result.put(duration,0);
        });

        result.forEach((duration, num) -> {
            System.out.println(String.valueOf(duration) + ":" + String.valueOf(num));
        });
    }

    /** analize by height */
    private static void analizeByHeight(SimpleMidiFile midiFile){
        Map<String,Integer> result = new HashMap<>();
        midiFile.vocalNoteList().forEach(note -> {
            String noteName = note.sign().getNoteName();

            if (result.containsKey(noteName))
                result.compute(noteName,(key,val)-> ++val);
            else
                result.put(noteName,0);
        });

        result.forEach((name,val) ->{
            System.out.println(name + ":" + String.valueOf(val));
        });
    }
}
