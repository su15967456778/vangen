package me.zhengjie.repository;

import me.zhengjie.domain.SysExcepFrontLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysExcepFrontLogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysExcepFrontLog record);

    int save(SysExcepFrontLog record);

    int insertSelective(SysExcepFrontLog record);

    SysExcepFrontLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SysExcepFrontLog record);
}