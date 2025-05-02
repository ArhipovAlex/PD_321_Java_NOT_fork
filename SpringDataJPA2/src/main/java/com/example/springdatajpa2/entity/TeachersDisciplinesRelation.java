package com.example.springdatajpa2.entity;

import jakarta.persistence.*;

@Entity
public class TeachersDisciplinesRelation {
    @EmbeddedId
    private com.example.springdatajpa2.entity.TeachersDisciplinesRelationId id;

    @MapsId("teacher")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher", nullable = false)
    private com.example.springdatajpa2.entity.Teacher teacher;

    @MapsId("discipline")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "discipline", nullable = false)
    private com.example.springdatajpa2.entity.Discipline discipline;

    public com.example.springdatajpa2.entity.TeachersDisciplinesRelationId getId() {
        return id;
    }

    public void setId(com.example.springdatajpa2.entity.TeachersDisciplinesRelationId id) {
        this.id = id;
    }

    public com.example.springdatajpa2.entity.Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(com.example.springdatajpa2.entity.Teacher teacher) {
        this.teacher = teacher;
    }

    public com.example.springdatajpa2.entity.Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(com.example.springdatajpa2.entity.Discipline discipline) {
        this.discipline = discipline;
    }

}