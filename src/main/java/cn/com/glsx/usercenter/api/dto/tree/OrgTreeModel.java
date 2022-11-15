package cn.com.glsx.usercenter.api.dto.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glsx.plat.common.model.TreeModel;

import java.util.ArrayList;
import java.util.List;

public class OrgTreeModel implements TreeModel<OrgModel> {

    protected OrgModel org;

    private Integer userNumber;

    private List<TreeModel> children = new ArrayList<>();

    public OrgTreeModel(OrgModel org) {
        this.org = org;
        this.userNumber = org.getUserNumber();
    }

    @Override
    public String getId() {
        return org.getType() + org.getOrgId();
    }

    @Override
    public String getParentId() {
        return String.valueOf(org.getParentId());
    }

    @Override
    public String getLabel() {
        return org.getOrgName();
    }

    @Override
    public Integer isRoot() {
        return org.getIsRoot();
    }

    @Override
    public Integer getDepth() {
        return org.getDepth();
    }

    @JsonIgnore
    @Override
    public Integer getOrder() {
        return org.getOrderNum();
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    @Override
    public boolean checked() {
        return false;
    }

    @Override
    public OrgModel getOrigin() {
        return org;
    }

    @Override
    public List<TreeModel> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List data) {
        this.children = data;
    }

}
