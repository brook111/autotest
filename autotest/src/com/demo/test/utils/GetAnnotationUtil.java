package com.demo.test.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自动获取用例中的描述内容
 */
public class GetAnnotationUtil {
	public static String getAnnotation(String filePath) {
		String annotation = null;
		try {
			FileReader freader = new FileReader(filePath);
			BufferedReader breader = new BufferedReader(freader);
			StringBuffer sb = new StringBuffer();

			try {
				String temp = "";
				/**
				 * 读取文件内容
				 */
				while ((temp = breader.readLine()) != null) {
					sb.append(temp);
					sb.append('\n');
				}
				String src = sb.toString();
				/**
				 * 做/* 注释的正则匹配
				 * 
				 * 
				 * 通过渐进法做注释的正则匹配，因为/*注释总是成对出现 当匹配到一个/*时总会在接下来的内容中会首先匹配到"*\\/",
				 * 因此在获取对应的"*\\/"注释时只需要从当前匹配的/*开始即可， 下一次匹配时只需要从上一次匹配的结尾开始即可
				 * （这样对于大文本可以节省匹配效率）—— 这就是渐进匹配法
				 * 
				 * 
				 * */
				Pattern leftpattern = Pattern.compile("/\\*");
				Matcher leftmatcher = leftpattern.matcher(src);
				Pattern rightpattern = Pattern.compile("\\*/");
				Matcher rightmatcher = rightpattern.matcher(src);
				sb = new StringBuffer();
				/**
				 * begin 变量用来做渐进匹配的游标 {@value} 初始值为文件开头
				 * **/
				int begin = 0;
				while (leftmatcher.find(begin)) {
					rightmatcher.find(leftmatcher.start());
					sb.append(src.substring(leftmatcher.start(),
							rightmatcher.end()));
					/** 为输出时格式的美观 **/
					sb.append('\n');
					begin = rightmatcher.end();
				}
				annotation = sb.toString();

			} catch (IOException e) {
				System.out.println("文件读取失败");
			} finally {
				breader.close();
				freader.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在");
		} catch (IOException e) {
			System.out.println("文件读取失败");
		}
		return annotation;
	}

	public static void getDesc(int start, String desc) {
		String restStr = desc.substring(start);// 截取@description之后的内容
		Pattern p = Pattern.compile("\\n|\\/|\\*");
		Matcher m = p.matcher(restStr);
		String finalStr = m.replaceAll("");
		System.out.println(finalStr);
	}

	public static void main(String[] args) {
		File f = new File(
				"src\\test\\java\\com\\incito\\logistics\\testcase\\quickSendGoods\\");
		File[] files = f.listFiles();
		int n = 0;
		for (int i = 0; i < files.length; i++) {
			String str = getAnnotation(files[i].getAbsolutePath());
			// 找到注释中@description的位置，然后+13 or +4从description之后截取的位置（int）
			if (str.indexOf("@description") != -1) {
				n = str.indexOf("@description") + 13;
				getDesc(n, str);
			} else if (str.indexOf("@Description") != -1) {
				n = str.indexOf("@Description") + 13;
				getDesc(n, str);
			} else if (str.indexOf("@描述") != -1) {
				n = str.indexOf("@描述") + 4;
				getDesc(n, str);
			} else {
				System.out.println("没有找到@description，对应的用例是："
						+ files[i].getAbsolutePath());
			}

		}
	}
}
