#include <algorithm>
#include <fstream>
#include <iostream>
#include <stack>
#include <string>
#include <vector>
#include <sstream>
#include <iterator>
#include <unordered_map>
#include <unordered_set>

#include "Solution.hpp"
#include "../../cpp/helper1.hpp"

using namespace std;

int main()
{
    int numInputs = 0;
    int target = 0;
    string input1;
    int expected_output;
    int actual_output;
    ifstream infile("../testcases.txt");
    Solution *obj = new Solution();
    string line;
    int lineNo = 0;
    while (getline(infile, line))
    {
        if (lineNo == 0)
        {
            lineNo += 1;
            continue;
        }
        if ((lineNo % 2) != 0)
        {
            input1 = line;
            RemoveAllCommas(line);
            string s = line;
            stringstream ss(s);
            istream_iterator<int> begin(ss);
            istream_iterator<int> end;
            vector<int> input(begin, end);
            actual_output = obj->maximumScore(input[0], input[1], input[2]);
        }
        else
        {
            stringstream ss(line);
            ss >> expected_output;

            if (checkOuputInt(expected_output, actual_output, input1))
            {
                return 0;
            }
        }
        lineNo += 1;
    }
    Success();
    return 0;
}