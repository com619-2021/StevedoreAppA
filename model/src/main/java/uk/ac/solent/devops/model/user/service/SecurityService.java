package uk.ac.solent.devops.model.user.service;

public interface SecurityService {
    void autologin(String username, String password);
}
