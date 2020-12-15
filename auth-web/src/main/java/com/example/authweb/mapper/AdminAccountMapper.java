package com.example.authweb.mapper;

import com.example.authweb.core.mapper.BaseMapper;
import com.example.authweb.domain.AdminAccount;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminAccountMapper extends BaseMapper<AdminAccount,Long> {

    @Override
    @Insert("INSERT INTO admin_account(id,userId,type,openid,accessToken,refreshToken,expireTime,createTime,lastLoginTime) VALUES(#{id},#{user.id},#{type},#{openid},#{accessToken},#{refreshToken},#{expireTime},#{createTime},#{lastLoginTime})")
    void insert(AdminAccount account);

    @Override
    @Delete("DELETE FROM admin_account WHERE id = #{id}")
    void delete(Long id);

    @Override
    @Update("UPDATE admin_account SET userId=#{user.id},type=#{type},openid=#{openid},accessToken=#{accessToken},refreshToken=#{refreshToken},expireTime=#{expireTime},createTime=#{createTime},lastLoginTime=#{lastLoginTime} WHERE id =#{id}")
    void update(AdminAccount account);

    @Override
    @ResultMap("BaseResultMap")
    @Select("SELECT id,userId,type,openid,accessToken,refreshToken,expireTime,createTime,lastLoginTime FROM admin_account WHERE id=#{id}")
    AdminAccount findById(Long id);

    @Override
    @ResultMap("BaseResultMap")
    @Select("SELECT id,userId,type,openid,accessToken,refreshToken,expireTime,createTime,lastLoginTime FROM admin_account")
    List<AdminAccount> findAll();

}
