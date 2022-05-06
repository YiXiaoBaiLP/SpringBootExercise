# SpringBoot 实战

### 017-springboot-springmvc

- 主要说明了注解：@Controller、@RestController、@RequestMapping、@GetMapping、@PostMapping、@DeleteMapper、@PutMapping

  - @Controller：标识此类是一个控制器类
  - @RestController：相当于垒上加 @Controller + @ReponseBody 注解，意味着当前控制层类中的所有方法返回的都是JSON对象

  - @RequestMapping：默认的请求方式为：get与post请求，可以使用 `method = RequestMethod.GET` 来指定具体的请求类型
  - @GetMapping：get 的请求类型（通常使用在**查询方法**上）
  - @PostMapping：pot的请求类型（通常使用在**增、删、改方法**上）
  - @DeleteMapping：delete的请求类型（通常使用在**删除方法**上）
  - @PutMapping：put的请求类型（通常使用在**修改方法**上）

### 018-springboot-restful

- RESTful 是一种请求风格，例如：`/student/detail/id/age`

- RESTful 中新增的注解

  ```java
      @GetMapping("/student/detail/{id}/{age}")
      public Object studentRESTful(@PathVariable("id") Integer id, // 使用 @PathVariable 注解获取请求参数上的变量
                                   @PathVariable("age") Integer age){
          Map<String, Object> retMap = new HashMap<>();
          retMap.put("id", id);
          retMap.put("age", age);
  
          return retMap;
      }
  ```

- 请求路径冲突的解决方法：

  1. 将请求的参数位置调换

     - 例如：

       ​	`@GetMapping("/student/detail/{id}/{age}")`

       ​	`@GetMapping("/student/{id}/detail/{age}") `

  2. 当请求的路径相同时，RESTful风格的请求方式会按照**增、删、改、查的请求来区分**

     - 例如：删除使用的注解 ` @DeleteMapper()`
       			查询使用的注解 `@GetMapper()`
           			修改使用的注解 `@PutMapper()`

### 019-springboot-redis

#### springboot集成Redis

- 添加Redis数据类型的依赖

  ```xml
  <!-- SpringBoot 集成Redis的起步依赖 -->
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-redis</artifactId>
  </dependency>
  ```

- 在SpringBoot核心配置文件中添加Redis配置

```yml
spring:
  redis:
    host: 192.168.15.127
    port: 6379
    password: ******

```

- 服务层中使用Redis存取值

  ```java
  /**
   * @author yixiaobai
   * @create 2022/05/03 下午7:40
   */
  @Service
  public class StudentServiceImpl implements StudentService {
      @Autowired // RedisTemplate：由 spring-data-redis 提供支持
      private RedisTemplate<Object, Object> redisTemplate;
      /**
       * Redis 中存入数据
       * @param key
       * @param value
       */
      @Override
      public void put(String key, String value) {
          redisTemplate.opsForValue().set(key, value);
      }
      /**
       *
       * @param key
       * @return
       */
      @Override
      public String get(String key) {
          String value = redisTemplate.opsForValue().get(key).toString();
          return value;
      }
  }
  ```

  ### 020-springboot-dubbo-interface（接口工程）

  ### 021-springboot-dubbo-provider（服务提供者）

  ### 022-springboot-consumer（服务消费者）

  #### SpringBoot 集成 Dubbo 分布式框架

  1. 接口工程：存放实体Bean和业务接口
  2. 服务提供者：业务接口的实现类并将服务暴露且注册到注册中心，调用数据持久层
     - 添加依赖（dubbo、注册中心）
     - 配置服务提供者核心配置文件
  3. 服务消费者：处理浏览器客户端发送的请求，从注册中心调用服务提供者所提供的服务
     - 添加依赖（dubbo、注册中心、接口工程）
     - 配置服务消费者核心配置文件

### 23～25. SpringBoot集成Dubbo、Redis、MyBatis、Spring、SpringMVC、JSP
 - **接口工程：** 存放实体bean和业务接口
 - **服务提供者：** 它是一个SpringBoot框架Web项目，集成MyBatis、Redis
   - 添加依赖：MyBatis依赖、MySql驱动、Dubbo依赖、zookeeper依赖、Redis依赖、接口工程
   - 配置SpringBoot核心配置文件
     - 配置连接数据库
     - 配置连接Redis
     - 配置Dubbo
 - **服务消费者：** 它是一个SpringBoot框架Web项目，集成JSP、Dubbo
   - 添加依赖：Dubbo依赖、zookeeper依赖、解析JSP页面的依赖、接口工程
   - 配置SpringBoot核心配置文件
     - 配置视图解析器
     - 配置Dubbo

