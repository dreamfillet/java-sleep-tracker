package ru.yandex.practicum.sleeptracker;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


public class SleepTrackerApp {
    static List<SleepingSession> sessions = new ArrayList<>();

    public static void main(String[] args) {

        SleepTrackerApp app = new SleepTrackerApp();
        if (args.length == 0) {
            System.out.println("Укажите путь к файлу с логом сна в аргументах запуска.");
            return;
        }

            app.loadFile(args[0]);

        if (sessions.isEmpty()) {
            System.out.println("Нет данных для анализа.");
            return;
        }

        //вывод количества сессий сна
        SessionsCounter s = new SessionsCounter();
        String sessionsCount = s.apply(SleepTrackerApp.sessions);
        SleepAnalysisResult sessionsCountPrint = new SleepAnalysisResult(sessionsCount);
        System.out.println(sessionsCountPrint);
        System.out.println("__________________");

        //вывод сессии с минимальной длительностью сна
        MinSleepDurationInMinutes min = new MinSleepDurationInMinutes();
        String minMinutes = min.apply(SleepTrackerApp.sessions);
        SleepAnalysisResult sessionsMinPrint = new SleepAnalysisResult( minMinutes);
        System.out.println(sessionsMinPrint);
        System.out.println("__________________");

        //вывод сессии с максимальной длительностью сна
        MaxSleepDurationInMinutes max = new MaxSleepDurationInMinutes();
        String maxMinutes = max.apply(SleepTrackerApp.sessions);
        SleepAnalysisResult sessionsMaxPrint = new SleepAnalysisResult(maxMinutes);
        System.out.println(sessionsMaxPrint);
        System.out.println("__________________");

        //вывод сессии со средней длительностью сна
        AverageSleepDurationInMinutes average = new AverageSleepDurationInMinutes();
        String averageMinutes = average.apply(SleepTrackerApp.sessions);
        SleepAnalysisResult sessionsAveragePrint = new SleepAnalysisResult(averageMinutes);
        System.out.println(sessionsAveragePrint);
        System.out.println("__________________");

        //вывод количества сессий с плохим качеством сна
        BadSleepQualitySessions badSessions = new BadSleepQualitySessions();
        String badSessionsCount = badSessions.apply(SleepTrackerApp.sessions);
        System.out.println(badSessionsCount);
        System.out.println("__________________");

        //вывод количества бессонных ночей
        SleeplessNightCase sleeplessNights = new SleeplessNightCase();
        String sleeplessNightsCounter = sleeplessNights.apply(SleepTrackerApp.sessions);
        System.out.println(sleeplessNightsCounter);
        System.out.println("__________________");

        //определение типа человека
        PersonTypeAnalyzer typeAnalyzer = new PersonTypeAnalyzer();
        String type = typeAnalyzer.apply(sessions);
        System.out.println(type);
        System.out.println("__________________");

    }

    public void loadFile(String fileName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.trim().isEmpty()) continue;

                try {
                    String[] parts = line.split(";");

                    LocalDateTime start = LocalDateTime.parse(parts[0].trim(), formatter);
                    LocalDateTime end = LocalDateTime.parse(parts[1].trim(), formatter);
                    SleepQuality quality = SleepQuality.valueOf(parts[2].trim().toUpperCase());

                   SleepingSession session = new SleepingSession(start, end, quality);
                    // String type = SleepingSession.setPersonType(session);
                   // session.setPersonType(type);
                    sessions.add(session);

                    System.out.println("Загруженная сессия " +  lineNumber + ": " + session);

                } catch (DateTimeParseException e) {
                    System.err.println("Ошибка формата даты в строке " + lineNumber + ": " + line);
                } catch (Exception e) {
                    System.err.println("Ошибка в строке " + lineNumber + ": " + e.getMessage());
                }
            }

            System.out.println("Всего загружено сессий: " + sessions.size());

        } catch (FileNotFoundException e) {
            System.err.println("Файл '" + fileName + "' не найден!");
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}