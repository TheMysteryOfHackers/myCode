package com.jkoss.framejui.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jkoss.base.entity.BaseEntity;

import java.io.Serializable;

/**
 * <p>
 * ?????ֵ
 * </p>
 *
 * @author zzx
 * @since 2019-11-13
 */
public class Dictionary extends BaseEntity<Dictionary> {

    private static final long serialVersionUID = 1L;


    /**
     * ??
     */
    @TableField("dkey")
    private String dkey;
    /**
     * ֵ
     */
    @TableField("dvalue")
    private String dvalue;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDkey() {
        return dkey;
    }

    public void setDkey(String dkey) {
        this.dkey = dkey;
    }

    public String getDvalue() {
        return dvalue;
    }

    public void setDvalue(String dvalue) {
        this.dvalue = dvalue;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
        ", id=" + id +
        ", dkey=" + dkey +
        ", dvalue=" + dvalue +
        "}";
    }
}
