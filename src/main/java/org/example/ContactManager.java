package org.example;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactManager {
    Logger logger = Logger.getLogger(ContactManager.class.getName());
    ArrayList<Contact> listContact = new ArrayList<>();
    HashSet<Contact> listSetContact = new HashSet<>();
    Map<String, ArrayList<Contact>> listMapContact = new HashMap<>();


    void add(Contact contact){
        if(!listSetContact.contains(contact)){
            listContact.add(contact);
            listSetContact.add(contact);
            listMapContact.putIfAbsent(contact.getGroup(), new ArrayList<>());
            listMapContact.get(contact.getGroup()).add(contact);
            System.out.println("контакт добавлен");
        }
        else logger.info(contact + " такой контакт существует");


    }

    void removeContact(String phone){
        Contact toRemove = null;
        Iterator<Contact> iterator = listContact.iterator();
        while (iterator.hasNext()){
            Contact contact = iterator.next();
            if(contact.getPhone().equals(phone)){
                toRemove = contact;
                iterator.remove();
                System.out.println("контакт успешно удален");
                break;
            }
        }
        if(toRemove != null){
            listSetContact.remove(toRemove);
            listMapContact.remove(toRemove.getPhone());
        }
        else logger.log(Level.SEVERE, "попытка удаления контакта котрого нет");

    }

    void searchByName(String name){
        Iterator<Contact> iterator = listContact.iterator();
        Contact tempContact = null;
        while (iterator.hasNext()){
            Contact contact = iterator.next();
            if(contact.getName().equals(name)){
                tempContact = contact;
            }
        }
        if(tempContact != null){
            System.out.println("контакт найден " + tempContact);
        }
        else logger.log(Level.SEVERE, "такого контакта нет");
    }

    void searchByGroup(String group){
        if (listMapContact.containsKey(group)) {
            System.out.println("Группа: " + group);
            for(Contact contact: listMapContact.get(group)){
                System.out.println(contact.toString());
            }

        } else {
            System.out.println("Группа не найдена.");
        }
    }

    void printContact(){
        Iterator<Contact> iterator = listContact.iterator();
        if (iterator.hasNext()) {
            do {
                System.out.println(iterator.next().toString());
            } while (iterator.hasNext());
        }

    }


}








