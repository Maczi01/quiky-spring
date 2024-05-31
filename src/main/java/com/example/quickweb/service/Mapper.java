package com.example.quickweb.service;

public interface Mapper<T, K, C> {
    T toDto(K k);
    K toEntity(T t);
    K toEntityFromCreateDto(C c);

}
