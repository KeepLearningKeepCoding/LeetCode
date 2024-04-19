import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        combine(n, k, 1, new ArrayList<>(), list);
        return list;
    }

    private void combine(int n, int k, int start, List<Integer> tmp, List<List<Integer>> list) {
        if (k == 0) {
            list.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            tmp.add(i);
            combine(n, k - 1, i + 1, tmp, list);
            tmp.remove(Integer.valueOf(i));
        }
    }
}
