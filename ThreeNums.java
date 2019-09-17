# Stack-Queue

//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
//使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//注意：答案中不可以包含重复的三元组。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumsSum {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> arr = new ArrayList<>();
        int len = nums.length;           //求出数组长度
        if(nums == null || len < 3){     //当数组为空或者元素个数小于3时,返回arr
            return arr;
        }
        Arrays.sort(nums);               //将数组按从小到大排序
        for(int i = 0 ; i < len ; i++){  //开始遍历
            if(nums[i] > 0){             //当nums[i] > 0时，说明后面的都是正数，三数之和不可能为0
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){//去除重复的
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    arr.add(Arrays.asList(nums[i] , nums[L] , nums[R]));
                    while(L < R && nums[L] == nums[L + 1]){
                        L++;                     //去除重复的
                    }
                    while(L < R && nums[R] == nums[R - 1]){
                        R--;                     //去除重复的
                    }
                    L++;
                    R--;
                }else if(sum < 0){            //如果和小于0，L++
                    L++;
                }else if(sum > 0){            //如果和大于0，R--
                    R--;
                }
            }
        }
        return arr;                          //返回结果
    }
    public static void main(String[] args) {

    }
}
