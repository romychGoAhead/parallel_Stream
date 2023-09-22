package com.school_z46.parallelStreams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school_z46.parallelStreams.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByAge(Integer age);

    List<Student> findAllByAgeBetween(int min, int max);

    @Query(value = "select count(*) from student", nativeQuery = true)
    Long countStudens();

    @Query(value = "select avg(age) from student", nativeQuery = true)
    double averageAge();

    @Query(value = "select * from student order by id desc quantity", nativeQuery = true)
        // сортируем в обратном порядке
    List<Student> findLastStudents(@Param("quantity") int n);


}