package uk.ac.solent.devops.model.user.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
