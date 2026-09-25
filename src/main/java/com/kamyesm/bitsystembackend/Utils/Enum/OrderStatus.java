package com.kamyesm.bitsystembackend.Utils.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {

    PENDING("در انتظار پرداخت"),
    PAID("پرداخت شده"),
    PROCESSING("در حال پردازش"),
    SHIPPED("تحویل پست داده شده"),
    DELIVERED("تحویل داده شده"),
    CANCELLED("لغو شده");

    private final String persianTitle;
}