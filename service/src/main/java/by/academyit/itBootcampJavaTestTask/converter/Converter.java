package by.academyit.itBootcampJavaTestTask.converter;


public interface Converter<E, D> {

    public D entityToDto(E entity);
    public E dtoToEntity(D dto);



}
