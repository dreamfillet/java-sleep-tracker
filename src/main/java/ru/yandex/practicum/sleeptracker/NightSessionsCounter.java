package ru.yandex.practicum.sleeptracker;

import java.time.LocalTime;
import java.util.List;
import java.util.function.Function;

public class NightSessionsCounter implements Function<List<SleepingSession>, Integer> {

    @Override
    public Integer apply(List<SleepingSession> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            return 0;
        }

        return (int) sessions.stream()
                .filter(session -> isNightSession(session)).count();
    }

    public static boolean isNightSession(SleepingSession session) {
        LocalTime startTime = session.getStartSleeping().toLocalTime();
        LocalTime endTime = session.getEndSleeping().toLocalTime();

        LocalTime nightStart = LocalTime.of(22, 0);
        LocalTime nightEnd = LocalTime.of(6, 0);

        boolean crossesMidnight = !session.getStartSleeping().toLocalDate().equals(session.getEndSleeping().toLocalDate());

        boolean startInNight = (startTime.isAfter(nightStart) || startTime.equals(nightStart)) ||
                startTime.isBefore(nightEnd);

        boolean endInNight = (endTime.isAfter(nightStart) || endTime.equals(nightStart)) ||
                endTime.isBefore(nightEnd);

        return crossesMidnight || startInNight || endInNight;
    }


}

