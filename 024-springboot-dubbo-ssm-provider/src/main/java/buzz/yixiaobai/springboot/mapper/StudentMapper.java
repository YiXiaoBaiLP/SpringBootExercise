package buzz.yixiaobai.springboot.mapper;

import buzz.yixiaobai.springboot.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    /**
     * 获取学生总人数
     * @return
     */
    Integer selectAllStudentCount();
}