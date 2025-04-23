import java.util.HashMap;

public class leetcode76 {
    class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }int start=0;int end=0;int len=Integer.MAX_VALUE;int freq=map.size();int startIndex=-1;
        while(end<s.length()){
            char ch=s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    freq--;
                }
            }while(freq==0){
                int size=end-start+1;
                if(size<len){
                    len=size;
                    startIndex=start;
                }ch=s.charAt(start);
                if(map.containsKey(ch)){
                    map.put(ch, map.getOrDefault(ch,0)+1);
                    if(map.get(ch)>0){
                        freq++;
                    }
                }start++;
            }end++;
        }if(startIndex==-1){
            return "";
        }
       return s.substring(startIndex, startIndex + len);

    }
}

}
