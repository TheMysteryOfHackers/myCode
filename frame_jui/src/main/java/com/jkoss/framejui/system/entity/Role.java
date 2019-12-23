package com.jkoss.framejui.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jkoss.base.entity.BaseEntity;

import java.io.Serializable;

/**
 * <p>
 * ??ɫ
 * </p>
 *
 * @author zzx
 * @since 2019-11-13
 */
public class Role extends BaseEntity<Role> {

    private static final long serialVersionUID = 1L;


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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Role{" +
        ", id=" + id +
        ", name=" + name +
        ", remarks=" + remarks +
        "}";
    }
}
