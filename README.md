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
