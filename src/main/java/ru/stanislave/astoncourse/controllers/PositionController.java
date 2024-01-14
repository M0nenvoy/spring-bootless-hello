package ru.stanislave.astoncourse.controllers;

import org.springframework.web.bind.annotation.*;
import ru.stanislave.astoncourse.factory.PositionRsFactory;
import ru.stanislave.astoncourse.factory.RsFactory;
import ru.stanislave.astoncourse.models.Position;


@RestController
@RequestMapping("/position")
public class PositionController extends CrudController<Position> {

    @Override
    protected String queryGetById(int id) {
        return String.format("SELECT title, salary FROM position WHERE id = %d", id);
    }

    @Override
    protected String queryGetAll() {
        return "SELECT title, salary FROM position";
    }

    @Override
    protected String queryCreate(Position position) {
        return String.format("INSERT INTO position (title, salary) VALUES ('%s', %d)", position.getTitle(), position.getSalary());
    }

    @Override
    protected String queryUpdate(Position position) {
        return String.format("UPDATE position SET title = '%s', salary = %d WHERE id = %d", position.getTitle(), position.getSalary(), position.getId());
    }

    @Override
    protected String queryDelete(int id) {
        return String.format("DELETE FROM position WHERE id = %d", id);
    }

    @Override
    protected String queryClear() {
        return "DELETE FROM position";
    }

    @Override
    protected RsFactory createModelFactory() {
        return new PositionRsFactory();
    }
}
