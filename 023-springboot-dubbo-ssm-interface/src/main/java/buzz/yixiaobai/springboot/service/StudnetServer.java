package buzz.yixiaobai.springboot.service;

import buzz.yixiaobai.springboot.model.Student;

/**
 * @author yixiaobai
 * @create 2022/05/04 上午12:53
 */
public interface StudnetServer {

    /**
     * 根据学生ID查询详情
     * @param id
     * @return
     */
    Student queryStudentById(Integer id);

    /**
     * 获取学生总人数
     * @return
     */
    Integer queryAllStudentCount();
}
