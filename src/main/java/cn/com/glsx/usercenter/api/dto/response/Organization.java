package cn.com.glsx.usercenter.api.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class Organization implements Serializable {

    private Long id;
    private Long parentId;
    private String orgName;
    private String orgCode;
    private Long userId;
}
