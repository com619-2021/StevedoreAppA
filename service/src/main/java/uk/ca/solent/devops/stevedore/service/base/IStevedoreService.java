package uk.ca.solent.devops.stevedore.service.base;

import java.util.List;
import java.util.UUID;

//Update for Dto´s
public interface IStevedoreService<T> {
    void Add(T model);

    List<T> Get();

    T Get(int id);

    T Get(UUID uuid);

    void Delete(long id);

    void Delete(UUID uuid);

    T Update(T updateModel);
}
