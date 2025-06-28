package wayfair.ordermanagement;

public class Order implements IOrder{
    String name;
    Double unitPrice;
    int quantity;
    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public void setUnitPrice(Double unitPrice)
    {
        this.unitPrice=unitPrice;
    }
    public Double getUnitPrice()
    {
        return this.unitPrice;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }
}
