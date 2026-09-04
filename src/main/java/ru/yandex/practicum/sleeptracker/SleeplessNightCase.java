package ru.yandex.practicum.sleeptracker;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SleeplessNightCase implements Function<List<SleepingSession>, String> {

    @Override
    public String apply(List<SleepingSession> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            return "Количество бессонных ночей: 0";
        }

        LocalDate firstDate = sessions.stream()
                .map(s -> s.getStartSleeping().toLocalDate())
                .min(LocalDate::compareTo)
                .orElse(LocalDate.now());

        LocalDate lastDate = sessions.stream()
                .map(s -> s.getStartSleeping().toLocalDate())
                .max(LocalDate::compareTo)
                .orElse(LocalDate.now());

        long totalNights = Period.between(firstDate, lastDate).getDays() + 1;

        Map<LocalDate, List<SleepingSession>> sessionsByNight = sessions.stream()
                .filter(NightSessionsCounter::isNightSession)
                .collect(Collectors.groupingBy(this::getNightDate));

        long nightsWithSleep = sessionsByNight.size();

        long sleeplessNights = totalNights - nightsWithSleep;

        return "Количество бессонных ночей: " + sleeplessNights;
    }

    private LocalDate getNightDate(SleepingSession session) {
        LocalDate startDate = session.getStartSleeping().toLocalDate();
        LocalDate endDate = session.getEndSleeping().toLocalDate();

        if (!startDate.equals(endDate)) {
            return startDate;
        }

        if (session.getStartSleeping().toLocalTime().isBefore(java.time.LocalTime.of(6, 0))) {
            return startDate.minusDays(1);
        }

        if (session.getStartSleeping().toLocalTime().isAfter(java.time.LocalTime.of(22, 0)) ||
                session.getStartSleeping().toLocalTime().equals(java.time.LocalTime.of(22, 0))) {
            return startDate;
        }

        return startDate;
    }
}




