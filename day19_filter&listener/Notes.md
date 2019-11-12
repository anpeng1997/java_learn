1.Filter：过滤器
       一般用来完成通用操作。如登录验证，统一编码处理、敏感字符过滤

        快速入门：
            step:
                1.定义一个类，实现接口Filter
                2.复写方法
                3.配置拦截路径
                    1.web.xml
                    2.注解
            2.code
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
            3.过滤器的细节
                1.wen.xml的配置
                    <filter>
                        <filter-name>filteDemo</filter-name>
                        <filter-class>cn.pengan.filters.filterDemo1</filter-class>
                    </filter>
                    <filter-mapping>
                        <filter-name>filteDemo</filter-name>
                       <!-- 拦截路径 -->
                        <url-pattern>/*</url-pattern>
                    </filter-mapping>
                2.过滤器执行流程
                    1.执行过滤器
                    2.执行放行后的资源
                    3.回来执行过滤放行代码后面的代码
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
                3.过滤器的生命周期方法
                    1.init:服务器启动时调用该方法，只执行一次
                    2.doFilter：每次请求被拦截资源时，执行多次
                    3.destroy：服务器正常关闭时
                4.过滤器配置：
                    *拦截路径配置
