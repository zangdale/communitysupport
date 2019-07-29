package com.didi.communitysupport.dao;

import com.didi.communitysupport.domain.OnebankEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* @author: koco
* @time: 2019-07-29 14:54
* @table: onebank
* @description: 
*/
public interface OnebankMapper {

    /**
     * @param  entity  table entity
     * @return List<OnebankEntity>
     */
    List<OnebankEntity> getByCondition(OnebankEntity entity);

    /**
     * @param  oId  
     * @return OnebankEntity
     */
    OnebankEntity getByOId(@Param("oId") Integer oId);

    /**
     * @param  entity  table entity
     * @return int
     */
    int insert(OnebankEntity entity);

    /**
     * @param entity  table entity
     * @return int
     */
    int updateById(OnebankEntity entity);

}