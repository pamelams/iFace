package iFace;

import java.util.Scanner;
import java.util.ArrayList;
import iFace.User;
import iFace.Useful;
import iFace.Message;

public class Main {
	public static ArrayList<User> accounts = new ArrayList<User>();
	public static ArrayList<Community> allCommunities = new ArrayList<Community>();
	static int aux;
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		User currentUser = null;
		Useful useful = new Useful();
		int cont = 1, function, option;
		
		
		System.out.println("### Bem vindo(a) ao iFace! ###");
		
		while(cont != 0)
		{
			function = 1;
			System.out.println("(0) Sair\n"
					+ "(1) Criar Conta\n"
					+ "(2) Fazer Login\n");
			
			cont = input.nextInt();
			
			if(cont == 0)
			{
				break;
			}
			else if(cont == 1)
			{	
				useful.cleanScreen();
				System.out.println("### Criar Conta ###\n");
				User newUser = new User();
				newUser.createAccount(newUser, accounts);
				if(newUser.getLogin() == null) {
					continue;
				}
				accounts.add(newUser);
				currentUser = newUser;
				
			}
			else if(cont == 2)
			{
				useful.cleanScreen();
				System.out.println("### Entrar ###");
				if(accounts.size() == 0) {
					System.out.print("\nLogin: ");
					String login;
					login = input.nextLine();
					login = input.nextLine();
					System.out.println("Usuário não encontrado!\n");
					continue;
				}
				currentUser = currentUser.loginUser(accounts);
				if(currentUser == null) {
					continue;
				}
				
			}
			else
			{
				useful.cleanScreen();
				System.out.println("Opção inválida!\n");
				continue;
			}
			while(function != 0) {
				useful.cleanScreen();
				System.out.println("\nOlá, "+ currentUser.getName() +"!\n\n"
						+ "(0) Sair\n"
						+ "(1) Editar perfil\n"
						+ "(2) Amigos\n"
						+ "(3) Mensagens\n"
						+ "(4) Comunidades\n"
						+ "(5) Recuperar Informações do Usuário\n"
						+ "(6) Remover Conta\n");
				function = input.nextInt();
				
				if(function == 0)
				{
					break;
				}
				else if(function == 1)
				{	
					currentUser.editAccount(currentUser, accounts);
				}
				else if(function == 2)
				{
					System.out.println("### Amigos ###\n"
							+ "(0) Voltar\n"
							+ "(1) Lista de Amigos\n"
							+ "(2) Convites de amizade\n"
							+ "(3) Enviar Convite de Amizade\n");
					option = input.nextInt();
					if(option == 0) {
						continue;
					}
					else if(option == 1)
					{
						System.out.println("### Lista de Amigos ###\n");
						currentUser.friendsList(currentUser);
					}
					else if(option == 2)
					{	
						System.out.println("### Convites de Amizade ###\n");
						currentUser.answerInvites(currentUser, accounts);
					}
					else if(option == 3)
					{
						System.out.println("### Enviar Convite de Amizade ###\n");
						currentUser.sendInvite(currentUser, accounts);
					}
					System.out.println("(0) Voltar\n");
					aux = input.nextInt();
				}
				else if(function == 3)
				{
					System.out.println("### Mensagens ###\n"
							+ "(0) Voltar\n"
							+ "(1) Enviar Mensagem\n"
							+ "(2) Ver Mensagens");
					option = input.nextInt();
					if(option == 0) {
						continue;
					}
					else if(option == 1) {
						Message newMessage = new Message();
						newMessage.sendMessage(accounts, currentUser, newMessage);
					}
					else if(option == 2) {
						int n = currentUser.getReceivedMessages().size();
						Message msg;
						for(int i = n-1; i >= 0; i--) {
							msg = (Message)currentUser.getReceivedMessages().get(i);
							msg.printMessage(msg);
							System.out.println("(0) Voltar\n"
									+ "(1) Excluir Mensagem\n"
									+ "(2) Próxima Mensagem\n");
							option = input.nextInt();
							if(option == 0) {
								break;
							}
							if(option == 1) {
								currentUser.getReceivedMessages().remove(i);
							}
						}
					}	
				}
				else if(function == 4)
				{
					System.out.println("### Comunidades ###\n"
							+ "(0) Voltar\n"
							+ "(1) Criar Comunidade\n"
							+ "(2) Entrar em Comunidade\n"
							+ "(3) Minhas Comunidades\n"
							+ "(4) Comunidades que sou Membro\n");
					option = input.nextInt();
					if(option == 1){
						currentUser.createCommunity(currentUser, allCommunities);
					}
					else if(option == 2){	
						currentUser.addMember(currentUser, allCommunities);
					}
					else if(option == 3){
						System.out.println("### Minhas Comunidades ###");
						currentUser.printCommunities(currentUser, currentUser.getMyCommunities());
					}
					else if(option == 4) {
						System.out.println("### Comunidades que sou Membro ###");
						currentUser.printCommunities(currentUser, currentUser.getCommunities());
					}
				}
				else if(function == 5)
				{
					currentUser.printUserInfo(currentUser);
				}
				else if(function == 6)
				{
					if(currentUser.removeAccount(currentUser, accounts) == true){
						break;
					}
				}
				else
				{
					System.out.println("Opção inválida!\n");
					continue;
				}
				
			}
		}
	}
}