### 026-springboot-java-1（了解即可）

- SpringBoot 创建Java工程（方式一）：通过SpringBoot容器获取

### 027-springboot-java-2（了解即可）

- SpringBoot 创建Java工程（方式二）：通过实现`CommandLineRunner`重写 `run()` 方法获取

### 028-springboot-close-logo

- **关闭SpringBoot启动logo**

  - ```java
    @SpringBootApplication
    public class Application {
        public static void main(String[] args) {
            // SpringApplication.run(Application.class, args);
            /*
            将 SpringApplication.run(Application.class, args) 方法拆分
                1、先获取 SpringApplication 对象
                2、设置SpringApplication对象的属性 setBannerMode(Banner.Mode.OFF);
                3、启动SpringApplication.run(args); 容器
             */
            // 获取启动入口SpringBoot类
            SpringApplication springApplication = new SpringApplication(Application.class);
            // 设置它的属性
            springApplication.setBannerMode(Banner.Mode.OFF);
            // 调用启动类
            springApplication.run(args);
        }
    }
    ```

### 029-springboot-modify-logo

- 修改logo
  - 在 `src/main/resources/banner.txt` 目录下创建文件即可，文件中写的内容会显示在启动log中

### 030-springboot-interceptor

##### SpringBoot使用拦截器

 - 定义一个拦截器，实现 `HandlerInterceptor`接口， **配置拦截的规则**
 - 创建一个配置类（即：在SpringMVC配置文件中使用 mvc:interceptors标签）， **配置拦截的请求**

### 031-springboot-servlet（了解即可）

##### SpringBoot中是使用servlet

- **第一种方式 ：** 注解方式 -> @WebServlet， @ServletCompanscan

1. Servlet的配置类，需要集成 HttpServlet方法，并重写doGet()、doPost()方法，实例：

```java
/**
 * @author yixiaobai
 * @create 2022/05/04 下午4:22
 */
@WebServlet(urlPatterns = "/myservlet") // 定义请求路径
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("My SpringBoot Servlet-1");
        resp.getWriter().flush();
        resp.getWriter().close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

2. 在主类中开启扫描，实例：

```java
@SpringBootApplication // 开启Spring配置
@ServletComponentScan(basePackages = "buzz.yixiaobai.springboot.servlet")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

- **第二种方式：**
  - 通过配置类注册组件的方式，使用功能@Bean注解

### 033-springboot-filter-1（使用注解的方式）

##### SpringBoot使用filter过滤器

- 自定义一个过滤器，注意实现的Filter类为javax.servlet包中

```java
/**
 * 自定义过滤器
 * @author yixiaobai
 * @create 2022/05/05 下午11:12
 */
@WebFilter(urlPatterns = "/myfilter")
public class MyFilter implements javax.servlet.Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("-------------------------------- 已进入过滤器 ------------------------------------");

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
```

- 在客户端中使用，**需要开启扫描器**

```java
@SpringBootApplication
@ServletComponentScan(basePackages = "buzz.yixiaobai.springboot.filter")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```

### 034-springboot-filter-2（使用配置类的方式）

##### SpringBoot中使用Filter过滤器

- 自定义过滤器(Filter)，**实现的包为javax.servlet.Filter**

```java
/**
 * 自定义过滤器
 * @author yixiaobai
 * @create 2022/05/05 下午11:25
 */
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--------------- 我进入过滤器了 ---------------------");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
```

- **Filter配置类**

```java
/**
 * @author yixiaobai
 * @create 2022/05/05 下午11:28
 */
@Configuration // 定义此类为配置类
public class FilterConfig {

    @Bean
    public FilterRegistrationBean myFilterRegistrationBean() {
        // 将自己的过滤器传入进去
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());

        // 添加过滤路径，可以匹配/user、/user/detail、/user/select/detail等
        filterRegistrationBean.addUrlPatterns("/user/*");
        return filterRegistrationBean;
    }
}
```

- **客户端类，不需要做任何配置**

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### 035-springboot-character-1（使用Java配置类的方式）

##### 修改字符编码

1. 要在Servlet中统一浏览器编码

```java
/**
 * @author yixiaobai
 * @create 2022/05/06 上午12:20
 */
@WebServlet(urlPatterns = "/myservlet")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("世界你好，Hello World!");
        // 统一设置浏览器编码格式
        resp.setContentType("text/html;character=utf-8");
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

2. 创建过滤器配置类，并指定编码

```java
/**
 * @author yixiaobai
 * @create 2022/05/06 上午12:31
 */
