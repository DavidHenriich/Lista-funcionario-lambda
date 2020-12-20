package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();
		
		System.out.print("Quantos funcionarios serão registrados: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("\nFuncionario #" + (i+1));
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while(hasId(list, id)) {
				System.out.print("Este id ja existe! \nTente Novamente: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
		}
		
		System.out.print("\nEntre com o Id do funcionario a ter aumento de salario: ");
		int idsal = sc.nextInt();
		
		Employee emp = list.stream().filter(x -> x.getId() == idsal).findFirst().orElse(null);
		
		if(emp == null) {
			System.out.println("Esse id não existe");
		}
		else {
			System.out.print("Qual a porcentagem: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		System.out.println("\nLista de funcionarios: ");
		for(Employee e : list) {
			System.out.println(e);
		}
				
		sc.close();
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
	
}
