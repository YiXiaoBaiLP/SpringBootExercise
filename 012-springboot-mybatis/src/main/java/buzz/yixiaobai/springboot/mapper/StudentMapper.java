package buzz.yixiaobai.springboot.mapper;

import buzz.yixiaobai.springboot.model.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 扫描 Dao接口 到Spring 容器中
public interface StudentMapper {
    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(Student record);

    /**
     * 插入数据，条件插入
     * @param record
     * @return
     */
    int insertSelective(Student record);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Student selectByPrimaryKey(Integer id);

    /**
     * 根据主键选择个更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * 根据主键更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Student record);
}