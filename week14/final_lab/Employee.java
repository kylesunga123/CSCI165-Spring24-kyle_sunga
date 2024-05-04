/*
 * File:	Employee.java
 * Author:	Ken Whitener
 * Date:	4/15/2024
 * 
 * Description: This class represents an employee with a hire date, id number, and department.
 * 				Employee is a subclass of Person.
 */


public class Employee extends Person {

	private Date	hireDate;
	private int		id;
	private String	department;

	// no argument 
	public Employee() {
		//add default values. ran into a lot on null pointers so i was running around the debugger.
		super();
		this.hireDate = new Date();
		this.id = 0; 
		this.department = "Unknown";
	}

	// overloaded constructor
	/**
	 * 
	 * @param p
	 * @param hired
	 * @param id
	 * @param dept
	 */
	public Employee(Person p, Date hired, int id, String dept) {
		super(p.getFirstName(), p.getLastName(), p.getPhoneNumber(), p.getDOB());			// call to super class copy constructor
		setHireDate(hired);	// sets will protect privacy
		setId(id);
		setDepartment(dept);
	}

	// overloaded constructor
	/**
	 * 
	 * @param first
	 * @param last
	 */
	public Employee(String first, String last){
		super(first, last);
		this.hireDate = new Date();  // Set a default hire date
        this.id = 0;  // Default ID
        this.department = "Unknown";  // Default department

	}

	// copy constructor
	/**
	 * 
	 * @param toCopy
	 */
	//Citation CHAT GPT. added comments
	public Employee(Employee toCopy){
    super(toCopy); 
    // Copies the hireDate field. Since Date is mutable, we create a new Date object
    // to ensure that the original Employee's hireDate is not altered by changes to this Employee's hireDate.
    this.hireDate = new Date(toCopy.getHireDate());
    // Copies the id field. Primitive types like int are copied by value, so this is a direct copy.
    this.id = toCopy.getId();
    // Copies the department field. Strings in Java are immutable, so direct assignment is safe
    // without risking the original object's department being altered.
    this.department = toCopy.getDepartment();
}

	/**
	 * 
	 * @return the date the Employee was hired
	 */
	public Date getHireDate() {
		return new Date(hireDate);			// privacy protection
	}

	/**
	 * 
	 * @param hireDate
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = new Date(hireDate);
	}

	/**
	 * 
	 * @return The Employee's ID number
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The Employee's Department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return super.toString() + "\nHired: " + hireDate + "\nID: " + id + "\nDept: " + department;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)					return true;	// idenitity check
		if (obj == null)					return false;	// null check
		if (getClass() != obj.getClass())	return false;	// origin check 
		if (!super.equals(obj))				return false;	// super class check (inheritance)

		Employee other = (Employee) obj;					// downcast

		if (hireDate == null){								// date hired
			if (other.hireDate != null)		return false;
		}
		else if (!hireDate.equals(other.hireDate))			// calls Date.equals (composition)
			return false;

		if (id != other.id)					return false;	// id (primitive)

		return true;	// everything is equal
	}
}
