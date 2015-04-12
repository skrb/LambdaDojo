package questions.section4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class S403StreamInsteadOfFor {

    public S403StreamInsteadOfFor() {
        processStatistics();
    }

    private void processStatistics() {
        // 乱数のリストを作成
        Random random = new Random();
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextDouble());
        }
        
        // 平均を算出
        double ave = 0.0;
        for (Double x : numbers) {
            ave += x;
        }
        ave /= numbers.size();

        // 分散を算出
        double variance = 0.0;
        for (Double x : numbers) {
            variance += (x - ave) * (x - ave);
        }
        variance /= numbers.size();
        
        System.out.println("Average: " + ave);
        System.out.println("Diverse: " + variance);
    }

    public static void main(String[] args) {
        new S403StreamInsteadOfFor();
    }
}
