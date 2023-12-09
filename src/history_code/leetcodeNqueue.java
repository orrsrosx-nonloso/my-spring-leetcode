package history_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcodeNqueue {
    private int n;
    private int[] col;
    private boolean[] onPath, diag1, diag2;
    private final List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        col = new int[n];
        onPath = new boolean[n];
        diag1 = new boolean[n * 2 - 1];
        diag2 = new boolean[n * 2 - 1];
        dfs(0);
        return ans;
    }

    private void dfs(int r) {
        if (r == n) {
            List<String> board = new ArrayList<>(n);
            for (int c : col) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                board.add(new String(row));
            }
            ans.add(board);
            return;
        }
        for (int c = 0; c < n; ++c) {
            int rc = r - c + n - 1;
            if (!onPath[c] && !diag1[r + c] && !diag2[rc]) {
                col[r] = c;
                onPath[c] = diag1[r + c] = diag2[rc] = true;
                dfs(r + 1);
                onPath[c] = diag1[r + c] = diag2[rc] = false; // 恢复现场
            }
        }
    }

}
