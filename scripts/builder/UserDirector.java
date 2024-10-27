package builder;

import entity.User;

public class UserDirector {
    private UserBuilder builder;

    public UserDirector(UserBuilder builder) {
        this.builder = builder;
    }

    public User constructUser(int id, String username, String email, String password) {
        return builder.setId(id)
                      .setUsername(username)
                      .setEmail(email)
                      .setPassword(password)
                      .build();
    }
}