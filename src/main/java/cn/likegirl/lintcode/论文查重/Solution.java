package cn.likegirl.lintcode.论文查重;

import java.util.*;

/**
 * 1463. 论文查重
 * 我们定义，两个论文的相似度为最长的相似单词子序列 * 2 除以两篇论文的总长度。
 * 给定两篇论文words1，words2（每个表示为字符串数组），和相似单词对列表pairs，求两篇论文的相似度。
 * <p>
 * 注意：相似关系是可传递的。例如，如果“great”和“good”类似，而“find”和“good”类似，那么“geat”和“find”类似。
 * 相似性也是对称的。 例如，“great”和“good”相似，则“good”和“great”相似。
 * 另外，一个词总是与其本身相似。
 * <p>
 * 样例
 * 给出words1= ["great","acting","skills","life"] ，words2= ["fine","drama","talent","health"] ，pairs= [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]]，返回0.75。
 * <p>
 * `解释：
 * 两篇单词相似的子单词序列为
 * "great","acting","skills"
 * "fine","drama","talent"
 * 总长度为8
 * 相似度为6/8=0.75`
 * 给出words1= ["I","love","you"] ，words2= ["you","love","me"] ，pairs= [["I", "me"]]，返回0.33。
 * <p>
 * 解释：
 * 两篇单词相似的子单词序列为
 * "I"
 * "me"
 * 或
 * "love"
 * "love"
 * 或
 * "you"
 * "you"
 * 总长度为6
 * 相似度为2/6=0.33
 * 注意事项
 * 两篇论文的长度都不超过800800，相似单词对数不超过30003000
 */
public class Solution {
    /**
     * @param words1: the words in paper1
     * @param words2: the words in paper2
     * @param pairs:  the similar words pair
     * @return: the similarity of the two papers
     */
    public static float getSimilarity(List<String> words1, List<String> words2, List<List<String>> pairs) {
        // Write your code here
        List<List<String>> newPairs = new ArrayList<>();
        List<String> pair;
        List<String> item;
        Set<String> similarityWords = new HashSet<>();
        int count = 0;
        for (int i = 0; i < pairs.size(); i++) {
            pair = pairs.get(i);
            for (int j = i + 1; j < pairs.size(); j++) {
                item = pairs.get(j);
                List<String> newPair = new ArrayList<>();
                if (pair.get(0).equals(item.get(0))) {
                    newPair.add(pair.get(1));
                    newPair.add(item.get(1));
                }
                if (pair.get(0).equals(item.get(1))) {
                    newPair.add(pair.get(1));
                    newPair.add(item.get(0));
                }
                if (pair.get(1).equals(item.get(0))) {
                    newPair.add(pair.get(0));
                    newPair.add(item.get(1));
                }
                if (pair.get(1).equals(item.get(1))) {
                    newPair.add(pair.get(0));
                    newPair.add(item.get(0));
                }
                if (newPair.size() > 0) {
                    newPairs.add(newPair);
                }
            }
        }
        pairs.addAll(newPairs);
        String w1;
        String w2;
        for (int i = 0; i < words1.size(); i++) {
            if (i >= words2.size()) {
                break;
            }
            w1 = words1.get(i);
            w2 = words2.get(i);
            similarityWords.clear();
            for (List<String> p : pairs) {
                if (p.get(0).equals(w1)) {
                    similarityWords.add(p.get(1));
                }
                if (p.get(1).equals(w1)) {
                    similarityWords.add(p.get(0));
                }
            }
            if (pairs.size() > 0) {
                if (similarityWords.contains(w2) || w1.equals(w2)) {
                    count++;
                }
            } else {
                for (int j = 0; j < words2.size(); j++) {
                    if (w1.equals(words2.get(j))) {
                        count++;
                        continue;
                    }
                }
            }
        }
        return (float) (Math.round((count * 2F) / (words1.size() + words2.size()) * 100) / 100.0);
    }

    public static void main(String[] args) {
        List<String> word1 = Arrays.asList("great", "acting", "skills", "life");
        List<String> word2 = Arrays.asList("fine", "drama", "talent", "talent");
        List<String> p1 = Arrays.asList("great", "good");
        List<String> p2 = Arrays.asList("fine", "good");
        List<String> p3 = Arrays.asList("acting", "drama");
        List<String> p4 = Arrays.asList("skills", "talent");
        List<List<String>> pairs = new ArrayList<>();
        pairs.add(p1);
        pairs.add(p2);
        pairs.add(p3);
        pairs.add(p4);
        System.out.println(getSimilarity(word1, word2, pairs));
    }
}