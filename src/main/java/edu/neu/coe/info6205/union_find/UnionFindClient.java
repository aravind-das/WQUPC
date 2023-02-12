package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UnionFindClient {
    private static int count(int n) {
        int connections = 0;
        int pairs = 0;

        UF_HWQUPC uf = new UF_HWQUPC(n);
        Random random = new Random();

        while(uf.components() > 1) {
            int p = random.nextInt(n);
            int q = random.nextInt(n);

            if(!uf.connected(p, q)){
                uf.union(p,q);
                connections++;
            }
            pairs++;
        }

        return pairs;
    }
    public static void main(String[] args) {
        System.out.println("Objects\t\tPairs");

        int tenPairs = 0;

        for (int n = 100; n < 1e7; n*=2) {
            int pairs = count(n);

            for (int runs = 0; runs < 10; runs++) {
                tenPairs += pairs;
            }

            System.out.println(n + "\t\t\t" + tenPairs/10);
        }
    }
}
