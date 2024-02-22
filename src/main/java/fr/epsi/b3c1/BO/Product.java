package fr.epsi.b3c1.BO;

import fr.epsi.b3c1.Enums.ProdType;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String code;
    @Column
    private String label;
    @Column
    private ProdType type;
    @Column
    private double price;

    @ManyToMany(mappedBy = "products")
    private Set<PetStore> petStores;

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", type=" + type +
                ", price=" + price +
                '}';
    }

    public static class Builder {
    private String code;
    private String label;
    private ProdType type;
    private double price;

    public Builder withCode(String code) {
        this.code = code;
        return this;
    }

    public Builder withLabel(String label) {
        this.label = label;
        return this;
    }

    public Builder withType(ProdType type) {
        this.type = type;
        return this;
    }

    public Builder withPrice(double price) {
        this.price = price;
        return this;
    }

    public Product build() {
        Product product = new Product();
        product.setCode(this.code);
        product.setLabel(this.label);
        product.setType(this.type);
        product.setPrice(this.price);
        return product;
    }
}
}
