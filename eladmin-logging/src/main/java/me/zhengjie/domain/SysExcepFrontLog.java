package me.zhengjie.domain;

import java.io.Serializable;
import java.util.Date;

public class SysExcepFrontLog implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExcepFile() {
        return excepFile;
    }

    public void setExcepFile(String excepFile) {
        this.excepFile = excepFile == null ? null : excepFile.trim();
    }

    public String getExcepContent() {
        return excepContent;
    }

    public void setExcepContent(String excepContent) {
        this.excepContent = excepContent == null ? null : excepContent.trim();
    }

    public Integer getExepLine() {
        return exepLine;
    }

    public void setExepLine(Integer exepLine) {
        this.exepLine = exepLine;
    }

    public Integer getExepColumn() {
        return exepColumn;
    }

    public void setExepColumn(Integer exepColumn) {
        this.exepColumn = exepColumn;
    }

    public Date getExepTime() {
        return exepTime;
    }

    public void setExepTime(Date exepTime) {
        this.exepTime = exepTime;
    }

    public String getExepMsg() {
        return exepMsg;
    }

    public void setExepMsg(String exepMsg) {
        this.exepMsg = exepMsg == null ? null : exepMsg.trim();
    }

    public String getExepStack() {
        return exepStack;
    }

    public void setExepStack(String exepStack) {
        this.exepStack = exepStack == null ? null : exepStack.trim();
    }

    public String getExepUrl() {
        return exepUrl;
    }

    public void setExepUrl(String exepUrl) {
        this.exepUrl = exepUrl == null ? null : exepUrl.trim();
    }

    public String getExepUserAgent() {
        return exepUserAgent;
    }

    public void setExepUserAgent(String exepUserAgent) {
        this.exepUserAgent = exepUserAgent == null ? null : exepUserAgent.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}