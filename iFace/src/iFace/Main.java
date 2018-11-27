package iFace;

import java.util.Scanner;
import java.util.ArrayList;
import iFace.User;
import iFace.Useful;

public class Main {
	public static ArrayList<User> accounts = new ArrayList<User>();
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
				if(accounts.size() == 0) {
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
						+ "(5) Comunidades\n"
						+ "(6) Recuperar Informações do Usuário\n"
						+ "(7) Remover Conta\n");
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
							+ "(1) Lista de Amigos\n"
							+ "(2) Convites de amizade\n"
							+ "(3) Enviar Convite de Amizade\n");
					option = input.nextInt();
					if(option == 1)
					{
						currentUser.friendsList(currentUser);
					}
					else if(option == 2)
					{	
						currentUser.answerInvites(currentUser, accounts);
					}
					else if(option == 3)
					{
						currentUser.sendInvite(currentUser, accounts);
					}
				}
				else if(function == 3)
				{
					System.out.println("### Mensagens ###\n"
							+ "(1) Enviar Mensagem\n"
							+ "(2) Ver Mensagens");
					option = input.nextInt();
					if(option == 1) {
						Message newMessage = new Message();
						newMessage.sendMessage(accounts, currentUser, newMessage);
					}
					
				}
				else if(function == 4)
				{
					accounts.remove(1);
					int n = accounts.size();
					for (int i=0; i<n; i++) {
					      System.out.printf("Posição %d- %s\n", i, accounts.get(i).name);
					    }
					
				}
				else if(function == 5)
				{
					
				}
				else if(function == 6)
				{
					
				}
				else if(function == 7)
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
			//System.out.println("\nAperte ENTER para continuar\n");
		}
	}
}
