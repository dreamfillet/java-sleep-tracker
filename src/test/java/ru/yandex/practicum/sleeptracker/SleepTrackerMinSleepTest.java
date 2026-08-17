package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.practicum.sleeptracker.SleepQuality.GOOD;

public class SleepTrackerMinSleepTest {
    @Test
    void minSleepDurationInMinutesCheckUp() {
        SleepingSession s1 = new SleepingSession(LocalDateTime.of(2026, 01, 01, 22, 00), LocalDateTime.of(2026, 01, 02, 07, 00), GOOD);
        SleepingSession s2 = new SleepingSession(LocalDateTime.of(2026, 02, 01, 14, 00), LocalDateTime.of(2026, 02, 01, 15, 00), GOOD);
        SleepingSession s3 = new SleepingSession(LocalDateTime.of(2026, 03, 01, 23, 00), LocalDateTime.of(2026, 03, 02, 03, 00), GOOD);
        SleepingSession s4 = new SleepingSession(LocalDateTime.of(2026, 04, 01, 22, 00), LocalDateTime.of(2026, 04, 01, 22, 30), GOOD);

        List<SleepingSession> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);


        MinSleepDurationInMinutes minDuration1 = new MinSleepDurationInMinutes();
        String min1 = minDuration1.apply(list1);
        int minValue1 = Integer.parseInt(min1.replaceAll("\\D+", ""));

        assertEquals(60, minValue1, "Должно быть 60 минут");

        List<SleepingSession> list2 = new ArrayList<>();
        list2.add(s1);
        list2.add(s2);
        list2.add(s3);
        list2.add(s4);


        MinSleepDurationInMinutes minDuration2 = new MinSleepDurationInMinutes();
        String min2 = minDuration2.apply(list2);
        int minValue2 = Integer.parseInt(min2.replaceAll("\\D+", ""));

        assertEquals(30, minValue2, "Должно быть 30 минут");

    }
}
