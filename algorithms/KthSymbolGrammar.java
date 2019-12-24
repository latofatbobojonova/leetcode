//https://leetcode.com/problems/k-th-symbol-in-grammar/

public class KthSymbolGrammar {
    public int kthGrammar(int N, int K) {
        if (K == 1) {
            return 0;
        } else if (K == 2) {
            return 1;
        }

        if (K % 2 == 0)
            return 1 - kthGrammar(N - 1, K / 2);
        return kthGrammar(N - 1, (K + 1) / 2);
    }
}
