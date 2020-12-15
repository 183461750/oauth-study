package com.example.authweb.mapper;

import com.example.authweb.core.mapper.BaseMapper;
import com.example.authweb.domain.AdminRole;
import com.example.authweb.domain.AdminRoleResource;
import com.example.authweb.domain.AdminUserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminRoleMapper extends BaseMapper<AdminRole,Long> {

    @Override
    @Insert("INSERT INTO admin_role(id,code,name,description) VALUES(#{id},#{code},#{name},#{description})")
    void insert(AdminRole role);

    @Override
    @Delete("DELETE FROM admin_role WHERE id = #{id}")
    void delete(Long id);

    @Override
    @Update("UPDATE admin_role SET code=#{code},name=#{name},description=#{description} WHERE id =#{id}")
    void update(AdminRole role);

    @Override
    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM admin_role WHERE id=#{id}")
    AdminRole findById(Long id);

    @Override
    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM admin_role")
    List<AdminRole> findAll();

    List<AdminRole> findByUserId(Long userId);

    void insertUserRoles(@Param("userRoles") List<AdminUserRole> userRoles);

    @Delete("DELETE FROM admin_user_role WHERE userId = #{userId}")
    void deleteUserRole(Long userId);

    void insertRoleResources(@Param("roleResources") List<AdminRoleResource> roleResources);

    void deleteRoleResources(@Param("roleId") Long roleId, @Param("resourcesIds") List<Long> resourcesIds);

}
