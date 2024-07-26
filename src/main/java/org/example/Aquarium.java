package org.example;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    public static int width = 5; //x axis
    public static int height = 5; //y axis
    public static int MAX_NUMBER = (width + 1) * (height + 1); //y axis
    private static final List<Fish> fishList = new ArrayList<Fish>();


    public void start() {
        int fishCount = RandomUtil.getRandomInt(5, 10);
        for (int i = 0; i < fishCount; i++) {
            Fish fish = FishFactory.createFish();
            fish.start();
            fishList.add(fish);
        }
    }

    public static void collision(Fish current) {
        if (fishList.size() >= MAX_NUMBER) {
            return;
        }
        synchronized (Aquarium.class) {
            for (Fish fish : fishList) {
                if (current.crush(fish)) {
                    Fish babyFish = FishFactory.createFish();
                    System.out.println("Collision " + current.getName() + " with " + fish.getName() + " and " + babyFish.getName());
                    babyFish.start();
                    fishList.add(babyFish);
                    printStatistics();
                    break;
                }
            }
        }

    }

    public static synchronized void remove(Fish fish) {
        fishList.remove(fish);
        System.out.println("RIP ->" + fish.getName()); //Rest in peace!
        printStatistics();
    }

    public static void printStatistics() {
        int male = 0, female = 0;
        int totalCount = fishList.size();
        for (Fish fish : fishList) {
            if (fish.getGender().equals(Gender.MALE)) {
                male++;
            } else {
                female++;
            }
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Total Fish Count: " + totalCount + ", male: " + male + ", female: " + female);
    }

}
