package cn.yklove.nowcoder.course2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem3 {

    /**
     * 给一个包含n个整数元素的集合a，一个包含m个整数元素的集合b。 </br>
     * 定义magic操作为，从一个集合中取出一个元素，放到另一个集合里，且操作过后每个集合的平均值都大大于于操作前。 </br>
     * 注意以下两点: </br>
     * 1)不可以把一个集合的元素取空，这样就没有平均值了 </br>
     * 2)值为x的元素从集合b取出放入集合a，但集合a中已经有值为x的元素，则a的平均值不变(因为集合元素不会重复)，</br>
     * b的平均值可能会改变(因为x被取出了)
     * </p>
     * 问最多可以进行多少次magic操作?
     */
    public class Soulution {

        /**
         * 经过分析，只能从平均值大的集合中取数字，放到平均值小的那个结合中才能满足条件。</br>
         * 并且，取出来的这个数字，必须满足大于集合b的平均值，并且小于集合a的平均值。 （平均b < x < 平均a）</br>
         * 并且，取的时候，先取最小的。(贪心)</br>
         * 因为拿最小的，会使集合a的平均值得到最大的提升，并且是集合b的平均值提升范围最小。</br>
         */
        public int magic(int[] a, int[] b) {
            double sumA = 0;
            double sumB = 0;
            for (int i = 0; i < a.length; i++) {
                sumA += a[i];
            }
            for (int i = 0; i < b.length; i++) {
                sumB += b[i];
            }
            int[] maxArr;
            int[] minArr;
            double maxSum;
            double minSum;
            double maxCount;
            double minCount;
            if (sumA > sumB) {
                maxArr = a;
                maxSum = sumA;
                minArr = b;
                minSum = sumB;
            } else {
                maxArr = b;
                maxSum = sumB;
                minArr = a;
                minSum = sumA;
            }
            minCount = minArr.length;
            maxCount = maxArr.length;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < minArr.length; i++) {
                set.add(minArr[i]);
            }
            Arrays.sort(maxArr);
            int ans = 0;
            for (int i = 0; i < maxArr.length; i++) {
                if (maxArr[i] > minSum / minCount && maxArr[i] < maxSum / maxCount) {
                    if (set.contains(maxArr[i])) {
                        maxSum -= maxArr[i];
                        maxCount -= 1;
                        ans++;
                        continue;
                    }
                    set.add(maxArr[i]);
                    maxCount -= 1;
                    minCount += 1;
                    maxSum -= maxArr[i];
                    minSum -= maxArr[i];
                    ans++;
                }
            }
            return ans;
        }

    }

}