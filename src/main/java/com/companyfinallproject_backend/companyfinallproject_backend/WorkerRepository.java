package com.companyfinallproject_backend.companyfinallproject_backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WorkerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Worker> getAll() {
        List<Worker> query = jdbcTemplate.query("SELECT id, name, secondname, position FROM worker",
                BeanPropertyRowMapper.newInstance(Worker.class));

        return query;
    }

    public Worker getById(int id) {
        return jdbcTemplate.queryForObject("SELECT id,name,secondname, position FROM worker WHERE " + "id = ?",
                BeanPropertyRowMapper.newInstance(Worker.class), id);

    }

    public int save(List<Worker> workers) {
        workers.forEach(worker -> jdbcTemplate.update("INSERT INTO worker(name, secondname, position) VALUES (?, ? ,?)",
                worker.getName(), worker.getSecondname(), worker.getPosition()));

        return 1;
    }

    public int update(Worker worker) {
        return jdbcTemplate.update("UPDATE worker SET name=?, secondname = ?, position = ? WHERE id = ?",
                worker.getName(), worker.getSecondname(), worker.getPosition());
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM worker WHERE id = ?", id);
    }
}
