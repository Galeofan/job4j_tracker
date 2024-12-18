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
        List<Label> labels = new ArrayList<>();
        for (Subject subject : pupils.get(0).subjects()) {
            String subjname = subject.name();
            int index = 0;
            int sum = 0;
            for (Pupil pupil : pupils) {
                sum += pupil.subjects().get(index).score();
                index++;
            }
            map.put(subjname, sum);
            labels.add(new Label(subjname,
                    (double) map.getOrDefault(subjname, sum) / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            label.add(new Label(pupil.name(), sum));
        }
        label.sort(Comparator.naturalOrder());
        return label.get(label.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Subject subject : pupils.get(0).subjects()) {
            String subjname = subject.name();
            int index = 0;
            int sum = 0;
            for (Pupil pupil : pupils) {
                sum += pupil.subjects().get(index).score();
                index++;
            }
            map.put(subjname, sum);
            labels.add(new Label(subjname,
                    (double) map.getOrDefault(subjname, sum)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}