import java.util.ArrayList;
import java.util.List;

public class leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <=rowIndex; i++) {
            List<Integer> ans = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    ans.add(1);
                } else if (j == i) {
                    ans.add(1);
                } else {
                    int a = list.get(i - 1).get(j - 1);
                    int b = list.get(i - 1).get(j);
                    int c = a + b;
                    ans.add(c);
                }
            }
            list.add(ans);
        }
        return list.get(rowIndex);
    }
}
