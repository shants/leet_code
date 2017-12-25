import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.*;

/**
 * Created by shantanus on 10/6/2017.
 */

class obj {
    public int idx;
    public int val;
}

public class MainClass {
    public static void main(String[] args)
    {
/*
        int arr[] = new int[10];
        Random r = new Random();
        for(int i=0; i < 10; ++i){

            arr[i] = r.nextInt(100);
        }
*/
/*
//        MergeSort m = new MergeSort();
//        m.printArr(arr);
//        m.mergeSort(arr, 0, arr.length -1);
//        m.printArr(arr);
        char[] str = {'d','c','f','e','b','a'};
//        for(int i=0;i< str.length;++i){
//            System.out.println(str[i]);
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("No of test cases");
            String s = br.readLine();
            int i = Integer.parseInt(s.trim());
            System.out.println("No of Test cases #" + i);

            System.out.println("Enter values");
            s = br.readLine();
            System.out.println(s);
            String[] inpArr = s.split(" ");
            int[] valArr = new int[inpArr.length];
            for(int ii=0; ii < inpArr.length;++ii){
                valArr[ii] = Integer.parseInt(inpArr[ii].trim());
            }

            for(int x=0;x<valArr.length;++x){
                System.out.println(" * " + valArr[x]);
            }
            System.out.flush();
            br.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }


//        NextPermutation p = new NextPermutation();
//        p.next(str);
        //System.out.println("No of Permutations = " + p.getCount());
*/
Solution s = new Solution();
//        System.out.println("Ans is " + Integer.toString(s.reverse(-123)));
//        System.out.println("\n");

//        String s1 = new String("()[]{}");
//        System.out.println(s.isValid(s1));

         //   s.addBinary("1101","1");

        int[] nums = {1,0,0};
        //s.reverse(nums,0,nums.length-1);
        //s.rotate(nums,1);
        int n = 11;
        //s.hammingWeight(n);
        //String str1 = new String("aaaaabbbbbcccccdddddeeeee");
        //String str2 = new String("pppppqqqqqrrrrrsssssttttt");
        //s.isIsomorphic(str1,str2);
        //s.containsNearbyDuplicate(nums,1);
        //s.majorityElement(nums);
        //s.moveZeroes(nums);
        //s.fizzBuzz(15);
        //System.out.println("Ans is " + s.addStrings("9", "99"));
        //BigInteger b  = new BigInteger("4294967295");
        //s.reverse(b.intValue());

        //int[] nums1 = {1};
        //int[] nums2 = {1};
        //s.intersect(nums1, nums2);
        //s.wrapper1();
        //s.isPalindrome("ab");
        int[] nums1 = { 7,1,5,3,6,4};
        s.maxProfit(nums1);
    }
}


