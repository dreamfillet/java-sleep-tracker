package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.practicum.sleeptracker.SleepQuality.GOOD;
import static ru.yandex.practicum.sleeptracker.SleepingSession.setPersonType;

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
        SleepingSession Session1 = new SleepingSession(LocalDateTime.of(2026, 01, 01, 22, 05), LocalDateTime.of(2026, 01, 02, 10, 05), GOOD);
        SleepingSession Session2 = new SleepingSession(LocalDateTime.of(2026, 01, 01, 21, 00), LocalDateTime.of(2026, 01, 02, 07, 30), GOOD);
        SleepingSession Session3 = new SleepingSession(LocalDateTime.of(2026, 01, 01, 22, 00), LocalDateTime.of(2026, 01, 02, 04, 00), GOOD);

        List<SleepingSession> list1 = new ArrayList<>();
        list1.add(Session1);
        list1.add(Session2);
        list1.add(Session3);

        String Type1 = SleepingSession.setPersonType(Session1).name();
        String Type2 = SleepingSession.setPersonType(Session2).name();
        String Type3 = SleepingSession.setPersonType(Session3).name();

        assertEquals("Голубь", Type1, "Должен быть хронотип 'Сова'");
        assertEquals("Голубь", Type2, "Должен быть хронотип 'Жаворонок'");
        assertEquals("Голубь", Type3, "Должен быть хронотип 'Голубь'");
    }
}
