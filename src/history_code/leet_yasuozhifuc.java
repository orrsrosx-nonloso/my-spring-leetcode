package history_code;

public class leet_yasuozhifuc {

//    令输入数组 cs 长度为 nnn。
//    使用两个指针 i 和 j 分别指向「当前处理到的位置」和「答案待插入的位置」：
//    i 指针一直往后处理，每次找到字符相同的连续一段 [i,idx)[i, idx)[i,idx)，令长度为 cntcntcnt；
//    将当前字符插入到答案，并让 j 指针后移：cs[j++] = cs[i]；
//    检查长度 cntcntcnt 是否大于 111，如果大于 111，需要将数字拆分存储。由于简单的实现中，我们只能从个位开始处理 cntcntcnt，因此需要使用 start 和 end 记录下存储数字的部分，再处理完 cntcntcnt 后，将 [start,end)[start, end)[start,end) 部分进行翻转，并更新 j 指针；
//    更新 i 为 idx，代表循环处理下一字符。

    public int compress(char[] cs) {
        int n = cs.length;
        int i = 0, j = 0;
        while (i < n) {
            int idx = i;
            while (idx < n && cs[idx] == cs[i]) idx++;
            int cnt = idx - i;
            cs[j++] = cs[i];
            if (cnt > 1) {
                int start = j, end = start;
                while (cnt != 0) {
                    cs[end++] = (char)((cnt % 10) + '0');
                    cnt /= 10;
                }
                reverse(cs, start, end - 1);
                j = end;
            }
            i = idx;
        }
        return j;
    }
    void reverse(char[] cs, int start, int end) {
        while (start < end) {
            char t = cs[start];
            cs[start] = cs[end];
            cs[end] = t;
            start++; end--;
        }
    }



}
