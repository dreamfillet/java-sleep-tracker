package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.practicum.sleeptracker.SleepQuality.*;
import static ru.yandex.practicum.sleeptracker.SleepingSession.setPersonType;

public class SleepTrackerAppTest {

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
        int count1 = counter1.apply(list1);

        assertEquals(2, count1, "Должно быть 2 сессии");

        List<SleepingSession> list2 = new ArrayList<>();
        list2.add(s1);
        list2.add(s2);
        list2.add(s3);
        list2.add(s4);

        SessionsCounter counter2 = new SessionsCounter();
        int count2 = counter2.apply(list2);

        assertEquals(4, count2, "Должно быть 4 сессии");


    }

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
        int min1 = minDuration1.apply(list1);

        assertEquals(60, min1, "Должно быть 60 минут");

        List<SleepingSession> list2 = new ArrayList<>();
        list2.add(s1);
        list2.add(s2);
        list2.add(s3);
        list2.add(s4);


        MinSleepDurationInMinutes minDuration2 = new MinSleepDurationInMinutes();
        int min2 = minDuration2.apply(list2);

        assertEquals(30, min2, "Должно быть 30 минут");

    }

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
        int max1 = maxDuration1.apply(list1);

        assertEquals(540, max1, "Должно быть 540 минут");

        List<SleepingSession> list2 = new ArrayList<>();
        list2.add(s1);
        list2.add(s2);
        list2.add(s3);
        list2.add(s4);


        MaxSleepDurationInMinutes maxDuration2 = new MaxSleepDurationInMinutes();
        int max2 = maxDuration2.apply(list2);

        assertEquals(540, max2, "Должно быть 540 минут");

    }

    @Test
    void averageSleepDurationInMinutesCheckUp() {
        SleepingSession s1 = new SleepingSession(LocalDateTime.of(2026, 01, 01, 22, 00), LocalDateTime.of(2026, 01, 02, 07, 00), GOOD);
        SleepingSession s2 = new SleepingSession(LocalDateTime.of(2026, 02, 01, 14, 00), LocalDateTime.of(2026, 02, 01, 15, 00), GOOD);
        SleepingSession s3 = new SleepingSession(LocalDateTime.of(2026, 03, 01, 23, 00), LocalDateTime.of(2026, 03, 02, 03, 00), GOOD);
        SleepingSession s4 = new SleepingSession(LocalDateTime.of(2026, 04, 01, 22, 00), LocalDateTime.of(2026, 04, 01, 22, 30), GOOD);

        List<SleepingSession> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);


        AverageSleepDurationInMinutes aveDuration1 = new AverageSleepDurationInMinutes();
        int average1 = aveDuration1.apply(list1);

        assertEquals(300, average1, "Должно быть 300 минут");

        List<SleepingSession> list2 = new ArrayList<>();
        list2.add(s1);
        list2.add(s2);
        list2.add(s3);
        list2.add(s4);


        AverageSleepDurationInMinutes aveDuration2 = new AverageSleepDurationInMinutes();
        int average2 = aveDuration2.apply(list2);

        assertEquals(217, average2, "Должно быть 217 минут");

    }

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
        List<SleepingSession> counter = badCounter.apply(mixedSessions1);
        int badSessionsPrint = counter.size();

        assertEquals(2, badSessionsPrint, "2 сессии с плохим сном");
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
        List<SleepingSession> counterr = badCounterr.apply(mixedSessions2);
        int badSessionsPrintt = counterr.size();

        assertEquals(3, badSessionsPrintt, "3 сессии с плохим сном");
    }

    @Test
    void sleeplessNightSessionsCheckUp1() {
        //test1
        SleepingSession sleeplessSession1 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 01, 00),
                LocalDateTime.of(2026, 01, 01, 04, 00),
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
        Integer counter = sleeplessCounter.apply(mixedSessions1);

        assertEquals(2, counter, "2 бессонные ночи");
    }

    @Test
    void sleeplessNightSessionsCheckUp2() {
        //test1
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

        List<SleepingSession> mixedSessions1 = new ArrayList<>();
        mixedSessions1.add(sleeplessSession1);
        mixedSessions1.add(normalSession2);
        mixedSessions1.add(normalSession1);

        SleeplessNightCase sleeplessCounter = new SleeplessNightCase();
        Integer counter = sleeplessCounter.apply(mixedSessions1);

        assertEquals(1, counter, "1 бессонная ночи");
    }

    @Test
    void sleeplessNightSessionsCheckUp3() {
        SleeplessNightCase counter = new SleeplessNightCase();

        assertEquals(0, counter.apply(null), "Null список должен возвращать 0");
        assertEquals(0, counter.apply(List.of()), "Пустой список должен возвращать 0");
    }

    @Test
    void sleeplessNightSessionsCheckUp4() {
        //test1
        SleepingSession normalSession1 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 01, 00),
                LocalDateTime.of(2026, 01, 01, 05, 01),
                BAD);

        SleepingSession normalSession2 = new SleepingSession(
                LocalDateTime.of(2026, 01, 01, 22, 00),
                LocalDateTime.of(2026, 01, 02, 07, 00),
                GOOD);

        List<SleepingSession> mixedSessions1 = new ArrayList<>();
        mixedSessions1.add(normalSession2);
        mixedSessions1.add(normalSession1);

        SleeplessNightCase sleeplessCounter = new SleeplessNightCase();
        Integer counter = sleeplessCounter.apply(mixedSessions1);

        assertEquals(0, counter, "нет бессонных ночей");
    }

    @Test
    void personTypesCheckUp() {
        SleepingSession owlSession = new SleepingSession(LocalDateTime.of(2026, 01, 01, 23, 05), LocalDateTime.of(2026, 01, 02, 10, 05), GOOD);
        SleepingSession earlyBirdSession = new SleepingSession(LocalDateTime.of(2026, 01, 01, 21, 00), LocalDateTime.of(2026, 01, 02, 06, 30), GOOD);
        SleepingSession pigeonSession = new SleepingSession(LocalDateTime.of(2026, 01, 01, 22, 00), LocalDateTime.of(2026, 01, 02, 04, 00), GOOD);

        List<SleepingSession> list1 = new ArrayList<>();
        list1.add(owlSession);
        list1.add(earlyBirdSession);
        list1.add(pigeonSession);

        String owlType = setPersonType(owlSession);
        String earlyBirdType = setPersonType(earlyBirdSession);
        String pigeonType = setPersonType(pigeonSession);

        assertEquals("Сова", owlType);
        assertEquals("Жаворонок", earlyBirdType);
        assertEquals("Голубь", pigeonType);
    }
}