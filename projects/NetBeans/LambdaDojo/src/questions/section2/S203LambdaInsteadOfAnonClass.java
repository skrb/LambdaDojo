package questions.section2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class S203LambdaInsteadOfAnonClass {

    public S203LambdaInsteadOfAnonClass() {
        rewriteByLambda();
    }

    // 2-3 Lambda 式で書きかえてみましょう
    private void rewriteByLambda() {
        // 1秒ごとに時間を表示するタスク
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                for (;;) {
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
        new S203LambdaInsteadOfAnonClass();
    }
}
