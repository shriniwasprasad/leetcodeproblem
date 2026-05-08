package org.example.problems.backtracking.hard;

import java.util.*;
import java.util.stream.*;

/**
 * Problem: N Queens
 * Topic: Backtracking
 * Level: Hard
 *
 * Problem Description:
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that
 * no two queens attack each other.
 *
 * LeetCode Problem Link: https://leetcode.com/problems/n-queens/
 */
public class NQueens {

    public static void main(String[] args) {
        System.out.println("=== NQueens ===");
        int n = 4;
        System.out.println("N: " + n);
        System.out.println("Result: " + solution(n));
        System.out.println("Alternative Result: " + alternativeSolution(n));
    }

    public static List<List<String>> solution(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        backtrack(result, board, 0, n);
        return result;
    }

    private static void backtrack(List<List<String>> result, char[][] board, int row, int n) {
        if (row == n) {
            result.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(result, board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) if (board[i][j] == 'Q') return false;
        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) res.add(new String(board[i]));
        return res;
    }

    public static List<List<String>> alternativeSolution(int n) {
        // Using recursive Stream for N-Queens is impractical due to board state,
        // but we can represent a board as a list of queen columns.
        return backtrackStream(new ArrayList<>(), n);
    }

    private static List<List<String>> backtrackStream(List<Integer> queens, int n) {
        if (queens.size() == n) {
            List<List<String>> res = new ArrayList<>();
            res.add(constructFromCols(queens, n));
            return res;
        }

        int row = queens.size();
        return IntStream.range(0, n)
            .filter(col -> isValidCol(queens, row, col))
            .mapToObj(col -> {
                List<Integer> nextQueens = new ArrayList<>(queens);
                nextQueens.add(col);
                return backtrackStream(nextQueens, n);
            })
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }

    private static boolean isValidCol(List<Integer> queens, int row, int col) {
        for (int i = 0; i < queens.size(); i++) {
            int prevCol = queens.get(i);
            if (prevCol == col || Math.abs(prevCol - col) == Math.abs(i - row)) return false;
        }
        return true;
    }

    private static List<String> constructFromCols(List<Integer> queens, int n) {
        List<String> board = new ArrayList<>();
        for (int qCol : queens) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[qCol] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
