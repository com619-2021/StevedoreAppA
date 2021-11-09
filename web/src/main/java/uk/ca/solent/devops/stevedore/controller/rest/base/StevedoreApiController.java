package uk.ca.solent.devops.stevedore.controller.rest.base;

import java.util.List;
import java.util.UUID;

public interface StevedoreApiController<T> {

    List<T> GetAll();

    T Get(int id);

    T Get(UUID uuid);

    void Add(T model);

    void Delete(long id);

    void Delete(UUID uuid);

    T Update(T updateModel);
}
