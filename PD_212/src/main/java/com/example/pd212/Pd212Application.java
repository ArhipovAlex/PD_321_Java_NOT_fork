package com.example.pd212;

import com.example.pd212.entity.Discipline;
import com.example.pd212.repository.DisciplineRepository;
import com.example.pd212.repository.TeacherRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Pd212Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Pd212Application.class, args);
        TeacherRepository teacherRepository = context.getBean(TeacherRepository.class);
        DisciplineRepository disciplineRepository = context.getBean(DisciplineRepository.class);
        teacherRepository.findAll().forEach(System.out::println);
        System.out.println(teacherRepository.findById(3));

        for(Discipline discipline : teacherRepository.findById(3).get().getDisciplines()) {
            System.out.println(discipline);
        }
    }

}
