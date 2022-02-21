package com.fazliddin.newwarehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fazliddin Xamdamov
 * @date 18.02.2022  17:00
 * @project New-Warehouse
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {

    private String message;
    private boolean success;
    private Object object;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
