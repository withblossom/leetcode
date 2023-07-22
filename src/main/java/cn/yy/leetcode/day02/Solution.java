package cn.yy.leetcode.day02;

import java.util.HashMap;

public class Solution {

    /*
    输入例子：
"abab"
输出例子：
2
例子说明：
第一次操作将两个'a'变成一个'f'，字符串变成"bbf"。
第二次操作将两个'b'变成一个'b'，字符串变成"fb"。
操作方式不是唯一的，但可以证明，最少操作次数为2。
     */
    public int minOperations1(String str) {

        int res = 0;
        int len = str.length();
        int aa = 0; //26个字母被使用的次数。
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (char i : map.keySet()) {
            int count = map.get(i);
            if (count == 1) {
                aa++;
            }
            if (count % 2 == 0) {
                res += count / 2; //消除n个字符，需要n/2次操作
                aa += count / 2; //消耗n/2个字母
            }
            if (count > 1 && count % 2 != 0) {
                res += count / 2;//消除n个字符，需要n/2次操作
                aa += count / 2 + 1;//消耗n/2个字母加上余出的1个字母
            }
        }
        //超出26个字母的部分，需要额外的操作
        //每2个字母，需要1次额外操作
        //既是aa-26
        if (aa > 26) {
            res += aa - 26;
        }
        return res;
    }

    public int minOperations2(String str){
        int res = 0;
        int aa = 0;
        HashMap<Character, Integer> map = new HashMap<>(26);
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count == 1){
                aa++;
            }else if (count%2==0){
                res+=count/2;
                aa+=count/2;
            }else if (count%2==1) {
                res+=count/2;
                aa+=count/2+1;
            }
        }
        if (aa > 26) {
            res += aa - 26;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "eseojrcseikwocesextjjssrreeeixosxsiworctxtrstekijwesketotrxewccrweoxscxertokeeescstxcoxoeriiwseikrwicokesieojxekexkeoxwsisttxeejwokwrkkijeskoxetsssjwitxoirieecetrtsjcswkssewjeeoxerrritettosetowxcwxksssttwsxkrxexkirkijowxskkewksjrwswwoorweexksrtcrjexxecerwscsoootirxctewixjwrckoixkeoitoercokrscoiooosjsieeewkroecekrwtoskecocssssekrwoeokkksttocsisreieoerwxtrewxixerwetsrrojoststowotkrokwkowetrejowekowecsoxsriisktsoswoesctwosjorcsorsssjkwsjkxtroeiieketxesxrxxerorcwtjeocoxxojtswrwitceojstojrsoccsxkjroetkossroeectrkijoksxccocssrwoescisooewkoioxxtxjeeewjsrctrrxkceoowjewosioiooorrieixotewcoicrrsxojccxtxijstwkewteissewxooisjsiekikxesttiktjiiotwkjorrsstsijtctjtkxkeejsccwjtctresersjrjoesrosriiksrciccssrsococjkoworejjoisrrxjoetesiejsxiesjorerwkkxxroowiwesiswsojctwwtxettiiseejeceojtirjrjieojsieirtertskewotsetkeocijrocijwwoiseceriekkoeowewcscrtcssektrcssejojjxwiwwtseeejowsstojosieescckxxswicjcsxriesiwikkcjsjswtoxtitktsioxjtroiitsxwjkweeeeiextwwwjessikicrsrsioowkwcsxeesxosssjocrtwsojkistsxieroies";
        Solution solution = new Solution();
        System.out.println(solution.minOperations1(s));
        System.out.println(solution.minOperations2(s));
    }
}
