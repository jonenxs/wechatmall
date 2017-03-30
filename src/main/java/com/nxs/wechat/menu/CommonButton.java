package com.nxs.wechat.menu;

/**
 * 类名: CommonButton </br>
 * 包名： com.nxs.menu
 * 描述: 子菜单项 :没有子菜单的菜单项，有可能是二级菜单项，也有可能是不含二级菜单的一级菜单。 </br>
 * 开发人员： nxs  </br>
 * 创建时间：  2017/1/31 </br>
 * 发布版本：V1.0  </br>
 */
public class CommonButton extends Button {

    private String type;
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
