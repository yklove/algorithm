package cn.yklove.leetcode.contest.weekly303;

import java.util.*;

/**
 * @author beamjl
 */
public class LeetCode3 {

    class FoodRatings {

        Map<String, PriorityQueue<Food>> map = new HashMap<>();

        Map<String, Food> map2 = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                Food food = new Food(foods[i], cuisines[i], ratings[i]);
                if (!map.containsKey(food.cuisines)) {
                    map.put(food.cuisines, new PriorityQueue<>((o1, o2) -> {
                        int tmp = o2.ratings.compareTo(o1.ratings);
                        if (tmp == 0) {
                            return o1.name.compareTo(o2.name);
                        }
                        return tmp;
                    }));
                }
                map.get(food.cuisines).add(food);
                map2.put(food.name, food);
            }
        }

        public void changeRating(String food, int newRating) {
            Food food1 = map2.get(food);
            PriorityQueue<Food> foods = map.get(food1.cuisines);
            foods.remove(food1);
            food1.ratings = newRating;
            foods.add(food1);
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Food> foods = map.get(cuisine);
            return foods.peek().name;
        }

        class Food {
            String name;
            String cuisines;
            Integer ratings;

            public Food(String name, String cuisines, Integer ratings) {
                this.name = name;
                this.cuisines = cuisines;
                this.ratings = ratings;
            }
        }
    }

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
}
