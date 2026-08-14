package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;


public class SleeplessNightCase implements Function<List<SleepingSession>, Integer> {
    private final int sleeplessNightduration = 180;
/*В ТЗ не увидел точной цифры минимального количества часов для бессонной ночи, поэтому по
примерам взял 3 часа
 */

    @Override
    public Integer apply(List<SleepingSession> sessions) {
        if (sessions == null || sessions.isEmpty()) {
            return 0;
        }
        return (int) sessions.stream()
                .filter(session -> NightSessionsCounter.isNightSession(session))
                .filter(session -> {
                    long durationMinutes = Duration.between(session.getStartSleeping(), session.getEndSleeping()).toMinutes();
                    return durationMinutes <= sleeplessNightduration;
                })
                .count();
    }
}



