package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.practicum.sleeptracker.SleepQuality.*;

public class SleepTrackerQuantityTest {
    @Test
    void sessionsQuantityCheckUp() {
        SleepingSession s1 = new SleepingSession(LocalDateTime.of(2026, 01, 01, 22, 00), LocalDateTime.of(2026, 01, 02, 07, 00), GOOD);
        SleepingSession s2 = new SleepingSession(LocalDateTime.of(2026, 02, 01, 14, 00), LocalDateTime.of(2026, 02, 02, 15, 00), GOOD);
        SleepingSession s3 = new SleepingSession(LocalDateTime.of(2026, 03, 01, 23, 00), LocalDateTime.of(2026, 03, 02, 03, 00), GOOD);
        SleepingSession s4 = new SleepingSession(LocalDateTime.of(2026, 04, 01, 22, 00), LocalDateTime.of(2026, 04, 02, 11, 00), NORMAL);

        List<SleepingSession> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);

        SessionsCounter counter1 = new SessionsCounter();
        String count1 = counter1.apply(list1);
        int value1 = Integer.parseInt(count1.replaceAll("\\D+", ""));

        assertEquals(2, value1, "Должно быть 2 сессии");

        List<SleepingSession> list2 = new ArrayList<>();
        list2.add(s1);
        list2.add(s2);
        list2.add(s3);
        list2.add(s4);

        SessionsCounter counter2 = new SessionsCounter();
        String count2 = counter2.apply(list2);
        int value2 = Integer.parseInt(count2.replaceAll("\\D+", ""));

        assertEquals(4, value2, "Должно быть 4 сессии");


    }
}
