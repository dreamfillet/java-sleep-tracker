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

        LocalTime owlStart = LocalTime.of(23, 0);
        LocalTime owlEnd = LocalTime.of(9, 0);
        LocalTime earlybirdStart = LocalTime.of(22, 0);
        LocalTime earlybirdEnd = LocalTime.of(7, 0);

        boolean isOwlStart = startTime.isAfter(owlStart) ||
                startTime.equals(owlStart) ||
                startTime.isBefore(LocalTime.of(6, 0));

        boolean isOwlEnd = endTime.isAfter(owlEnd) || endTime.equals(owlEnd);

        if (isOwlStart && isOwlEnd) {
            return PersonType.OWL;
        }

        boolean isEarlybirdStart = startTime.isBefore(earlybirdStart) || startTime.equals(earlybirdStart);
        boolean isEarlybirdEnd = endTime.isBefore(earlybirdEnd) || endTime.equals(earlybirdEnd);

        if (isEarlybirdStart && isEarlybirdEnd) {
            return PersonType.EARLYBIRD;
        }

        return PersonType.PIGEON;
    }
}