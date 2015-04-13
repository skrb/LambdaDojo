package answers.section2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

public class S205LambdaForStrategy {

    static class Container<T> {

        private T value;

        public Container(T value) {
            this.value = value;
        }

        public void output(Consumer<T> saver) {
            saver.accept(value);
        }
    }

    public S205LambdaForStrategy() {
        useContainer();
        useContainerAnswer1();
        useContainerAnswer2();
    }

    private void useContainer() {
        Container<String> container = new Container<>("Hello, World!");

        container.output(new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println(value);
            }
        });

        final String filename = "container.txt";
        container.output(new Consumer<String>() {
            @Override
            public void accept(String value) {
                try {
                    Path path = Paths.get(filename);
                    Files.write(path, value.getBytes());
                } catch (IOException ex) {
                    // 例外処理
                    System.err.println("printに失敗しました");
                }
            }
        });
    }

    private void useContainerAnswer1() {
        Container<String> container = new Container<>("Hello, World!");

        // Lambda 式で置き換え
        container.output(value -> {
            System.out.println(value);
        });

        final String filename = "container.txt";
        container.output(value -> {
            try {
                Path path = Paths.get(filename);
                Files.write(path, value.getBytes());
            } catch (IOException ex) {
                // 例外処理
                System.err.println("printに失敗しました");
            }
        });
    }

    private void useContainerAnswer2() {
        Container<String> container = new Container<>("Hello, World!");

        // メソッド参照を使用
        container.output(System.out::println);

        final String filename = "container.txt";
        container.output(value -> {
            try {
                Path path = Paths.get(filename);
                Files.write(path, value.getBytes());
            } catch (IOException ex) {
                // 例外処理
                System.err.println("printに失敗しました");
            }
        });
    }

    public static void main(String... args) {
        new S205LambdaForStrategy();
    }
}
