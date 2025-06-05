package com.klitzke.aula.Enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    //Atributos
    private int code;

    //Construtor
    private OrderStatus(int code) {
        this.code = code;
    }

    //Get para ficar publico esse valor
    public int getCode() {
        return code;
    }

    //Metodo para
    public static OrderStatus valueOf(int code) {
        for(OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código invalido!");
    }

}
