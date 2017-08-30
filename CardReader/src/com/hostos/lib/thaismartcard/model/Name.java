
package com.hostos.lib.thaismartcard.model;

public class Name {
    private static String title;
    private static String firstName;
    private static String midName;
    private static String lastName;

    public Name() {
    }

    public Name(String title, String firstName, String midName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMidName() {
        return midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String toString(){
        return this.title + " " + this.firstName + " " + this.midName + " " + this.lastName;
    }
}
