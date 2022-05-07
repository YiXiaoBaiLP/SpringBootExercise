package buzz.yixiaobai.springboot.model;

/**
 * @author yixiaobai
 * @create 2022/05/07 上午10:15
 */
public class User {

    private Integer id;

    private Integer age;

    private String userName;

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
