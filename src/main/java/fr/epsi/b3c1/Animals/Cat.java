package fr.epsi.b3c1.Animals;

import fr.epsi.b3c1.BO.Animal;
import jakarta.persistence.*;

@Entity
public class Cat extends Animal {
    @Column(name = "chip_id")
    private String chipId;

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                "chipId='" + chipId + '\'' +
                '}';
    }

    public static class Builder {
        private String chipId;

        public Builder withChipId(String chipId) {
            this.chipId = chipId;
            return this;
        }

        public Cat build() {
            Cat cat = new Cat();
            cat.setChipId(this.chipId);
            return cat;
        }
    }
}
