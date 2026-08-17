package ru.yandex.practicum.sleeptracker;

public class SleepAnalysisResult {

    private final Object value;

    public SleepAnalysisResult(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return (String) value;
    }
}