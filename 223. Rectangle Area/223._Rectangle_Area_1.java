public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int XOverLap = 0;
        if (A >= E) {
            if (G > A)
                XOverLap = G > C ? C - A : G - A;
        } else {
            if (E < C)
                XOverLap = C > G ? G - E : C - E;
        }
        //System.out.println("XOverLap = " + XOverLap);
        int YOverLap = 0;
        if (B >= F) {
            if (H > B)
                YOverLap = H > D ? D - B : H - B;
        } else {
            if (F < D)
                YOverLap = D > H ? H - F : D - F;
        }
        //System.out.println("YOverLap = " + YOverLap);
        return (C - A) * (D - B) + (G - E) * (H - F) - XOverLap * YOverLap;
    }
}