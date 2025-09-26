package com.main.estocafy.shared.exceptions.types;

import java.io.Serial;

public class ExpiredBatchException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ExpiredBatchException(String message) {
        super(message);
    }
    
}
