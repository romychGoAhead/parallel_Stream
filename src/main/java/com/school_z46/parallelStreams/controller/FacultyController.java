package com.school_z46.parallelStreams.controller;

import org.springframework.web.bind.annotation.*;
import com.school_z46.parallelStreams.exception.StudentNotFoundException;
import com.school_z46.parallelStreams.model.Faculty;
import com.school_z46.parallelStreams.model.Student;
import com.school_z46.parallelStreams.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService; // подключаем сервис

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/{id}")
    public Faculty getById(@PathVariable("id") Long id) {
        return facultyService.getById(id);
    }
    @PostMapping
    public Faculty create(@RequestBody Faculty faculty) {          // @RequestBody-  тело запроса
        return facultyService.create(faculty);
    }

    @PutMapping("/{id}")
    public Faculty update(@PathVariable("id") Long id, @RequestBody Faculty faculty) {
        return facultyService.update(id, faculty);
    }
    @DeleteMapping("/{id}")
    public Faculty remove (@PathVariable ("id")Long id) {
        return facultyService.remove(id);
    }
    @GetMapping
    public Collection<Faculty> getAll() {
        return facultyService.getAll();
    }

    @GetMapping("/filtered")
    public Collection<Faculty> getByColor (@RequestParam ("color") String color){
        return  facultyService.getByColor(color);
    }

    @GetMapping("/by-color-or-name")
    public Collection<Faculty> filteredByColorOrName (@RequestParam String colorOrName){ // мы передаем параметр
        return  facultyService.getAllByNameOrColor(colorOrName,colorOrName); // эти параметры мы передаем в оба места и в имя и цвет, т.к парамет поиска у нас и мя и цвет
    }

    @GetMapping("/by-student")
    public Faculty getByStudent(@RequestParam Long studentId){ // передаем студента
        return  facultyService.getByStudentId(studentId);
    }

    @GetMapping("/stream/longest-name/")
    public String getLongestName(){
        return facultyService.getLongestName();
    }
}