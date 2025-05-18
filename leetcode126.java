import java.util.*;
public class leetcode126 {
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) {
                return new ArrayList<>();
            }
    
            // Initialize the queue with the starting word
            Queue<List<String>> queue = new LinkedList<>();
            queue.add(Arrays.asList(beginWord));
    
            // This will store the final result of all shortest paths
            List<List<String>> result = new ArrayList<>();
    
            // Set to store visited words to prevent revisiting in current BFS level
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);
    
            // Flag to stop processing once we find the shortest paths
            boolean found = false;
    
            while (!queue.isEmpty() && !found) {
                int size = queue.size();
    
                // Track words visited in the current level
                Set<String> localVisited = new HashSet<>();
    
                // Process all paths in the current level
                for (int i = 0; i < size; i++) {
                    List<String> path = queue.poll();
                    String word = path.get(path.size() - 1);
    
                    // If we reached the endWord, add the current path to the result
                    if (word.equals(endWord)) {
                        found = true;
                        result.add(path);
                    } else {
                        // Try all possible single-letter transformations
                        for (int j = 0; j < word.length(); j++) {
                            char[] chars = word.toCharArray();
                            for (char c = 'a'; c <= 'z'; c++) {
                                chars[j] = c;
                                String nextWord = new String(chars);
    
                                // Only consider valid words that are in wordSet and not yet visited
                                if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                                    List<String> newPath = new ArrayList<>(path);
                                    newPath.add(nextWord);
                                    queue.add(newPath);
                                    localVisited.add(nextWord);
                                }
                            }
                        }
                    }
                }
    
                // Add all locally visited words to the global visited set
                visited.addAll(localVisited);
            }
    
            return result;
        }
    }
}
