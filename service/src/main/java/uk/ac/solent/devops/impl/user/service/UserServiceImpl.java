package uk.ac.solent.devops.impl.user.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.ac.solent.devops.impl.dao.user.springdata.RoleRepository;
import uk.ac.solent.devops.impl.dao.user.springdata.UserRepository;
import uk.ac.solent.devops.model.user.dto.Role;
import uk.ac.solent.devops.model.user.dto.User;
import uk.ac.solent.devops.model.user.dto.UserRoles;
import uk.ac.solent.devops.model.user.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    final static Logger LOG = LogManager.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User create(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findByName(UserRoles.ROLE_USER.toString())));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUserRoles(String username, List<String> roleNames) {
        User user = userRepository.findByUsername(username);
        StringBuilder msg = new StringBuilder("updating user " + username + " with roles :");
        roleNames.forEach(x -> msg.append(x).append(" "));
        LOG.debug(msg.toString());

        Set<Role> newRoles = new HashSet<>();

        //Lambda introduced in Java 8
        //roleNames.stream().map(roleRepository::findByName).filter(x -> !x.isEmpty()).map(x -> x.get(0)).collect(Collectors.toList());

        roleNames.forEach(x -> {
            List<Role> roles = roleRepository.findByName(x);
            if (roles.isEmpty()) {
                throw new IllegalArgumentException("RoleName is not known to system: " + x);
            }
            newRoles.add(roles.get(0));
        });

        user.setRoles(newRoles);

        user = userRepository.saveAndFlush(user);

        return user;
    }

    @Override
    public List<Role> getAvailableUserRoles() {
        return roleRepository.findAll();
    }

    @Override
    public List<String> getAvailableUserRoleNames() {
        return roleRepository.findAll().stream().map(Role::getName).collect(Collectors.toList());
    }

}
