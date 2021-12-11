package uk.ac.solent.devops.impl.dao.user.spring;

import org.springframework.stereotype.Component;
import uk.ac.solent.devops.impl.dao.user.springdata.RoleRepository;
import uk.ac.solent.devops.model.user.dao.RoleDAO;
import uk.ac.solent.devops.model.user.dto.Role;

import java.util.List;

@Component
public class RoleDAOImplSpring implements RoleDAO {

    private final RoleRepository roleRepository;

    public RoleDAOImplSpring(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void deleteAll() {
        roleRepository.deleteAll();
    }

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findByName(roleName).stream().findFirst().orElse(null);
    }

}
