package uk.ac.solent.devops.impl.rest.base;

import java.util.List;
import java.util.UUID;

public interface ControllerBase<T> {


    void add(T model);

    List<T> get();

    T get(long id);

    T get(UUID uuid);

    void delete(long id);

    void delete(UUID id);

    T update(T updateModel);

}
