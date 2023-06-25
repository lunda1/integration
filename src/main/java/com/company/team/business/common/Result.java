package com.company.team.business.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private int code;

    private String msg;

    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    public static <T> Result<T> failure(String s) {
        return new Result<>(500, Strings.isNotBlank(s) ? s : "failure", null);
    }
}
