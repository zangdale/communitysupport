package com.didi.dao;

import com.didi.domain.UserEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* @author: koco
* @time: 2019-07-28 20:36
* @table: user
* @description: 
*/
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