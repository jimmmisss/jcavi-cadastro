package com.jcavi.cadastro.mapper;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Mappable {

    ModelMapper mapper();

    default <T> T map(Object source, Class<T> clazz) {
        return mapper().map(source, clazz);
    }

    default <T> List<T> map(Collection<?> source, Class<T> clazz) {
        return source
                .stream()
                .map(t -> map(t, clazz))
                .collect(Collectors.toList());

    }

}
