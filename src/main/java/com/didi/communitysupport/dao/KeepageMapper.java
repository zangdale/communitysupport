package com.didi.communitysupport.dao;

import com.didi.communitysupport.domain.KeepageEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* @author: koco
* @time: 2019-07-29 14:54
* @table: keepage
* @description: 
*/
public interface KeepageMapper {

    /**
     * @param  entity  table entity
     * @return List<KeepageEntity>
     */
    List<KeepageEntity> getByCondition(KeepageEntity entity);

    /**
     * @param  kId  
     * @return KeepageEntity
     */
    KeepageEntity getByKId(@Param("kId") Integer kId);

    /**
     * @param  kUserid  
     * @return List<KeepageEntity>
     */
    List<KeepageEntity> getByKUserid(@Param("kUserid") Integer kUserid);

    /**
     * @param  entity  table entity
     * @return int
     */
    int insert(KeepageEntity entity);

    /**
     * @param entity  table entity
     * @return int
     */
    int updateById(KeepageEntity entity);

}