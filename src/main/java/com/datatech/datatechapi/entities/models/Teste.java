package com.datatech.datatechapi.entities.models;

import com.datatech.datatechapi.dao.GradeDao;

import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        GradeDao gradeDao = new GradeDao();
        List<Grade> grades = new ArrayList<>();

        grades = gradeDao.buscarPorProfessor("Adriana Jacinto", "Banco de DAdos I");
        for (Grade grade : grades) {
            System.out.println(grade);
        }
    }
}
