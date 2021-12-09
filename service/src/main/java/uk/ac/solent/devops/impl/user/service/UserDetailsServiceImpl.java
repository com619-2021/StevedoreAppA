package uk.ac.solent.devops.impl.user.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uk.ac.solent.devops.impl.dao.user.springdata.UserRepository;
import uk.ac.solent.devops.model.user.dto.User;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    final static Logger LOG = LogManager.getLogger(UserDetailsServiceImpl.class);

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("could not find username: " + username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        user.getRoles().forEach(x -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(x.getName()));
            LOG.debug("   added granted authority role to username " + username + " " + x.getName());
        });

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled() != null && user.getEnabled(),
                true,
                true,
                true,
                grantedAuthorities);
    }
}
