package ru.yandex.practicum.sleeptracker;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class SleepingSession {
    /*Удобно конвертировать содержимое каждой сессии сна в отдельный объект класса
    «Сессия сна» — назовём его SleepingSession. Также подумайте, какой тип данных
    будет удобно использовать для хранения информации о качестве сна
     */
    private LocalDateTime startSleeping;
    private LocalDateTime endSleeping;
    private int duration;
    private SleepQuality quality;
    private String personType;

    public SleepingSession(LocalDateTime startSleeping, LocalDateTime endSleeping, SleepQuality quality) {
        this.startSleeping = startSleeping;
        this.endSleeping = endSleeping;
        this.quality = quality;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public LocalDateTime getStartSleeping() {
        return startSleeping;
    }

    public LocalDateTime getEndSleeping() {
        return endSleeping;
    }

    public int getDuration() {
        return duration;
    }

    public SleepQuality getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return startSleeping +
                ";" + endSleeping +
                ";" + quality;
    }

    public static String setPersonType(SleepingSession session) {

        LocalTime startTime = session.getStartSleeping().toLocalTime();
        LocalTime endTime = session.getEndSleeping().toLocalTime();

        LocalTime nightStart1 = LocalTime.of(23, 0);
        LocalTime nightEnd1 = LocalTime.of(9, 0);

        LocalTime nightStart2 = LocalTime.of(22, 0);
        LocalTime nightEnd2 = LocalTime.of(7, 0);


        if (startTime.isAfter(nightStart1) && endTime.isAfter(nightEnd1)) {
            return "Сова";
        } else if (startTime.isBefore(nightStart2) && endTime.isBefore(nightEnd2)) {
            return "Жаворонок";
        } else {
            return "Голубь";
        }

    }
}
