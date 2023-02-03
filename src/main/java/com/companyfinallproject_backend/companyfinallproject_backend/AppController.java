package com.companyfinallproject_backend.companyfinallproject_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class AppController {

    @Autowired
    WorkerRepository workerRepository;

    @GetMapping("/test")
    public int test() {
        return 1;
    }

    @GetMapping("")
    public List<Worker> getAll() {
        return workerRepository.getAll();
    }

    @GetMapping("/{id}")
    public Worker getById(@PathVariable("id") int id) {
        return workerRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Worker> worker) {
        return workerRepository.save(worker);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Worker updatedWorker) {
        Worker worker = workerRepository.getById(id);

        if (worker != null) {
            worker.setName(updatedWorker.getName());
            worker.setSecondname(updatedWorker.getSecondname());
            worker.setPosition(updatedWorker.getPosition());

            workerRepository.update(worker);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partUpdate(@PathVariable("id") int id, @RequestBody Worker updatedWorker) {
        Worker worker = workerRepository.getById(id);

        if (worker != null) {
            if (updatedWorker.getName() != null)
                worker.setName(updatedWorker.getName());
            if (updatedWorker.getSecondname() != null)
                worker.setSecondname(updatedWorker.getSecondname());
            if (updatedWorker.getPosition() != null)
                worker.setPosition(updatedWorker.getPosition());

            workerRepository.update(worker);

            return 1;

        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) {
        return workerRepository.delete(id);
    }

}
