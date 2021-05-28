// Finding duplicates in an array.


import java.util.HashSet;

public class duplicates {
    public static boolean containsDuplicate(int[] nums)
    {
        HashSet<Integer> dup= new HashSet<Integer>();
        for(int i= 0; i<nums.length;i++)
        {
            if(dup.contains(nums[i]))
                return true;
            dup.add(nums[i]);
        }
        return false;
    }
    public static void main(String []args)
    {
        int []arr={1,2,3,4};
        System.out.println(containsDuplicate(arr));
    }
}
