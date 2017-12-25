import sun.reflect.generics.tree.Tree;
import sun.security.acl.WorldGroupImpl;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by shantanus on 12/20/2017.
 */
public class Solution {

   /* public String convertToTitle(int n) {
        if(n<=0)
            return "";
        StringBuilder s = new StringBuilder("");
        while(n>0){

        }

    }*/

    public int maxProfit(int[] prices) {
        if(prices.length==0 || prices.length==1)
            return 0;
        int[] min = new int[prices.length];
        int m = Integer.MAX_VALUE;
        for(int i=0; i <prices.length; ++i){
            if(prices[i]<= m){
                m=prices[i];
                min[i]=m;

            }else{
                min[i]=m;
            }
        }
        int maxDiff = Integer.MIN_VALUE;
        for(int i=0; i <prices.length; ++i){
            if(prices[i]-min[i]> maxDiff)
                maxDiff=prices[i]-min[i];
        }
        return maxDiff;
    }

    public boolean isPalindrome(String s) {
        if(s.isEmpty())
            return true;

        s = s.toLowerCase();
        StringBuilder str = new StringBuilder();
        for(int i=0; i < s.length(); ++i){
            if((s.charAt(i)>='a' && s.charAt(i)<='z')||(s.charAt(i)>='0' && s.charAt(i)<='9') ){
                str.append(s.charAt(i));
            }
        }

        return isPalin(str);
    }

    public int addDigits(int num) {
        while(num>=10){
            int s = num;
            num=0;
            while(s!=0){
                int dig = s%10;
                s/=10;
                num +=dig;
            }
        }
        return num;
    }


