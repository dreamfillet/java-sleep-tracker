package ru.yandex.practicum.sleeptracker;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static ru.yandex.practicum.sleeptracker.SleepingSession.setPersonType;

public class PersonTypeAnalyzer implements Function<List<SleepingSession>, String> {

    @Override
    public String apply(List<SleepingSession> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            return "Нет данных для определения типа";
        }

        StringBuilder result = new StringBuilder();
        result.append("Типы людей по сессиям:\n");

        IntStream.range(0, sessions.size())
                .forEach(i -> {
                    SleepingSession session = sessions.get(i);
                    PersonType chronotype = setPersonType(session);
                    session.setPersonType(chronotype);

                    result.append("  Сессия ").append(i + 1).append(": ")
                            .append(session.getStartSleeping().toLocalTime())
                            .append(" → ")
                            .append(session.getEndSleeping().toLocalTime())
                            .append(" → ")
                            .append(chronotype)
                            .append("\n");
                });

        return result.toString();
    }

}