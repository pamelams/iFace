package iFace;

import java.util.ArrayList;
import java.util.Scanner;
import iFace.Useful;

public class User {
	private String login;
	private String password;
	public String name; 
	private static ArrayList<User> friends = new ArrayList<User>();
	private ArrayList<String> chat = new ArrayList();
	Scanner input = new Scanner(System.in);
	Useful useful = new Useful();
	
	public User() {

	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getLogin() {
		return login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void createAccount(User newUser) {
		String login;
		String name;
		String password;
		
		System.out.print("\nLogin: ");
		login = input.nextLine();
		System.out.print("\nName: ");
		name = input.nextLine();
		System.out.print("\nPassword: ");
		password = input.nextLine();
		newUser.setLogin(login);
		newUser.setName(name);
		newUser.setPassword(password);
	}
	public User loginUser(ArrayList<User> accounts) {
		User currentUser = new User();
		String login;
		String password;
		int cont = 1;
		
		System.out.print("\nLogin: ");
		login = input.nextLine();
		currentUser = searchUser(accounts, 1, login);
		if(currentUser != null){
			System.out.print("\nPassword: ");
			password = input.nextLine();
			if(password.equals(currentUser.getPassword())){
				return currentUser;
			}
			else {
				useful.cleanScreen();
				System.out.println("Login ou Senha incorretos!\n");
			}
			
		}
		return null;
	}
	public void editAccount(User currentUser){
		System.out.println("Selecione a opção que deseja editar:\n"
				+ "(1) Login\n"
				+ "(2) Senha\n"
				+ "(3) Nome");
		int edit = input.nextInt();
		String newString;
		if(edit == 1)
		{
			System.out.println("Digite o novo Login:\n");
			newString = input.next();
			currentUser.setLogin(newString);
			
		}
		else if(edit == 2)
		{
			System.out.println("Digite a nova senha:\n");
			newString = input.next();
			currentUser.setPassword(newString);
			
		}
		else if(edit == 3)
		{
			System.out.println("Digite o novo Nome:\n");
			newString = input.next();
			currentUser.setName(newString);
		}
	}
	public User searchUser(ArrayList<User> accounts, int attribute, String element) {
		int n = accounts.size();
		
		if(attribute == 1) { // search login
			
			for(int i = 0; i < n; i++) {
				if(element.equals(accounts.get(i).login))
				{
					return accounts.get(i);
				}
			}
			System.out.println("Usuário não encontrado!\n");
		}
		else if(attribute == 2) { // search name
			
			for(int i = 0; i < n; i++) {
				if(element.equalsIgnoreCase(accounts.get(i).name))
				{
					return accounts.get(i);
				}
			}
			System.out.println("Usuário não encontrado!\n");
		}
		return null;
	}
	public void removeAccount(User currentUser) {
		
	}
}