  class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
  }

  public void wrapper1(){


      Interval[] i = new Interval[2];
      i[0] = new Interval(5,8);
      i[1] = new Interval(6,8);
      canAttendMeetings(i);
  }
   public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }
    });
       //boolean possible = true;
       for(int i=0; i <= intervals.length-2;++i){
           if(intervals[i].end > intervals[i+1].start)
               return false;
       }
       return true;
   }

    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        if(s.isEmpty())
            return ans;

        StringBuilder pat = new StringBuilder("++");
        int idx = 0;
        int t = 0;
        int d = s.length();
        while(idx != -1 && idx+1<s.length()){
            //t = idx;
            idx = s.indexOf(pat.toString(), idx);
            if(idx == -1)
                break;
            StringBuilder temp = new StringBuilder(s);
            ans.add(temp.replace(idx, idx + 2, "--").toString());
            idx++;
        }

        return ans;
    }


    public int missingNumber(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int n = nums.length;
        long sum = n*(n+1)/2;
        long s = 0;
        for(int i=0; i < n;++i){
            s+=nums[i];
        }
        return (int)(sum-s);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hash1 = new HashMap<>();
        HashMap<Integer, Integer> hash2 = new HashMap<>();

        for(int i=0; i < nums1.length; ++i){
            if(hash1.containsKey(nums1[i])){
                int v = hash1.get(nums1[i]);
                hash1.replace(nums1[i], v+1);
            }else{
                hash1.put(nums1[i], 1);
            }
        }

        for(int i=0; i < nums2.length; ++i){
            if(hash2.containsKey(nums2[i])){
                int v = hash2.get(nums2[i]);
                hash2.replace(nums2[i], v+1);
            }else{
                hash2.put(nums2[i], 1);
            }
        }

        HashMap<Integer, Integer> h = new HashMap<>();
        int count = 0;
        for(Integer k : hash1.keySet()){
            if(hash2.containsKey(k)){
                int t = Math.min(hash1.get(k), hash2.get(k));
                h.put(k,t);
                count+=t;
            }
        }
        int[] arr = new int[count];
        int idx = 0;
        for(Integer k : h.keySet()){
            int p = h.get(k);
            for(int i=0;i<p;i++){
                arr[idx]=k;
                idx++;
            }
        }
        return arr;
    }


    public int[] intersection(int[] nums1, int[] nums2) {

        int[] temp = new int[0];
        if(nums1.length == 0 || nums2.length == 0)
            return temp;
        Set<Integer> arr = new HashSet<>();
        Set<Integer> s = new HashSet<>();
        for(int i=0; i < nums1.length;++i){
            if(!s.contains(nums1[i]))
                s.add(nums1[i]);
        }
        int count = 0;
        for(int i=0; i < nums2.length;++i){
            if(s.contains(nums2[i])){
                if(!arr.contains(nums2[i])) {
                    arr.add(nums2[i]);
                    count++;
                }
            }
        }
        int[] x = new int[arr.size()];
        int idx = 0;
        for(Integer k : arr){
            x[idx]=k;
            idx++;
        }
        return x;
    }

    public int reverseBits(int n) {
        if(n==0)
            return 0;
        //long l = Long.toBinaryString(n);
        StringBuilder s = new StringBuilder(Long.toBinaryString(n));
        return (int)Long.parseLong(s.reverse().toString());
    }

    public String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int diff = Math.abs(l1-l2);
        String str = "";
        for(int i=0; i < diff; ++i){
               str="0" + str;
        }

        if(l1>l2){
                num2 = str+num2;
        }else{
            num1 = str+num1;
        }
        int carry = 0;
        StringBuilder s = new StringBuilder();
        for(int i=num1.length()-1; i>=0;--i){
            int j = num1.charAt(i)-'0' + num2.charAt(i)-'0' + carry;
            if(j > 9) {
                j=j%10;
                carry = 1;
            }else{
                carry = 0;
            }
            s.append(j);
        }
        if (carry==1)
            s.append(carry);

        return s.reverse().toString();
    }


   public void wrapper(){

       TreeNode t = new TreeNode(1);
       t.left = null;
       t.right= new TreeNode(2);
        closestValue(t, 3.42);
   }

    public void inorderClos(TreeNode root, Integer min, double target){
        if(root == null)
            return;

        inorderClos(root.left, min, target);

        if( Math.abs(root.val-target) <= Math.abs(min-target))
            min = root.val;

        inorderClos(root.right, min, target);
    }

    public int closestValue(TreeNode root, double target) {
        if(root == null)
            return 0;
        Integer min = root.val;
        inorderClos(root, min, target);
        return min.intValue();
    }

    public int hammingDistance(int x, int y) {
        long l1 = Integer.toUnsignedLong(x);
        long l2 = Integer.toUnsignedLong(y);
        long diff = l1 ^ l2;
        return Long.bitCount(diff);
    }

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        return sb.toString();
    }

    public int arrayPairSum(int[] nums) {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i < nums.length; i=i+2){
            sum+=nums[i];
        }
        return sum;
    }

    public void tp(TreeNode root, LinkedList<Integer> l, List<LinkedList<Integer>> arr){
        if(root == null){
            return;
        }

        l.add(root.val);
        tp(root.left, l, arr);
        if(root.left == null && root.right == null){
            LinkedList<Integer> temp = new LinkedList<>();
            l.forEach((i)-> temp.add(i));
            arr.add(temp);
        }


        tp(root.right, l, arr);
        if(!l.isEmpty()){
            l.removeLast();
        }
    }



    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l1 = new ArrayList<>();
        if(root == null)
            return l1;


        LinkedList<Integer> l = new LinkedList<>();
        List<LinkedList<Integer>> arr = new ArrayList<>();

        tp(root, l, arr);


        for(int i=0; i < arr.size(); ++i){
            StringBuilder s = new StringBuilder();
            for(int j=0; j < arr.get(i).size(); ++j){
                if(j==0){
                    s = s.append(arr.get(i).get(j));
                }else{
                    s= s.append("->" + arr.get(i).get(j));
                }
            }
            l1.add(s.toString());
        }
        return l1;
    }



    public List<String> fizzBuzz(int n) {
        if(n==0)
            return null;
        List<String> l = new ArrayList<>();
        for(int i=1 ; i<=n;++i){
            if(i%3==0 &&  i%5 == 0){
                l.add("FizzBuzz");
                continue;
            }else if(i%3 == 0 ){
                l.add("Fizz");
            }else if(i%5 == 0){
                l.add("Buzz");
            }else{
                l.add(Integer.toString(i));
            }
        }
        return l;
    }


    public void moveZeroes(int[] nums) {

        if(nums.length == 0 || nums.length ==1 )
            return ;

        int i=0;
        int j=0;
        while(true){
            while(i<nums.length && nums[i]!= 0) ++i;
            while(j<nums.length && nums[j]==0 ) ++j;
            boolean swap = false;
            if(i<j && j <nums.length){
                int t = nums[i];
                nums[i]= nums[j];
                nums[j] = t;
                swap = true;

            }
            if(swap == false && i< nums.length && j < nums.length)
                j=j+1;
            if(i>=nums.length || j>= nums.length )
                break;
        }
    }



   public boolean canPermutePalindrome(String s) {
        if(s.length()==0)
            return true;

       HashMap<Character, Integer> hash = new HashMap<>();
       for(int i=0; i < s.length(); ++i){
           if(hash.containsKey(s.charAt(i))){
               int k = hash.get(s.charAt(i));
               hash.replace(s.charAt(i), k+1);
           }else{
               hash.put(s.charAt(i),1);
           }
       }
       int odd = 0;
       int even = 0;
       for(Integer v : hash.values()){
           if(v%2 == 0)
               even++;
           else
               odd++;
       }
       if(odd ==1 || odd ==0 )
           return true;
       else
           return false;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        invertTree(root.left);
        invertTree(root.right);
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;

        return root;
    }

    public int shortestDistance(String[] words, String word1, String word2) {
    if(words.length==0)
        return -1;

    HashMap<String, ArrayList<Integer>> hash = new HashMap<>();
    for(int i=0; i < words.length; ++i){
        if(hash.containsKey(words[i])){
             hash.get(words[i]).add(i);

        }else{
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(i);
            hash.put(words[i], arr);
        }
    }

    ArrayList<Integer> a1 = hash.get(word1);
    ArrayList<Integer> a2 = hash.get(word2);

    int diff = Integer.MAX_VALUE;
    for(int i=0; i < a1.size(); ++i){
        for(int j=0; j< a2.size(); ++j){
            if(Math.abs(a1.get(i)-a2.get(j))< diff){
                diff = Math.abs(a1.get(i)-a2.get(j));
            }
        }
    }

    return diff;
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<nums.length; ++i){
            if(hash.containsKey(nums[i]) ){
                int k = hash.get(nums[i]);
                hash.replace(nums[i], k+1);
            }else{
                hash.put(nums[i], 1);
            }
        }

        for(Integer k : hash.keySet()){
            int v = hash.get(k);
            if(v >= nums.length/2+1)
                return k;
        }
        return -1;
    }



    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0)
            return false;
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();
        for(int i=0; i < nums.length; ++i){
            if(!hash.containsKey(nums[i])) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                hash.put(nums[i], arr);
            }else{
                hash.get(nums[i]).add(i);
            }
        }

        for(ArrayList<Integer> arr : hash.values()){
            for(int i=0; i < arr.size(); ++i){
                for(int j = 0 ; j < arr.size(); ++j){
                    if(i!=j){
                        if(Math.abs(arr.get(i)-arr.get(j))<=k){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }


    public boolean containsDuplicate(int[] nums) {

        if(nums.length == 0)
            return false;

        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i < nums.length; ++i){
            if(hash.containsKey(nums[i]))
                return false;
            hash.put(nums[i], 1);
        }
        return true;
    }


    public boolean isIsomorphic(String s, String t) {
        if(s.isEmpty() || t.isEmpty())
            return true;
        s= s.toLowerCase();
        t= t.toLowerCase();

        ArrayList<ArrayList<Integer>> l1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> l2 = new ArrayList<ArrayList<Integer>>();
        HashMap<Character, Integer> arr1 = new HashMap<>();
        HashMap<Character, Integer> arr2 = new HashMap<>();

        for(int i=0; i < s.length(); ++i){
            Character v = s.charAt(i);
            if(!arr1.containsKey(v)) {
                arr1.put(v,l1.size());
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                l1.add(l);
            }else {
                l1.get(arr1.get(s.charAt(i))).add(i);
            }
        }

        for(int i=0; i < t.length(); ++i){
            Character v = t.charAt(i);
            if(!arr2.containsKey(v)) {
                arr2.put(v,l2.size());
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                l2.add(l);
            }else {
                l2.get(arr2.get(t.charAt(i))).add(i);
            }
        }

        if(l1.size() != l2.size())
            return false;

        for(int j = 0; j< l1.size(); ++j){
            if(l1.get(j).size() != l2.get(j).size())
                return false;
            for(int k=0; k < l1.get(j).size(); ++k ){
                if(l1.get(j).get(k) != l2.get(j).get(k))
                    return false;
            }
        }
        return true;
    }

    public int hammingWeight(int n) {


      return Integer.bitCount(n);
    }

    public void deleteNode(ListNode node) {
        if(node == null)
            return;

        //ListNode temp = node;
        if(node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
        }

    }

    public boolean isAnagram(String s, String t) {
        if(s.isEmpty() && t.isEmpty())
            return true;
        if(s.isEmpty() &&  !t.isEmpty())
            return false;

        if(!s.isEmpty() &&  t.isEmpty())
            return false;

        if(s.length() != t.length())
            return false;

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        for(int i=0; i < s1.length; ++i ){
            if(s1[i]!=t1[i])
                return false;
        }
        return true;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)
            return null;

        if(p == null && q==null)
            return root;

        if(p != null && q==null)
            return p;

        if(p == null && q!=null)
            return q;

        if(p==q)
            return p;

        while(root!=null){
            if((root.val == p.val) ||(root.val == q.val) || ((q.val < root.val) && (p.val > root.val)) || ((q.val > root.val) && (p.val < root.val))){
                return root;
            }
            if(p.val<root.val && q.val<root.val){
                root=root.left;
            }
            if(p.val>root.val && q.val>root.val){
                root=root.right;
            }
        }
        return root;
        }

    public void rotate(int[] nums, int k) {
        if(k > nums.length)
            k = k%nums.length;

        if(nums.length==0 || k==0 || k == nums.length)
            return;
        if(k > nums.length)
            k = nums.length%k;

        reverse(nums,0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        return;
    }

    public void reverse(int[] nums, int s, int e){
        if(s+1==e){
            int t = nums[e];
            nums[e] = nums[s];
            nums[s]=t;
            return;
        }

        for(int i=0; i <= (e-s)/2; ++i){
            int t = nums[s+i];
            nums[s+i] = nums[e-i];
            nums[e-i]=t;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;

        while(head != null && head.val== val ){
            head = head.next;
        }
        if(head == null )
            return null;

        ListNode curr = head;
        ListNode prev = head;
        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
                curr=curr.next;
            }else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode prev=null;
        ListNode curr = head;
        ListNode ahead = head.next;
        while(ahead!=null){
            curr.next=prev;
            prev=curr;
            curr=ahead;
            ahead=ahead.next;

        }
        curr.next=prev;
        return curr;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB== null)
            return null;
        int a = getLength(headA);
        int b = getLength(headB);
        if(a > b ){
            int i = 0;
            while(i<(a-b)){
                headA = headA.next;
                i++;
            }
        }else{
            int i = 0;
            while(i<(b-a)){
                headB = headB.next;
                i++;
            }
        }
        while(true) {
            if(headA == headB)
                return headA;
            if(headA==null || headB==null)
                return null;
            headA=headA.next;
            headB=headB.next;
        }
    }

    public int getLength(ListNode l){
        int count = 0;
        while(l != null){
            l=l.next;
            count++;
        }
        return count;
    }

    public int[] twoSum1(int[] numbers, int target) {
        int[] ans = new int[2];
        int i = 0; int j = numbers.length-1;
        while(i < j){
            int s = (numbers[i] + numbers[j]);
            if(s ==target){
                ans[0]=i+1;
                ans[1]=j+1;
                return ans;
            }else if(s<target){
                i++;
            }else{
                j--;
            }

        }
        return ans;
    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != null && fast != null && fast.next!=null){
            if(slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null ){
            return false;
        }

        if(root == null && sum!=0)
            return false;

        if( (root != null) && (root.left==null) && (root.right==null) && (root.val==sum)) {
            return true;
        }

        return (hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val));

    }

    int minimumDepth(TreeNode root)
    {
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null)
            return 0;

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;

        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minimumDepth(root.right) + 1;

        // If right subtree is NULL, recur for right subtree
        if (root.right == null)
            return minimumDepth(root.left) + 1;

        return Math.min(minimumDepth(root.left),
                minimumDepth(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int d1 = maxDepth(root.left);
        int d2 = maxDepth(root.right);
        if(Math.abs(d1-d2)> 1)
            return false;
        else
            return (isBalanced(root.left) && isBalanced(root.right));
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        if(nums.length == 1) {
            TreeNode t = new TreeNode(nums[0]);
            return t;
        }

        TreeNode t1 = sortedArrayToBSTwithParams(nums, 0, nums.length-1);
        return t1;
    }


    public TreeNode sortedArrayToBSTwithParams(int[] nums, int low, int high) {
        if(low > high)
            return null;
        if(low == high)
            return new TreeNode(nums[low]);

        int mid = (low+high)/2 + 1;
        TreeNode t = new TreeNode(nums[mid]);
        t.left=sortedArrayToBSTwithParams(nums, low, mid-1);
        t.right=sortedArrayToBSTwithParams(nums, mid+1, high);
        return t;
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> l = new ArrayList<>();
        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();
        if(root == null)
            return l;

        q1.add(root);


        while(true) {
            if(q1.isEmpty() && q2.isEmpty())
                break;
            if (!q1.isEmpty()) {
                ArrayList<Integer> l1 =  new ArrayList<>();
                while (!q1.isEmpty()) {
                    TreeNode temp = q1.remove();

                    l1.add(temp.val);

                    if (temp.left != null)
                        q2.add(temp.left);
                    if (temp.right != null)
                        q2.add(temp.right);

                }
                l.add(l1);
            }

            if (!q2.isEmpty()) {
                ArrayList<Integer> l1 =  new ArrayList<>();
                while (!q2.isEmpty()) {
                    TreeNode temp = q2.remove();
                    l1.add(temp.val);
                    if (temp.left != null)
                        q1.add(temp.left);
                    if (temp.right != null)
                        q1.add(temp.right);

                }
                l.add(l1);
            }
        }

        //Collections.reverse(l);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=l.size()-1; i >= 0; --i){
            ans.add(l.get(i));
        }
        return ans;
    }


    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isMirror(root.left, root.right);
    }

    boolean isMirror(TreeNode l, TreeNode r){
        if(l==null && r== null)
            return true;
        if(l==null || r == null)
            return false;

        return (l.val ==r.val && isMirror(l.left,r.right) && isMirror(l.right,r.left));

    }

    boolean isPalin(StringBuilder s){
        for(int i=0; i < (s.length()/2)+1; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    void inorderTraverse(TreeNode t, StringBuilder s){
        if(t == null)
            return ;
        inorderTraverse(t.left, s);
        s.append(t.val);
        inorderTraverse(t.right,s);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;

        ListNode temp = head;
        ListNode curr = head;

        while(curr!=null) {
            while (curr.next != null && temp.val == curr.val) {
                curr = curr.next;
            }
            temp.next = curr;
            temp = temp.next;
            curr=curr.next;
        }
        return head;
    }

    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }

        int[] dp = new int [n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<n+1;++i){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public String addBinary(String a, String b) {
        StringBuilder s1 = new StringBuilder(a).reverse();
        StringBuilder s2 = new StringBuilder(b).reverse();
        StringBuilder ans = new StringBuilder("");

        int diff = Math.abs(s1.length()-s2.length());
        char[] c = new char[diff];
        Arrays.fill(c,'0');

        if(s1.length()> s2.length())
            s2=s2.append(c);
        else
            s1.append(c);


        int carry = 0;
        for(int i = 0; i < s1.length() ; ++i){
            int p = (s1.charAt(i)-'0') + (s2.charAt(i)-'0') + carry;
            if(p==0||p==1 ) {
                carry = 0;
            }
            if(p==2|| p==3){
                carry=1;
                p=p%2;
            }
            ans.append(p);
        }

        if(carry==1)
            ans.append(1);

        return ans.reverse().toString();

    }


    public int[] plusOne(int[] digits) {
        int l = digits.length-1;
        int carry = 1;
        for(int i=l; i>= 0; --i) {
            digits[i]= digits[i]+carry;
            if(digits[i] == 10) {
                digits[i]=0;
                carry=1;
            }else {
                carry=0;
            }

        }
        if(carry == 1) {
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            for(int i=1; i < ans.length ; ++i) {
                ans[i]=digits[i-1];
            }
            return ans;
        }
        return digits;
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0)
            return 0;
        int j = s.length()-1;
        int count = 0;
        while(j>=0 && s.charAt(j)!=' '){
            count++;
        }

        return count;
    }

    public int searchInsert(int[] nums, int target) {
        int i=0;
        int j = nums.length-1;
        if(target<nums[0])
            return 0;
        if(target > nums[j]){
            return j+1;
        }

        while(i<j){
            if(nums[i]==target)
                return i;
            if(nums[j]==target)
                return j;

            int mid = (i+j)/2+1;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid]> target)
                j=mid-1;
            else
                i=mid+1;

        }
        if(target> nums[i])
            return i+1;
        else
            return i;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            while(i<nums.length){
                if(nums[i]==val) {
                    break;
                }
                i++;
            }
            while(j>=0){
                if(nums[j]!=val){
                    break;
                }else{
                    j--;
                }
            }

            if(i<j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }

        }
        for(int k=0; k < nums.length;++k) {
            if(nums[k] == val)
                count++;

        }
        return nums.length-count;
    }

  public int removeDuplicates(int[] nums) {

      if(nums.length==0 || nums.length==1)
          return nums.length;

      if(nums.length==2){
          if(nums[0]==nums[1])
              return 1;
          else
              return 2;
      }

      int i=0;
      int j = 1;

      while(j<nums.length){
          if(nums[i]==nums[j]){
              j++;
          }else{
            nums[i+1]=nums[j];
              i++;
              j++;
          }
      }

        return i+1;
    }

  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode temp = null;
        ListNode head = null;

        if(l1.val < l2.val) {
            temp = l1;
            l1 = l1.next;
        }else{
            temp = l2;
            l2=l2.next;
        }

        head = temp;

        while(l1 != null && l2!= null){
            if(l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2=l2.next;
            }
            temp=temp.next;
        }

        if(l1 == null){
            temp.next = l2;
        }else{
            temp.next=l1;
        }

        return head;
    }


    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> st = new Stack<Character>();

        for(int i=0; i < s.length(); ++i){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
                st.push(s.charAt(i));
                continue;
            }
            char c = s.charAt(i);
            if(c == ')' || c == '}' || c == ']' ){
                if(!st.empty()){
                    Character p = st.pop();
                    if( !(  (c == ')' && p == '(') ||
                            (c == '}' && p == '{') ||
                            (c == ']' && p == '['))) {
                        return false;
                    }
                }
            }
        }
        if(st.empty())
            return true;
        else
            return false;
    }

    public String longestCommonPrefix(String[] strs) {
            if(strs.length == 0){
                return new String("");
            }
            if(strs.length == 1){
                return strs[0];
            }

            Arrays.sort(strs);

            if(strs[0].length() == 0){
                return new String("");
            }
            int i=0;
            int count=0;
            int k = Math.min(strs[0].length(), strs[strs.length-1].length());
            while(i<k) {
                if(strs[0].charAt(i) == strs[strs.length-1].charAt(i)){
                    count++;
                }else{
                    break;
                }
                ++i;
            }
            String s = strs[0].substring(0,count);
            return s;

        }


    public boolean isPalindrome(int x) {
        if(x<0 || (x>0 && x%10 == 0))
            return false;
        if(x/10 == 0)
            return true;

        int no = 0;
        while(x>no) {
            no = (no*10) + (x%10);
            x=x/10;
        }
        if(no == x || x == no/10)
            return true;
        else
            return false;
    }

