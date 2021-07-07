package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	//ASSOCIAÇÕES
	private Departament departament; //Associação um para um
	private List <HourContract> contracts = new ArrayList<>(); // Associacao um para muitos
	
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	/*NÃO PODEMOS TER UM SET PARA UMA LIST NESTE CASO
	public void setContracts(List<HourContract> contracts) {
		this.contracts = contracts;
	}*/
	
	//CRIANDO OS METODOS
	
	
	
	
	public void addContract(HourContract contract) {
		contracts.add(contract);		
	}
	public void removeContract(HourContract contract) {
		contracts.remove(contract);	
	}
	public Double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {		
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();				
			}			
		}
		return sum;
	}		
}


		
		
		
	

