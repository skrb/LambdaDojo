package questions.section2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

public class S05LambdaForStrategy {

    static class Container<T> {

        private T value;

        public Container(T value) {
            this.value = value;
        }

        public void output(Consumer<T> saver) {
            saver.accept(value);
        }
    }
    
    public S05LambdaForStrategy() {
        useContainer();
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

    public static void main(String... args) {
        new S05LambdaForStrategy();
    }
}
