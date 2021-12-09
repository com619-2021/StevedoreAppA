package uk.ac.solent.devops.impl.user.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import uk.ac.solent.devops.impl.dao.user.springdata.RoleRepository;
import uk.ac.solent.devops.impl.dao.user.springdata.UserRepository;
import uk.ac.solent.devops.model.user.dto.Role;
import uk.ac.solent.devops.model.user.dto.User;
import uk.ac.solent.devops.model.user.dto.UserRoles;

import javax.annotation.PostConstruct;
import java.util.HashSet;


@Component
public class DBInitialise {

    final static Logger LOG = LogManager.getLogger(DBInitialise.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public DBInitialise(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostConstruct
    public void init() {

        if (roleRepository.findAll().isEmpty()) {
            for (UserRoles allRole : UserRoles.values()) {
                String roleName = allRole.name();
                LOG.debug("initialising user role " + roleName + " to database");
                Role role = new Role();
                role.setName(roleName);
                roleRepository.saveAndFlush(role);
            }
        }

        if (userRepository.findAll().isEmpty()) {
            LOG.debug("new database initialising default globaladmin and basicuser");
            User adminUser = new User();
            adminUser.setFirstName("globaladmin");
            adminUser.setSecondName("globaladmin");
            adminUser.setUsername("globaladmin");
            adminUser.setPassword(bCryptPasswordEncoder.encode("globaladmin"));

            HashSet<Role> roles = new HashSet<>();
            roles.addAll(roleRepository.findByName(UserRoles.ROLE_USER.toString()));
            roles.addAll(roleRepository.findByName(UserRoles.ROLE_GLOBAL_ADMIN.toString()));

            adminUser.setRoles(roles);
            userRepository.saveAndFlush(adminUser);

            User basicUser = new User();
            basicUser.setFirstName("basicuser");
            basicUser.setSecondName("basicuser");
            basicUser.setUsername("basicuser");
            basicUser.setPassword(bCryptPasswordEncoder.encode("basicuser"));
            roles = new HashSet<>(roleRepository.findByName(UserRoles.ROLE_USER.toString()));

            basicUser.setRoles(roles);
            userRepository.saveAndFlush(basicUser);
        }
    }
}
