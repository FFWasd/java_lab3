package ru.igoshev.person;
public class Name{
    private final String second_name;
    private final String first_name;
    private final String surname;
    @Override 
    public String toString(){
        if (second_name.length() > 0 && first_name.length() >0 && surname.length() >0){
            return first_name + " " + surname + " " + second_name;
        }
        else if(second_name.length() > 0 && first_name.length() > 0 && surname.length() == 0){
            return first_name + " " + second_name;
        }
        else if(second_name.length() == 0 && first_name.length() >0 && surname.length() == 0){
            return first_name;
        }
        return "";
    }
    
    public Name(String first_name, String second_name, String surname){
        if (isEmpty(first_name) && isEmpty(second_name) && isEmpty(surname)){
            throw new IllegalArgumentException("Как минимум один параметр должен быть не null!");
        }
        this.second_name = second_name;
        this.first_name = first_name;
        this.surname = surname;            
    }


    public Name(String first_name, String second_name){
        this(first_name,second_name,null);
    }

    public Name(String first_name){
        this(first_name,null,null);
    }

    boolean isEmpty(String s){
        return s == null || s.trim().isEmpty();
    }

    String getFirstName(){
        return first_name;
    }
    String getSecondName(){
        return second_name;
    }
    String getSurname(){
        return surname;
    }
}