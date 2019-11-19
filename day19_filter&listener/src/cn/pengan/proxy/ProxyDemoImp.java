package cn.pengan.proxy;

public class ProxyDemoImp implements ProxyDemo {

    @Override
    public String Method1(int i) {
        return "I'm Method1,parameter" + i;
    }

    @Override
    public void Method2() {
        System.out.println("I'm Method2");
    }
}
