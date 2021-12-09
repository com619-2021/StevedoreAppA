package uk.ac.solent.devops.model.user.dao;

import uk.ac.solent.devops.model.user.dto.User;

import java.util.List;

public interface UserDAO {

    User findById(Long id);

    User save(User user);

    List<User> findAll();

    void deleteById(long id);

    void delete(User user);

    void deleteAll();

    List<User> findByRoleName(String rolename);
    
    List<User> findByNames(String firstName, String secondName);

    User findByUsername(String username);
    
}

