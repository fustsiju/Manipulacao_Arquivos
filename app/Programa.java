package app;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Fulvio Stefanine\\Desktop\\Anotações\\EHP.txt"); // Localizando o arquivo
		Scanner num = null; //Iniciando o scanner como null
		try {
			num = new Scanner(file); // Igualando o num ao file
			while (num.hasNextLine()) { //Enquanto tiver proxima linha
				System.out.println(num.nextLine()); //Imprima a proxima linha
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {	//Boa prática utilizar o finally para fechar o scanner
			if (num != null) { 
				num.close();
			}
		}
	}
}