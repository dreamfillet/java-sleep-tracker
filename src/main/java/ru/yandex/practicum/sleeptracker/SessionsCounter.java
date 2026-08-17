package ru.yandex.practicum.sleeptracker;

import java.util.List;
import java.util.function.Function;

public class SessionsCounter implements Function<List<SleepingSession>, String> {
    @Override
    public String apply(List<SleepingSession> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            return "Общее количество сессий сна: 0";
        }

        int count = sessions.size();
        return "Общее количество сессий сна: " + count;

    }
}



