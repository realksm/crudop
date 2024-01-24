package com.lect09.crudop;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {
    private static Integer count = 1;
    private final HashMap<Integer, Employee> db = new HashMap<>();

    @PostMapping("/createEmployee")
    public String createEmployee(@RequestBody Employee emp) {
        emp.setId(count++);
        db.put(emp.getId(), emp);
        return "we have " + (count - 1) + " employees";
    }

    @GetMapping("/employees")
    public Employee getEmployeeById(@RequestParam Integer id) {
        return db.getOrDefault(id, new Employee());
    }

    @GetMapping("/employees/get")
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(db.values());
    }

    @PutMapping("/update/{empId}")
    public Employee updateEmployee(@PathVariable Integer empId, @RequestBody Employee emp) {
        if(!db.containsKey(empId)) {
            return new Employee();
        }
        Employee updateEmp = db.get(empId);
        if(emp.getName() != null) updateEmp.setName(emp.getName());
        if(emp.getAge() != null) updateEmp.setAge(emp.getAge());
        if(emp.getDesignation() != null) updateEmp.setDesignation(emp.getDesignation());
        if(emp.getGender() != null) updateEmp.setGender(emp.getGender());
        db.put(empId, updateEmp);
        return db.get(empId);
    }

    @DeleteMapping("/delete/{empId}")
    public Employee deleteEmployee(@PathVariable Integer empId) {
        if(db.containsKey(empId)) {
            return db.remove(empId);
        }
        return new Employee();
    }
}