package uk.ac.solent.devops.impl.dao.user.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import uk.ac.solent.devops.model.user.dto.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
    List<Role> findByName(@Param("rolename") String rolename);
    
}
