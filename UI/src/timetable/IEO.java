
package timetable;

/**
 *
 * @author brianbett
 */
public class IEO {
    String fname;
    String lname;
    String department;
    String password;
    String email;
    String phone;

    public IEO(String department, String email, String phone, String fname, String lname, String password) {
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
/**
 * 
 * @return 
 */
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
