package com.wst.mp_quiz;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        String id ="test";
        Integer gr = 1;
        Integer qu = 1;
        String s = id.concat(String.valueOf(gr)).concat(String.valueOf(qu));
        System.out.println(s);

    }

    public static List<String> findRepeatedDnaSequences(String s) {

        Map<String,Integer> hashTable = new HashMap<>();
        List<String> res=new ArrayList<>();

        for(int i=0;i+10<s.length();i++){
            String str = s.substring(i,i+10);
            if(hashTable.containsKey(str)){
                Integer temp =hashTable.get(str);
                temp++;
                hashTable.put(str,temp);
            }else{
                hashTable.put(str,1);
            }

            if(hashTable.get(str)==2){
                res.add(str);
            }
        }

        return res;

    }


}
