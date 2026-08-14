package ru.yandex.practicum.sleeptracker;

import java.util.List;
import java.util.function.Function;

public class SessionsCounter implements Function<List<SleepingSession>, Integer> {
    @Override
    public Integer apply(List<SleepingSession> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            System.out.println("Нет данных о сессиях сна.");
            return 0;
        }

        int count = sessions.size();
        return count;

    }
}



