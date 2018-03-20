package com.hyb.tij.chapter13.section06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplacements {
	public static void main(String[] args) {
		String src = "/*! Here's a block of text to use as input to \n"
				+ "  the regular  expression macher. Note thate we'll \n"
				+ "  first extract  the block of text process the  \n"
				+ "  extracted block. !*/";
		Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(src);
		String s = "";
		if(mInput.find()) {
			s = mInput.group(1);
			//两个以上空格转一个空格
			s = s.replaceAll(" {2,}", " ");
			System.out.println(s);
			//去除每行第一个空格
			s = s.replaceAll("(?m)^ +", "");
			System.out.println(s);
			
			s = s.replaceFirst("[aeiou]", "(VOWEL1)");
			System.out.println(s);
			
			StringBuffer sBuf = new StringBuffer();
			Pattern p = Pattern.compile("[aeiou]");
			Matcher m = p.matcher(s);
			while(m.find()) {
				m.appendReplacement(sBuf, m.group().toUpperCase());
			}
			m.appendTail(sBuf);
			System.out.println(sBuf);
		}
		
	}
}
