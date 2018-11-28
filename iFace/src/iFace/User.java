package iFace;

import java.util.ArrayList;
import java.util.Scanner;
import iFace.Useful;

public class User {
	private String login;
	private String password;
	public String name; 
	private static ArrayList<User> friends = new ArrayList<User>();
	private ArrayList<Message> sentMessages = new ArrayList<Message>();
	private ArrayList<Message> receivedMessages = new ArrayList<Message>();
	private ArrayList<User> invites = new ArrayList<User>();
	private ArrayList<Community> communities = new ArrayList<Community>();
	private ArrayList<Community> myCommunities = new ArrayList<Community>();
	
	Scanner input = new Scanner(System.in);
	Useful useful = new Useful();
	
	public User() {
		this.sentMessages = sentMessages;
		this.receivedMessages = receivedMessages;
		this.invites = invites;
		this.communities = communities;
	}
	public ArrayList getSentMessages() {
		return sentMessages;
	}
	public ArrayList getReceivedMessages() {
		return receivedMessages;
	}
	public ArrayList getFriends() {
		return friends;
	}
	public ArrayList getInvites() {
		return invites;
	}
	public ArrayList getCommunities() {
		return communities;
	}
	public ArrayList getMyCommunities() {
		return myCommunities;
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
	public void createAccount(User newUser, ArrayList<User> accounts) {
		String login;
		String name;
		String password;
		
		System.out.print("\nLogin: ");
		login = input.nextLine();
		User existentUser = searchUser(accounts, 1, login);
		if(existentUser != null) {
			System.out.println("Este Login já está sendo usado!\n");
			return;
		}
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
	public void editAccount(User currentUser, ArrayList<User> accounts){
		useful.cleanScreen();
		System.out.println("### Selecione a opção que deseja editar: ###\n"
				+ "(0) Voltar\n"
				+ "(1) Login\n"
				+ "(2) Senha\n"
				+ "(3) Nome");
		int edit = input.nextInt();
		String newString;
		if(edit == 1){
			System.out.println("Digite o novo Login:\n");
			newString = input.next();
			User existentUser = searchUser(accounts, 1, newString);
			if(existentUser != null) {
				System.out.println("Este Login já está sendo usado!\n");
				return;
			}
			currentUser.setLogin(newString);
			
		}
		else if(edit == 2){
			System.out.println("Digite a nova senha:\n");
			newString = input.next();
			currentUser.setPassword(newString);
			
		}
		else if(edit == 3){
			System.out.println("Digite o novo Nome:\n");
			newString = input.next();
			currentUser.setName(newString);
		}
		else {
			return;
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
	
	public void friendsList(User currentUser) {
		int n = currentUser.getFriends().size();
		User friend = new User();
		for(int i = 0; i < n; i++) {
			friend = (User)currentUser.getFriends().get(i);
			System.out.println(friend.getName());
		}	
	}
	public void answerInvites(User currentUser, ArrayList accounts) {
		int n = currentUser.getInvites().size();
		User newFriend = new User();
		int option;
		for(int i = 0; i < n; i++) {
			newFriend = (User)currentUser.getInvites().get(i);
			System.out.println(newFriend.getName() + " quer ser seu Amigo!\n"
					+ "(0) Voltar\n"
					+ "(1) Aceitar\n"
					+ "(2) Recusar\n"
					+ "(3) Próximo Convite\n");
			option = input.nextInt();
			if(option == 0) {
				return;
			}
			else if(option == 1) {
				currentUser.getFriends().add(newFriend);
				newFriend.getFriends().add(currentUser);
				currentUser.getInvites().remove(i);
				System.out.println("Agora você e " + newFriend.getName() + "são Amigos!\n");
			}
			else if(option == 2) {
				currentUser.getInvites().remove(i);
			}
		}
	}
	public void sendInvite(User currentUser, ArrayList accounts) {
		String friendName;
		System.out.print("Digite o nome do usuário que deseja adicionar: ");
		friendName = input.nextLine();
		User newFriend = searchUser(accounts, 2, friendName);
		if(newFriend.getLogin() == null)
		{
			System.out.println("\nUsuário não encontrado!\n");
			return;
		}
		else {
			newFriend.getInvites().add(currentUser);
			System.out.println("\nConvite Enviado!\n");
			return;
		}
	}
	public void createCommunity(User currentUser, ArrayList<Community> allCommunities) {
		Community newCommunity = new Community();
		String name;
		String description;
		System.out.println("Digite o nome da nova Comunidade:\n");
		name = input.nextLine();
		System.out.println("Digite a Descrição da nova Comunidade:\n");
		description = input.nextLine();
		currentUser.getMyCommunities().add(newCommunity);
		newCommunity.owner = currentUser;
		allCommunities.add(newCommunity);
	}
	public void addMember(User currentUser, ArrayList<Community> allCommunities) {
		String name;
		System.out.println("Digite o nome da Comunidade que deseja entrar:\n");
		name = input.nextLine();
		int n = allCommunities.size();
		for(int i = 0; i < n; i++) {
			if(name.equalsIgnoreCase(allCommunities.get(i).name)) {
				allCommunities.get(i).members.add(currentUser);
				currentUser.getCommunities().add(allCommunities.get(i));
				break;
			}
		}
		System.out.println("Comunidade não Encontrada!\n");
	}
	public void printCommunities(User currentUser, ArrayList<Community> communities) {
		int n = currentUser.getMyCommunities().size();
		Community currentCommunity;
		for(int i = 0; i < n; i++) {
			currentCommunity = communities.get(i);
			System.out.println("\nComunidade: " + currentCommunity.name + "\nDescrição: " + currentCommunity.description);
		}
	}
	public void printUserInfo(User currentUser) {
		System.out.println("->Login: " + currentUser.getLogin() +
				"\n->Nome: " + currentUser.getName() +
				"\n->Minhas Comunidades:");
		currentUser.printCommunities(currentUser, currentUser.getMyCommunities());
		System.out.println("->Comunidades que sou Membro:");
		currentUser.printCommunities(currentUser, currentUser.getCommunities());
		System.out.println("->Amigos:");
		currentUser.friendsList(currentUser);
		System.out.println("->Mensagens:");
		int n = currentUser.getReceivedMessages().size();
		Message msg;
		for(int i = n-1; i >= 0; i--) {
			msg = (Message)currentUser.getReceivedMessages().get(i);
			msg.printMessage(msg);
		}	
	}
	public boolean removeAccount(User currentUser, ArrayList<User> accounts) {
		System.out.println("Tem Certeza que deseja remover sua conta? (Não pode ser desfeito)\n"
				+ "(1) Sim\n"
				+ "(2) Não\n");
		int option = input.nextInt();
		if(option == 1)
		{
			currentUser.setName(null);
			currentUser.setPassword(null);
			currentUser.setPassword(null);
			int n = accounts.size();
			for(int i = 0; i < n; i++) {
				if(currentUser.getLogin().equals(accounts.get(i).login))
				{
					accounts.remove(i);
					break;
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}
}

