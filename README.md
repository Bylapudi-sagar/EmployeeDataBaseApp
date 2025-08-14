# Employee Database Application (JDBC + MySQL + Maven)

## 📌 Project Description
This is a Java **console-based application** built using **JDBC** and **MySQL**.  
It allows you to **manage employee records** with basic CRUD operations and fetch employee details by ID.  
The application automatically creates the database and table if they don't exist.

## 🚀 Features
- **Add Employee** – Insert new employee records.
- **View All Employees** – Display all employees from the database.
- **Update Employee Salary** – Modify the salary of an employee.
- **Delete Employee** – Remove employee details from the database.
- **Fetch Employee by ID** – Retrieve details of a specific employee.
- **Auto DB & Table Creation** – Automatically creates database and table if not present.
- **Maven Support** – Easy dependency management for MySQL JDBC driver.

## 🛠️ Technologies Used
- **Java 8+**
- **MySQL Database**
- **JDBC (Java Database Connectivity)**
- **Maven**
- **MySQL Connector/J** (JDBC driver)

## 📂 Project Structure
src/main/java/
├── com/jsp/EmployeeDBApp/db/DBConnection.java
├── com/jsp/EmployeeDBApp/dto/Employee.java
├── com/jsp/EmployeeDBApp/dao/EmployeeDAO.java
├── com/jsp/EmployeeDBApp/service/EmployeeService.java
└── com/jsp/EmployeeDBApp/Main.java


## ⚙️ Setup Instructions

### 1️⃣ Install MySQL and Create Root User
Make sure MySQL is installed and running.  
Update `DBConnection.java` with your **username** and **password**:
```java
private static final String USER = "root";
private static final String PASSWORD = "root";
  
### 2. Clone Repository
git clone https://github.com/Bylapudi-sagar/EmployeeDataBaseApp.git
cd EmployeeDBApp

### 3. Build Project with Maven
mvn clean install

### 4. Run the Application
mvn exec:java -Dexec.mainClass="com.jsp.EmployeeDBApp.Main"

## sample output
 
***** Employee Database App *****
1. Add Employee
2. View Employees
3. Update Employee Salary
4. Delete Employee
5.Fetch Employee
6. Exit
Enter choice: 1
Enter Name:  Bylapudi
Enter Email: bylapudi@gmail.com
Enter Department:  IT
Enter Salary:  30000
 Database checked/created.
 Table checked/created.
✅ Employee added successfully.

***** Employee Database App *****
1. Add Employee
2. View Employees
3. Update Employee Salary
4. Delete Employee
5.Fetch Employee
6. Exit
Enter choice: 2

ID	Name	Email	Department	Salary

 Employee [id=1, name= sagar, email=sagar@gmail.com, department=software developer, salary=20000.0]

 Employee [id=2, name=Koti, email= koti@gmail.com, department= vlsi, salary=50000.0]

 Employee [id=3, name= Bylapudi, email=bylapudi@gmail.com, department= IT, salary=30000.0]

***** Employee Database App *****
1. Add Employee
2. View Employees
3. Update Employee Salary
4. Delete Employee
5.Fetch Employee
6. Exit
Enter choice: 5
Enter Employee ID to Fetch: 3

ID	Name	Email	Department	Salary

 Employee [id=3, name= Bylapudi, email=bylapudi@gmail.com, department= IT, salary=30000.0]

***** Employee Database App *****
1. Add Employee
2. View Employees
3. Update Employee Salary
4. Delete Employee
5.Fetch Employee
6. Exit
Enter choice: 4
Enter Employee ID: 2
 Employee deleted successfully.

***** Employee Database App *****
1. Add Employee
2. View Employees
3. Update Employee Salary
4. Delete Employee
5.Fetch Employee
6. Exit
Enter choice: 2

ID	Name	Email	Department	Salary

 Employee [id=1, name= sagar, email=sagar@gmail.com, department=software developer, salary=20000.0]

 Employee [id=3, name= Bylapudi, email=bylapudi@gmail.com, department= IT, salary=30000.0]

***** Employee Database App *****
1. Add Employee
2. View Employees
3. Update Employee Salary
4. Delete Employee
5.Fetch Employee
6. Exit
Enter choice: 6
Thank you for using the Employee Database Application. Have a great day!

## 🎯 Learning Outcomes

1.Understanding of JDBC API and MySQL database operations.
2.Working with PreparedStatement to prevent SQL injection.
3.Managing dependencies using Maven.
4.Implementing multi-class structure in Java.
  
