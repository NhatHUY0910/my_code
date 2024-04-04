package case_module2.model.user_account;

import case_module2.model.enum_user.GenderCustomer;

public class CustomerAccount extends Account{
    private String fullName;
    private int age;
    private GenderCustomer gender;
    private int phoneNumber;
    private String country;
    private double wallet;

    public CustomerAccount(String userName, String passWord, String fullName, int age, GenderCustomer gender, int phoneNumber, String country, double wallet) {
        super(userName, passWord);
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.wallet = wallet;
    }

    public CustomerAccount(String userName, String passWord, String fullName, int age, GenderCustomer gender, int phoneNumber, String country) {
        super(userName, passWord);
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.country = country;
    }

    public GenderCustomer getGender() {
        return gender;
    }

    public void setGender(GenderCustomer gender) {
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void updateBalance(double updatedBalance) {
        this.wallet = updatedBalance;
    }
}
