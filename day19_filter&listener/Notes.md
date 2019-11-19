##Filter：过滤器
#####一般用来完成通用操作。如登录验证，统一编码处理、敏感字符过滤
####快速入门： 
 1. 定义一个类，实现接口Filter  
 2. 复写方法  
 3. 配置拦截路径（两种方式）
    1. web.xml
    ```
    <filter>
        <filter-name>filteDemo</filter-name>
        <filter-class>cn.pengan.filters.filterDemo1</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>filteDemo</filter-name>
       <!-- 拦截路径 -->
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    ```
    2. 注解
    ```java
    @WebFilter("/*")  //再访问所有资源之前都会执行该过滤器
    public class filterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter.....");
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {
    }
    }
    ```
####过滤器的细节:
 1. 过滤器执行流程
    1. 执行过滤器
    2. 执行放行后的资源
    3. 回来执行过滤放行代码后面的代码
    ```
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //是否放行的逻辑代码
        //用来增强request
        System.out.println("doFilter.....");
        //放行代码
        filterChain.doFilter(servletRequest,servletResponse);
        //放行后的代码
        //用来增强response
    }
    ```
 2. 过滤器的生命周期方法
    1. init：服务器启动时调用该方法，只执行一次
    2. doFilter：每次请求被拦截资源时，执行多次
    3. destroy：服务器正常关闭时
 3. 过滤器配置：
    1. 拦截路径配置:
        1. 具体资源路径：/index.jsp 只有访问index.jsp时才会执行过滤器
        2. 拦截目录：/user/*
        3. 后缀名拦截：*.jsp
        4. 拦截所有路径：/*
    2. 拦截请求类型配置
        1. REQUEST //拦截浏览器直接请求（默认值）
        2. FORWARD //拦截服务器内部请求转发
        3. ERROR //拦截错误跳转页面
        4. ASYNC //拦截异步请求
        5. INCLUDE //包含访问资源
        ```
       //注解方式
        @WebFilter(value = "/*",dispatcherTypes = { DispatcherType.ASYNC.REQUEST,DispatcherType.FORWARD })
        
       //web.xml方式
       <filter-mapping>
           <filter-name>filteDemo</filter-name>
        <!-- 拦截路径-->
           <url-pattern>/*</url-pattern>
           <dispatcher>REQUEST</dispatcher>
        </filter-mapping>
       ```    
    3. Filter执行的顺序
        1. 注解方式：  
        根据类名的名称来顺序排序，如：AFilter就在BFilter之前执行
        2. web.xml方式  
        根据<filter-mapping>标签的位置来执行，排在前面的先执行  

##设计模式
#####一些通用的解决固定问题的方式
####代理者模式
 * 概念:
    1. 真实对象：被代理的对象
    2. 代理对象：代理真实对象的对象，使用`Proxy.newProxyInstance()`获得  
        ```
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
        ```
    3. 代理模式：代理对象的代理真实对象，来达到增强真实对象的目的
 * 实现方式：
    1. 静态代理：有一个类文件（.class）描述代理模式
    2. 动态代理：在内存中动态形成的代理类
 * 实现方式
    1. 代理对象和真实对象实现相同的接口
    2. 代理对象 = `Proxy.newProxyInstance()`
    3. 使用代理对象调用方法
    4. 增强方法
 *增强方式
    1. 增强参数列表
    2. 增强返回值
    3. 增强方法体
 * 例子：`SensitiveWordFilter`类对request中提交的参数值，做了敏感词汇过滤
 
##listener：监听器
#####web的三大组件之一
* 事件监听的机制
    * 事件：一件事情
    * 事件源：事件发生的地方
    * 监听器：一个对象
    * 注册监听：将事件、事件源、监听器绑定在一起。当事件源上发生某个事情之后，执行监听代码
* ServletContextListener 接口：监听ServletContext对象的创建及销毁
    * 实际作用： 
    用来程序启动后加载资源文件（以后的开发中，自己写监听器的情况很少，一般都是在框架中比较多，而我们只需要写好配置文件即可）
    * 方法：
        1. `public void contextInitialized(ServletContextEvent sce)`  
        ServletContext创建后会调用该方法
        2. `public void contextDestroyed(ServletContextEvent sce) `  
        ServletContext销毁之后会调用该方法
    * 配置方式
        1. web.xml
            ```xml
            <listener>
                    <listener-class>cn.pengan.listeners.DemoListener</listener-class>
            </listener>
            ```
        2. 注解
            `@WebListener()` 直接加在监听类上
    * 在web.xml 配置监听器所需要的参数
        ```xml
         <context-param>
                <param-name>localhostConfigPATH</param-name>
                <param-value>/WEB-INF/classes/applicationConfg.xml</param-value>
         </context-param>
        ```  
        ```
        //在contextInitialized实现方法中加载资源文件
        ServletContext servletContext = sce.getServletContext();
        String localhostConfigPATH = servletContext.getInitParameter("localhostConfigPATH");
        String realPath = servletContext.getRealPath(localhostConfigPATH);
        //拿到真实路径后就可以将配置文件中的数据读取出来
        ```