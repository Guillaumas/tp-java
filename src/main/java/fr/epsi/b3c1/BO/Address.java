package fr.epsi.b3c1.BO;


import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 10, nullable = false)
    private String number;

    @Column(length = 100, nullable = false)
    private String street;

    @Column(length = 10, nullable = false)
    private String zipCode;

    @Column(length = 50, nullable = false)
    private String city;

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static class Builder {
        private String number;
        private String street;
        private String zipCode;
        private String city;

        public Builder withNumber(String number) {
            this.number = number;
            return this;
        }

        public Builder withStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder withZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Address build() {
            Address address = new Address();
            address.setNumber(this.number);
            address.setStreet(this.street);
            address.setZipCode(this.zipCode);
            address.setCity(this.city);
            return address;
        }
    }
}

