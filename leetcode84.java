import java.util.Stack;

public class leetcode84 {
    public int largestRectangleArea(int[] heights) {
        int ans=0;
        Stack<Integer>s=new Stack<>();        
        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                int index=s.peek();
                s.pop();
                if(s.isEmpty()){
                ans=Math.max(ans,heights[index]*i);
            }else{
                ans=Math.max(ans,heights[index]*(i-s.peek()-1));
            }
            }
            s.push(i);
        }while(!s.isEmpty()){
            int index=s.peek();
            s.pop();
            if(s.isEmpty()){
                ans=Math.max(ans,heights[index]*heights.length);
            }else{
                ans=Math.max(ans,heights[index]*(heights.length-s.peek()-1));
            }
        }return ans;
    }
}
