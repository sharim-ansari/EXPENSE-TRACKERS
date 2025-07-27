package service;

import model.User;
import dao.UserDAO;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public boolean registerUser(User user) {
        if (userDAO.findUserByEmail(user.getEmail()) == null) {
            userDAO.createUser(user);
            return true;
        }
        return false;
    }

    public User loginUser(String email, String password) {
        User user = userDAO.findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}