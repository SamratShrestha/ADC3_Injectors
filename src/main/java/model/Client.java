/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ica
 */
public class Client {

    private int id;
    private String username;
    private String password;
    private String email;
    private Long phone;
    private String gender;
    private String firstname;
    private String lastname;
    private String address;
    private String country;
    private String answer;
    private String oldPassword;

    public Client() {
    }

    public Client(String username, String password, String email, Long phone, String gender, String firstname, String lastname, String address, String country,String answer) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.country = country;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getAnswer() {
        return answer;
    }

    public String getOldPassword() {
        return oldPassword;
    }

   

}
