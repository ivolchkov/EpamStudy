package ua.epam.task3.builder;

public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private int code;

    private User(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.password = builder.password;
        this.code = builder.code;
    }

    public static class Builder {
        private String name;
        private String surname;
        private String email;
        private String password;
        private int code;

        private Builder() {}

        public Builder withName(String name) {
            this.name = name;

            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;

            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;

            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;

            return this;
        }

        public Builder withCode(int code) {
            this.code = code;

            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static Builder build() {
        return new Builder();
    }
}
