package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner tec = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("-----------------------------------------------");

		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("-----------------------------------------------");
		List<Seller> list02 = sellerDao.findAll();
		for (Seller obj02 : list02) {
			System.out.println(obj02);
		}

		System.out.println("-----------------------------------------------");
		Seller newSeller = new Seller(null, "Gustavo", "Gustavo@gmail", new Date(), 10000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted " + newSeller.getId());

		System.out.println("-----------------------------------------------");
		seller = sellerDao.findById(1);
		seller.setName("João");
		sellerDao.update(seller);
		System.out.println("Completed");

		System.out.println("-----------------------------------------------");
		System.out.print("Entre com o ID ");
		int id = tec.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Completed");

		tec.close();
	}

}
