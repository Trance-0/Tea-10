// reference: https://ncduy0303.github.io/Competitive-Programming/Contest%20Template/main.cpp
#include <bits/stdc++.h>

using namespace std;

template <typename A, typename B>
ostream &operator<<(ostream &os, const pair<A, B> &p) { return os << '(' << p.first << ", " << p.second << ')'; }
template <typename T_container, typename T = typename enable_if<!is_same<T_container, string>::value, typename T_container::value_type>::type>
ostream &operator<<(ostream &os, const T_container &v)
{
    os << '{';
    string sep;
    for (const T &x : v)
        os << sep << x, sep = ", ";
    return os << '}';
}
void dbg_out() { cerr << endl; }
template <typename Head, typename... Tail>
void dbg_out(Head H, Tail... T)
{
    cerr << ' ' << H;
    dbg_out(T...);
}
#ifdef LOCAL
#define dbg(...) cerr << "(" << #__VA_ARGS__ << "):", dbg_out(__VA_ARGS__)
#else
#define dbg(...)
#endif

#define ar array
#define ll long long
#define ld long double
#define sza(x) ((int)x.size())
#define all(a) (a).begin(), (a).end()

const int MAX_N = 1e5 + 5;
const ll MOD = 1e9 + 7;
const ll INF = 1e9;
const ld EPS = 1e-9;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int tc = 1;
    cin >> tc;
    // the key insight is the conner must have the same color, the validation method is to check adjacent boarder.
    for (int t = 1; t <= tc; t++)
    {
        // cout << "Case #" << t << ": ";
        int n,m;
        cin >> n >> m;
        vector<string> board;
        for (int i=0;i<n;i++){
            string temps;
            cin >> temps;
            board.push_back(temps);
        }
        // upper left white
        bool ulw=0,urw=0,blw=0,brw=0,ulb=0,urb=0,blb=0,brb=0;
        for(char i:board[0]){
            if(i=='W'){
                ulw|=1;
                urw|=1;
            }else{
                ulb|=1;
                urb|=1;
            }
        }
        for(char i:board[n-1]){
            if(i=='W'){
                blw|=1;
                brw|=1;
            }else{
                blb|=1;
                brb|=1;
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='W'){
                blw|=2;
                ulw|=2;
            }else{
                blb|=2;
                blb|=2;
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][m-1]=='W'){
                brw|=2;
                urw|=2;
            }else{
                brb|=2;
                brb|=2;
            }
        }
        if ((ulw==3 && brw==3)||(ulb==3 && brb==3)){
            cout<<"Yes"<<endl;
            return;
        }
        if ((urw==3 && blw==3)||(urb==3 && blb==3)){
            cout<<"Yes"<<endl;
            return;
        }
        cou<<"No"<<endl;
    }
}