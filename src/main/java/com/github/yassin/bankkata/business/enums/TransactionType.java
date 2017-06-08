package com.github.yassin.bankkata.business.enums;

/**
 * TransactionType define transaction type (DEPOSITE, WITHDRAWAL)
 *       
 * @author Yassin
 *
 */
public enum TransactionType {

	DEPOSITE(1),
	WITHDRAWAL(-1);

    private int type;

    TransactionType(int type) {
        this.type = type;
    }

}
