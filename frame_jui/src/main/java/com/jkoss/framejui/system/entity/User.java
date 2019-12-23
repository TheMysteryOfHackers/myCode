package com.jkoss.framejui.system.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jkoss.base.entity.BaseEntity;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author chair
 * @since 2019-11-11
 */
public class User extends BaseEntity<User> {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色id
	 */
	@TableField("rid")
	private String rid;
	/**
	 * 组织机构id
	 */
	@TableField("ogid")
	private String ogid;
	/**
	 * 姓名
	 */
	@TableField("name")
	private String name;
	/**
	 * 密码
	 */
	@TableField("pwd")
	private String pwd;
	/**
	 * 性别 1-男、2-女
	 */
	@TableField("sex")
	private BigDecimal sex;
	/**
	 * 生日
	 */
	@TableField("birth")
	private String birth;
	/**
	 * 手机
	 */
	@TableField("phone")
	private String phone;
	/**
	 * 邮件
	 */
	@TableField("email")
	private String email;
	/**
	 * 登录时间
	 */
	@TableField("logintime")
	private String logintime;
	/**
	 * 登录ip
	 */
	@TableField("loginip")
	private String loginip;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getOgid() {
		return ogid;
	}

	public void setOgid(String ogid) {
		this.ogid = ogid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public BigDecimal getSex() {
		return sex;
	}

	public void setSex(BigDecimal sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getLoginip() {
		return loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" + ", id=" + id + ", rid=" + rid + ", ogid=" + ogid + ", name=" + name + ", pwd=" + pwd + ", sex=" + sex + ", birth=" + birth + ", phone=" + phone + ", email=" + email + ", logintime=" + logintime + ", loginip=" + loginip + "}";
	}
}
