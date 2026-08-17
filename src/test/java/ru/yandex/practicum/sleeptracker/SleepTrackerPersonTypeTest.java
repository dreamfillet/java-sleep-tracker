package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.practicum.sleeptracker.SleepQuality.GOOD;

public class SleepTrackerPersonTypeTest {
    @Test
    void personTypesCheckUp() {
        SleepingSession owlSession = new SleepingSession(LocalDateTime.of(2026, 01, 01, 23, 05), LocalDateTime.of(2026, 01, 02, 10, 05), GOOD);
        SleepingSession earlyBirdSession = new SleepingSession(LocalDateTime.of(2026, 01, 01, 21, 00), LocalDateTime.of(2026, 01, 02, 06, 30), GOOD);
        SleepingSession pigeonSession = new SleepingSession(LocalDateTime.of(2026, 01, 01, 22, 00), LocalDateTime.of(2026, 01, 02, 04, 00), GOOD);

        List<SleepingSession> list1 = new ArrayList<>();
        list1.add(owlSession);
        list1.add(earlyBirdSession);
        list1.add(pigeonSession);

        String owlType = SleepingSession.setPersonType(owlSession).name();
        String earlyBirdType = SleepingSession.setPersonType(earlyBirdSession).name();
        String pigeonType = SleepingSession.setPersonType(pigeonSession).name();

        assertEquals("Сова", owlType, "Должен быть хронотип 'Сова'");
        assertEquals("Жаворонок", earlyBirdType, "Должен быть хронотип 'Жаворонок'");
        assertEquals("Голубь", pigeonType, "Должен быть хронотип 'Голубь'");
    }

    @Test
    void personTypesCheckUp2() {
        SleepingSession session1 = new SleepingSession(LocalDateTime.of(2026, 01, 01, 22, 05), LocalDateTime.of(2026, 01, 02, 10, 05), GOOD);
        SleepingSession session2 = new SleepingSession(LocalDateTime.of(2026, 01, 01, 21, 00), LocalDateTime.of(2026, 01, 02, 07, 30), GOOD);
        SleepingSession session3 = new SleepingSession(LocalDateTime.of(2026, 01, 01, 22, 00), LocalDateTime.of(2026, 01, 02, 04, 00), GOOD);

        List<SleepingSession> list1 = new ArrayList<>();
        list1.add(session1);
        list1.add(session2);
        list1.add(session3);

        String type1 = SleepingSession.setPersonType(session1).name();
        String type2 = SleepingSession.setPersonType(session2).name();
        String type3 = SleepingSession.setPersonType(session3).name();

        assertEquals("Голубь", type1, "Должен быть хронотип 'Голубь'");
        assertEquals("Голубь", type2, "Должен быть хронотип 'Голубь'");
        assertEquals("Голубь", type3, "Должен быть хронотип 'Голубь'");
    }
}
