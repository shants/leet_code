/**
 * Created by shantanus on 12/16/2017.
 */
public class Permutation {
    int count = 0;
    public int getCount() {
        return count;
    }
    public void printPermute(char[] str){
        for(int i=0; i < str.length; ++i){
            System.out.print(str[i]+" ");
        }
        System.out.println("\n");
    }


    public void permute(char[] str, int i, int j){
        if(i >= j){
            count++;
            printPermute(str);

            return;
        }else{
            for(int k=i;k<=j;k++){
                char t;
                t = str[i];
                str[i]= str[k];
                str[k]=t;

                permute(str,i+1,j);

                t = str[i];
                str[i]= str[k];
                str[k]=t;
            }
        }
    }
}
