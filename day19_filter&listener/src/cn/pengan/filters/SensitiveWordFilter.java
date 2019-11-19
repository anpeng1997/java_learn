package cn.pengan.filters;

import jdk.nashorn.internal.ir.CallNode;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.*;

@WebFilter(value = "/filterDemoServlet")
public class SensitiveWordFilter implements Filter {
    public void destroy() {
    }

    /*
     * 使用代理模式过滤request的parameter中的敏感关键字
     * */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    String name = (String) method.invoke(req, args);
                    name = FilterSensitiveWord(name);
                    return name;
                }
                if (method.getName().equals("getParameterMap")) {
                    Map<String, String[]> map = new HashMap<>((Map<String, String[]>) method.invoke(req, args));
                    Set<String> keys = map.keySet();
                    for (String key : keys) {
                        String[] parameters = map.get(key);
                        String[] newParameters = new String[parameters.length];
                        for (int i = 0; i < parameters.length; i++) {
                            newParameters[i] = FilterSensitiveWord(parameters[i]);
                        }
                        map.put(key, newParameters);
                    }
                    return map;
                }
                if (method.getName().equals("getParameterValues")) {
                    String[] strings = (String[]) method.invoke(req, args);
                    for (int i = 0; i < strings.length; i++) {
                        strings[i]=FilterSensitiveWord(strings[i]);
                    }
                    return strings;
                }
                return method.invoke(req, args);
            }
        });
        chain.doFilter(proxy_req, resp);
    }

    /**
     * 过滤字符串中的敏感字词，没有敏感字符则返回原字符
     *
     * @param word 要过滤的字符串
     * @return 返回过滤后的字符
     */
    private String FilterSensitiveWord(String word) {
        for (String sensitiveWord : sensitiveWords) {
            if (word.contains(sensitiveWord)) {
                word = word.replaceAll(sensitiveWord, "***");
            }
        }
        return word;
    }

    private List<String> sensitiveWords = new ArrayList<String>();

    public void init(FilterConfig config) throws ServletException {
        URL resource = SensitiveWordFilter.class.getClassLoader().getResource("SensitiveWords.txt");
        System.out.println(resource.getPath());
        try {
            FileInputStream fileInputStream = new FileInputStream(resource.getFile());
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(fileInputStream, "utf-8"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sensitiveWords.add(line);
            }
            System.out.println(sensitiveWords);
            fileInputStream.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
