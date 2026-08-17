package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class SleeplessNightCase implements Function<List<SleepingSession>, String> {
    private final int sleeplessNightDuration = 180;

    @Override
    public String apply(List<SleepingSession> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            return "Количество бессонных ночей: 0";
        }

        Map<LocalDate, List<SleepingSession>> byDate = sessions.stream()
                .collect(Collectors.groupingBy(s -> s.getStartSleeping().toLocalDate()));

        long sleeplessNights = byDate.values().stream()
                .filter(daySessions -> {
                    long nightMinutes = daySessions.stream()
                            .filter(NightSessionsCounter::isNightSession)
                            .mapToLong(s -> Duration.between(s.getStartSleeping(), s.getEndSleeping()).toMinutes())
                            .sum();
                    return nightMinutes <= sleeplessNightDuration;
                })
                .count();

        return "Количество бессонных ночей: " + sleeplessNights;
    }


}



