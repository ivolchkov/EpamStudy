package ua.epam.task2.Equals;

import java.util.Objects;

public class User {
    private String name;
    private String surname;
    private int age;
    private boolean active;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) {
            return true;
        }

        if ( obj == null || this.getClass() != obj.getClass() ) {
            return false;
        }

        User another = (User) obj;

        return (this.age == another.getAge()
                && this.active == another.isActive()
                && this.name == another.getName() || ( this.name != null && this.name.equals(another.getName())))
                && (this.surname == another.getSurname() || ( this.surname != null && this.surname.equals(another.getSurname())));

    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;


        result = this.name == null ? 0 : this.name.hashCode();
        result = prime * result + (this.surname == null ? 0 : this.surname.hashCode());
        result = prime * result + this.age;
        result = prime * result + ( this.active ? 1 : 0);

        return result;
    }

}
