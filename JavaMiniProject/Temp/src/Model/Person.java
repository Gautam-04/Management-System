package Model;

import java.util.Calendar;

public class Person {
    private int ListenerId;
    private String name;
    private Calendar dob;
    private long mobile_no;
    private String email;
    private String gender;

    public Person(int ListenerId, String name, long mobile_no, String email, String gender)
    {
        setId(ListenerId);
        setName(name);
        setMobileNo(mobile_no);
        setEmail(email);
        setGender(gender);
    }

    public Person(String name, long mobile_no, String email, String gender)
    {
        int ListenerId = (int) Math.random();
        System.out.println("Student Created with Id: "+ ListenerId);
        setId(ListenerId);
        String[] split_name = name.split(" ");
        setName(name);
        setMobileNo(mobile_no);
        setEmail(email);
        setGender(gender);
    }

    public void setId(int id) { this.ListenerId = id; }

    public void setMobileNo(long mobile_no)
    {
        this.mobile_no = mobile_no;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }


    public int getId()
    {
        return this.ListenerId;
    }

    public long getMobileNo()
    {
        return this.mobile_no;
    }
    public String getEmail() { return this.email; }

    public String getGender()
    {
        return this.gender;
    }

    final public String display()
    {
        return("Id: "+this.getId()+" ,Name :"+this.getName()+ ",Mobile No :"+this.getMobileNo()+" ,Email :"+this.getEmail()+" ,Gender :"+this.getGender());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
