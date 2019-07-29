package com.didi.communitysupport.dao;

import com.didi.communitysupport.domain.BloodEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* @author: koco
* @time: 2019-07-29 14:54
* @table: blood
* @description: 
*/
public interface BloodMapper {

    /**
     * @param  bId  
     * @return BloodEntity
     */
    BloodEntity getByBId(@Param("bId") Integer bId);

    /**
     * @param  bUserid  
     * @return List<BloodEntity>
     */
    List<BloodEntity> getByBUserid(@Param("bUserid") Integer bUserid);

    /**
     * @param  entity  table entity
     * @return List<BloodEntity>
     */
    List<BloodEntity> getByCondition(BloodEntity entity);

    /**
     * @param  entity  table entity
     * @return int
     */
    int insert(BloodEntity entity);

    /**
     * @param entity  table entity
     * @return int
     */
    int updateById(BloodEntity entity);

}