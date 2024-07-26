package org.example;

public class FishFactory {


    public static Fish createFish() {
        Gender gender = randomGender();
        int age = RandomUtil.getRandomInt(10, 15);
        int x = RandomUtil.getRandomInt(Aquarium.width + 1);
        int y = RandomUtil.getRandomInt(Aquarium.height + 1);
        Fish fish = new Fish(gender, age, x, y);
        return fish;
    }


    public static Gender randomGender() {
        return RandomUtil.getRandomInt(2) == 0 ? Gender.FEMALE : Gender.MALE;
    }


}
