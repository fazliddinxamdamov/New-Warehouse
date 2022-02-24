package com.fazliddin.newwarehouse.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Supplier;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> {
    private boolean success;
    private String message;
    private T data;
    private List<ErrorData> errors;

    public ApiResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResult(T data) {
        this.success = true;
        this.data = data;
    }

    public ApiResult(T data, String message) {
        this.success = true;
        this.data = data;
        this.message = message;
    }

    public ApiResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public ApiResult(boolean success, List<ErrorData> errors) {
        this.success = success;
        this.errors = errors;
    }

    public static <E> ApiResult<E> successResponse(E data) {
        return new ApiResult<>(true, data);
    }

    public static <E> ApiResult<E> successResponse(String message) {
        return new ApiResult<>(true, message);
    }

    public static <E> ApiResult<E> successResponse(E data, String message) {
        return new ApiResult<>(data, message);
    }

    /**
     * If a value is present, returns the value, otherwise throws an exception
     * produced by the exception supplying function.
     */
    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (data != null) {
            return data;
        } else {
            throw exceptionSupplier.get();
        }
    }

    /**
     * if a success is false throws an exception  produced by the exception supplying function.
     */
    public <X extends Throwable> void noSuccessThrow(Supplier<? extends X> exception) throws X {
        if (!success) throw exception.get();
    }


}