@Configuration
public class SystemConfig {
    @Bean
    public FilterRegistrationBean characterEncodingFilterRegistrationBean() {
        // 创建字符编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        // 强制使用指定字符编码
        characterEncodingFilter.setForceEncoding(true);
        // 设置指定字符编码
        characterEncodingFilter.setEncoding("utf-8");

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        // 设置字符编码过滤器
        filterRegistrationBean.setFilter(characterEncodingFilter);
        // 设置字符编码器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}
```

3. 修改全局配置类 **application.yml**

```yml
server:
  servlet:
    encoding:
      enabled: false
```

4. 客户端中引用

```java
@SpringBootApplication
@ServletComponentScan(basePackages = "buzz.yixiaobai.springboot.servlet") // 扫描Servlet
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### 036-springboot-character-2 （使用全局配置类）

##### 修改中文乱码的问题

1. 修改 application.yml 全局配置类

```yml
# 设置请求响应字符编码
server:
  servlet:
    encoding:
      force: true
      enabled: true
      charset: UTF-8
```

2. 自定义Servlet类

```java
/**
 * @author yixiaobai
 * @create 2022/05/06 上午1:02
 */
@WebServlet(urlPatterns = "/myservlet")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("世界你好，Hello World！");
        // 配置内容类型
        resp.setContentType("text/html");
        resp.getWriter().flush();
        resp.getWriter().close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```

3. 客户端中使用

```java
@SpringBootApplication
@ServletComponentScan(basePackages = "buzz.yixiaobai.springboot.servlet") // 开启扫描Servlet
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```

### 037-springboot-war

##### SpringBoot 打War包

- **SpringBoot中配置的端口号就会失效，需要在Tomcat中配置**

- 第一步：修改pom.xml

```xml
    <!-- 指定打war包 -->
    <packaging>war</packaging>
```

- 第二步：在build标签中指定war名称

```xml
<build>
    <!-- 指定打war包的名称 -->
    <finalName>springboot</finalName>

    <!-- 编译JSP -->
    <resources>
        <resource>
            <directory>src/main/webapp</directory>
            <targetPath>META-INF/resources</targetPath>
            <includes>
                <include>**/*.*</include>
            </includes>
        </resource>
    </resources>
	<!-- SpringBoot 工程自带 -->
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

- **第三步：在启动类中需要继承SpringBootServletInitializer类，并重写configure方法**

```java
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 参数为当前springboot 启动类
        // 构建新资源
        return builder.sources(Application.class);
    }
}
```

### 038-springboot-jar

- 配置pom.xml文件，编译插件必须要选择`<version>1.4.2.RELEASE</version>` 1.5以上的编译插件不支持jsp的打包

```xml
 <build>
     <!-- 指定包名 -->
     <finalName>springboot</finalName>
     <!-- 指定JSP的编译路径 -->
     <resources>
         <resource>
             <directory>src/main/webapp</directory>
             <targetPath>META-INF/resources</targetPath>
             <includes>
                 <include>*.*</include>
             </includes>
         </resource>
         <resource>
             <directory>src/main/resources</directory>
             <includes>
                 <include>**/*.*</include>
             </includes>
         </resource>
     </resources>
     <plugins>
         <plugin>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-maven-plugin</artifactId>
             <version>1.4.2.RELEASE</version>
         </plugin>
     </plugins>
</build>
```

### 039-springboot-logback

##### 使用 logback 记录日志

1. `pom.xml` 文件中添加依赖
   - 由于 springboot 框架已经集成 logback包，所有我们不需要添加
   - 只需要添加 `lombok` 即可

```xml
<!-- 添加Slf4j依赖 -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>
```

2. 在 `src/mian/resources` 目录下添加 [logback-spring.xml ](./039-springboot-logback/src/main/resources/logback-spring.xml)配置文件以及详细说明

3. 使用log记录日志案例

```java
/**
 * @author yixiaobai
 * @create 2022/05/06 下午8:36
 */
@Controller
@Slf4j // 有 lombok 提供注解，来记录日志
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/count")
    public @ResponseBody String studentCount() {
        log.trace("trace：查询当前学生总人数");
        log.debug("debug：查询当前学生总人数");
        log.info("info：查询当前学生总人数");
        log.warn("warn：查询当前学生总人数");
        log.error("error：查询当前学生总人数");
        Integer studentCount = studentService.queryStudentCount();
        return "学生的总人数为：" + studentCount ;
    }
}
```

