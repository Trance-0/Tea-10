class Solution
{
public:
    vector<int> getLocation(int idx, int n)
    {
        vector<int> step(2);
        step[0] = n - (idx - 1) / n - 1;
        step[1] = ((idx - 1) / n) % 2 == 0 ? (idx - 1) % n : n - (idx - 1) % n - 1;
        return step;
    }
    int snakesAndLadders(vector<vector<int>> &board)
    {
        int n = board.size(), depth = 0, layer = min(6, n * n);
        vector<int> temp(2), cur(2);
        vector<bool> inqueue(n * n, true);
        queue<int> q;
        q.push(1);
        // do DFS
        while (!q.empty())
        {
            if(!inqueue[n*n-1]){
                return depth;
            }
            layer = q.size();
            depth++;
            for (int j = 0; j < layer; j++)
            {
                int target = q.front();
                q.pop();
                cur = getLocation(target, n);
                for (int i = target + 1; i <= min(target + 6, n * n); i++)
                {
                    // deal with numbers
                    temp = getLocation(i, n);
                    if (board[temp[0]][temp[1]] >= 0)
                    {
                        if (inqueue[board[temp[0]][temp[1]] - 1])
                        {
                            q.push(board[temp[0]][temp[1]]);
                            inqueue[board[temp[0]][temp[1]] - 1] = false;
                        }
                        continue;
                    }
                    if (inqueue[i - 1])
                    {
                        q.push(i);
                        inqueue[i - 1] = false;
                    }
                }
            }
        }
        return -1;
    }
};