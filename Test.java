package com.trs.test;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;

/**
 * Description:
 *
 * @author: qym
 * date: 2020/2/19 11:39
 * @version: 1.0
 */
public class Test {
    ArrayList<String> res = new ArrayList<>();
    String temp = "";
    int start = 0;
    public ArrayList<String> letterCombinations(String digits) {
        if(StringUtils.isBlank(digits)){
            res.add(temp);
            return res;
        }
        //判断数字digits是否符合0-99
        if(!isBetween0And99(digits)){
            System.out.println("输入数字不合法，小于0或大于99");
            res.add(temp);
            return res;
        }

        //将数字以及对应的字母以key-value存入map集合中,以便于读取
        HashMap<Character,String> map=new HashMap<>();
        map.put('0',"");
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        res = combine(digits, start, map);
        return res;
    }

    private boolean isBetween0And99(String digits) {
        int tempNum = Integer.parseInt(digits);
        return (tempNum>-1 && tempNum<100);
    }

    public ArrayList<String> combine(String digits, int start, HashMap<Character,String> map){
        //达到字母组合的总数目，返回结果
        if(start == digits.length()){
            res.add(temp);
            return res;
        }


        String str = map.get(digits.charAt(start));
        for(int i = 0; i < str.length(); i++){
            //拼接字母，形成字母组合
            temp = temp + str.charAt(i);
            //start+1,不断将从每个数字中获取一个字母，并把这些字母拼接起来
            combine(digits, start + 1, map);
            //剔除最后一个字母，加入新的字母，产生新的组合
            temp = temp.substring(0, temp.length() - 1);
        }
        return res;
    }



}
