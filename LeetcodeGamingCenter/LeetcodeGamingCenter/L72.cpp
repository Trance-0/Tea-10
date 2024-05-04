#include "LeetcodeGamingCenter.h"

using namespace std;
class Solution {
public:
    int minDistance(string word1, string word2) {
        // this is a 2D dp problem
        int l1 = word1.length(), l2 = word2.length();
        // we may use l1 is greater in default
        if (l1<l2) {
            swap(l1,l2);
            swap(word1,word2);
        }
        vector<vector<int>> maxCommon(l1+1,vector<int>(0,l2+1));
        for (int i = 1; i < l1;i++) {
            for (int j = 1; j < l2;j++) {
                if (word1[i-1]==word2[j-1]) {
                    maxCommon[i][j] = maxCommon[i - 1][j - 1];
                } else {
                    maxCommon[i][j] = min(maxCommon[i - 1][j - 1], min(maxCommon[i][j-1], maxCommon[i - 1][j]) + 1);
                }
            }
        }
        return maxCommon[l1][l2];
    }
    int main()
    {
        cout << minDistance("horse","rse") << endl;
        return 0;
    }
};