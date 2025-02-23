package org.example;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        ContactManager contactManager = new ContactManager();
        contactManager.add(new Contact("Андрей", "89523547689", "test@rambler.ru", "семья"));
        contactManager.add(new Contact("Виталик", "89432345566", "Vpocht23@mail.ru", "работа"));
        contactManager.add(new Contact("Марина", "89523458790", "companyma@mail.ru", "друзья"));
        contactManager.add(new Contact("Марина2", "89529458790", "comanyma@mail.ru", "друзья"));
        contactManager.add(new Contact("Марина3", "89520458790", "compan@mail.ru", "семья"));

        String menu = "Выберите действие: \n" + "1. Добавить контакт\n" + "2. Удалить контакт\n" + "3. Посмотреть все контакты\n" + "4. Найти контакт по имени\n" + "5. Посмотреть контакты по группе\n" + "0. Выход";
        while(true){
            System.out.println(menu);
            int choise = scanner.nextInt();
            scanner.nextLine();
            switch (choise){
                case 1:
                    System.out.println("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.println("Введите телефон: ");
                    String phone = scanner.next();
                    System.out.println("Введите email: ");
                    String email = scanner.next();
                    System.out.println("введите группу: ");
                    String group = scanner.next();
                    contactManager.add(new Contact(name, phone, email, group));
                    break;

                case 2:
                    System.out.println("Введите номер тел контакта, который должен быть удален:");
                    contactManager.removeContact(scanner.next());
                    break;

                case 3:
                    contactManager.printContact();
                    break;

                case 4:
                    System.out.println("Введите имя контакта: ");
                    contactManager.searchByName(scanner.nextLine());
                    break;

                case 5:
                    System.out.println("Введите группу контакта: ");
                    contactManager.searchByGroup(scanner.next());
                    break;

                case 0:
                    System.out.println("Выход из программы ");
                    scanner.close();
                    return;
            }

        }

    }
}
