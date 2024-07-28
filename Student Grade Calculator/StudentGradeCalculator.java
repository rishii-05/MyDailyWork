import java.util.Scanner;
public class StudentGradeCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter the number of subjects: ");
		int n = scanner.nextInt();
		int tot = 0;
		for (int i = 1; i <= n; i++) {
			System.out.print("Enter marks obtained in subject " + i + ": ");
			int marks = scanner.nextInt();
			tot += marks;
		}
		double avg = (double) tot / (n * 100) * 100;
		char grade;
		if (avg >= 90) {
			grade = 'A';
		} else if (avg >= 80) {
			grade = 'B';
		} else if (avg >= 70) {
			grade = 'C';
		} else if (avg >= 60) {
			grade = 'D';
		} else if (avg >= 50) {
			grade = 'E';
		} else {
			grade = 'F';
		}
		System.out.println("-------------------------------------");
		System.out.println("Total Marks: " + tot);
		System.out.println("Average Percentage: " + avg + "%");
		System.out.println("Grade: " + grade);
		if(avg >= 50){
			System.out.println("Status : Pass");
		} else {
			System.out.println("Status : Fail");
		}
		scanner.close();
	}
}