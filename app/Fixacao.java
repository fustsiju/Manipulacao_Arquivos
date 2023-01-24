package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import entidades.Produto;

public class Fixacao {
	public static void main(String args[]) {
		leitura();
	}

	public static void leitura() {
		Scanner num = new Scanner(System.in);
		List<Produto> line = new ArrayList<>();

		System.out.println("Insira o caminho do arquivo: ");
		String caminho = num.nextLine();
		File file = new File(caminho);
		String fold = file.getParent();
		StringTokenizer tk = null;

		boolean arq = new File(fold + "\\out").mkdir();
		System.out.println("Pasta criada com sucesso: " + arq);
		String arquivo = fold + "\\out\\sumario.txt";
		Produto produto = new Produto();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {  //MUITO FEIO USAR TRY DENTRO DE TRY, EVITAR!
				String linha = br.readLine();
				while (linha != null) {
					tk = new StringTokenizer(linha, ",");

					String nome = tk.nextToken();
					produto.setNome(nome);
					String preco = tk.nextToken();
					produto.setPreco(Double.parseDouble(preco));
					String quant = tk.nextToken();
					produto.setQuant(Integer.parseInt(quant));

					line.add(produto);
					linha = br.readLine();
					
					bw.write(produto.getNome() + ", " + produto.getPreco());
					bw.newLine();
				}
				System.out.println(arquivo + " CRIADO!");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (num != null) {
				num.close();
			}
		}
	}
}
