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