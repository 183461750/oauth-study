package com.example.authweb.mapper;

import com.example.authweb.core.mapper.BaseMapper;
import com.example.authweb.domain.AdminUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser,Long> {

    @Override
    @Insert("INSERT INTO admin_user(id,name,avatarUrl,username,password,tel,gender,createTime,lastLoginTime) VALUES(#{id},#{name},#{avatarUrl},#{username},#{password},#{tel},#{gender},#{createTime},#{lastLoginTime})")
    void insert(AdminUser user);

    @Override
    @Delete("DELETE FROM admin_user WHERE id = #{id}")
    void delete(Long id);

    @Override
    @Update("UPDATE admin_user SET name=#{name},avatarUrl=#{avatarUrl},username=#{username},password=#{password},tel=#{tel},gender=#{gender},createTime=#{createTime},lastLoginTime=#{lastLoginTime} WHERE id =#{id}")
    void update(AdminUser user);

    @Override
    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM admin_user WHERE id=#{id}")
    AdminUser findById(Long id);

    @Override
    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM admin_user")
    List<AdminUser> findAll();

    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM admin_user WHERE name like #{name}")
    List<AdminUser> findByName(String name);

    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM admin_user WHERE username=#{username}")
    AdminUser findByUsername(String username);

    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM admin_user WHERE tel=#{tel}")
    AdminUser findByTel(String tel);

}
