package ru.yandex.practicum.sleeptracker;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class SleepingSession {

    private LocalDateTime startSleeping;
    private LocalDateTime endSleeping;
    private SleepQuality quality;
    private PersonType personType;

    public SleepingSession(LocalDateTime startSleeping, LocalDateTime endSleeping, SleepQuality quality) {
        this.startSleeping = startSleeping;
        this.endSleeping = endSleeping;
        this.quality = quality;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public LocalDateTime getStartSleeping() {
        return startSleeping;
    }

    public LocalDateTime getEndSleeping() {
        return endSleeping;
    }

    public SleepQuality getQuality() {
        return quality;
    }

    public PersonType getPersonType() {
        return personType;
    }

    @Override
    public String toString() {
        return startSleeping +
                ";" + endSleeping +
                ";" + quality;
    }

    public PersonType setPersonType(SleepingSession session) {
        LocalTime startTime = session.getStartSleeping().toLocalTime();
        LocalTime endTime = session.getEndSleeping().toLocalTime();

        LocalTime OWL_START = LocalTime.of(23, 0);
        LocalTime OWL_END = LocalTime.of(9, 0);
        LocalTime EARLYBIRD_START = LocalTime.of(22, 0);
        LocalTime EARLYBIRD_END = LocalTime.of(7, 0);

        boolean isOwlStart = startTime.isAfter(OWL_START) ||
                startTime.equals(OWL_START) ||
                startTime.isBefore(LocalTime.of(6, 0));

        boolean isOwlEnd = endTime.isAfter(OWL_END) || endTime.equals(OWL_END);

        if (isOwlStart && isOwlEnd) {
            return PersonType.OWL;
        }

        boolean isEarlybirdStart = startTime.isBefore(EARLYBIRD_START) || startTime.equals(EARLYBIRD_START);
        boolean isEarlybirdEnd = endTime.isBefore(EARLYBIRD_END) || endTime.equals(EARLYBIRD_END);

        if (isEarlybirdStart && isEarlybirdEnd) {
            return PersonType.EARLYBIRD;
        }

        return PersonType.PIGEON;
    }
}