package org.balaji.multiplex.personal.ds.dp;
/*
 *   how many ways users can climb a n stairs if user can only perform 1 or 2 steps
 *
 *    f(n) = f(n-1)  + f(n-2) , where f(1)=1 , f(2)=2
 *
 * */


import java.util.logging.LogManager;
import java.util.logging.Logger;

public class OptimizationEnumerationExample1 {

    private static Logger log = LogManager.getLogManager().getLogger("OptimizationEnumerationExample1");
    public static void main(String[] args) {

        // Approach1

        System.out.println("Number of ways to reach 3 stair " + stairs(3));
        System.out.println("Number of ways to reach 10 stair " + stairs(10));
        System.out.println("Number of ways to reach 50 stair " + stairs(50));


        // Approach2

        System.out.println("Number of ways to reach 3 stair " + stairsWithOptimizedApproach(3));
        System.out.println("Number of ways to reach 10 stair " + stairsWithOptimizedApproach(10));
        System.out.println("Number of ways to reach 50 stair " + stairsWithOptimizedApproach(50));


    }


    private static int stairs(int stepno) {
        switch (stepno) {
            case 1:
                return 1;
            case 2:
                return 2;
        }
        return stairs(stepno - 1) + stairs(stepno - 2);
    }


    private static int stairsWithOptimizedApproach(int stepno) {

        int step1 = 1;
        int step2 = 2;
        int sum = 0;
        switch (stepno) {
            case 1:
                return 1;
            case 2:
                return 2;
        }

        for (int i = 3; i <= stepno; i++) {

            sum = step1 + step2;
            step1 = step2;
            step2 = sum;
        }

        return sum;

    }


}
