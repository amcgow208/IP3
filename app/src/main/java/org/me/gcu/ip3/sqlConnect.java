package org.me.gcu.ip3;
import android.database.sqlite.SQLiteDatabase;


public class sqlConnect{

    private int id;
    private String firname, surname, username, email, password, sessionUsrnme, sessionPswrd;

    //constructor


    public sqlConnect(int id, String firname, String surname, String username, String password, String email) {
        this.id = id;
        this.firname = firname;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public sqlConnect(){

    }

    //toString Conversion
    @Override
    public String toString() {
        return "sqlConnect{" +
                "id=" + id +
                ", firname='" + firname + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //Get & Set values
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    public String getFirname() { return firname; }
    public void setFirname(String firname) { this.firname = firname; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail( ) { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword( ) { return password; }
    public void setPassword(String password) { this.password = password; }

}
