package com.ilop.architecture.data.response;

/**
 * TODO：本类仅用作示例参考，请根据 "实际项目需求" 配置自定义的 "响应状态元信息"
 */
public class ResponseStatus {

    private int responseCode ;
    private boolean success = true;
    private String message ;

    private Enum source = ResultSource.NETWORK;

    public ResponseStatus() {
    }

    public ResponseStatus(int responseCode, boolean success, String message) {
        this.responseCode = responseCode;
        this.success = success;
        this.message = message;
    }

    public ResponseStatus(int responseCode, boolean success, String message, Enum source) {
        this(responseCode, success, message);
        this.source = source;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Enum getSource() {
        return source;
    }
}
