import java.util.Collections;

/**
 * Created by shantanus on 12/16/2017.
 */
public class NextPermutation {
    public void next(char[] str) {
        // find next lexographical value
        // step 1 find largest k such that str[k]<str[k+1]
        // step 2 find largest l such that str[k]<str[l]
        // step 3 swap str[k] str[l]
        // step 4 sort str[k+1] .. str[n]
        int k = str.length-1;
        for(k=str.length-2;k>=0;k--){
            if(str[k]<str[k+1])
                break;
        }

        if(k==-1) {
            System.out.println("No More Perms");
            System.exit(-1);
        }

        System.out.println("Index k is " + k);

        int i = k;
        int pIdx = k+1;
        // find least no greater than k
        while(i< str.length){
            if(str[k]< str[i] && str[i]<str[pIdx]){
                pIdx=i;
            }
            i++;
        }
        // swap k, i
        char t = str[pIdx];
        str[pIdx] = str[k];
        str[k]=t;

        // sort
        java.util.Arrays.sort(str,k+1,str.length);

        System.out.println("Next Perm is " );
        for(int x=0;x<str.length;++x){
            System.out.print(str[x]+" ");

        }
        System.out.println("\n");

    }
}
