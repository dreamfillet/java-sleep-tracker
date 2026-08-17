package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class MinSleepDurationInMinutes implements Function<List<SleepingSession>, String> {
    @Override
    public String apply(List<SleepingSession> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            return "Минимальная продолжительность сессии (в минутах): 0";
        }

        return "Минимальная апродолжительность сессии (в минутах): " + sessions.stream()
                .map(session -> {
                    long minutes = Duration.between(session.getStartSleeping(), session.getEndSleeping()).toMinutes();
                    return (int) minutes;
                })
                .min((a, b) -> a.compareTo(b))
                .orElse(0);
    }
}
