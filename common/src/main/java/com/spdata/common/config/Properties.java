package com.spdata.common.config;

/**
 * @author yangqifang
 * @deprecated : spring cloud config server 对应的数据库实体类  表名:Properties
 */
public class Properties {
    /**
     * ID
     */
    private Integer id;

    /**
     * 键
     */
    private String key;

    /**
     * 值
     */
    private String value;

    /**
     * 应用程序名称
     */
    private String application;

    /**
     * 配置环境
     */
    private String profile;

    /**
     * 标签
     */
    private String label;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getApplication() {
        return this.application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}

