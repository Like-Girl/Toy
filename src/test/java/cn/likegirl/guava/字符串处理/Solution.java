package cn.likegirl.guava.字符串处理;

import com.google.common.base.Joiner;

import org.junit.Test;

public class Solution {

	/**
	 * 连接器[Joiner]
	 */
	@Test
	public void JoinerTest() {
		// JAVA8 连接器
		try {
			System.out.println(String.join(";", "Harry", null, "Ron", "Hermione"));
			;
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Guava 连接器
		try {
			Joiner joiner = Joiner.on("; ").skipNulls();
			System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));
			// 程序异常
			System.out.println(Joiner.on(";").join("Harry", null, "Ron", "Hermione"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 拆分器[Splitter]
	 */
	public void SplitterTest() {

	}

	/**
	 * 字符匹配器[CharMatcher]
	 */
	public void CharMatcherTest() {

	}

	/**
	 * 字符集[Charsets]
	 */
	public void CharsetsTest() {

	}

	/**
	 * 大小写格式[CaseFormat]
	 */
	public void CaseFormatTest() {

	}

}
