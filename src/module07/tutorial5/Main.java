package module07.tutorial5;

import module07.tutorial5.ClientDAO;
import module07.tutorial5.GenericDAO;
import module07.tutorial5.UserDAO;
import module07.tutorial5.ClientDAO;
import module07.tutorial5.UserDomain;

public class Main {

    private final static GenericDAO<Integer, UserDomain> userDAO = new UserDAO();
    private final static GenericDAO<String, ClientDomain> clientDAO = new ClientDAO();

    public static void main(String[] args) {
        System.out.println("===UserDAO===");
        var user = new UserDomain(1, "João", 36);
        System.out.println(userDAO.count());
        System.out.println(userDAO.save(1, user));
        System.out.println(userDAO.findAll());
        System.out.println(userDAO.find(d -> d.getId().equals(1)));
        System.out.println(userDAO.find(d -> d.getId().equals(2)));
        System.out.println(userDAO.count());
        System.out.println(userDAO.delete(new UserDomain(-1, "", -1)));
        System.out.println(userDAO.delete(user));
        System.out.println(userDAO.findAll());
        System.out.println(userDAO.count());
        System.out.println("===UserDAO(end)===");

        System.out.println("===ClientDAO===");
        var client = new ClientDomain("A", "Maria", 21);
        System.out.println(clientDAO.count());
        System.out.println(clientDAO.save(1, client));
        System.out.println(clientDAO.findAll());
        System.out.println(clientDAO.find(d -> d.getId().equals("A")));
        System.out.println(clientDAO.find(d -> d.getId().equals("2")));
        System.out.println(clientDAO.count());
        System.out.println(clientDAO.delete(new ClientDomain("", "", -1)));
        System.out.println(clientDAO.delete(client));
        System.out.println(clientDAO.findAll());
        System.out.println(clientDAO.count());
        System.out.println("===ClientDAO(end)===");
    }

}
