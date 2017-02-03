import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;
import java.lang.Math;
public class Armazem_de_Nomes {
	public static void main(String[] args) {
		String[] bancoDePalavras = {"Peixe", "Arvore", "Fome", "Amor", "Empreendedorismo"};
		String[] temas = {"Animal", "Natureza", "Condição sensitiva", "Sentimento", "Negócios"};
		String msg = "";
		
		Random palavra = new Random();
		int qtd_palavras = palavra.nextInt(3);
		String[] DicionarioDasSelecionadas = new String[qtd_palavras];
		
		while(qtd_palavras + 1 > 0) {
			
			int posicaoDaPalavra = palavra.nextInt(bancoDePalavras.length);
			int tamanho = bancoDePalavras[posicaoDaPalavra].length();

			JOptionPane.showMessageDialog(null,tamanho);
			
			
			for (int i = 0; i < tamanho; i++) {
				msg += "_ ";
				}
				msg +=  "\n" + temas[posicaoDaPalavra] + "\n";
				
				
			String palavraEscolhida = temas[posicaoDaPalavra];
			JOptionPane.showMessageDialog(null,msg);
			
				while(tamanho > 0){	
					String letra = JOptionPane.showInputDialog("Diga uma letra: ");
					
					while (letra.length() > 1){
						JOptionPane.showMessageDialog(null, "Não é válido digitar mais"
								+ " de uma letra por tentativa. Tente novamente.");
						letra = JOptionPane.showInputDialog("Diga uma letra: ");
						}
					tamanho --;
					}
				
					msg = "";
					qtd_palavras --;
				}
		
		

		String forca = "\n    O\n"
				+      "   / | \\\n" 
				+ 	   "   /   \\\n";
		
		JOptionPane.showMessageDialog(null, forca);
		
		
	}
}
