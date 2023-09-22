#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

// d[i] - i번 빌딩을 짓는데 걸리는 시간
// p[i] - i번 빌딩을 짓기 위해 먼저 지어야 하는 건물 목록 (배열)
// r[i] - i번 빌딩까지 테크를 올리기 위해 필요한 최소 시간
// r[i] = max(r[p[i][j]]) + d[i], where 0 <= j < p[i].length

vector<int> d, r;
vector<vector<int>> p;

inline int max(int a, int b)
{
    return a > b ? a : b;
}

int solve(int w)
{
    if (r[w] >= 0) return r[w];
    
    int m = 0;

    for (auto i: p[w]) m = max(m, solve(i));

    return (r[w] = m + d[w]);
}

int main()
{
    int t, n, k, w, from, to;
    scanf("%d", &t);

    while (t--) {
        scanf("%d %d", &n, &k);

        p.clear();
        d.resize(n + 1);
        p.resize(n + 1);
        r.resize(n + 1);
        fill(begin(r), end(r), -1);

        for (int i = 1; i <= n; ++i) scanf("%d", &d[i]);

        while (k--) {
            scanf("%d %d", &from, &to);
            p[to].push_back(from);
        }

        scanf("%d", &w);

        printf("%d\n", solve(w));
    }

    return 0;
}
