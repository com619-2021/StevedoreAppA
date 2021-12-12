package uk.ac.solent.devops.model.base.service;

import java.util.List;
import java.util.UUID;

public interface ServiceBase<T> {

    T create(T user);

    T findByUuid(UUID uuid);

    List<T> findAll();

    T save(T user);

}
