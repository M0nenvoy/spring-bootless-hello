package ru.stanislave.astoncourse.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stanislave.astoncourse.factory.EmployeeRsFactory;
import ru.stanislave.astoncourse.factory.RsFactory;
import ru.stanislave.astoncourse.models.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends CrudController<Employee> {
    @Override
    protected String queryGetById(int id) {
        return String.format("SELECT id, name, position_id FROM employee WHERE id = %d", id);
    }

    @Override
    protected String queryGetAll() {
        return "SELECT id, name, position_id FROM employee";
    }

    @Override
    protected String queryCreate(Employee employee) {
        return String.format("INSERT INTO employee (name, position_id) VALUES ('%s', %d)", employee.getName(), employee.getPositionId());
    }

    @Override
    protected String queryUpdate(Employee employee) {
        return String.format("UPDATE employee SET name = '%s', position_id = %d WHERE id = %d", employee.getName(), employee.getPositionId(), employee.getId());
    }

    @Override
    protected String queryDelete(int id) {
        return String.format("DELETE FROM employee WHERE id = %d", id);
    }

    @Override
    protected String queryClear() {
        return "DELETE FROM employee";
    }

    @Override
    protected RsFactory createModelFactory() {
        return new EmployeeRsFactory();
    }
}
