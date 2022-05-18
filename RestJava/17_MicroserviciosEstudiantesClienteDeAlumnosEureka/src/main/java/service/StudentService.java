package service;

import java.util.List;

import modelo.Student;

public interface StudentService {
	
	void altaStudent(Student student);
	List<Student> studentPorPuntuacionMinima(double puntuacion);
}
