/**
 * Represents a ErrorResponse
 *
 * @author P Tr Xuan
 * Created on Sep 15, 2021
 */
package com.vti.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents a ErrorResponse
 *
 * 
 * @author P Tr Xuan
 * Created on Sep 15, 2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String field;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;

    private ErrorResponse(String field, String message) {
        this.field = field;
        this.message = message;
    }
    @Getter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    List<ErrorResponse> errors = new ArrayList<>();

    public void addError(String field, String message) {
        errors.add(new ErrorResponse(field, message));
    }
}
