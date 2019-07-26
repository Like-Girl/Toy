package cn.likegirl.lintcode.第一个只出现一次的字符;


/**
 * 209. 第一个只出现一次的字符
 * <p>
 * 给出一个字符串，找出第一个只出现一次的字符。
 * <p>
 * 样例
 * 样例 1:
 * 输入: "abaccdeff"
 * 输出:  'b'
 * <p>
 * 解释:
 * 'b' 是第一个出现一次的字符
 * <p>
 * <p>
 * 样例 2:
 * 输入: "aabccd"
 * 输出:  'b'
 * <p>
 * 解释:
 * 'b' 是第一个出现一次的字符
 */
public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public static char firstUniqChar(String str) {
        // Write your code here
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean f = true;
            if(i > 0){
                if(chars[0] == chars[i]){
                    f = false;
                }else{
                    for (int j = i + 1; j < chars.length; j++) {

                        if (chars[i] == chars[j]) {
                            f = false;
                            chars[j] = chars[0];
                        }
                    }
                }
            }else{
                for (int j = i + 1; j < chars.length; j++) {

                    if (chars[i] == chars[j]) {
                        f = false;
                        chars[j] = chars[0];
                    }
                }
            }
            if(f){
                System.out.println(i);
                return chars[i];
            }
            chars[i] = chars[0];
        }
        return '0';
    }

    public static void main(String[] args) {
        String s = "jvummmdcrysgqpotfbmayrmvwegvcpyipdqlbjerddqpjfxqjffhcpnlcbrefcoteowavxvuhiqwrhcxslapvtrdubtsdmukqqniqttyafurtgryipujjnkqvocvbwkyvcqlcwqhxjrongofigrgbkslojhqmfnntbpldchurawojnqvkwgbpaybygdcjusdfmqxplovhxvmmpkeiraxowfomvqdpcnsbrmckfjeughkgfpgmchyxpjuddsirheagpluoiubysauyultwsgqdqygerfaktmqhnanqleknrefqweirlcbmybqhrlpuqjdpojbpjtwovdsxkcdedunrkterwhoihrdkencutbhbhdlcblyaqxmkhyxetwbcvygwgxhpfpyjnkfdjpcwnqvggrjimvwvgfimvmcalucqfnjdkonwlmppxwwcqmqvhweaxskayrfufkgcfjiuduqcedctcnetqgmpxpwkebmybjbjjkthfrxyddgtetwapxhjwvvqasqidaobmkclrrkbkisgfqfewvvrsblpcrmdflrdwoiojwphayhvkwjjmhwrallatibflvpaalsobkoxdmxqquinhyvguifqiyfelnjcxugqnhbflbmaticdphcpjoiostaytvsyrehciiyxbkegswpbylnxpexdekinlqjrywxcxkxjhhxfkxcbkidacrpvahxuorarpjoltpleecfyemsnqhhpgdwvmxvnhxtqvtfxtfvsqyfnpbbpemtgehycrpxyahueyavdbvrmssvxraodmniweiapatoadwjjfhckdfrihdskuaprnnitsmjxtcqlkrlkcybbxwfasgeodobxxqiaqktohflxahuesypvclstkyaimshlydbildbrmjnlodpbhcbtjhkiuafyoklwtuwajwrhjmvncchjrwxmdekmejugyutwoibvrhnbabhbglyuyjischjkivifsywektnhswsuxtwz";
        System.out.println(firstUniqChar(s));
    }
}