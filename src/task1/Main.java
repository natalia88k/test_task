package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        try {
            File task1 = new File(args[0]);
            Scanner in = new Scanner(task1);

            while (in.hasNextInt()) {
                numbers.add(in.nextInt());
            }
        } catch (FileNotFoundException e) {

        }

        Collections.sort(numbers);
        int percentileIndex = ((int) Math.ceil(0.9 * numbers.size())) - 1;
        double alpha = 0.9 * (numbers.size() + 1) - Math.floor(0.9 * (numbers.size() + 1));
        double beta = 1 - alpha;

        double percentile = 0.0;
        if (numbers.size() == 1) {
            percentile = numbers.get(percentileIndex);
        } else if (numbers.size() > 1) {
            percentile = alpha * numbers.get(percentileIndex) + beta * numbers.get(percentileIndex + 1);
        }

        double mediana = 0.0;
        if (numbers.size() % 2 == 0) {
            int index1 = numbers.size() / 2;
            int index2 = index1 - 1;
            mediana = (numbers.get(index1) + numbers.get(index2)) / 2.0;
        } else {
            int index = numbers.size() / 2;
            mediana = numbers.get(index);
        }

        double max = Double.MIN_VALUE;

        for (int i = 0; i < numbers.size(); i++) {

            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }

        double min = Double.MAX_VALUE;

        for (int i = 0; i < numbers.size(); i++) {

            if (numbers.get(i) < min) {
                min = numbers.get(i);
            }
        }

        double sum = 0.0;
        double averageValue = 0.0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        if (!numbers.isEmpty()) {
            averageValue = sum / numbers.size();
        }

        System.out.printf("%.2f\n", percentile);
        System.out.printf("%.2f\n", mediana);
        System.out.printf("%.2f\n", max);
        System.out.printf("%.2f\n", min);
        System.out.printf("%.2f\n", averageValue);

    }

}
