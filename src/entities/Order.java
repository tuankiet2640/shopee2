package entities;

import service.CustomerService;

import java.util.List;

public class Order {
    private List<OrderLine> orderLines;
    private int orderId;
    private  Address address= new Address();
    private  long total;
    private int customerId;

    public Order(Address address, List<OrderLine> orderLines, long total, int customerId, int orderId) {
        this.address = address;
        this.orderLines = orderLines;
        this.total = total;
        this.customerId = customerId;
        this.orderId=orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "address=" + address +
                ", " + orderLines +
                ", total=" + total +
                ", customer=" + CustomerService.getCustomerById(customerId).getUsername() +
                '}';
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setOrderLine(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Address getAddress() {
        return address;
    }

    public List<OrderLine> getOrderLine() {
        return orderLines;
    }

    public long getTotal() {
        return total;
    }

    public int getCustomerId() {
        return customerId;
    }
}
