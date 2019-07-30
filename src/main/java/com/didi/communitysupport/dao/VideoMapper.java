package com.didi.communitysupport.dao;

import com.didi.communitysupport.domain.VideoEntity;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author: koco
* @time: 2019-07-29 14:54
* @table: video
* @description: 
*/
@Mapper
public interface VideoMapper {

    /**
     * @param  entity  table entity
     * @return List<VideoEntity>
     */
    List<VideoEntity> getByCondition(VideoEntity entity);

    /**
     * @param  vId  主键id
     * @return VideoEntity
     */
    VideoEntity getByVId(@Param("vId") Integer vId);

    /**
     * @param  entity  table entity
     * @return int
     */
    int insert(VideoEntity entity);

    /**
     * @param entity  table entity
     * @return int
     */
    int updateById(VideoEntity entity);

}