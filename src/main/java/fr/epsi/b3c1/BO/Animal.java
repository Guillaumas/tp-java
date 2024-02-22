package fr.epsi.b3c1.BO;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private LocalDate birth;

    @Column(length = 50)
    private String color;

    @ManyToOne
    @JoinColumn(name = "petStore_id", nullable = false)
    private PetStore petStore;

    public Animal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", color='" + color + '\'' +
                '}';
    }

    public static class Builder {
        private LocalDate birth;
        private String color;
        private PetStore petStore;

        public Builder withBirth(LocalDate birth) {
            this.birth = birth;
            return this;
        }

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Builder withPetStore(PetStore petStore) {
            this.petStore = petStore;
            return this;
        }

        public Animal build() {
            Animal animal = new Animal();
            animal.setBirth(this.birth);
            animal.setColor(this.color);
            animal.setPetStore(this.petStore);
            return animal;
        }
    }
}
