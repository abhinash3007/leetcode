import java.util.Arrays;

public class leetcode135 {
    public int candy(int[] ratings) {
        // int[]count=new int[ratings.length];
        // Arrays.fill(count,1);
        // int amount=0;
        // for(int i=1;i<ratings.length;i++){
        //     if(ratings[i]>ratings[i-1]){
        //         count[i]=count[i-1]+1;
        //     }
        // }for(int i=ratings.length-2;i>=0;i--){
        //     if(ratings[i]>ratings[i+1]){
        //         count[i]=Math.max(count[i],count[i+1]+1);
        //     }
        // }for(int i=0;i<count.length;i++){
        //     amount+=count[i];
        // }
        // return amount;
        int sum=1;
        int peak=0;
        int down=0;
        int i=1;
        while(i<ratings.length){
            if(ratings[i]==ratings[i-1]){
                sum+=1;
                i++;
                continue;
            }
            peak=1;
            while(i< ratings.length && ratings[i]>ratings[i-1]){
                peak++;
                sum+=peak;
                i++;
            }down=0;
            while(i< ratings.length && ratings[i]<ratings[i-1]){
                down++;
                sum+=down;
                i++;
            }down++;
            if(down>peak){
                sum+=down-peak;
            }

        }
        return sum;
    }
}
