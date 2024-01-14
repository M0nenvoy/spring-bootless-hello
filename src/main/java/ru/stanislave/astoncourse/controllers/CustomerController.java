package ru.stanislave.astoncourse.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stanislave.astoncourse.factory.CustomerRsFactory;
import ru.stanislave.astoncourse.factory.RsFactory;
import ru.stanislave.astoncourse.models.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController extends CrudController<Customer> {
    @Override
    protected String queryGetById(int id) {
        return String.format("SELECT id, name FROM customer WHERE id = %d", id);
    }

    @Override
    protected String queryGetAll() {
        return "SELECT id, name FROM customer";
    }

    @Override
    protected String queryCreate(Customer customer) {
        return String.format("INSERT INTO customer (name) VALUES ('%s')", customer.getName());
    }

    @Override
    protected String queryUpdate(Customer customer) {
        return String.format("UPDATE customer SET name = '%s'", customer.getName());
    }

    @Override
    protected String queryDelete(int id) {
        return String.format("DELETE FROM customer WHERE id = %d", id);
    }

    @Override
    protected String queryClear() {
        return "DELETE FROM customer";
    }

    @Override
    protected RsFactory createModelFactory() {
        return new CustomerRsFactory();
    }
}