/*
    public int reverse(int x) {
        boolean neg = false;
        if(x<0) {
            neg = true;
            x*=-1;
        }
        BigInteger newInt = new BigInteger("0");
        BigInteger mul = new BigInteger("0");
        BigInteger newMul = new BigInteger("10");
        while(x>0){
            newInt = (newInt.multiply(mul));
              newInt = newInt.add(new BigInteger(Integer.toString(x%10)));
            x/=10;
            if(mul.intValue() == 0)
                mul = newMul;
        }
        if(newInt.longValue() > Integer.MAX_VALUE)
            return 0;

        System.out.println(newInt.toString());
        if(neg){
            //System.out.println();
            return newInt.intValue() * -1;
        }
        return newInt.intValue();
    }
*/

    public int[] twoSum(int[] nums, int target) {
        element[] arr = new element[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            arr[i] = new element();
            arr[i].idx = i;
            arr[i].val = nums[i];
        }

        Arrays.sort(arr, new Comparator<element>() {
            @Override
            public int compare(element o1, element o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int k = arr[i].val + arr[j].val;
            if(k == target)
                break;
            else if (k < target) {
                i++;
            } else {
                j--;
            }
        }
        int[] rtr = new int[2];
        rtr[0]=arr[i].idx;
        rtr[1]=arr[j].idx;
        return rtr;

    }

    class element {
        public int idx;
        public int val;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
