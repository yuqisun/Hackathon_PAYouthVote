package org.hackathon.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SingleResponse<T> implements Serializable {

    private Boolean success;
    private String message;
    private T data;

    private SingleResponse() {
    }

    private SingleResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    private SingleResponse(T data) {
        this.data = data;
        this.success = true;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> SingleResponse<T> success(T data) {
        return new SingleResponse<T>(data);
    }

    public static <T> SingleResponse<T> success() {
        return new SingleResponse<T>(null, true);
    }

    public static <T> SingleResponse<T> failure(String message) {
        return new SingleResponse<T>(message, false);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Response{");
        sb.append("success=").append(success);
        sb.append(", message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
