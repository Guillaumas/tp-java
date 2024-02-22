package fr.epsi.b3c1.BO;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100)
    private String managerName;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private Set<Animal> animals;

    @ManyToMany
    @JoinTable(
            name = "petstore_product",
            joinColumns = @JoinColumn(name = "petstore_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;


    public PetStore() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                '}';
    }

    public static class Builder {
        private String name;
        private String managerName;
        private Address address;
        private Set<Animal> animals;
        private Set<Product> products;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withAnimals(Set<Animal> animals) {
            this.animals = animals;
            return this;
        }

        public Builder withProducts(Set<Product> products) {
            this.products = products;
            return this;
        }

        public PetStore build() {
            PetStore petStore = new PetStore();
            petStore.setName(this.name);
            petStore.setManagerName(this.managerName);
            petStore.setAddress(this.address);
            petStore.setAnimals(this.animals);
            petStore.setProducts(this.products);
            return petStore;
        }
    }
}
