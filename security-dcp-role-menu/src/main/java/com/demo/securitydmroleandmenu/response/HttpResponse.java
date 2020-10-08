package com.demo.securitydmroleandmenu.response;

/**
 * @Auther:Lian
 * @Date:2020/10/4 18:44
 * @Description:TODO
 * @version:1.0
 */
public class HttpResponse {
    private Integer code;
    private Boolean successful;
    private String message;
    private Object data;

    public HttpResponse(HttpCode httpCode, Object data) {
        code = httpCode.getCode();
        successful = httpCode.getSuccessful();
        message = httpCode.getMessage();
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
