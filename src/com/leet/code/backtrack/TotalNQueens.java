package com.leet.code.backtrack;

import java.util.Arrays;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode
 */
public class TotalNQueens {

    int result=0;
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];
        for (char[] c:board){
            Arrays.fill(c,'.');
        }
        backtracking(board,0,n);
        return result;
    }
    void backtracking(char[][] board,int row,int n){
        if (row==n){
            result++;
            return;
        }
        for (int i=0;i<n;i++){
            if (isValid(board,row,i,n)){
                board[row][i]='Q';
                backtracking(board,row+1,n);
                board[row][i]='.';
            }
        }
    }
    boolean isValid(char[][] board,int row,int col,int n){
        // 检查列
        for (int i = 0; i < row; ++i) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
