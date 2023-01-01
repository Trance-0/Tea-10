#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
   int climbStairs(int n) {
        int n_1=1;
        int n_2=2;
        int swap;
        if(n==1){
            return n_1;
        }
        if(n==2){
            return n_2;
        }
        for(int i=2;i<n;i++){
            swap=n_1+n_2;
            n_1=n_2;
            n_2=swap;
        }
        return swap;
    }
};