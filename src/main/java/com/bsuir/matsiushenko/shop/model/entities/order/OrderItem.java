package com.bsuir.matsiushenko.shop.model.entities.order;

import com.bsuir.matsiushenko.shop.model.entities.phone.Phone;

public class OrderItem {
    private Long id;
    private Phone phone;
    private Order order;
    private int quantity;

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(final Phone phone) {
        this.phone = phone;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(final Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}