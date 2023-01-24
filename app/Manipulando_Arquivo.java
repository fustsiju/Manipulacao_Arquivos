package app;

import java.io.File;
import java.util.Scanner;

public class Manipulando_Arquivo {
	public static void main(String[] args) {
		Scanner num = new Scanner(System.in);
		try {
			System.out.println("Insira o caminho do arquivo: ");
			String strPath = num.nextLine();
			File path = new File(strPath);

			File[] pastas = path.listFiles(File::isDirectory); // Listando pastas
			System.out.println("PASTAS:");
			for (File pasta : pastas) {
				System.out.println(pasta);
			}

			File[] arquivos = path.listFiles(File::isFile); // Listando arquivos
			System.out.println("ARQUIVOS:");
			for (File arquivo : arquivos) {
				System.out.println(arquivo);
			}

			boolean successo = new File(strPath + "\\testeArquivo").mkdir(); // Criando uma pasta no caminho
																				// especificado

			System.out.println("Pasta criada com sucesso: " + successo); // Confirmação da criação da pasta
			System.out.println();
			System.out.println("Path: " + path.getPath()); // Todo o caminho
			System.out.println("Parent: " + path.getParent()); // Nome do caminho
			System.out.println("Name: " + path.getName()); // Nome do arquivo

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} finally {
			num.close();
		}

	}
}