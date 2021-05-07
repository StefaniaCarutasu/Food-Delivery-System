package controllers;

import database.CsvManipulator;
import database.Database;
import orders.Order;
import users.User;

import java.util.ArrayList;
import java.util.List;

//create user
//delete user
//update user: update username, update password, update email, update age, update address
//display user
//display order history of a user
//cancel order

public class UsersController {
    public static void createUser(String username, String password, String email, int age, String address){
        String methodName = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        CsvManipulator.write(methodName);

        User user = new User(username, address, age, password, email);
        Database.addUser(user);
    }

    public static void createUser(String username, String password, String email){
        String methodName = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        CsvManipulator.write(methodName);

        User user = new User(username, password, email);
        Database.addUser(user);
    }

    public static void deleteUser(String id){
        String methodName = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        CsvManipulator.write(methodName);

        int i = 0;
        while(i < Database.getUsers().size()){
            if(Database.getUsers().get(i).getId().equals(id)){
                List<User> userList = Database.getUsers();
                userList.remove(i);
                Database.setUsers(userList);
                break;
            }
            i++;
        }
    }

    public static void updateUser(String id, String fieldToUpdate, String updatedValue){
        String methodName = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        CsvManipulator.write(methodName);

        int i = 0;
        while(i < Database.getUsers().size()){
            if(Database.getUsers().get(i).getId().equals(id)){
                switch (fieldToUpdate){
                    case "Email":
                        Database.getUsers().get(i).setEmail(updatedValue);
                        break;
                    case "Username":
                        Database.getUsers().get(i).setUserName(updatedValue);
                        break;
                    case "Age":
                        Database.getUsers().get(i).setAge(Integer.parseInt(updatedValue));
                        break;
                    case "Password":
                        Database.getUsers().get(i).setPassword(updatedValue);
                        break;
                    case "Address":
                        Database.getUsers().get(i).setAddress(updatedValue);
                        break;
                    default:
                        break;
                }
                break;
            }
            i++;
        }
    }

    public static void showUser(String id){
        String methodName = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        CsvManipulator.write(methodName);

        Boolean found = false;
        int i = 0;
        while(i < Database.getUsers().size()){
            if(Database.getUsers().get(i).getId().equals(id)){
                String usr = Database.getUsers().get(i).toString();
                System.out.println(usr);
                found = true;
                break;
            }
            i++;
        }
        if(!found){
            System.out.println("There is no such user in database");
        }
    }

    public void showOrderHistory(String userId){
        String methodName = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        CsvManipulator.write(methodName);

        User usr = Database.getUserById(userId);
        List<Order> orderHistory = new ArrayList<Order>();
        int i = 0;
        while(i < Database.getOrders().get("cancelled").size()){
            if(Database.getOrders().get("cancelled").get(i).getUserId().equals(userId)){
                orderHistory.add(Database.getOrders().get("cancelled").get(i));
            }
            i++;
        }
        i = 0;
        while(i < Database.getOrders().get("resolved").size()){
            if(Database.getOrders().get("resolved").get(i).getUserId().equals(userId)){
                orderHistory.add(Database.getOrders().get("resolved").get(i));
            }
            i++;
        }

        System.out.println("User: " + usr.getUserName() + "\n");
        System.out.println("Orders:\n");
        for(Order order: orderHistory){
            System.out.println(order.toString() + "\n");
        }
    }

    public static void cancelOrder(String orderId, String userId){
        String methodName = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        CsvManipulator.write(methodName);

        for(Order ord: Database.getOrders().get("active")){
            if(ord.getId().equals(orderId) && ord.getUserId().equals(userId)){
                OrdersController.markAsCancelled(orderId);
            }
        }
    }
}