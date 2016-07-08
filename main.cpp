#include <iostream>
#include <vector>

using namespace std;

/**
 * qj1: https://leetcode.com/problems/two-sum/
 */
class Solution {
public:
    static vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        for (int i = 0; i < nums.size() - 1; ++i) {
            for (int j = i + 1; j < nums.size(); ++j) {
                if (nums[i] + nums[j] == target) {
                    result.push_back(i);
                    result.push_back(j);
                    return result;
                }
            }
        }
        return result;
    }
};

int main() {
    int a[] = { 2, 7, 11, 15 };
    vector<int> nums(a, a + sizeof(a) / sizeof(int));

    ostream_iterator<int> output(cout, " ");
    unique_copy(nums.begin(), nums.end(), output);
    cout << endl;

    vector<int> result(Solution::twoSum(nums, 17));
    unique_copy(result.begin(), result.end(), output);

    return 0;
}
