package coding;

import java.util.*;

class Student {
	int id;
	float cgpa;
	String name;

	public Student(int id, float cgpa, String name) {

		this.id = id;
		this.cgpa = cgpa;
		this.name = name;
	}
}

public class PriorityServe {

	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<>(

				(a, b) -> {
					if (Float.compare(a.cgpa, b.cgpa) != 0) {
						return Float.compare(b.cgpa, a.cgpa);
					} else if (!a.name.equals(b.name)) {
						return a.name.compareTo(b.name);
					} else {
						return Integer.compare(a.id, b.id);
					}
				}

		);

		Scanner sc = new Scanner(System.in);
		System.out.println("enter no of evens:");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("enter event:");
			String event = sc.next();
			if (event.equals("SERVED")) {
				if (!pq.isEmpty())
					pq.poll();
			} else if (event.equals("ENTER")) {
				System.out.println("enter name:");
				String name = sc.next();

				System.out.println("enter cgpa:");
				float cgpa = sc.nextFloat();

				System.out.println("enter id:");
				int id = sc.nextInt();
				pq.offer(new Student(id, cgpa, name));
			} else {
				System.out.println("invalid");
			}
		}

		if (pq.isEmpty()) {
			System.out.println("---");
		} else {
			while (!pq.isEmpty()) {
				System.out.println(pq.poll().name);
			}
		}

	}

}

/*
 * CONSOLE OUTPUT:
 * 
 * enter no of evens: 12
 * enter event: ENTER
 * enter name: JAN
 * enter cgpa: 3.7
 * enter id: 50 
 * enter event: ENTER
 * enter name: MARK 
 * enter cgpa: 3.8 
 * enter id: 24
 * enter event: ENTER 
 * enter name: SHAFI 
 * enter cgpa: 3.7 
 * enter id: 35
 * enter event: SERVED 
 * enter event: SERVED 
 * enter event: ENTER 
 * enter name: SAMIYA
 * enter cgpa: 3.85
 * enter id: 36
 * enter event: SERVED 
 * enter event: ENTER
 * enter name: HASHLEY
 * enter cgpa: 3.9 
 * enter id: 42 
 * enter event: ENTER
 * enter name: MARIA
 * enter cgpa: 3.6 
 * enter id: 46 
 * enter event: ENTER 
 * enter name: ANIK 
 * enter cgpa: 3.95 
 * enter id: 49 
 * enter event: ENTER 
 * enter name: DAN 
 * enter cgpa: 3.95 
 * enter id: 50 
 * enter event: SERVED
 * DAN HASHLEY SHAFI MARIA
 * 
 * 
 * 
 * 
 * 
 */