package ua.epam.task4.student;

import java.util.Objects;

public class AddressOld {
    private String city;
    private String street;
    private int streetNumber;
    private int flatNumber;

    private AddressOld(AddressBuilder addressBuilder) {
        this.city = addressBuilder.city;
        this.street = addressBuilder.street;
        this.flatNumber = addressBuilder.flatNumber;
        this.streetNumber = addressBuilder.streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressOld address = (AddressOld) o;
        return streetNumber == address.streetNumber &&
                flatNumber == address.flatNumber &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, streetNumber, flatNumber);
    }

    @Override
    public String toString() {
        StringBuilder address = new StringBuilder();

        address.append("City: ").append(city).append("\n");
        address.append("Street: ").append(street);
        address.append(" №: ").append(streetNumber).append("\n");
        address.append("Flat №: ").append(flatNumber);

        return address.toString();
    }

    public static AddressBuilder build() {
        return new AddressBuilder();
    }

    public static class AddressBuilder {
        private String city;
        private String street;
        private int streetNumber;
        private int flatNumber;

        private AddressBuilder() {}

        public AddressBuilder withCity(String city) {
            this.city = city;

            return this;
        }

        public AddressBuilder withStreet(String street) {
            this.street = street;

            return this;
        }

        public AddressBuilder withStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;

            return this;
        }

        public AddressBuilder withFlatNumber(int flatNumber) {
            this.flatNumber = flatNumber;

            return this;
        }

        public AddressOld build() {
            return new AddressOld(this);
        }

    }
}
