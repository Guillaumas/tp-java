package fr.epsi.b3c1.Animals;

import fr.epsi.b3c1.BO.Animal;
import fr.epsi.b3c1.Enums.FishLiveEnv;
import jakarta.persistence.*;

@Entity
public class Fish extends Animal {
    @Column(name = "living_env")
    private FishLiveEnv livingEnv;

    public Fish() {
    }

    public FishLiveEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLiveEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv +
                '}';
    }

    public static class Builder {
        private FishLiveEnv livingEnv;

        public Builder withLivingEnv(FishLiveEnv livingEnv) {
            this.livingEnv = livingEnv;
            return this;
        }

        public Fish build() {
            Fish fish = new Fish();
            fish.setLivingEnv(this.livingEnv);
            return fish;
        }
    }
}
