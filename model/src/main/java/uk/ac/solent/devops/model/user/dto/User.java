package uk.ac.solent.devops.model.user.dto;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@Entity
@Table(name = "user")
public class User {

    private Long id;
    private String href = null;
    private String username;
    private String password;
    private String passwordConfirm;
    private String firstName;
    private String secondName;
    private Boolean enabled = true;

    @XmlElementWrapper(name = "roles")
    @XmlElement(name = "role")
    private Set<Role> roles = new HashSet<Role>();


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    // generated by rest service from id
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    // Note Password and roles omitted from tostring
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", href=" + href + ", username=" + username
                + ", firstName=" + firstName + ", secondName="
                + secondName
                + ", enabled=" + enabled + "PASSWORD ROLES omitted }";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.username);
        return hash;
    }

    // username is unique for identity
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final User other = (User) obj;
        return Objects.equals(this.username, other.username);
    }


}
