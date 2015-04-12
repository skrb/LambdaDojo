package answers.section2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class S202LambdaInsteadOfAnonClass {

    public S202LambdaInsteadOfAnonClass() {
        rewriteByLambda();
        rewriteByLambdaAnswer1();
        rewriteByLambdaAnswer2();
    }

    // 2-2 Lambda 式で書きかえてみましょう
    private void rewriteByLambda() {

        // この匿名クラスを Lambda 式で書きかえ
        Callable<List<String>> callable = new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                // ファイル読み込み処理
                Path path = Paths.get("src/questions/section2/S202LambdaInsteadOfAnonClass.java");
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

    private void rewriteByLambdaAnswer1() {

        // Lambda 式で置き換え
        Callable<List<String>> callable = () -> {
            // ファイル読み込み処理
            Path path = Paths.get("src/questions/section2/S202LambdaInsteadOfAnonClass.java");
            return Files.readAllLines(path);
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

    private void rewriteByLambdaAnswer2() {

        // 1式で記述可能なので、波カッコと return 文を省略
        Callable<List<String>> callable = () -> Files.readAllLines(Paths.get("src/questions/section2/S202LambdaInsteadOfAnonClass.java"));

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

    public static void main(String... args) {
        new S202LambdaInsteadOfAnonClass();
    }
}
