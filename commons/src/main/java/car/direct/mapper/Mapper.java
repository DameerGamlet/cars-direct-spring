package car.direct.mapper;

public interface Mapper<T, R> {
    R map(T t);
}
