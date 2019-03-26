package com.gongyongqin.demo.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface Userdao {
    /**
     * 员工列表查询
     */
    @Select("select id,user_id,user_name,user_sex,user_sal,user_dept from user")
    List<Map> getUserList();

    /**
     * 车辆添加
     */
    @Insert(value = "insert into user values (null,#{user_id},#{user_name},#{user_sex},#{user_sal},#{user_dept})")
    int addCar(Map map);

    /**
     * 通过条件获取员工列表
     */
    @Select("select id,user_id,user_name,user_sex,user_sal,user_dept from user where user_dept=user_dept")
    List<Map> getDeptListBy(Map map);

    /**
     * 更改
     * @param map
     * @return
     */
    @Insert("update user set user_id=#{user_id},user_name=#{user_name},user_sex=#{user_sex},user_sal=#{user_sal},user_dept=#{user_dept} where id = #{id}")
    int updateUser(Map map);

    /**
     * 删除
     * @param
     * @return
     */
    @Delete("delete from user where id=#{id}")
    int deleteUser(Integer ID);

    /**
     * 批量删除
     * @param
     * @return
     */
    @Delete("<script>delete from user where id in\n" +
            "  <foreach collection=\"list\" item = \"model\" open=\"(\" separator=\",\" close=\")\">#{id}  \n" +
            "      \n" +
            "        </foreach> </script>")
    int batchDel(List IDs);

}
