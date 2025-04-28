import java.util.*;
public class leetcode89 {
        private List<String> solveRec(int n){
            if(n==1){
                List<String> list = new ArrayList<>();
                list.add("0");
                list.add("1");
                return list;
            }
    
            List<String> res = new ArrayList<>();
            List<String> list = solveRec(n-1);
            for(int i=0; i<list.size(); i++){
                res.add("0" + list.get(i));
            }
            for(int i=list.size()-1; i>=0; i--){
                res.add("1" + list.get(i));
            }
            return res;
        }
    
    
        public List<Integer> grayCode(int n) {
            List<String> list = solveRec(n);
            List<Integer> ans = new ArrayList<>();
            for(String s:list){
                ans.add(Integer.parseInt(s, 2));
            }
            return ans;
        }
}
