/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.model.user.dao;

import java.util.List;
import uk.ac.solent.devops.model.user.dto.Role;

/**
 *
 * @author cgallen
 */
public interface RoleDAO {

    public Role findById(Long id);

    public Role save(Role role);

    public List<Role> findAll();

    public void deleteById(long id);

    public void delete(Role role);

    public void deleteAll();

    public Role findByRoleName(String rolename);


}
