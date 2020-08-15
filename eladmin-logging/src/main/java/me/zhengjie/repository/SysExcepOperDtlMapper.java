package me.zhengjie.repository;

import me.zhengjie.domain.SysExcepOperDtl;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysExcepOperDtlMapper {

    int deleteByPrimaryKey(Integer id);

    int save(SysExcepOperDtl record);

    int insertSelective(SysExcepOperDtl record);

    SysExcepOperDtl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysExcepOperDtl record);

    int updateByPrimaryKey(SysExcepOperDtl record);
}