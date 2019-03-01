package cn.likegirl.lintcode.合法标识符;


import java.util.regex.Pattern;

/**
 * 1658. 合法标识符
 * cat-only-icon
 * CAT 专属题目
 * 中文English
 * 请判断字符串 str 是不是一个合法的标识符。
 * 合法的标识符由字母（A-Z，a-z）、数字（0-9）和下划线组成，并且首字符不能为数字。
 * <p>
 * 样例
 * 样例 1：
 * <p>
 * 输入：str= "LintCode"
 * 输出：true
 * 解释：
 * 因为 "LintCode" 由字母组成。
 * 样例 2：
 * <p>
 * 输入：str = "123_abc"
 * 输出：false
 * 解释：
 * 虽然 "123_abc" 由字母、数字和下划线组成，但是它的首字符为数字。
 */
public class Solution {
    /**
     * @param str: The identifier need to be judged.
     * @return: Return if str is a legal identifier.
     */
    public static boolean isLegalIdentifier(String str) {
        // Write your code here.
        String regex = "^[A-Za-z]+(\\S*?)$";
        return Pattern.matches(regex, str);
    }

    public static boolean isLegalIdentifier1(String str) {
        // Write your code here.
        str = str.replaceAll("^[A-Za-z]", "*");
        str = str.replaceAll("[A-Za-z0-9_]*$", "");
        System.out.println(str);
        return "*".equals(str);
    }

    public static void main(String[] args) {
        System.out.println(isLegalIdentifier1("m8_l_LG__DrL___b7g_bKtHsF7l_aly_E7mEoj_pl_nUNFu_YQ_ce_mzH9_YCxznd_kC_omaOt_lEF_CheY0dmcoSQR3_g_0eHwmw_LrXtTPN7L___G_qu2HB_r_m1e_9NQpyu_OrzVv_lt6oUu1d__soss__b5AME6x__AyHB_5qm_7xb1voOHc_y_ediZ_f_Tg_MWHpf2nYd_CF_aWMazNy3Qh__aU_VltTN_uXzID_pFeff_fz2itUy5JcMifszesAe_Ffqhs8u7_f_1qNqRw_o_Ha_WbgWFl5ba__G_xd"));
    }
}