package cn.pengan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        ProxyDemoImp proxyDemo = new ProxyDemoImp();
        ProxyDemo proxyInstance = (ProxyDemo) Proxy.newProxyInstance(proxyDemo.getClass().getClassLoader(), proxyDemo.getClass().getInterfaces(), new InvocationHandler() {
            //动态代理方法，之后无论调用ProxyDemoImp的那个方法，这个方法都会执行
            //用来增强原有的方法，可以增强方法的参数、返回值、执行体代码。

            /**
             *  proxy:代理的对象
             *  method：执行的方法
             *  args:传递过来的参数
             * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //判断是否调用的时Method1,是的话就对该方法进行加强
                if ("Method1".equals(method.getName())) {
                    int parm = (int) args[0];
                    //增强参数
                    parm = parm * 10;
                    //使用真实对象调用该方法，并获取返回值
                    String str = (String) method.invoke(proxyDemo, parm);
                    //增强返回值
                    return str + "____这是增强之后的Method1";
                } else {
                    method.invoke(proxyDemo, args);
                    return null;
                }
            }
        });
        String s = proxyInstance.Method1(1111);
        System.out.println(s);

    }
}
