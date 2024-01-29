package com.kalyan.errorcodes;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ErrorCode {
	public static final String ERROR_CODE = "NO_RECORD_404";

}
