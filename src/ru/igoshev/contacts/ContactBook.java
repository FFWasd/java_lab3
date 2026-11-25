package ru.igoshev.contacts;
import java.util.ArrayList;

public class ContactBook{
    private ContactNode head = new ContactNode();
    private int count = 0;
    public ContactBook(){
        this.head = null;
        this.count = 0;
    }
    private class ContactNode{
        private String number;
        private String name;
        private ContactNode next;
        ContactNode(){
           this.number = " "; 
           this.name =" ";
           this.next = null;
        }

        void setName(String name){
            this.name = name;
        }

        void setNumber(String number){
            this.number = number;
        }
    }

    public String add(String number, String name){
        ContactNode node = new ContactNode();
        if (head == null){
            node.setName(name);
            node.setNumber(number);
            head = node;
        }
        else{
            if (!checkName(name)){
                node.setName(name);
                node.setNumber(number);
                node.next = head;
                head = node;
            }
            else{
                node = head;
                while(node != null){
                    if(node.name.toLowerCase().equals(name.toLowerCase())){
                        String oldNumber = node.number;
                        node.setNumber(number);
                        return oldNumber;
                    }
                    else{
                        node = node.next;
                    }
                }
            }
        }
        count++;
        return null;
    }

    public boolean checkName(String name){
        ContactNode node = head;
        while(node != null){
            if (name.toLowerCase().equals(node.name.toLowerCase())){
                return true;
            }
            else{
                node=node.next;
            }
        }
        return false;
    }

    public boolean checkNumber(String number){
        ContactNode node = head;
        while(node != null){
            if (number.equals(node.number)){
                return true;
            }
            else{
                node=node.next;
            }
        }
        return false;
    }

    public void delete(String name){
        if (checkName(name)){
            ContactNode node = head;
            while(!node.next.name.toLowerCase().equals(name.toLowerCase())){
                node = node.next;
            }
            node.next = node.next.next;
            System.out.println("Контакт " + name +" удалён");
            count--;
        }
        else{
            System.out.println("Такого контакта нет");
        }
    }

    public String find(String name){
        ContactNode node = head;
        while(node!= null){
            if (node.name.toLowerCase().equals(name.toLowerCase())){
                return node.number;
            }
            else{
                node = node.next;
            }
        }
        return "Такого контакта нет";
    }

    public int getCount(){
        return count;
    }

    public ArrayList<String> getPairs(){
        ContactNode node = head;
        ArrayList<String> list = new ArrayList<>();
        while (node != null){
            list.add(node.name + " - " + node.number);
            node = node.next;
        }
        return list;
    }

    public ArrayList<String> getNames(){
        ContactNode node = head;
        ArrayList<String> list = new ArrayList<>();
        while (node != null){
            list.add(node.name);
            node = node.next;
        }
        return list;
    }

    public ArrayList<String> getNumbers(){
        ContactNode node = head;
        ArrayList<String> list = new ArrayList<>();
        while (node != null){
            list.add(node.number);
            node = node.next;
        }
        return list;
    }

    public ArrayList<String> getNamesByPart(String part){
        ContactNode node = head;
        ArrayList<String> list = new ArrayList<>();
        while (node != null){
           if (node.name.toLowerCase().startsWith(part.toLowerCase())){
            list.add(node.name);
           }
           node = node.next;
        }
        return list;
    }

    @Override
    public String toString(){
        ContactNode node = head;
        String res = "";
        while (node.next != null){
            res += (node.name + " - " + node.number + ", ");
            node=node.next;
        }
        res += (node.name + " - " + node.number + ". ");
        return res;
    }
}