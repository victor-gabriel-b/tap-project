package builder;

import entity.User;

public class ConcreteUserBuilder implements UserBuilder {
    private int id;
    private String username;
    private String email;
    private String password;

    @Override
    public UserBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public User build() {
        return new User(id, username, email, password);
    }
}