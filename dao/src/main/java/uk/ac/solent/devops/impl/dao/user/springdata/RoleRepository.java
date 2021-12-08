package uk.ac.solent.devops.impl.dao.user.springdata;

import java.util.List;
import uk.ac.solent.devops.model.user.dto.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
    public List<Role> findByName(@Param("rolename") String rolename);
    
}
