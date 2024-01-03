package org.hackathon.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListResponse<T> implements Serializable {

    private Boolean success;
    private String message;
    private List<T> data;

    private ListResponse() {
    }

    private ListResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    private ListResponse(List<T> data) {
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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static <T> ListResponse<T> success(List<T> data) {
        return new ListResponse<T>(data);
    }

    public static <T> ListResponse<T> success() {
        return new ListResponse<T>(null, true);
    }

    public static <T> ListResponse<T> failure(String message) {
        return new ListResponse<T>(message, false);
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
