package me.zhengjie.service.dto;

import lombok.Data;
import me.zhengjie.domain.SysExcepFrontLog;
import me.zhengjie.domain.SysExcepOperDtl;

import java.util.Date;
import java.util.List;

@Data
public class SysExcepFrontDto {

    private String excepFile;

    private String excepContent;

    private Integer exepLine;

    private Integer exepColumn;

    private Date exepTime;

    private String exepMsg;

    private String exepStack;

    private String exepUrl;

    private String exepUserAgent;

    private String username;

    private Date createTime;

    private Date updateTime;

    private List<SysExcepOperDtl> sysExcepOperDtls;

    public SysExcepFrontLog toSysExcepFrontLog() {
        SysExcepFrontLog sysExcepFrontLog = new SysExcepFrontLog();
        sysExcepFrontLog.setCreateTime(new Date());
        sysExcepFrontLog.setExcepContent(getExcepContent());
        sysExcepFrontLog.setExcepFile(getExcepFile());
        sysExcepFrontLog.setExepColumn(getExepColumn());
        sysExcepFrontLog.setExepLine(getExepLine());
        sysExcepFrontLog.setExepMsg(getExepMsg());
        sysExcepFrontLog.setExepStack(getExepStack());
        sysExcepFrontLog.setExepUrl(getExepUrl());
        sysExcepFrontLog.setExepUserAgent(getExepUserAgent());
        sysExcepFrontLog.setUpdateTime(getUpdateTime());
        sysExcepFrontLog.setUsername(getUsername());
        return sysExcepFrontLog;
    }


}
