package com.goujiaoprohibited.management.pojo.Loots;
import java.util.HashMap;
import java.util.Map;

public class LootGPMapping {

    private static final Map<String, Map<Integer, Double>> gpMapping = new HashMap<>();

    static {
        Map<Integer, Double> headMapping = new HashMap<>();
        headMapping.put(1, 10.0);
        headMapping.put(2, 12.0);
        headMapping.put(3, 14.0);
        gpMapping.put("head", headMapping);

        Map<Integer, Double> chestMapping = new HashMap<>();
        chestMapping.put(1, 8.0);
        chestMapping.put(2, 9.0);
        chestMapping.put(3, 10.0);
        gpMapping.put("chest", chestMapping);

        Map<Integer, Double> legsMapping = new HashMap<>();
        legsMapping.put(1, 6.0);
        legsMapping.put(2, 7.0);
        legsMapping.put(3, 8.0);
        gpMapping.put("legs", legsMapping);

        Map<Integer, Double> trincketMapping = new HashMap<>();
        trincketMapping.put(1, 10.0);
        trincketMapping.put(2, 12.0);
        trincketMapping.put(3, 14.0);
        gpMapping.put("trincket", legsMapping);
    }

    public static double getPoint(String slot, int level) {
        Map<Integer, Double> levelMap = gpMapping.get(slot);
        if (levelMap == null || !levelMap.containsKey(level)) {
            throw new IllegalArgumentException();
        }
        return levelMap.get(level);
    }
}