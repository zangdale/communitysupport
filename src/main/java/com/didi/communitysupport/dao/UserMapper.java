package com.didi.communitysupport.dao;

import com.didi.communitysupport.domain.UserEntity;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author: koco
* @time: 2019-07-29 14:54
* @table: user
* @description: 
*/
@Mapper
public interface UserMapper {

    /**
     * @param  entity  table entity
     * @return List<UserEntity>
     */
    List<UserEntity> getByCondition(UserEntity entity);

    /**
     * @param  uId  
     * @return UserEntity
     */
    UserEntity getByUId(@Param("uId") Integer uId);

    /**
     * @param  entity  table entity
     * @return int
     */
    int insert(UserEntity entity);

    /**
     * @param entity  table entity
     * @return int
     */
    int updateById(UserEntity entity);

}