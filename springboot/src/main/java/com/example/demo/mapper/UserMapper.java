package com.example.demo.mapper;

import com.example.demo.model.user;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户mapper接口
 */
public interface UserMapper {

    /**
     * 新增
     * @param userName
     * @param password
     */
    @Insert("insert into user(username,password) values(#{userName},#{password})")
    void addNewUser(@Param("userName")String userName, @Param("password")String password);

    /**
     * 根据ID和姓名查询用户
     * @param id
     * @param
     * @return
     */
    @Select("<script>" +
            "select * from user where 1=1 " +
            "<if test='id != 0'>" +
            " and id = #{id} " +
            "</if> " +
            "<if test='userName != null'>" +
            " and username like '%${userName}%' " +
            "</if> " +
            "order by id " +
            "</script>")
    List<user> findUsersByCondition(@Param("id") int id, @Param("userName") String userName);

    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    user findUserById(@Param("id") int id);

    /**
     * 更新用户信息
     * @param id
     * @param userName
     * @param password
     */
    @Update("update user set userName = #{userName}, password = #{password} where id = #{id}")
    void update(@Param("id") int id, @Param("userName")String userName, @Param("password")String password);

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void delete(@Param("id") int id);
}
