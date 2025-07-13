package entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student 
{
	@ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int studentId;

    private String name;
    private String email;
    private String phone;
    
	public int getStudentId() 
	
	{
		return studentId;
	}
	
	public void setStudentId(int studentId) 
	{
		this.studentId = studentId;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getEmail() 
	
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

    

}
