#include <cstdio>
#include <vector>

using namespace std;

inline int countDigits(int a)
{
    if (a < 10) return 1;
    if (a < 100) return 2;
    if (a < 1'000) return 3;
    if (a < 10'000) return 4;
    if (a < 100'000) return 5;
    if (a < 1'000'000) return 6;

    return 7;
}

int d;
vector<int> nn(12);
vector<long long> coeff(6);

inline long long toLongLong()
{
    long long r = 0;

    for (auto n : nn) r = r * 10 + n;

    return r;
}

void brute_force(size_t i, int l, int r, long long& sum)
{
    if (l >= r) return;

    for (int n = -9; n <= 9; ++n) {
        auto cur_sum = sum + coeff[i] * n;

        if (cur_sum < 0) continue;

        if (n <= 0) {
            if (l == 0) {
                nn[l] = nn[r] = 1;
            }
            else {
                nn[l] = 0;
                nn[r] = -n;
            }
        }
        else {
            nn[l] = n;
            nn[r] = 0;
        }

        if (cur_sum != d) brute_force(i + 1, l + 1, r - 1, cur_sum);

        if (cur_sum == d) {
            sum = cur_sum;
            return;
        }
        else nn[l] = nn[r] = 0;
    }
}

const long long pow10[12] = {
    1, 10, 100, 1'000, 10'000, 100'000,
    1'000'000, 10'000'000, 100'000'000,
    1'000'000'000, 10'000'000'000, 100'000'000'000
};

long long solve()
{
    // 9의 배수가 아니면 만족하는 해가 없음.
    if (d % 9 != 0) return -1;

    const int digits = countDigits(d);
    
    // digits 자리 숫자부터 최대 12자리까지 탐색.
    for (int i = (digits < 2)? 2 : digits; i <= 12; ++i) {
        // n = digits 자리 숫자 x 와 x(뒤집음)의 차로 조합 가능한 값은
        // 1 <= k <= n / 2 일 때 Σ(10^(n-k) - 10(k-1))*(a_(n+k-1) - a_k)) 로 표현할 수 있다.
        // 여기서 a_1, a_2, ..., a_k, ... a_n 은 각 자리 숫자로 0 ~ 9이다. 단 a_n (제일 첫 자리 수) 는 1 ~ 9.
        // 그러면 결국 a_1, a_2, ..., a_n 조합을 찾는 문제가 되고 최대 12자리까지만 탐색하면 되는데
        // 12자리도 다 보는게 아니라 1'000'000 까지만 나오면 되니까 몇개 안봐도 됨
        for (int k = 1; k <= (i / 2); ++k) coeff[k - 1] = pow10[i - k] - pow10[k - 1];

        nn.clear();
        nn.resize(i);

        long long sum = 0;
        brute_force(0, 0, i - 1, sum);

        if (sum == d) return toLongLong();
    }

    return -1;
}

int main()
{
    scanf("%d", &d);
    printf("%lld", solve());

    return 0;
}
