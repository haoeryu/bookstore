package com.bookstore.springtest.entity;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;


@Document(collection="customerIcon")
public class CustomerIcon {
    @Id
    private Integer _id;

    @Field("customerIcon")
    private String customerIcon;

    public CustomerIcon(int _id, String customerIcon) {
        this._id = _id;
        this.customerIcon = customerIcon;
    }

    public String getCustomerIcon() {
        return customerIcon;
    }
    public void setCustomerIcon(String customerIcon) {
        this.customerIcon = customerIcon;
    }

}
