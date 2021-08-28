package com.cursomaven.daos;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {
    public abstract Optional<T> get(int id);
    public abstract List<T> getAll();
    public abstract void save(T t);
    public abstract void update(T t);
    public abstract void delete(T t);
}
