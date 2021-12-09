package uk.ac.solent.devops.model.user.dao;

import uk.ac.solent.devops.model.user.dto.Role;

import java.util.List;

public interface RoleDAO {

    Role findById(Long id);

    Role save(Role role);

    List<Role> findAll();

    void deleteById(long id);

    void delete(Role role);

    void deleteAll();

    Role findByRoleName(String roleName);
}
