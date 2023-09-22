package com.school_z46.parallelStreams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.school_z46.parallelStreams.model.Avatar;
import com.school_z46.parallelStreams.model.Student;

import java.util.Optional;


@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findByStudent(Student student);
}
