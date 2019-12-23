package com.jkoss.framejui.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jkoss.base.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * ??֯????
 * </p>
 *
 * @author zzx
 * @since 2019-11-13
 */
public class Organization extends BaseEntity<Organization> {

    private static final long serialVersionUID = 1L;

    /**
     * ????id
     */
    @TableField("pid")
    private String pid;
    /**
     * ???
     */
    @TableField("name")
    private String name;
    /**
     * ??ע
     */
    @TableField("remarks")
    private String remarks;
    /**
     * ???
     */
    @TableField("sort")
    private BigDecimal sort;
    /**
     * ?ȼ?
     */
    @TableField("level")
    private BigDecimal level;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getSort() {
        return sort;
    }

    public void setSort(BigDecimal sort) {
        this.sort = sort;
    }

    public BigDecimal getLevel() {
        return level;
    }

    public void setLevel(BigDecimal level) {
        this.level = level;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Organization{" +
        ", id=" + id +
        ", pid=" + pid +
        ", name=" + name +
        ", remarks=" + remarks +
        ", sort=" + sort +
        ", level=" + level +
        "}";
    }
}
