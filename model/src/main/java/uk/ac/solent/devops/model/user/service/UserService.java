package uk.ac.solent.devops.model.user.service;

import java.util.List;
import uk.ac.solent.devops.model.user.dto.Role;
import uk.ac.solent.devops.model.user.dto.User;

public interface UserService {

    User create(User user);

    User findByUsername(String username);

    List<User> findAll();

    User save(User user);
    
    User updateUserRoles(String username, List<String> roleNames);
    
    List<Role> getAvailableUserRoles();
    
    List<String> getAvailableUserRoleNames();

}
