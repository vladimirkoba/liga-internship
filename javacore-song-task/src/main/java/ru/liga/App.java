package ru.liga;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static ru.liga.songtask.content.Content.ZOMBIE;

/**
 * Всего нот: 15
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
 * <p>
 * Анализ интервалов:
 * 2: 9
 * 5: 3
 * 11: 2
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        List<String> simpleMidiFiles = new ArrayList<>();
        int i = 0;
        URL resource = String.class.getClass().getClassLoader().getResource("cranberries-zombie.mid");


//        logger.info("Количество нот: " + simpleMidiFile.vocalNoteList().size());
//        logger.info("Длительность (сек): " + simpleMidiFile.durationMs() / 1000);

    }
}
