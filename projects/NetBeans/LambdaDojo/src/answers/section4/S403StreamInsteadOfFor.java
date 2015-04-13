package answers.section4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class S403StreamInsteadOfFor {

    public S403StreamInsteadOfFor() {
        processStatistics();
        processStatisticsAnswer1();
        processStatisticsAnswer2();
        processStatisticsAnswer3();
        processStatisticsAnswer4();
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

    private void processStatisticsAnswer1() {
        // 乱数のリストを作成
        Random random = new Random();

        // 0 から 100 までの IntStream を使用して、100 個の DoubleStream を作成
        // ボクシングを行ってから、リスト化する
        List<Double> numbers = IntStream.range(0, 100)
                                        .mapToDouble(x -> random.nextDouble())
                                        .boxed()
                                        .collect(Collectors.toList());
        
        // reduce メソッドを使用して合計を算出し、平均を求める
        double ave = numbers.stream()
                            .reduce(0.0, (x, y) -> x + y);
        ave /= numbers.size();

        // map メソッドで平均からの差の 2 乗を計算
        // reduce メソッドで合算する
        double ave2 = ave; // 実質的 final にするために新しい変数を定義
        double variance = numbers.stream()
                                 .map(x -> (x - ave2) * (x - ave2))
                                 .reduce(0.0, (x, y) -> x + y);
        variance /= numbers.size();
        
        System.out.println("Average: " + ave);
        System.out.println("Diverse: " + variance);
    }

    private void processStatisticsAnswer2() {
        // 乱数のリストを作成
        Random random = new Random();

        // 0 から 100 までの IntStream を使用して、100 個の Stream<Double> を作成
        // 最後にリスト化する
        List<Double> numbers = IntStream.range(0, 100)
                                        .mapToObj(x -> random.nextDouble())
                                        .collect(Collectors.toList());
        
        // collect メソッドを使用して合計を算出し、平均を求める
        double ave = numbers.stream()
                            .collect(Collectors.summingDouble(x -> x));
        ave /= numbers.size();

        // map メソッドで平均からの差の 2 乗を計算
        // collect メソッドで合算する
        double ave2 = ave; // 実質的 final にするために新しい変数を定義
        double variance = numbers.stream()
                                 .map(x -> (x - ave2) * (x - ave2))
                                 .collect(Collectors.summingDouble(x -> x));
        variance /= numbers.size();
        
        System.out.println("Average: " + ave);
        System.out.println("Diverse: " + variance);
    }

    private void processStatisticsAnswer3() {
        // 乱数のリストを作成
        Random random = new Random();

        // generate メソッドを使用して、Double クラスの無限ストリームを作成し
        // limit メソッドで個数を 100 に制限する。最後にリスト化する
        List<Double> numbers = Stream.generate(() -> random.nextDouble())
                                     .limit(100)
                                     .collect(Collectors.toList());
        
        // collect メソッドを統計情報を算出し、そこから平均をえる
        double ave = numbers.stream()
                            .collect(Collectors.summarizingDouble(x -> x))
                            .getAverage();

        // map メソッドで平均からの差の 2 乗を計算
        // collect メソッドを統計情報を算出し、そこから平均をえる
        double variance = numbers.stream()
                                 .map(x -> (x - ave) * (x - ave))
                                 .collect(Collectors.summarizingDouble(x -> x))
                                 .getAverage();
        
        System.out.println("Average: " + ave);
        System.out.println("Diverse: " + variance);
    }

    private void processStatisticsAnswer4() {
        // Random クラスの double メソッドで DoubleStream オブジェクトを生成できるので
        // それを配列化する
        double[] numbers = new Random().doubles(100)
                                       .toArray();
        
        // DoubleStream クラスの average メソッドで平均を算出
        // average メソッドの返り値の型は OptionalDouble クラスなので、getAsDouble メソッドで値を取得する
        double ave = DoubleStream.of(numbers)
                                 .average()
                                 .getAsDouble();

        // map メソッドで平均からの差の 2 乗を計算
        // average メソッドで平均を算出
        double variance = DoubleStream.of(numbers)
                                      .map(x -> (x - ave) * (x - ave))
                                      .average()
                                      .getAsDouble();
        
        System.out.println("Average: " + ave);
        System.out.println("Diverse: " + variance);
    }

    public static void main(String[] args) {
        new S403StreamInsteadOfFor();
    }
}
