package com.demo.securitydmroleandmenu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther:Lian
 * @Date:2020/9/27 16:44
 * @Description:TODO
 * @version:1.0
 */
@Document(value = "menu_info")
public class Menu {
    @Id
    private Integer menu_id;
    //1菜单，2按钮
    private Integer menu_type;
    //页面路由；对应菜单
    private String menu_routing;
    //接口路径；对应按钮
    private String menu_pattern;
    private Integer menu_pid;
    //族谱形式：1-2；2是父节点，1是祖父节点
    private String menu_pids;
    private String menu_remark;

    public Menu(Integer menu_id, Integer menu_type, String menu_routing, String menu_pattern, Integer menu_pid, String menu_remark) {
        this.menu_id = menu_id;
        this.menu_type = menu_type;
        this.menu_routing = menu_routing;
        this.menu_pattern = menu_pattern;
        this.menu_pid = menu_pid;
        this.menu_remark = menu_remark;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", menu_type=" + menu_type +
                ", menu_routing='" + menu_routing + '\'' +
                ", menu_pattern='" + menu_pattern + '\'' +
                ", menu_pid=" + menu_pid +
                ", menu_pids='" + menu_pids + '\'' +
                ", menu_remark='" + menu_remark + '\'' +
                '}';
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public Integer getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(Integer menu_type) {
        this.menu_type = menu_type;
    }

    public String getMenu_routing() {
        return menu_routing;
    }

    public void setMenu_routing(String menu_routing) {
        this.menu_routing = menu_routing;
    }

    public String getMenu_pattern() {
        return menu_pattern;
    }

    public void setMenu_pattern(String menu_pattern) {
        this.menu_pattern = menu_pattern;
    }

    public Integer getMenu_pid() {
        return menu_pid;
    }

    public void setMenu_pid(Integer menu_pid) {
        this.menu_pid = menu_pid;
    }

    public String getMenu_pids() {
        return menu_pids;
    }

    public void setMenu_pids(String menu_pids) {
        this.menu_pids = menu_pids;
    }

    public String getMenu_remark() {
        return menu_remark;
    }

    public void setMenu_remark(String menu_remark) {
        this.menu_remark = menu_remark;
    }
}
