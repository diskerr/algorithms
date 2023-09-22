#include <cstdio>

inline int pow2(int n)
{
    return n * n;
}

int main()
{
    int n, x1, y1, r1, x2, y2, r2;

    scanf("%d", &n);

    while (--n >= 0) {
        scanf("%d %d %d %d %d %d", &x1, &y1, &r1, &x2, &y2, &r2);

        const int D2 = pow2(x1 - x2) + pow2(y1 - y2);

        if (D2 == 0 && r1 == r2) printf("-1\n");
        else {
            const int RS2 = pow2(r1 + r2), RD2 = pow2(r1 - r2);

            if (D2 == RS2 || D2 == RD2) printf("1\n");
            else if (RD2 < D2 && D2 < RS2) printf("2\n");
            else printf("0\n");
        }
    }

    return 0;
}
