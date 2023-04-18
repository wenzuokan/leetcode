package com.leet.code.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 17,电话号码的字母组合
 */
public class LetterCombinations {

    List<String> list=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0){
            return list;
        }
        String[] letter={"","","abc","def","ghi","jkl","pqrs","tuv","wxyz"};
        backtracking(digits,letter,0);
        return list;
    }

    StringBuilder temp=new StringBuilder();
    private void backtracking(String digits,String[] letter,int num){
        if (num==digits.length()){
            list.add(temp.toString());
            return;
        }
        String str=letter[digits.charAt(num)-'0'];
        for (int i=0;i<str.length();i++){
            temp.append(str.charAt(i));
            backtracking(digits,letter,num+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
