package com.liamtang.otherpractice.sparsematrix;

public class Term {

    public static int MAX_TERMS = 9;
    public int row;
    public int col;
    public int value;

    public Term(int row, int col, int value) {
        this.col = col;
        this.row = row;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%d   %d   %d ", row, col, value);
    }
}
