/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.model.user.dao;

import uk.ac.solent.devops.model.user.dto.User;

import java.util.List;

/**
 *
 * @author cgallen
 */
public interface UserDAO {

    public User findById(Long id);

    public User save(User user);

    public List<User> findAll();

    public void deleteById(long id);

    public void delete(User user);

    public void deleteAll();

    public List<User> findByRoleName(String rolename);
    
    public List<User> findByNames(String firstName, String secondName);

    public User findByUsername(String username);
    
}

