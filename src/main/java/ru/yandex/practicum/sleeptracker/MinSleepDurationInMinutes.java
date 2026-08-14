package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class MinSleepDurationInMinutes implements Function<List<SleepingSession>, Integer> {
    @Override
    public Integer apply(List<SleepingSession> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            return 0;
        }

        return sessions.stream()
                .map(session -> {
                    long minutes = Duration.between(session.getStartSleeping(), session.getEndSleeping()).toMinutes();
                    return (int) minutes;
                })
                .min((a, b) -> a.compareTo(b))
                .orElse(0);
    }
}
