package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.practicum.sleeptracker.SleepQuality.GOOD;

public class SleepTrackerPersonTypeTest {

    @Test
    void personTypesCheckUp1_Owl() {
        SleepingSession owlSession1 = new SleepingSession(
                LocalDateTime.of(2026, 1, 1, 23, 5),
                LocalDateTime.of(2026, 1, 2, 10, 5),
                GOOD
        );

        SleepingSession owlSession2 = new SleepingSession(
                LocalDateTime.of(2026, 1, 1, 0, 0),
                LocalDateTime.of(2026, 1, 2, 11, 30),
                GOOD
        );

        SleepingSession owlSession3 = new SleepingSession(
                LocalDateTime.of(2026, 1, 2, 1, 0),
                LocalDateTime.of(2026, 1, 2, 12, 0),
                GOOD
        );

        List<SleepingSession> sessions = new ArrayList<>();
        sessions.add(owlSession1);
        sessions.add(owlSession2);
        sessions.add(owlSession3);

        PersonType type1 = owlSession1.setPersonType(owlSession1);
        PersonType type2 = owlSession2.setPersonType(owlSession2);
        PersonType type3 = owlSession3.setPersonType(owlSession3);

        assertEquals(PersonType.OWL, type1, "Сессия 1 должна быть OWL");
        assertEquals(PersonType.OWL, type2, "Сессия 2 должна быть OWL");
        assertEquals(PersonType.OWL, type3, "Сессия 3 должна быть OWL");
    }

    @Test
    void personTypesCheckUp2_Earlybird() {

        SleepingSession earlybirdSession1 = new SleepingSession(
                LocalDateTime.of(2026, 1, 1, 21, 0),
                LocalDateTime.of(2026, 1, 2, 5, 30),
                GOOD
        );

        SleepingSession earlybirdSession2 = new SleepingSession(
                LocalDateTime.of(2026, 1, 1, 20, 30),
                LocalDateTime.of(2026, 1, 2, 5, 0),
                GOOD
        );

        SleepingSession earlybirdSession3 = new SleepingSession(
                LocalDateTime.of(2026, 1, 1, 21, 30),
                LocalDateTime.of(2026, 1, 2, 6, 0),
                GOOD
        );

        List<SleepingSession> sessions = new ArrayList<>();
        sessions.add(earlybirdSession1);
        sessions.add(earlybirdSession2);
        sessions.add(earlybirdSession3);


        PersonType type1 = earlybirdSession1.setPersonType(earlybirdSession1);
        PersonType type2 = earlybirdSession2.setPersonType(earlybirdSession2);
        PersonType type3 = earlybirdSession3.setPersonType(earlybirdSession3);

        assertEquals(PersonType.EARLYBIRD, type1, "Сессия 1 должна быть EARLYBIRD");
        assertEquals(PersonType.EARLYBIRD, type2, "Сессия 2 должна быть EARLYBIRD");
        assertEquals(PersonType.EARLYBIRD, type3, "Сессия 3 должна быть EARLYBIRD");
    }

    @Test
    void personTypesCheckUp3_Mixed() {

        SleepingSession owlSession = new SleepingSession(
                LocalDateTime.of(2026, 1, 1, 23, 5),
                LocalDateTime.of(2026, 1, 2, 10, 5),
                GOOD
        );

        SleepingSession earlybirdSession = new SleepingSession(
                LocalDateTime.of(2026, 1, 1, 21, 0),
                LocalDateTime.of(2026, 1, 2, 5, 30),
                GOOD
        );

        SleepingSession pigeonSession = new SleepingSession(
                LocalDateTime.of(2026, 1, 1, 22, 30),
                LocalDateTime.of(2026, 1, 2, 7, 0),
                GOOD
        );

        List<SleepingSession> sessions = new ArrayList<>();
        sessions.add(owlSession);
        sessions.add(earlybirdSession);
        sessions.add(pigeonSession);

        PersonType type1 = owlSession.setPersonType(owlSession);
        PersonType type2 = earlybirdSession.setPersonType(earlybirdSession);
        PersonType type3 = pigeonSession.setPersonType(pigeonSession);

        assertEquals(PersonType.OWL, type1, "Сессия 1 должна быть OWL");
        assertEquals(PersonType.EARLYBIRD, type2, "Сессия 2 должна быть EARLYBIRD");
        assertEquals(PersonType.PIGEON, type3, "Сессия 3 должна быть PIGEON");
    }


    @Test
    void personTypesCheckUp5_Pigeon() {

        SleepingSession pigeonSession1 = new SleepingSession(
                LocalDateTime.of(2026, 1, 1, 22, 30),
                LocalDateTime.of(2026, 1, 2, 7, 0),
                GOOD
        );

        SleepingSession pigeonSession2 = new SleepingSession(
                LocalDateTime.of(2026, 1, 1, 23, 0),
                LocalDateTime.of(2026, 1, 2, 6, 30),
                GOOD
        );

        SleepingSession pigeonSession3 = new SleepingSession(
                LocalDateTime.of(2026, 1, 1, 22, 45),
                LocalDateTime.of(2026, 1, 2, 7, 15),
                GOOD
        );

        List<SleepingSession> sessions = new ArrayList<>();
        sessions.add(pigeonSession1);
        sessions.add(pigeonSession2);
        sessions.add(pigeonSession3);

        PersonType type1 = pigeonSession1.setPersonType(pigeonSession1);
        PersonType type2 = pigeonSession2.setPersonType(pigeonSession2);
        PersonType type3 = pigeonSession3.setPersonType(pigeonSession3);

        assertEquals(PersonType.PIGEON, type1, "Сессия 1 должна быть PIGEON");
        assertEquals(PersonType.PIGEON, type2, "Сессия 2 должна быть PIGEON");
        assertEquals(PersonType.PIGEON, type3, "Сессия 3 должна быть PIGEON");
    }

    @Test
    void personTypesCheckUp6_EdgeCase() {

        SleepingSession edgeSession = new SleepingSession(
                LocalDateTime.of(2026, 1, 1, 23, 0),
                LocalDateTime.of(2026, 1, 2, 6, 0),
                GOOD
        );

        List<SleepingSession> sessions = new ArrayList<>();
        sessions.add(edgeSession);

        PersonType type1 = edgeSession.setPersonType(edgeSession);

        assertEquals(PersonType.PIGEON, type1, "Сессия 1 должна быть PIGEON");

    }
}
