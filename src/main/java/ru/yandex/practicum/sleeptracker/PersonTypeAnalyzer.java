package ru.yandex.practicum.sleeptracker;

import java.time.LocalTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class PersonTypeAnalyzer implements Function<List<SleepingSession>, String> {

    @Override
    public String apply(List<SleepingSession> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            return "Нет данных для определения типа";
        }

        List<SleepingSession> nightSessions = sessions.stream()
                .filter(NightSessionsCounter::isNightSession)
                .toList();

        if (nightSessions.isEmpty()) {
            return "Нет ночных сессий для определения хронотипа";
        }

        StringBuilder result = new StringBuilder();
        result.append("Типы людей по ночным сессиям:\n");

        IntStream.range(0, nightSessions.size())
                .forEach(i -> {
                    SleepingSession session = nightSessions.get(i);
                    PersonType chronotype = setPersonType(session);
                    session.setPersonType(chronotype);

                    result.append("  Сессия ").append(": ")
                            .append(session.getStartSleeping().toLocalTime())
                            .append(" - ")
                            .append(session.getEndSleeping().toLocalTime())
                            .append(" → ")
                            .append(chronotype)
                            .append("\n");
                });

        return result.toString();
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