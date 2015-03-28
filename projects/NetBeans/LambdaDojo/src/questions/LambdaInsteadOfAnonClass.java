package questions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class LambdaInsteadOfAnonClass {

    public LambdaInsteadOfAnonClass() {
        writeLambda1();
        writeLambda2();
        writeLambda3();
    }

    // 2-1 Lambda 式で書きかえてみましょう
    private void writeLambda1() {
        // この匿名クラスを Lambda 式で書きかえ
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return Integer.compare(x, y);
            }
        };

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Integer number = numbers.remove(random.nextInt(10 - i));
            numbers.add(number);
        }

        System.out.println("Before Sort: " + numbers);

        // 整数のリストをソート
        Collections.sort(numbers, comparator);
        System.out.println("After Sort: " + numbers);
    }

    // 2-2 Lambda 式で書きかえてみましょう
    private void writeLambda2() {
        
        // この匿名クラスを Lambda 式で書きかえ
        Callable<List<String>> callable = new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                // ファイル読み込み処理
                Path path = Paths.get("src/questions/LambdaInsteadOfAnonClass.java");
                return Files.readAllLines(path);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);

        // 非同期にファイルを読み込み
        Future<List<String>> future = executor.submit(callable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException ex) {
            // 例外処理
        } finally {
            executor.shutdown();
        }
    }

    // 2-1 Lambda 式で書きかえてみましょう
    private void writeLambda3() {
        // 1秒ごとに時間を表示するタスク
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                for(;;) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(LocalTime.now().format(formatter));
                    } catch (InterruptedException ex) {
                        return;
                    }
                }
            }
        };
        
        ExecutorService executor = Executors.newFixedThreadPool(1);

        // 1分間だけ、タスクを実行する
        executor.submit(runnable);
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException ex) {
        } finally {        
            executor.shutdownNow();
        }
    }

    public static void main(String... args) {
        new LambdaInsteadOfAnonClass();
    }
}
