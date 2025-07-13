package entity;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "admissions")
public class Admission 

{
	@ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	  private int admissionId;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    private LocalDate admissionDate;

	public int getAdmissionId() 
	
	{
		return admissionId;
	}

	public void setAdmissionId(int admissionId) 
	
	{
		this.admissionId = admissionId;
	}

	public Student getStudent() 
	
	{
		return student;
	}

	public void setStudent(Student student) 
	
	{
		this.student = student;
	}

	public Course getCourse() 
	
	{
		return course;
	}

	public void setCourse(Course course) 
	{
		this.course = course;
	}

	public LocalDate getAdmissionDate()
	{
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate)
	
	{
		this.admissionDate = admissionDate;
	}
    
    


}
