package task3.builder;

public class UserBuilder {
    private String username;
    private String password;

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        return new User(username, password);
    }
}
