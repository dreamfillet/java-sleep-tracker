package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.practicum.sleeptracker.SleepQuality.GOOD;

public class SleepTrackerMaxSleepTest {
    @Test
    void maxSleepDurationInMinutesCheckUp() {
        SleepingSession s1 = new SleepingSession(LocalDateTime.of(2026, 01, 01, 22, 00), LocalDateTime.of(2026, 01, 02, 07, 00), GOOD);
        SleepingSession s2 = new SleepingSession(LocalDateTime.of(2026, 02, 01, 14, 00), LocalDateTime.of(2026, 02, 01, 15, 00), GOOD);
        SleepingSession s3 = new SleepingSession(LocalDateTime.of(2026, 03, 01, 23, 00), LocalDateTime.of(2026, 03, 02, 03, 00), GOOD);
        SleepingSession s4 = new SleepingSession(LocalDateTime.of(2026, 04, 01, 22, 00), LocalDateTime.of(2026, 04, 01, 22, 30), GOOD);

        List<SleepingSession> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);


        MaxSleepDurationInMinutes maxDuration1 = new MaxSleepDurationInMinutes();
        String max1 = maxDuration1.apply(list1);
        int maxValue1 = Integer.parseInt(max1.replaceAll("\\D+", ""));

        assertEquals(540, maxValue1, "Максимальная длительность должна быть 540 минут");

        List<SleepingSession> list2 = new ArrayList<>();
        list2.add(s1);
        list2.add(s2);
        list2.add(s3);
        list2.add(s4);


        MaxSleepDurationInMinutes maxDuration2 = new MaxSleepDurationInMinutes();
        String max2 = maxDuration2.apply(list1);

        // Извлекаем число из строки
        int maxValue2 = Integer.parseInt(max2.replaceAll("\\D+", ""));

        assertEquals(540, maxValue2, "Максимальная длительность должна быть 540 минут");


    }
}
