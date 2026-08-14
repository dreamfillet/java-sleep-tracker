package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class AverageSleepDurationInMinutes implements Function<List<SleepingSession>, Integer> {
    @Override
    public Integer apply(List<SleepingSession> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            return 0;
        }

        double average = sessions.stream()
                .mapToInt(session -> (int) Duration.between(session.getStartSleeping(), session.getEndSleeping()).toMinutes())
                .average()
                .orElse(0.0);

        return (int) average;
    }
}
