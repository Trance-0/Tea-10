#include <bits/stdc++.h>

class L191
{
public:
    int hammingWeight(uint32_t n)
    {
        // while n is greater than zero
        int result = 0;
        while (n)
        {
            // if n's first bit is one
            if (n & 1)
            {
                result++;
            }
            // shift n down 1 bit
            n >>= 1;
        }
        return result;
    }
};