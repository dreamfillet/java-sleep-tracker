package ru.yandex.practicum.sleeptracker;


import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BadSleepQualitySessions implements Function<List<SleepingSession>, List<SleepingSession>> {
    @Override
    public List<SleepingSession> apply(List<SleepingSession> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            return List.of();
        }

        List<SleepingSession> badSessions = sessions.stream()
                .filter(session -> {
                    String q = String.valueOf(session.getQuality());
                    if (q == null) return false;
                    return "BAD".equals(q.trim());
                })
                .collect(Collectors.toList());


        return badSessions;
    }

}

