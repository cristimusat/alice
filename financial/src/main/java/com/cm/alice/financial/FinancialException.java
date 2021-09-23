package com.cm.alice.financial;

public class FinancialException extends RuntimeException {
    public FinancialException(String errorMessage) {
        super(errorMessage);
    }

    public FinancialException(String errorMesage, Exception e) {
        super(errorMesage, e);
    }
}
