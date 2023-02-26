package com.liamtang.otherpractice.sparsematrix;

import java.util.Arrays;

public class SparseMatrix {

    public Term[] transpose(Term[] a) {
        int n= a[0].value; // total amount of terms
        int currentb = 1; // current index of b

        Term[] b = new Term[a.length];
        b[0]= new Term(a[0].row, a[0].col, a[0].value);

        if (n > 0) {
            for(int i =0; i < a[0].col; i++) {
                /* transpose by the columns in a */
                for(int j=1; j<=n; j++) {
                    /* find elements in a that column index equals the current column number */
                    if (a[j].col == i) {
                        /* element is in current column, add it to b */
                        b[currentb]= new Term(a[j].row, a[j].col, a[j].value);
                        currentb++;
                    }
                }
            }
        }

        return b;
    }

    public Term[] fastTranspose(Term[] a) {
        int[] numberOfTermsForEachColNo = new int[a.length];
        int[] startingPos = new int[a.length];
        int numCols = a[0].col;
        int numTerms = a[0].value;

        Term[] b = new Term[a.length];
        b[0] = new Term(numCols, a[0].row, numTerms);

        if (numTerms > 0) {
            for(int i = 0; i < numCols; i++) {
                numberOfTermsForEachColNo[i] = 0;
            }

            for (int i = 1; i <= numTerms; i++) {
                numberOfTermsForEachColNo[a[i].col]++;
                System.out.println(Arrays.toString(numberOfTermsForEachColNo));
            }
            System.out.println(String.format("numberOfTermsForEachColNo: %s", Arrays.toString(numberOfTermsForEachColNo)));

            startingPos[0] = 1;
            for (int i = 1; i < numCols; i++) {
                startingPos[i] = startingPos[i - 1] + numberOfTermsForEachColNo[i - 1];
                System.out.println(Arrays.toString(startingPos));
            }
            System.out.println(String.format("startingPos: %s", Arrays.toString(startingPos)));

            for (int i = 1; i <= numTerms; i ++) {
                //System.out.println("===============");
                //System.out.println(String.format("current startingPos: %s", Arrays.toString(startingPos)));
                int colToRowNewPos = startingPos[a[i].col]++;
                //System.out.println(String.format("after   startingPos: %s", Arrays.toString(startingPos)));
                //System.out.println("j=" + j);
                //System.out.println(String.format("a[%d].col=%d", i, a[i].col));
                //System.out.println(String.format("startingPos[%d]=%d", a[i].col, startingPos[a[i].col]));
                //System.out.println(a[i].toString());
                b[colToRowNewPos] = new Term(a[i].col, a[i].row, a[i].value);
            }

        }

        return b;

    }


    public static void main(String[] args) {

        SparseMatrix matrix = new SparseMatrix();
        Term[] a = new Term[Term.MAX_TERMS];
        a[0] = new Term(6, 6, 8);
        a[1] = new Term(0, 0, 15);
        a[2] = new Term(0, 3, 22);
        a[3] = new Term(0, 5, -15);
        a[4] = new Term(1, 1, 11);
        a[5] = new Term(1, 2, 3);
        a[6] = new Term(2, 3, -6);
        a[7] = new Term(4, 0, 91);
        a[8] = new Term(5, 2, 28);


        //Term[] transposed_a = matrix.transpose(a);
        //Arrays.stream(transposed_a).forEach(System.out::println);

        Term[] transposed_a = matrix.fastTranspose(a);
        System.out.println("================final answer================");
        Arrays.stream(transposed_a).forEach(System.out::println);





    }

}
