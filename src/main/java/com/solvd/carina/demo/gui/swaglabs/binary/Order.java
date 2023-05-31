package com.solvd.carina.demo.gui.swaglabs.binary;

public class Order {
    private long idOrder;

    private long idUser;

    private String item;

    public Order() {
    }

    public Order(long idOrder, long idUser, String item) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.item = item;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", item='" + item + '\'' +
                '}';
    }
}
