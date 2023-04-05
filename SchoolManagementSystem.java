package SchoolManagementSystem;

import java.util.ArrayList;
import java.util.List;
/*
 * This School Management System Project is for Manage the School Fund
 * It managed How much School is earned or spend;
 * In this Project we used Aggregation,getters,setters,Collection Framework(ArrayList)
 */ class School 
{
    private List<Teacher>  teachers;
    private List<Student> students;
    private static int totalmoneyearned;
    private static int totalmoneyspend;
     
   public School(List<Teacher>  teachers,List<Student> students) 
   {
	   this.teachers=teachers;
	   this.students=students;
	   totalmoneyearned=0;
	   totalmoneyspend=0;
   }

public List<Teacher> getTeachers()
{
	return teachers;
}

public void addTeachers(Teacher teacher)
{
	teachers.add(teacher);
}

public List<Student> getStudents() 
{
	return students;
}

public void addStudents(Student student)
{
	students.add(student);
}

public int getTotalmoneyearned() 
{
	return totalmoneyearned;
}

public static void updateTotalmoneyearned(int moneyearned) 
{
	totalmoneyearned += moneyearned;
}

public int getTotalmoneyspend()
{
	return totalmoneyspend;
}

public  static void updatemoneyspend(int moneyspend)
{
	totalmoneyearned-=moneyspend;
} 
   
   
  
}
 class Teacher 
 /*
  * This class Keep record for Teacher salary
  */
{
   private int Teacherid;
   private String Teachername;
   private int Teachersalary;
   private String Teachersubject;
   private int Salaryearned;
   
   
   public Teacher(int Teacherid,String Teachername,int Teachersalary,String Teachersubject)
   {
	this.Teacherid=Teacherid;
	this.Teachername=Teachername;
	this.Teachersalary=Teachersalary;
	this.Teachersubject=Teachersubject;
	this.Salaryearned=0;
	
	
   }
   public int getTeacherid()
   {
   	return Teacherid;
   }


   public String getTeachername()
   {
   	return Teachername;
   }


   public int getTeachersalary() 
   {
   	return Teachersalary;
   }


   public String getTeachersubject()
   {
   	return Teachersubject;
   }
public void setTeachersalary(int Teachersalary)
{
	this.Teachersalary = Teachersalary;
}
public void receiveSalary(int Teachersalary)
{
	Salaryearned+=Teachersalary;
	School.updatemoneyspend(Teachersalary);
}
   
}

/**
 * 
 * Student class keep  record for Studentfees
 *
 */
 class Student
{
	private int studid;
	private String studname;
	private int studclass; 
	private int feespaid;
	private int  feesTotal;
	
	public Student(int studid,String studname,int studclass) 
	{
		this.feespaid=0;
		this.feesTotal=25000;
		this.studid=studid;
		this.studname=studname;
		this.studclass=studclass;
		
		
	}

	public void setStudclass(int studclass)
	
	{
		this.studclass = studclass;
	}

	public void payfees(int fees)
	{
		this.feespaid += fees;
		School.updateTotalmoneyearned(feespaid);
		
	}

	public int getStudid()
	{
		return studid;
	}

	public String getStudname()
	{
		return studname;
	}

	public int getStudclass() 
	{
		return studclass;
	}

	public int getFeespaid()
	{
		return feespaid;
	}

	public int getFeesTotal() 
	{
		return feesTotal;
	}
    public int getRemaingfees()
    {
    	return feesTotal-=feespaid;
    }
	
}

public class SchoolManagementSystem
{

	public static void main(String[] args)
	{
		Teacher Sudha=new Teacher(1, "Sudha", 25000, "CoreJava");
		Teacher Mohan=new Teacher(2, "Mohan", 30000, "Python");
		Teacher Sham=new Teacher(3, "Sham", 40000, "ASP.Net");
		
		List<Teacher> teacherList = new ArrayList<>();
		teacherList.add(Sudha);
		teacherList.add(Mohan);
		teacherList.add(Sham);
		
		Student Savi=new Student(101, "Savi", 6);
		Student Rihan=new Student(102, "Rihan", 7);
		Student Ved=new Student(103, "Ved", 4);
		
		List<Student> studentList=new ArrayList<>();
		studentList.add(Savi);
		studentList.add(Rihan);
		studentList.add(Ved);
		
		School SMS=new School(teacherList, studentList);
		
		System.out.println(".....SMS School has Earned the Fund .......");
		Savi.payfees(50000);
		System.out.println("Savi has Paidfees :"+Savi.getFeespaid());
		Rihan.payfees(60000);
		System.out.println("Rihan has Paidfees :"+Rihan.getFeespaid());
		Ved.payfees(45000);
		System.out.println("Ved has Paidfees : "+Ved.getFeespaid());
		System.out.println("______________________________________________________________");
		System.out.println("SMS School has Earned the Totalfund is RS."+SMS.getTotalmoneyearned());
		System.out.println("______________________________________________________________");

		System.out.println(".......SMS School has Spend Fund......");
		Sudha.receiveSalary(Sudha.getTeachersalary());
		System.out.println("SMS has spent for Salary "+Sudha.getTeachersalary());
		Mohan.receiveSalary(Mohan.getTeachersalary());
		System.out.println("SMS has spent for Salary : "+Mohan.getTeachersalary());
		Sham.receiveSalary(Sham.getTeachersalary());
		System.out.println("SMS has spent for Salary : "+Sham.getTeachersalary());
		System.out.println("______________________________________________________________");
		System.out.println(".....Remaing Fund SMS  School has is Rs."+SMS.getTotalmoneyearned());
		System.out.println("______________________________________________________________");




	}

}
