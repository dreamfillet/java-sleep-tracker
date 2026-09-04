package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.practicum.sleeptracker.SleepQuality.BAD;
import static ru.yandex.practicum.sleeptracker.SleepQuality.GOOD;

public class SleepTrackerBadSleepTest {
    @Test
    void badSleepQualitySessionsCheckUp() {
        //test1
        SleepingSession badSession1 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 22, 00),
                LocalDateTime.of(2026, 01, 01, 22, 00),
                BAD);

        SleepingSession badSession2 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 10, 00),
                LocalDateTime.of(2026, 01, 01, 11, 00),
                BAD);

        SleepingSession goodSession1 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 18, 00),
                LocalDateTime.of(2026, 01, 02, 06, 00),
                GOOD);

        List<SleepingSession> mixedSessions1 = new ArrayList<>();
        mixedSessions1.add(badSession1);
        mixedSessions1.add(badSession2);
        mixedSessions1.add(goodSession1);


        BadSleepQualitySessions badCounter = new BadSleepQualitySessions();
        String counter = badCounter.apply(mixedSessions1);
        int badSessionsPrint = Integer.parseInt(counter.replaceAll("\\D+", ""));

        assertEquals(2, badSessionsPrint, "Должно быть 2 сессии с плохим сном");

//test2
        SleepingSession badSession3 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 22, 00),
                LocalDateTime.of(2026, 01, 01, 22, 00),
                BAD);

        SleepingSession badSession4 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 10, 00),
                LocalDateTime.of(2026, 01, 01, 11, 00),
                BAD);

        SleepingSession badSession5 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 10, 00),
                LocalDateTime.of(2026, 01, 01, 11, 00),
                BAD);

        SleepingSession goodSession2 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 18, 00),
                LocalDateTime.of(2026, 01, 02, 06, 00),
                GOOD);

        SleepingSession goodSession3 = new SleepingSession(
                LocalDateTime.of(2026, 02, 01, 18, 00),
                LocalDateTime.of(2026, 02, 02, 06, 00),
                GOOD);

        List<SleepingSession> mixedSessions2 = new ArrayList<>();
        mixedSessions2.add(badSession3);
        mixedSessions2.add(badSession4);
        mixedSessions2.add(badSession5);
        mixedSessions2.add(goodSession2);
        mixedSessions2.add(goodSession3);


        BadSleepQualitySessions badCounterr = new BadSleepQualitySessions();
        String counterr = badCounterr.apply(mixedSessions2);
        int badSessionsPrint2 = Integer.parseInt(counterr.replaceAll("\\D+", ""));

        assertEquals(3, badSessionsPrint2, "Должно быть 3 сессии с плохим сном");
    }
}
