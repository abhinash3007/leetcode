import java.util.*;
public class leetcode68 {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> result = new ArrayList<>();
            int i = 0;
            while (i < words.length) {
                int totalWords = words[i].length();
                int space = 0;
                int j = i + 1;
                while (j < words.length && 1 + words[j].length() + space + totalWords <= maxWidth) {
                    totalWords += words[j].length();
                    space += 1;
                    j++;
                }
                int remaining = maxWidth - totalWords;
                int extraSpace =  space==0 ? 0:remaining / space;
                int extraSpaceRemaining = space==0 ? 0: remaining % space;
                if (j == words.length) {
                    extraSpace = 1;
                    extraSpaceRemaining = 0;
                }
                result.add(findLine(i, j, extraSpace, extraSpaceRemaining, words, maxWidth));
                i = j;
            }
            return result;
        }
    
        public String findLine(int i, int j, int extraSpace, int extraSpaceRemaining, String[] words, int maxWidth) {
            StringBuilder s = new StringBuilder();
            for (int k = i; k < j; k++) {
                s.append(words[k]);
                  if(k == j-1)
                    continue;
                for (int z = 1; z <= extraSpace; z++) {
                    s.append(" ");
                    if (extraSpaceRemaining > 0) {
                        s.append(" ");
                        extraSpaceRemaining--;
                    }
                }
            }
            while (s.length() < maxWidth) {
                s.append(" ");
            }
            return s.toString();
        }
    
}
