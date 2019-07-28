package com.didi.dao;

import com.didi.domain.VideoEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* @author: koco
* @time: 2019-07-28 20:36
* @table: video
* @description: 
*/
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