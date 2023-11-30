import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] a = {0,3,7,2,5,8,4,6,0,1};
//       int as = longestConsecutive(a);
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] a  = new int[len];
        a[0] = nums[0];
        for (int i=1;i<len;i++){
            if (a[i-1]>0){
                a[i]= a[i-1]+nums[i];
            }
            else {
                a[i] = nums[i];
            }
        }
        int res = a[0];
        for (int i=1;i<len;i++){
            res =  Math.max(res,a[i]);
        }
        return res;
    }
}