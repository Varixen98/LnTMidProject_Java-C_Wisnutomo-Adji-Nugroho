package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	public Main() {
		ArrayList<Karyawan> listKaryawan = new ArrayList<Karyawan>();
		Scanner scan = new Scanner(System.in);
		
		int manager_count = 0, supervisor_count = 0, admin_count = 0;
		//Things to do :
		//1. add bonus salary
		//2. input 0 during menu 3
		//3. check code employee sudah dipakai atau belum
		//4.
		int menu;
		char choice;
		do {
			System.out.println("=====================================");
			System.out.println("|         Employee Manager          |");
			System.out.println("=====================================");
			System.out.println("1. Add new employee");
			System.out.println("2. View all employee");
			System.out.println("3. Update employee data");
			System.out.println("4. Delete employee data");
			System.out.println("5. Exit");
			System.out.print("--> ");
			menu = scan.nextInt();
			scan.nextLine();
			
			switch(menu) {
			case 1 : {
				System.out.println("Add employee section : ");
					
				//input employee code
				String idCode;
				boolean isUnique = true;
				do {
						
					System.out.print("Input employee's Id code format[AA-XXXX] : ");
					idCode = scan.nextLine();
						
					if(idCode.length() != 7 ||!idCode.contains("-")) {
						System.out.println("Invalid id code!\nPlease refrain to the given prompt!");
						isUnique = false;
							
					}else{
						isUnique = true;
					}
						
					for(int m = 0; m < listKaryawan.size(); m++) {
						if(listKaryawan.get(m).getIdCode().equals(idCode)) {
							System.out.println(listKaryawan.get(m).getIdCode() + " the id code is already taken!");
							isUnique = false;
							break;
						}
					}
				}while(!isUnique);
					
				//input employee name
				String name;
				do {
					System.out.print("Input employee's name [>= 3] : ");
					name = scan.nextLine();
				}while(name.length() < 3);
					
				//input employee gender
				String gender;
				do {
					System.out.print("Input employee's gender [Laki-Laki | Perempuan] (Case Sensitive) : ");
					gender = scan.nextLine();
					if(gender.equals("Laki-Laki")) {
						break;
					}else if(gender.equals("Perempuan")) {
						break;
					}
				}while(true);
					
				//input employee position
				//also assign employee salary based on the their position
				String position;
				int salary = 0;
				do {
				System.out.print("Input employees position [Manager | Supervisor | Admin] (Case Sensitive) : ");
				position = scan.nextLine();
				
				if(position.equals("Manager")) {
					salary = 8000000;
					manager_count++;
					break;
				}else if(position.equals("Supervisor")) {
					salary = 6000000;
					supervisor_count++;
					break;
				}else if(position.equals("Admin")) {
					salary = 4000000;
					admin_count++;
					break;
				}
				}while(true);
					
				//Adding new employee to the arraylist
				Karyawan karyawan = new Karyawan(idCode, name, gender, position, salary);
				listKaryawan.add(karyawan);
					
				//Confirmation for adding a new employee
				System.out.println("New employee with ID : " + idCode + "\nis successfully added to the database!");
					
					
				//adding bonus to other employee if there are 3 employee with the same position
				//are already working in the company!
				int bonus = 0;
				if((manager_count - 1) % 3 == 0 && (manager_count - 1 != 0)) { 
					System.out.print("Bonus sebesar 10% telah diberikan kepada employee dengan kode ");
					for(int c = 0; c < listKaryawan.size() - 1; c++) {
						if(listKaryawan.get(c).getPosition().equals("Manager")) {
							bonus =  (int)(listKaryawan.get(c).getSalary() * 0.1 + listKaryawan.get(c).getSalary());
							listKaryawan.get(c).setSalary(bonus);
							System.out.print(listKaryawan.get(c).getIdCode() + ", ");
						}
					}
					System.out.println("");
					
				}else if((supervisor_count - 1) % 3 == 0 && (supervisor_count - 1 != 0)) {
					for(int c = 0; c < listKaryawan.size() - 1; c++) {
						if(listKaryawan.get(c).getPosition().equals("Supervisor")) {
							bonus = (int)(listKaryawan.get(c).getSalary() * 0.075 + listKaryawan.get(c).getSalary());
							listKaryawan.get(c).setSalary(bonus);
							System.out.print(listKaryawan.get(c).getIdCode() + ", ");
						}
					}
					System.out.println("");
					
				}else if((admin_count - 1) % 3 == 0 && (admin_count - 1 != 0)) {
					for(int c = 0; c < listKaryawan.size() - 1; c++) {
						if(listKaryawan.get(c).getPosition().equals("Admin")) {
							bonus = (int)(listKaryawan.get(c).getSalary() * 0.05 + listKaryawan.get(c).getSalary());
							listKaryawan.get(c).setSalary(bonus);
							System.out.print(listKaryawan.get(c).getIdCode() + ", ");
						}
					}
					System.out.println("");
				}
					
				//Sort the array list
				Collections.sort(listKaryawan, Comparator.comparing(Karyawan::getName));
				
				break;
			}
			case 2 : {
				
				//Displaying data
				System.out.println("Displaying all employee data : ");
				System.out.println("|----|-----------------|-------------------------------|----------------|-----------------|------------------|");
				System.out.println("|No  |Employee' Code   |Employee's Name                |Gender          |Position         |Salary            |");
				System.out.println("|----|-----------------|-------------------------------|----------------|-----------------|------------------|");
				int i = 0;
				for(Karyawan karyawan : listKaryawan) {
					System.out.printf("|%4d", i+1);
					karyawan.selfIntro();
					i++;
				}
				System.out.println("|----|-----------------|-------------------------------|----------------|-----------------|------------------|");
				break;
			}
			case 3 : {
				
				//Update employee data
				System.out.println("Displaying all employee data : ");
				System.out.println("|----|-----------------|-------------------------------|----------------|-----------------|------------------|");
				System.out.println("|No  |Employee' Code   |Employee's Name                |Gender          |Position         |Salary            |");
				System.out.println("|----|-----------------|-------------------------------|----------------|-----------------|------------------|");
				int i = 0;
				for(Karyawan karyawan : listKaryawan) {
					System.out.printf("|%4d", i+1);
					karyawan.selfIntro();
					i++;
				}
				System.out.println("|----|-----------------|-------------------------------|----------------|-----------------|------------------|");
				
				//asking the entry number
				int num;
				System.out.print("Input the entry number that you want to update : ");
				num = scan.nextInt();
				scan.nextLine();
			
				//asking the employee's code
				String newIdCode;
				boolean codeUnique = true;
				do {
					System.out.print("Input employee's code [AX-XXXX] : ");
					newIdCode = scan.nextLine();
					
					if(newIdCode.equals("0")) {
						newIdCode = listKaryawan.get(num - 1).getIdCode();
						break;
					}
					
					
					if(newIdCode.length() != 7 || !newIdCode.contains("-")) {
						System.out.println("Invalid code format!\nPlease refrain to prompt for the correct format!");
						codeUnique = false;
					}else {
						codeUnique = true;
					}
					
					for(int b = 0; b < listKaryawan.size(); b++) {
						if(listKaryawan.get(b).getIdCode().equals(newIdCode)) {
							System.out.println(listKaryawan.get(b).getIdCode() + " is already taken!");
							codeUnique = false;
							break;
						}
					}
					
				}while(!codeUnique);
				
				//asking employee name
				String newName;
				do {
				System.out.print("Input employee's name [>= 3] :  ");
				newName = scan.nextLine();
				if(newName.equals("0")) {
					newName = listKaryawan.get(num - 1).getName();
					break;
				}
				}while(newName.length() < 3);
				
				//asking the employee gender
				String newGender;
				do {
					System.out.print("Input employee's gender [Laki-Laki | Perempuan] (Case Sensitive) : ");
					newGender = scan.nextLine();
					if(newGender.equals("0")) {
						newGender = listKaryawan.get(num - 1).getGender();
						break;
					}else if(newGender.equals("Laki-Laki")) {
						break;
					}else if(newGender.equals("Perempuan")) {
						break;
					}
				}while(true);
				
				//asking the employee position
				System.out.print("Input employee's position [Manager | Supervisor | Admin] (Case Sensitive) : ");
				String newPosition = scan.nextLine();
				int newSalary = 0;
				if(newPosition.equals("Manager")) {
					newSalary = 8000000;
					
				}else if(newPosition.equals("Supervisor")) {
					newSalary = 6000000;
	
				}else if(newPosition.equals("Admin")) {
					newSalary = 4000000;
					
				}else if(newPosition.equals("0")) {
					newPosition = listKaryawan.get(num - 1).getPosition();
					newSalary = listKaryawan.get(num - 1).getSalary();
					
				}
				
				Karyawan newKaryawan = new Karyawan(newIdCode, newName, newGender, newPosition, newSalary);
				listKaryawan.set(num - 1, newKaryawan);
				
				//sort the updated array list
				Collections.sort(listKaryawan, Comparator.comparing(Karyawan::getName));
				break;
				
			}
			case 4 : {
				
				//delete employee data from the program
				System.out.println("Displaying all employee data : ");
				System.out.println("|----|-----------------|-------------------------------|----------------|-----------------|------------------|");
				System.out.println("|No  |Employee' Code   |Employee's Name                |Gender          |Position         |Salary            |");
				System.out.println("|----|-----------------|-------------------------------|----------------|-----------------|------------------|");
				int i = 0;
				for(Karyawan karyawan : listKaryawan) {
					System.out.printf("|%4d", i+1);
					karyawan.selfIntro();
					i++;
				}
				System.out.println("|----|-----------------|-------------------------------|----------------|-----------------|------------------|");
				int num;
				System.out.print("Input the entry number that you want to delete : ");
				num = scan.nextInt();
				scan.nextLine();
				
				//confirmation
				System.out.println("Employee with ID code " + listKaryawan.get(num - 1).getIdCode() + " is successfully deleted from the database");
				listKaryawan.remove(num - 1);
				break;
			}
			case 5 : {
				
				//Exit program
				System.out.println("Exit program!");
				System.exit(0);
				break;
			}
			}
			
			System.out.println("Return to main menu?(Y/N) : ");
			System.out.print("--> ");
			choice = scan.next().charAt(0);
			scan.nextLine();
			if(choice == 'N' || choice == 'n') {
				System.out.println("Exit program!");
				System.exit(0);
			}
		}while(menu < 1 || menu > 4 || choice == 'y' || choice == 'Y');
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
