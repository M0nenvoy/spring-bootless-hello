package ru.stanislave.astoncourse.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stanislave.astoncourse.factory.ProjectRsFactory;
import ru.stanislave.astoncourse.factory.RsFactory;
import ru.stanislave.astoncourse.models.Project;

@RestController
@RequestMapping("/project")
public class ProjectController extends CrudController<Project> {
    @Override
    protected String queryGetById(int id) {
        return String.format("SELECT id, name, deadline FROM project WHERE id = %d", id);
    }

    @Override
    protected String queryGetAll() {
        return "SELECT id, name, deadline FROM project";
    }

    @Override
    protected String queryCreate(Project project) {
        return String.format("INSERT INTO project (name, deadline) VALUES ('%s', '%s')", project.getName(), project.getDeadline().toString());
    }

    @Override
    protected String queryUpdate(Project project) {
        return String.format("UPDATE project SET name = '%s', deadline = '%s' WHERE id = %d", project.getName(), project.getDeadline().toString(), project.getId());
    }

    @Override
    protected String queryDelete(int id) {
        return String.format("DELETE FROM project WHERE id = %d", id);
    }

    @Override
    protected String queryClear() {
        return "DELETE FROM project";
    }

    @Override
    protected RsFactory createModelFactory() {
        return new ProjectRsFactory();
    }
}
