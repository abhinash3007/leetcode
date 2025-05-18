import java.util.*;
public class leetcode127 {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int count=0;
            Set<String>visitedList=new HashSet<>(wordList);
            if(!visitedList.contains(endWord)){
                return 0;
            }
            Queue<String>q=new LinkedList<>();
            q.add(beginWord);
            visitedList.add(beginWord);
            count++;
            while(!q.isEmpty()){
                int size=q.size();
                for(int k=0;k<size;k++){
                    String word=q.remove();
                    char[]arr=word.toCharArray();
                    for(int i=0;i<arr.length;i++){
                        char current=arr[i];
                        for(char c='a';c<='z';c++){
                            arr[i]=c;
                            String newWord=new String(arr);
                            if(newWord.equals(endWord)){
                                return count+1;
                            }
                            if(visitedList.contains(newWord)){
                                q.add(newWord);
                                visitedList.remove(newWord);                                
                            }
                        }
                        arr[i]=current;
                    }
                }
                count++;
            }
            return 0;
        }    
    }
}
