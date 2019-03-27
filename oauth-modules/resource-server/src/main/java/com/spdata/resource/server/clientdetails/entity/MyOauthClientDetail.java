package com.spdata.resource.server.clientdetails.entity;

import com.spdata.common.clientdetail.OauthClientDetails;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/3/26-13:10
 **/
@Getter
@Setter
public class MyOauthClientDetail {
    private String clientId;

    private String resourceIds;

    private String clientSecret;

    private String scope;

    private String authorizedGrantTypes;

    private String webServerRedirectUri;

    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalInformation;

    private String autoapprove;
}
