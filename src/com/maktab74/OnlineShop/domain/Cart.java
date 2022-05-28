package com.maktab74.OnlineShop.domain;

public class Cart extends Base {

    private int userId;

    private int productId;

    private String productType;

    private int count;

    private int totalPrice;

    public Cart() {
    }

    public Cart(int id, int userId, int productId, String productType, int count, int totalPrice) {
        super(id);
        this.userId = userId;
        this.productId = productId;
        this.productType = productType;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                super.toString() +
                "userId=" + userId +
                ", productId=" + productId +
                ", productType='" + productType + '\'' +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
