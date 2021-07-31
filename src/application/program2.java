package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}

		System.out.println("-----------------------------------------------------");

		Department dep = departmentDao.findById(1);
		System.out.println(dep);

		System.out.println("-----------------------------------------------------");
		System.out.print("Entre com o ID a ser excluido ");
		int n = sc.nextInt();
		departmentDao.deleteById(n);
		System.out.println("Id excluido ");

		System.out.println("-----------------------------------------------------");

		Department newDepartment = new Department(null, "teste");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted " + newDepartment.getId());

		System.out.println("-----------------------------------------------------");
		newDepartment = new Department(5, "Casa");
		departmentDao.update(newDepartment);
		sc.close();
		System.out.println("Alterado " + newDepartment.getId() + newDepartment.getName());

	}

}
