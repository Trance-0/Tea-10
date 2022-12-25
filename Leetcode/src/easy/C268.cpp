
class C268 {
    public:
    // the & mean pass by reference
    int missingNumber(vector<int>& nums) {
        // get largest number of nums, eg. if largest number is 4, you get 100
        // eg the nums is [0,4,2,3]
        // binary is [000,100,010,011]
        // number missing is 1, which is 001.
        int result = nums.size();
        int i=0;
        
        for(int num:nums){
            // run for num=0 xor is 100
            // run for num=4 xor is 000
            // run for num=2 xor is 011
            // run for num=3 xor is 010
            result ^= num;
            // run for i=0 xor is 100
            // run for i=1 xor is 001
            // run for i=2 xor is 001
            // run for i=3 xor is 001
            result ^= i;
            i++;
        }
        // the principle for that is if you flip the xor twice for the same number
        // you will ge the original one
        return result;
    }
};
