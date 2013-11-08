package questions;

@FunctionalInterface
public interface Doubler<T extends Number> {
    T doDouble(T x);
}
