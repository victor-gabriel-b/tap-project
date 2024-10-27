package builder;

import entity.User;

public interface UserBuilder {
    UserBuilder setId(int id);
    UserBuilder setUsername(String username);
    UserBuilder setEmail(String email);
    UserBuilder setPassword(String password);
    User build();
}
