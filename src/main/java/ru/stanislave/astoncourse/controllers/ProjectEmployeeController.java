package ru.stanislave.astoncourse.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stanislave.astoncourse.factory.ProjectEmployeeFactory;
import ru.stanislave.astoncourse.factory.RsFactory;
import ru.stanislave.astoncourse.models.ProjectEmployee;


@RestController
@RequestMapping("/project-employee")
public class ProjectEmployeeController extends CrudController<ProjectEmployee> {

    @Override
    protected String queryGetById(int id) {
        return String.format("SELECT employee_id, project_id FROM project_employee WHERE id = %d", id);
    }

    @Override
    protected String queryGetAll() {
        return "SELECT employee_id, project_id FROM project_employee";
    }

    @Override
    protected String queryCreate(ProjectEmployee projectEmployee) {
        return String.format(
                "INSERT INTO project_employee (employee_id, project_id) VALUES (%d, %d)",
                projectEmployee.getEmployeeId(),
                projectEmployee.getProjectId()
        );
    }

    @Override
    protected String queryUpdate(ProjectEmployee projectEmployee) {
        return String.format(
                "UPDATE project_employee SET employee_id = %d, project_id = %d WHERE id = %d",
                projectEmployee.getEmployeeId(),
                projectEmployee.getProjectId(),
                projectEmployee.getId()
        );
    }

    @Override
    protected String queryDelete(int id) {
        return String.format("DELETE FROM project_employee WHERE id = %d", id);
    }

    @Override
    protected String queryClear() {
        return "DELETE FROM project_employee";
    }

    @Override
    protected RsFactory createModelFactory() {
        return new ProjectEmployeeFactory();
    }
}
