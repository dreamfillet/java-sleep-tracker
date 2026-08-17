package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.practicum.sleeptracker.SleepQuality.BAD;
import static ru.yandex.practicum.sleeptracker.SleepQuality.GOOD;

public class SleepTrackerSleeplessNightTest {
    @Test
    void sleeplessNightSessionsCheckUp1() {
        SleepingSession sleeplessSession1 = new SleepingSession(
                LocalDateTime.of(2026, 01, 02, 01, 00),
                LocalDateTime.of(2026, 01, 02, 04, 00),
                BAD);

        SleepingSession sleeplessSession2 = new SleepingSession(
                LocalDateTime.of(2026, 02, 01, 04, 00),
                LocalDateTime.of(2026, 02, 01, 06, 00),
                BAD);

        SleepingSession normalSession1 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 22, 00),
                LocalDateTime.of(2026, 01, 02, 07, 00),
                GOOD);

        List<SleepingSession> mixedSessions1 = new ArrayList<>();
        mixedSessions1.add(sleeplessSession1);
        mixedSessions1.add(sleeplessSession2);
        mixedSessions1.add(normalSession1);

        SleeplessNightCase sleeplessCounter = new SleeplessNightCase();
        String count1 = sleeplessCounter.apply(mixedSessions1);
        int value1 = Integer.parseInt(count1.replaceAll("\\D+", ""));


        assertEquals(2, value1, "2 бессонные ночи");
    }

    @Test
    void sleeplessNightSessionsCheckUp2() {
        SleepingSession normalSession1 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 01, 00),
                LocalDateTime.of(2026, 01, 01, 04, 01),
                BAD);

        SleepingSession sleeplessSession1 = new SleepingSession(
                LocalDateTime.of(2026, 02, 01, 04, 00),
                LocalDateTime.of(2026, 02, 01, 06, 00),
                BAD);

        SleepingSession normalSession2 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 22, 00),
                LocalDateTime.of(2026, 01, 02, 07, 00),
                GOOD);

        List<SleepingSession> mixedSessions2 = new ArrayList<>();
        mixedSessions2.add(sleeplessSession1);
        mixedSessions2.add(normalSession2);
        mixedSessions2.add(normalSession1);

        SleeplessNightCase sleeplessCounter = new SleeplessNightCase();
        String count1 = sleeplessCounter.apply(mixedSessions2);
        int value1 = Integer.parseInt(count1.replaceAll("\\D+", ""));

        assertEquals(1, value1, "1 бессонная ночи");
    }

    @Test
    void sleeplessNightSessionsCheckUp3() {
        SleeplessNightCase counter = new SleeplessNightCase();

        String result1 = counter.apply(null);
        assertEquals("Количество бессонных ночей: 0", result1, "Null список должен возвращать 'Количество бессонных ночей: 0'");

        String result2 = counter.apply(List.of());
        assertEquals("Количество бессонных ночей: 0", result2, "Пустой список должен возвращать 'Количество бессонных ночей: 0'");

        int value1 = Integer.parseInt(result1.replaceAll("\\D+", ""));
        int value2 = Integer.parseInt(result2.replaceAll("\\D+", ""));

        assertEquals(0, value1, "Null список должен возвращать 0");
        assertEquals(0, value2, "Пустой список должен возвращать 0");
    }


    @Test
    void sleeplessNightSessionsCheckUp4() {
        SleepingSession normalSession1 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 01, 00),
                LocalDateTime.of(2026, 01, 01, 05, 01),
                BAD);

        SleepingSession normalSession2 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 22, 00),
                LocalDateTime.of(2026, 01, 02, 07, 00),
                GOOD);

        List<SleepingSession> mixedSessions3 = new ArrayList<>();
        mixedSessions3.add(normalSession2);
        mixedSessions3.add(normalSession1);

        SleeplessNightCase sleeplessCounter = new SleeplessNightCase();
        String count1 = sleeplessCounter.apply(mixedSessions3);
        int value1 = Integer.parseInt(count1.replaceAll("\\D+", ""));

        assertEquals(0, value1, "нет бессонных ночей");
    }
    @Test
    void sleeplessNightSessionsCheckUp5() {

        SleepingSession crossMonthBad = new SleepingSession(
                LocalDateTime.of(2026, 1, 31, 23, 0),
                LocalDateTime.of(2026, 2, 1, 1, 0),
                GOOD
        );
        List<SleepingSession> sessions = new ArrayList<>();
        sessions.add(crossMonthBad);

        SleeplessNightCase counter = new SleeplessNightCase();


        String resultString = counter.apply(sessions); // "Количество бессонных ночей: 1"

        int result = Integer.parseInt(resultString.replaceAll("\\D+", ""));

        assertEquals(1, result, "Бессонная ночь с переходом через месяц → 1");
    }

}

