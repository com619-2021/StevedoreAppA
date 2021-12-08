/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.impl.dao.user.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.ac.solent.devops.impl.dao.user.springdata.RoleRepository;
import uk.ac.solent.devops.impl.dao.user.springdata.UserRepository;
import uk.ac.solent.devops.model.user.dao.UserDAO;
import uk.ac.solent.devops.model.user.dto.Role;
import uk.ac.solent.devops.model.user.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author cgallen
 */
@Component
public class UserDAOImplSpring implements UserDAO {

    @Autowired
    private UserRepository userRepository = null;

    @Autowired
    private RoleRepository roleRepository = null;

    @Override
    public User findById(Long id) {
        Optional<User> o = userRepository.findById(id);
        if (o.isPresent()) {
            return o.get();
        }
        return null;
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
    public List<User> findByRoleName(String rolename) {
        // there should only be one of each role
        List<Role> roles = roleRepository.findByName(rolename);

        if (roles.isEmpty()) {
            return new ArrayList<User>();
        }

        Set<User> userSet = roles.get(0).getUsers();

        return new ArrayList<User>(userSet);
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
