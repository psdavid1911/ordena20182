package Ordenacao;

import Base.Lista;

public class Casca {

    public static void ordena(Lista<Integer> nums) {
        int h = 1;
        int n = nums.size();

        while (h < n) {
            h = h * 3 + 1;
        }

        h = h / 3;
        int c, j;

        while (h > 0) {
            for (int i = h; i < n; i++) {
                c = nums.get(i);
                j = i;
                while (j >= h && nums.get(j - h) > c) {
                    nums.set(j, nums.get(j - h));
                    j = j - h;
                }
                nums.set(j, c);
            }
            h = h / 2;
        }
    }
}
