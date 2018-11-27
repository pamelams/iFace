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
		int cont = 1, function;
		
		
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
				User newUser = new User();
				newUser.createAccount(newUser);
				accounts.add(newUser);
				currentUser = newUser;
				
			}
			else if(cont == 2)
			{
				useful.cleanScreen();
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
						+ "(2) Adicionar Amigo\n"
						+ "(3) Mensagens\n"
						+ "(5) Criar Comunidade\n"
						+ "(6) Adicionar membro\n"
						+ "(7) Recuperar Informações do Usuário\n"
						+ "(8) Remover Conta\n");
				function = input.nextInt();
				
				if(function == 0)
				{
					break;
				}
				else if(function == 1)
				{	
					currentUser.editAccount(currentUser);
				}
				else if(function == 2)
				{
					
					
				}
				else if(function == 3)
				{
					accounts.remove(1);
					int n = accounts.size();
					for (int i=0; i<n; i++) {
					      System.out.printf("Posição %d- %s\n", i, accounts.get(i).name);
					    }
					
				}
				else if(function == 4)
				{
					
				}
				else if(function == 5)
				{
					
				}
				else if(function == 6)
				{
					
				}
				else if(function == 7)
				{
					
				}
				else if(function == 8)
				{
					
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
