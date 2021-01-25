package Program;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	private Vector<Employee> listEmployee = new Vector<Employee>();
	public static Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	public Main() {
		mainMenu();
	}
	
	private void mainMenu() {
		int menu = 0;

		do {
			System.out.println("1. Insert Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.println("5. Exit");
			
			menu = scan.nextInt(); scan.nextLine();
			
			switch (menu) {
			case 1: {
				insert();
				break;
			}
			case 2: {
				view();
				break;
			}
			
			case 3: {
				update();
				break;
			}
			case 4: {
				remove();
				break;
			}
			case 5: {
				
				break;
			}
		}
		} while (menu != 5);
		
	}
	private void insert() {
		String nama, gender, jab, id;
		int counter = 0;
		do {
			System.out.println("Input nama karyawan [>=3]:");
			nama = scan.nextLine();			
		} while (nama.length() < 3);
		
		do {
			System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive):");
			gender = scan.nextLine();			
		} while (!gender.equals("Laki-laki")&&!gender.equals("Perempuan"));
		
		do {
			System.out.println("Input Jabatan [Manager | Supervisor | Admin] (Case Sensitive):");
			jab = scan.nextLine();			
		} while (!jab.equals("Manager") && !jab.equals("Supervisor") && !jab.equals("Admin"));

		
		id = "";
		
		for (int i = 0; i < 2; i++) {
			id += (char)(rand.nextInt(26)+'A');
		}
		id += '-';
		for (int i = 0; i < 4; i++) {
			id += rand.nextInt(10)+1;
		}
		System.out.println("Berhasil menambahkan karyawan dengan id "+ id);	
		if(jab.equals("Manager")) {
	
			for (Employee employee : listEmployee) {

				if (employee instanceof Manager) {
					if(counter == 0) {
						System.out.printf("Bonus sebesar 10%% telah diberikan kepada karyawan dengan id %s", employee.getKode());
						counter++;
					}
					
					else if(counter > 0) {
						System.out.printf(", %s", employee.getKode());
						counter++;
					}
					employee.setGaji(employee.getGaji() + (employee.getGaji() * 10 / 100));
				}
			}
			System.out.printf("\n");	
			
			int gaji = 8000000;
			listEmployee.add(new Manager(id, nama, gender, gaji));
				
		}
		else if(jab.equals("Supervisor")) {
			
			for (Employee employee : listEmployee) {

				if (employee instanceof Supervisor) {
					if(counter == 0) {
						System.out.printf("Bonus sebesar 7.5%% telah diberikan kepada karyawan dengan id %s", employee.getKode());
						counter++;
					}
					
					else if(counter > 0) {
						System.out.printf(", %s", employee.getKode());
						counter++;
					}
					employee.setGaji(employee.getGaji() + (employee.getGaji() * 75 / 1000));
				}
			}
			System.out.printf("\n");	
			
			int gaji = 6000000;
			listEmployee.add(new Supervisor(id, nama, gender, gaji));
				
		}
		else if(jab.equals("Admin")) {
			
			for (Employee employee : listEmployee) {

				if (employee instanceof Admin) {
					if(counter == 0) {
						System.out.printf("Bonus sebesar 10%% telah diberikan kepada karyawan dengan id %s", employee.getKode());
						counter++;
					}
					
					else if(counter > 0) {
						System.out.printf(", %s", employee.getKode());
						counter++;
					}
					employee.setGaji(employee.getGaji() + (employee.getGaji() * 5 / 100));
				}
			}
			System.out.printf("\n");	
			
			int gaji = 4000000;
			listEmployee.add(new Admin(id, nama, gender, gaji));
				
		}
	}
	
	private void view() {
		int counter = 0;
		listEmployee.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee arg0, Employee arg1) {
				// TODO Auto-generated method stub
				return arg0.nama.compareTo(arg1.nama);
			}
		});
		System.out.println("---------------------------------------------------------------------");
		System.out.println("|No |ID        |Nama                |Gender    |Jabatan   |Gaji      |");
		System.out.println("---------------------------------------------------------------------");
		for (Employee employee : listEmployee) {
			counter++;
			System.out.printf("|%3d|%10s|%20s|%10s|%10s|%10s|\n", counter, employee.getKode(), employee.getNama(), employee.getKelamin(), employee.getClass().getSimpleName(), employee.getGaji());
		}
		System.out.println("---------------------------------------------------------------------");
	}
	
	private void update() {
		int update;
		view();
		System.out.println("Employee index want to update:");
		update = scan.nextInt(); scan.nextLine();
		Employee a = listEmployee.get(update - 1);
		listEmployee.remove(a);
		insert();
	}
	
	private void remove() {
		int remove;
		view();
		System.out.println("Employee index want to remove:");
		remove = scan.nextInt(); scan.nextLine();
		Employee a = listEmployee.get(remove - 1);
		listEmployee.remove(a);		
	}
	public static void main(String[] args) {
		new Main();
	}

}
