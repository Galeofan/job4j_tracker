package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        int score = 0;
        for (Pupil pupil : pupils) {
            for (int i = 0; i < pupil.subjects().size(); i++) {
                score += pupil.subjects().get(i).score();
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
            for (int i = 0; i < pupil.subjects().size(); i++) {
                score += pupil.subjects().get(i).score();
                count++;
            }
            result.add(new Label(pupil.name(), (double) score / count));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Subject subject : pupils.get(0).subjects()) {
            String subjname = subject.name();
            int sum = subject.score();
            int counter = 1;
            for (int i = 1; i < pupils.size(); i++) {
                for (int j = 0; j < pupils.get(i).subjects().size(); j++) {
                    if (subjname.equals(pupils.get(i).subjects().get(j).name())) {
                        counter++;
                        sum += pupils.get(i).subjects().get(j).score();
                    }
                }
            }
            map.put(subjname, sum);
        }
        List<Label> labels = new ArrayList<>();
        for (String key : map.keySet()) {
            int value = map.get(key);
            labels.add(new Label(key, (double) value / pupils.size()));
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
        for (Subject subject : pupils.get(0).subjects()) {
            String subjname = subject.name();
            int sum = subject.score();
            int counter = 1;
            for (int i = 1; i < pupils.size(); i++) {
                for (int j = 0; j < pupils.get(i).subjects().size(); j++) {
                    if (subjname.equals(pupils.get(i).subjects().get(j).name())) {
                        counter++;
                        sum += pupils.get(i).subjects().get(j).score();
                    }
                }
            }
            map.put(subjname, sum);
        }
        List<Label> labels = new ArrayList<>();
        for (String key : map.keySet()) {
            int value = map.get(key);
            labels.add(new Label(key, value));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}