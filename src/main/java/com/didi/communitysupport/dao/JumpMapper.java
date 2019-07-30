package com.didi.communitysupport.dao;

import com.didi.communitysupport.domain.JumpEntity;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author: koco
* @time: 2019-07-29 14:54
* @table: jump
* @description: 
*/
@Mapper
public interface JumpMapper {

    /**
     * @param  entity  table entity
     * @return List<JumpEntity>
     */
    List<JumpEntity> getByCondition(JumpEntity entity);

    /**
     * @param  jId  
     * @return JumpEntity
     */
    JumpEntity getByJId(@Param("jId") Integer jId);

    /**
     * @param  jUserid  
     * @return List<JumpEntity>
     */
    List<JumpEntity> getByJUserid(@Param("jUserid") Integer jUserid);

    /**
     * @param  entity  table entity
     * @return int
     */
    int insert(JumpEntity entity);

    /**
     * @param entity  table entity
     * @return int
     */
    int updateById(JumpEntity entity);

}