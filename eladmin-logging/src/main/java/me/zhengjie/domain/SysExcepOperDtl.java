package me.zhengjie.domain;

import java.io.Serializable;
import java.util.Date;

public class SysExcepOperDtl implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String operType;
    private String operData;
    private Date operTime;
    private Date createTime;
    private Date updateTime;
    private Integer excepLogId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    public String getOperData() {
        return operData;
    }

    public void setOperData(String operData) {
        this.operData = operData == null ? null : operData.trim();
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
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

    public Integer getExcepLogId() {
        return excepLogId;
    }

    public void setExcepLogId(Integer excepLogId) {
        this.excepLogId = excepLogId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", operType=").append(operType);
        sb.append(", operData=").append(operData);
        sb.append(", operTime=").append(operTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", excepLogId=").append(excepLogId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}