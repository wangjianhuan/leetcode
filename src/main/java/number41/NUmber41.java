package number41;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.*;

/**
 * @author WJH
 * @date 2021/9/30 上午12:27
 * @QQ 1151777592
 */
public class NUmber41 {
    public static void main(String[] args) {
        System.out.println(new Solution41().firstMissingPositive(new int[]{3, 4,-1,1}));
    }
}

class Solution41 {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            hashSet.add(nums[i]);
        }
        Set<Integer> set = new TreeSet(hashSet);
        Integer[] integers = set.toArray(new Integer[]{});

        int[] result = new int[integers.length];
        for (int i = 0; i < integers.length; i++){
            result[i] = integers[i].intValue();
        }
        int[] numList = new int[result.length];
        for (int i = 0;i< result.length;i++){
            if (result[i] > 0){
                int num = i;
                for (int j = 0; j< result.length-num;j++,i++){
                    numList[j] = result[i];
                }
                return isFlag(numList);
            }
        }
        return 0;
    }

    private int isFlag(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i+1 != nums[i]){
                return i+1;
            }
            if (i == nums.length-1){
                return nums.length+1;
            }
        }
        return 0;
    }

}