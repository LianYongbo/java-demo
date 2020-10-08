package com.demo.securitydmroleandmenu.response;

/**
 * @Auther:Lian
 * @Date:2020/10/4 18:46
 * @Description:TODO
 * @version:1.0
 */
public enum HttpCode {
    OK(200, true, "请求成功！"),
    BadRequest(400, false, "数据格式或数据本身有误！"),
    Forbidden(403, false, "禁止访问！"),
    NotFound(404, false, "资源不存在！");
    private Integer code;
    private Boolean successful;
    private String message;

    HttpCode(Integer code, Boolean successful, String message) {
        this.code = code;
        this.successful = successful;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
