package cn.com.glsx.usercenter.api.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class CUser implements Serializable {

    private Long userId;
    private String account;
    private String username;
    private String avatar;
    private Long relUserId;

}
