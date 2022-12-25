#include <bits/stdc++.h>
class Solution
{
public:
    vector<int> countBits(int n)
    {
        vector<int> result;
        for(int i=0;i<n;i++){
        // while n is greater than zero
        int sum = 0;
        int num=i;
        while (num)
        {
            // if n's first bit is one
            sum+=num&1;
            // shift n down 1 bit
            num >>= 1;
        }
        result.push_back(sum);
        }
        return result;
    }
};