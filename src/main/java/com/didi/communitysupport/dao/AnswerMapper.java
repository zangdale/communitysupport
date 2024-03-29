package com.didi.communitysupport.dao;

import com.didi.communitysupport.domain.AnswerEntity;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author: koco
* @time: 2019-07-29 14:54
* @table: answer
* @description: 
*/
@Mapper
public interface AnswerMapper {

    /**
     * @param  aId  
     * @return AnswerEntity
     */
    AnswerEntity getByAId(@Param("aId") Integer aId);

    /**
     * @param  aQuestionid  
     * @return List<AnswerEntity>
     */
    List<AnswerEntity> getByAQuestionid(@Param("aQuestionid") Integer aQuestionid);

    /**
     * @param  aUserid  
     * @return List<AnswerEntity>
     */
    List<AnswerEntity> getByAUserid(@Param("aUserid") Integer aUserid);

    /**
     * @param  entity  table entity
     * @return List<AnswerEntity>
     */
    List<AnswerEntity> getByCondition(AnswerEntity entity);

    /**
     * @param  entity  table entity
     * @return int
     */
    int insert(AnswerEntity entity);

    /**
     * @param entity  table entity
     * @return int
     */
    int updateById(AnswerEntity entity);

}