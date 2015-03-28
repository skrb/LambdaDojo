package answers;

@FunctionalInterface
public interface Doubler<T extends Number> {
    T doDouble(T x);
}
