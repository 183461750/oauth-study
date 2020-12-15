package com.example.authweb.mapper;

import com.example.authweb.core.mapper.BaseMapper;
import com.example.authweb.domain.AdminApp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminAppMapper extends BaseMapper<AdminApp,Long> {

    @Override
    void insert(AdminApp app);
    void insertClientDetails(AdminApp app);

    @Override
    void delete(Long id);

    @Override
    void update(AdminApp app);

    @Override
    AdminApp findById(Long id);

    @Override
    List<AdminApp> findAll();

    List<AdminApp> findByNameOrClientId(@Param("name") String name, @Param("clientId") String clientId);

    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM admin_app WHERE clientId=#{clientId}")
    AdminApp findByClientId(@Param("clientId") String clientId);

}
