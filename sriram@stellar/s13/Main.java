import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int y=sc.nextInt();
		int given_year=1900;
		int ry=0;
		int ly=0;
			
		y=(y-1)-given_year;//(2014-1)-1900=>123
		ly=y/4;//=>123/4=>30
		ry=y-ly;//123-30=>93
		int totalDays=(ry*365)+(ly*366)+1;
		int day=totalDays%7;
		if (day==0)
			System.out.println("Monday");
		else if (day==1)
			System.out.println ("Tuesday");
		else if(day==2)
			System.out.println("Wednesday");
		else if (day==3)
			System.out.println("Thursday");
		else if(day==4)
			System.out.println("Friday");
		else if(day==5)
			System.out.println("Saturday");
		else if(day==6)
			System.out.println("Sunday");
		else
			System.out.println("Wrong Input");

	}

}
