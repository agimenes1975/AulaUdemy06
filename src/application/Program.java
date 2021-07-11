package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);			
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter departament's name: ");
		String DepartmentName = sc.nextLine();
		System.out.println("");
		System.out.println("Enter worker data");
		System.out.print("Name...: ");
		String WorkerName = sc.nextLine();
		System.out.print("Level...: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary...: ");
		Double BaseSalary = sc.nextDouble();
		Worker worker = new Worker(WorkerName, WorkerLevel.valueOf(workerLevel), BaseSalary, new Department(DepartmentName));
		System.out.println("");
		System.out.print("How many contracts to this worker?...: ");
		
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract number #" + i +" data");
			System.out.print("Date DD/MM/YYYY...: ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour... ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours)...: ");
			int hours = sc.nextInt();			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract); // aqui é criado a associação do contrato.	
		}
		System.out.println("");
		System.out.print("Enter month and year to calculate income (MM/YYYY)...: ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2)); // estamos pegando parte do mes
		int year = Integer.parseInt(monthAndYear.substring(3)); // estamos pegando parte do ano
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: "+ worker.getDepartament().getName());
		System.out.println("Income for " + monthAndYear + ": "+ String.format("%.2f", worker.income(year, month)));
				
		sc.close();

	}

}
