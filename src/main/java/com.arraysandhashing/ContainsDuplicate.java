

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,5,-2,-4,0};
        boolean result = containsDuplicateUsingTwoForLoops(nums);
        System.out.println(result);
        System.out.println("=============================================");
        boolean res = containsDuplicateUsingTwoPointer(nums);
        System.out.println(res);

    }

    public static boolean containsDuplicateUsingTwoForLoops(int[] nums) {

        if(nums.length <= 1)
            return false;

        for(int i =0; i < nums.length ; i++){
            for(int j = i+1; j< nums.length; j++){
                if(nums[i] == nums[j])
                    return true;
            }
        }

        return false;
    }
    public static boolean containsDuplicateUsingTwoPointer(int[] nums){

        if(nums.length <= 1)
            return false;

        Set<Integer> exists = new HashSet<>();

        for(int i =0 ; i< nums.length; i++){
            if(!exists.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
