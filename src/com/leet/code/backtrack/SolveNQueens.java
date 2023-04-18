package com.leet.code.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 51,N皇后
 */
public class SolveNQueens {

    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for (char[] c:board){
            Arrays.fill(c,'.');
        }
        backtracking(n,0,board);
        return res;
    }

    void backtracking(int n,int row,char[][] board){
        if (row==n){
            res.add(ArrayToList(board));
            return;
        }
        for (int col=0;col<n;col++){
            if (isValid(row,col,n,board)){
                board[row][col]='Q';
                backtracking(n,row+1,board);
                board[row][col]='.';
            }
        }
    }

    boolean isValid(int row,int col,int n,char[][] board){//判断当前期盼是否符合皇后要求
        for (int i=0;i<row;++i){//列
            if (board[i][col]=='Q'){
                return false;
            }
        }
        for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (board[i][j]=='Q'){
                return false;
            }
        }
        for (int i=row-1,j=col+1;i>=0&&j>=0;i--,j++){
            if (board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public List<String> ArrayToList(char[][] board){
        List<String> list=new ArrayList<>();
        for (char[] c:board){
            list.add(String.valueOf(c));
        }
        return list;
    }
}
