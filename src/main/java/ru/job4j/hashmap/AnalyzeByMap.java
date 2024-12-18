package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        int score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                count++;
            }
        }
        return (double) score / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int count = 0;
            int score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                count++;
            }
            result.add(new Label(pupil.name(), (double) score / count));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
            for (Pupil pupil : pupils) {
                for (Subject subject : pupil.subjects()) {
                    map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
                }
            }
        List<Label> labels = new ArrayList<>();
        for (String key : map.keySet()) {
            int value = map.get(key);
            labels.add(new Label(key, (double) value / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            labels.add(new Label(pupil.name(), sum));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        List<Label> labels = new ArrayList<>();
        for (String key : map.keySet()) {
            int value = map.get(key);
            labels.add(new Label(key, (double) value));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}