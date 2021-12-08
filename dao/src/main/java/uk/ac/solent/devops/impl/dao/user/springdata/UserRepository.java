package uk.ac.solent.devops.impl.dao.user.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uk.ac.solent.devops.model.user.dto.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

    @Query("select u from User u where u.firstName = :firstName and u.secondName = :secondName")
    public List<User> findByNames(@Param("firstName") String firstName, @Param("secondName") String secondName);
    
}
