package com.didi.communitysupport.dao;

import com.didi.communitysupport.domain.IllEntity;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author: koco
* @time: 2019-07-29 14:54
* @table: ill
* @description: 
*/
@Mapper
public interface IllMapper {

    /**
     * @param  entity  table entity
     * @return List<IllEntity>
     */
    List<IllEntity> getByCondition(IllEntity entity);

    /**
     * @param  iId  
     * @return IllEntity
     */
    IllEntity getByIId(@Param("iId") Integer iId);

    /**
     * @param  iUserid  
     * @return List<IllEntity>
     */
    List<IllEntity> getByIUserid(@Param("iUserid") Integer iUserid);

    /**
     * @param  entity  table entity
     * @return int
     */
    int insert(IllEntity entity);

    /**
     * @param entity  table entity
     * @return int
     */
    int updateById(IllEntity entity);

}