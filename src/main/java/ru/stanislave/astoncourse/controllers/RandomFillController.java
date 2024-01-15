package ru.stanislave.astoncourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stanislave.astoncourse.DbUtil;
import ru.stanislave.astoncourse.models.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

@RestController
@RequestMapping("/random-fill")
public class RandomFillController {
    @Autowired
    private CustomerController customerController;
    @Autowired
    private PositionController positionController;
    @Autowired
    private EmployeeController employeeController;
    @Autowired
    private ProjectController projectController;

    @PostMapping
    public String fill(@RequestBody RandomFillInstruction instruction) {
        try (Connection con = DbUtil.connect()) {
            Random r = new Random();
            for (int i = 0; i < instruction.getCustomerNumber(); ++i) {
                int ri = r.nextInt(instruction.getCustomerNamePool().size());
                String name = instruction.getCustomerNamePool().get(ri);
                customerController.create(new Customer(0, name));
            }

            for (int i = 0; i < instruction.getPositionNumber(); ++i) {
                int ri = r.nextInt(instruction.getPositionNamePool().size());
                String name = instruction.getPositionNamePool().get(ri);
                int salary = r.nextInt(instruction.getPositionMaxSalary());
                positionController.create(new Position(0, name, salary));
            }

            for (int i = 0; i < instruction.getEmployeeNumber(); ++i) {
                int ri = r.nextInt(instruction.getEmployeeNamePool().size());
                String name = instruction.getEmployeeNamePool().get(ri);
                int position = r.nextInt(instruction.getPositionNumber());
                employeeController.create(new Employee(0, position, name));
            }

            for (int i = 0; i < instruction.getProjectNumber(); ++i) {
                int ri = r.nextInt(instruction.getProjectNamePool().size());
                String name = instruction.getProjectNamePool().get(ri);
                Date deadline = Date.valueOf(LocalDate.now().plusDays(r.nextInt(instruction.getProjectMaxDaysSinceDeadline())));
                projectController.create(new Project(0, name, deadline));
            }
            return "ok";
        } catch (SQLException e) {
            return "An error has occurred: " + e.getMessage();
        }
    }
}
