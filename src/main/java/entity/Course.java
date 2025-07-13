package entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity

@Table(name = "courses")
public class Course 

{

	@ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int courseId;

    private String courseName;
    private int duration;
    
	public int getCourseId()
	
	{
		return courseId;
	}
	
	public void setCourseId(int courseId)
	
	{
		this.courseId = courseId;
	}
	
	public String getCourseName()
	
	{
		return courseName;
	}
	
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	
	public int getDuration() 
	{
		return duration;
	}
	
	public void setDuration(int duration)
	{
		this.duration = duration;
	}
    
}
