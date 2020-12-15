package com.example.authweb.mapper;

import com.example.authweb.core.mapper.BaseMapper;
import com.example.authweb.domain.AdminResource;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminResourceMapper extends BaseMapper<AdminResource,Long> {

    @Override
    @Insert("INSERT INTO admin_resource(id,name,domain,operate,code) VALUES(#{id},#{name},#{domain},#{operate},#{code})")
    void insert(AdminResource resource);

    @Override
    @Delete("DELETE FROM admin_resource WHERE id = #{id}")
    void delete(Long id);

    @Override
    @Update("UPDATE admin_resource SET name=#{name},domain=#{domain},operate=#{operate},code=#{code} WHERE id =#{id}")
    void update(AdminResource resource);

    @Override
    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM admin_resource WHERE id=#{id}")
    AdminResource findById(Long id);

    @Override
    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM admin_resource")
    List<AdminResource> findAll();

    List<AdminResource> findByUserId(Long userId);

    @ResultMap("BaseResultMap")
    @Select("SELECT R.* FROM admin_resource R " +
            "LEFT JOIN admin_role_resource RR ON RR.resourceId=R.id " +
            "WHERE RR.roleId=#{roleId}")
    List<AdminResource> findByRoleId(Long roleId);

}
