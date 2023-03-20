package org.me.gcu.ip3;
import android.database.sqlite.SQLiteDatabase;


public class sqlConnect {

    private int id;
    private String firname, surname, username, email, password;

    //constructor


    public sqlConnect(int id, String firname, String surname, String username, String email, String password) {
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
    public String setFirname(String firname) { return firname; }
    public String getSurname() { return surname; }
    public String setSurname(String surname) { return surname; }
    public String getUsername() { return username; }
    public String setUsername(String username) { return username; }
    public String getEmail( ) { return email; }
    public String setEmail(String email) { return email; }
    public String getPassword( ) { return password; }
    public String setPassword(String password) { return password; }

}
