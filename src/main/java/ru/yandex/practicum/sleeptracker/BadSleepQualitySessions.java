package ru.yandex.practicum.sleeptracker;


import java.util.List;
import java.util.function.Function;


public class BadSleepQualitySessions implements Function<List<SleepingSession>, String> {
    @Override
    public String apply(List<SleepingSession> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            return "Количество сессий с плохим качеством сна: " + List.of();
        }

        long badSessions = sessions.stream()
                .filter(session -> session.getQuality() == SleepQuality.BAD)
                .count();


        return "Количество сессий с плохим качеством сна: " + badSessions;
    }

}

