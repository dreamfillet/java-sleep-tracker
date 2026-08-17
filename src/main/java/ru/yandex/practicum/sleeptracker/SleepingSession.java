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

    public static PersonType setPersonType(SleepingSession session) {
        LocalTime startTime = session.getStartSleeping().toLocalTime();
        LocalTime endTime = session.getEndSleeping().toLocalTime();

        LocalTime nightStart1 = LocalTime.of(23, 0);
        LocalTime nightEnd1 = LocalTime.of(9, 0);

        LocalTime nightStart2 = LocalTime.of(22, 0);
        LocalTime nightEnd2 = LocalTime.of(7, 0);

        if (startTime.isAfter(nightStart1) && endTime.isAfter(nightEnd1)) {
            return PersonType.Сова;
        } else if (startTime.isBefore(nightStart2) && endTime.isBefore(nightEnd2)) {
            return PersonType.Жаворонок;
        } else {
            return PersonType.Голубь;
        }
    }
}