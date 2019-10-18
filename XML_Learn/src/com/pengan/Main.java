package com.pengan;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        String path = Main.class.getClassLoader().getResource("XMLDemo.xml").getPath();
       //加载文档进内容，获取dom树
        Document document = Jsoup.parse(new File(path), "utf-8");
        //通过标签名获取元素节点集合
        Elements elements = document.getElementsByTag("users");
//        System.out.println(elements.toString());
        Element ele =  elements.get(0);
        System.out.println(ele.text());

        //选择器
        Elements users = document.select("#user_01");
        System.out.println(users);

    }
}
