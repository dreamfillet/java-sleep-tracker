package ru.yandex.practicum.sleeptracker;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


public class SleepTrackerApp {
    static List<SleepingSession> sessions = new ArrayList<>();
    String fileName = "C:/Users/filatov.vyacheslav/Desktop/Projects/java-sleep-tracker/src/main/resources/sleep_log.txt";

    /*Я понимаю, что в ТЗ написано "Приложение должно принимать на вход как аргумент командной строки путь к файлу с логом сна",
    но чем больше изучаю варианты ИИ по реализации, тем больше запутываюсь. Просьба написать, какой способ
    предпочтителен, попробую изучить и реализовать. Пока могу только в таком виде загрузку файла предоставить.
     */
    public static void main(String[] args) {

        SleepTrackerApp app = new SleepTrackerApp();
        app.loadFile(app.fileName);

        //вывод количества сессий сна
        SessionsCounter s = new SessionsCounter();
        int sessionsCount = s.apply(SleepTrackerApp.sessions);
        SleepAnalysisResult sessionsCountPrint = new SleepAnalysisResult("Количество сессий сна за период: ", sessionsCount);
        System.out.println(sessionsCountPrint);
        System.out.println("__________________");

        //вывод сессии с минимальной длительностью сна
        MinSleepDurationInMinutes min = new MinSleepDurationInMinutes();
        int minMinutes = min.apply(SleepTrackerApp.sessions);
        SleepAnalysisResult sessionsMinPrint = new SleepAnalysisResult("Минимальная продолжительность сессии (в минутах): ", minMinutes);
        System.out.println(sessionsMinPrint);
        System.out.println("__________________");

        //вывод сессии с максимальной длительностью сна
        MaxSleepDurationInMinutes max = new MaxSleepDurationInMinutes();
        int maxMinutes = max.apply(SleepTrackerApp.sessions);
        SleepAnalysisResult sessionsMaxPrint = new SleepAnalysisResult("Максимальная продолжительность сессии (в минутах): ", maxMinutes);
        System.out.println(sessionsMaxPrint);
        System.out.println("__________________");

        //вывод сессии с средней длительностью сна
        AverageSleepDurationInMinutes average = new AverageSleepDurationInMinutes();
        int averageMinutes = average.apply(SleepTrackerApp.sessions);
        SleepAnalysisResult sessionsAveragePrint = new SleepAnalysisResult("Средняя продолжительность сессии (в минутах): ", averageMinutes);
        System.out.println(sessionsAveragePrint);
        System.out.println("__________________");

        //вывод списка сессий с плохим качеством сна
        BadSleepQualitySessions badSessions = new BadSleepQualitySessions();
        List<SleepingSession> badSessionsList = badSessions.apply(SleepTrackerApp.sessions);
        int badSessionsPrint = badSessionsList.size();
        System.out.println("Количество сессий с плохим качеством сна: " + badSessionsPrint);
        System.out.println("__________________");

        //вывод списка сессий с ночным сном
        NightSessionsCounter nights = new NightSessionsCounter();
        int nightsCounter = nights.apply(SleepTrackerApp.sessions);
        System.out.println("Количество ночных сессий: " + nightsCounter);
        System.out.println("__________________");

        //вывод списка бессонных ночей
        SleeplessNightCase sleeplessNights = new SleeplessNightCase();
        int sleeplessNightsCounter = sleeplessNights.apply(SleepTrackerApp.sessions);
        System.out.println("Количество бессонных ночей: " + sleeplessNightsCounter);
        System.out.println("__________________");

    }

    public void loadFile(String fileName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;
/*Я понимаю, что в ТЗ сказано не использовать циклы. Но я пока не настолько силен, чтобы понять как этот
цикл перевести в stream. Просьба дать подсказку*/
            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.trim().isEmpty()) continue;

                try {
                    String[] parts = line.split(";");

                    LocalDateTime start = LocalDateTime.parse(parts[0].trim(), formatter);
                    LocalDateTime end = LocalDateTime.parse(parts[1].trim(), formatter);
                    SleepQuality quality = SleepQuality.valueOf(parts[2].trim().toUpperCase());

                    SleepingSession session = new SleepingSession(start, end, quality);
                    String type = SleepingSession.setPersonType(session);
                    session.setPersonType(type);
                    sessions.add(session);

                    System.out.println("Загруженная сессия " + "(Тип человека " + type + " ) " + lineNumber + ": " + session);

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