package app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escrevendo_Arquivo {
	public static void main(String[] args) {
		String[] lines = new String[] { "Fulvio Stefanine", "João Pedro", "Arthur Rodrigues" };
		String path = "C:\\Users\\Fulvio Stefanine\\Desktop\\Escrevendo.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) { //Para evitar recriação do arquivo adicione ", true" ao path
			for (String line : lines) {											//path, true
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}