package uk.ac.solent.devops.impl.dao.user.spring;

import org.springframework.stereotype.Component;
import uk.ac.solent.devops.impl.dao.user.springdata.RoleRepository;
import uk.ac.solent.devops.impl.dao.user.springdata.UserRepository;
import uk.ac.solent.devops.model.user.dao.UserDAO;
import uk.ac.solent.devops.model.user.dto.Role;
import uk.ac.solent.devops.model.user.dto.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImplSpring implements UserDAO {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserDAOImplSpring(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User person) {
        return userRepository.save(person);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public List<User> findByRoleName(String roleName) {
        List<Role> roles = roleRepository.findByName(roleName);
        if (roles.isEmpty()) return new ArrayList<>();
        return new ArrayList<>(roles.get(0).getUsers());
    }

    @Override
    public List<User> findByNames(String firstName, String secondName) {
        return userRepository.findByNames(firstName, secondName);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
