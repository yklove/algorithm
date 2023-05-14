package cn.yklove.leetcode.contest.weekly317;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Solution {
        public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
            Map<String, Map<String, Integer>> map = new HashMap<>();
            for (int i = 0; i < creators.length; i++) {
                String creator = creators[i];
                Map<String, Integer> tmp;
                if (map.containsKey(creator)) {
                    tmp = map.get(creator);
                } else {
                    tmp = new HashMap<>();
                    map.put(creator, tmp);
                }
                tmp.put(ids[i], views[i]);
                tmp.put("all", tmp.getOrDefault("all", 0) + views[i]);
            }
            List<Map.Entry<String, Map<String, Integer>>> collect = map.entrySet().stream().sorted((o1, o2) ->
                    o2.getValue().getOrDefault("all", 0)
                            .compareTo(o1.getValue().getOrDefault("all", 0))
            ).collect(Collectors.toList());

            List<List<String>> list = new ArrayList<>();
            int count = Integer.MIN_VALUE;
            for (int i = 0; i < collect.size(); i++) {
                Map.Entry<String, Map<String, Integer>> stringMapEntry = collect.get(i);
                if (stringMapEntry.getValue().getOrDefault("all", 0) >= count) {
                    count = stringMapEntry.getValue().getOrDefault("all", 0);
                    stringMapEntry.getValue().remove("all");
                    List<Map.Entry<String, Integer>> collect1 = stringMapEntry.getValue().entrySet().stream().sorted((o1, o2) -> {
                        int i1 = o2.getValue().compareTo(o1.getValue());
                        if (i1 == 0) {
                            return o1.getKey().compareTo(o2.getKey());
                        } else {
                            return i1;
                        }
                    }).collect(Collectors.toList());
                    list.add(Arrays.asList(stringMapEntry.getKey(), collect1.get(0).getKey()));
                } else {
                    break;
                }
            }
            return list;
        }
    }

}
