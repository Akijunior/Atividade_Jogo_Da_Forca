
import java.util.Iterator;
import java.util.Random;
import javax.swing.JOptionPane;

public class Armazem_de_Nomes {
	public static void main(String[] args) {
		
		String[] bancoDePalavras = {"Peixe", "Arvore", "Fome", "Amor", "Empreendedorismo"};
		String[] temas = {"Animal", "Natureza", "Condição sensitiva", "Sentimento", "Negócios"};
		
		int cont = 0, i;
		
		Random palavra = new Random();
		int qtd_palavras = palavra.nextInt(3);
		String[] listaDasSelecionadas = new String[qtd_palavras];
		
		while(cont < qtd_palavras) {
			
			int posicaoDaPalavra = palavra.nextInt(bancoDePalavras.length);
			int tamanho = bancoDePalavras[posicaoDaPalavra].length();
			String[] msg = new String[tamanho];
			String msgF = "";
			JOptionPane.showMessageDialog(null,"Tamanho da palavra: " + tamanho + "\n");
			
			
			
			for (i = 0; i < tamanho; i++) {
				msg[i] = "_ ";
				msgF += msg[i];
				}
				msgF +=  "\n" + temas[posicaoDaPalavra] + "\n";

				
			String palavraEscolhida = bancoDePalavras[posicaoDaPalavra];
			listaDasSelecionadas[cont] = palavraEscolhida;
			cont ++;
			
				
				while(tamanho > 0){	
					
					String letra = JOptionPane.showInputDialog(msgF + "Diga uma letra: ");
					msgF = "";
					int contAcerto = 0;
					
					while (letra.length() > 1){
						
						JOptionPane.showMessageDialog(null, "Não é válido digitar mais"
								+ " de uma letra por tentativa. Tente novamente.");
						letra = JOptionPane.showInputDialog("Diga uma letra: ");
						}
					
					for(i = 0; i < tamanho; i++){
						String letraDaVez = String.valueOf(palavraEscolhida.charAt(i));
						
						if(letra.equalsIgnoreCase(letraDaVez)){
							msg[i] = letraDaVez;
							
							}
						}
					
					
					for (i = 0; i < tamanho; i++) {
						if(msg[i].equals("_")){
							contAcerto ++;
						}
						msgF += msg[i];
						}
					
					if (contAcerto == 0){
						JOptionPane.showMessageDialog(null, "Parabéns, você venceu!");
					}
						msgF +=  "\n" + temas[posicaoDaPalavra] + "\n";
					}
				
				
					msg[i] = "";
					msgF = "";
				}
		
		

		String forca = "\n    O\n"
				+      "   / | \\\n" 
				+ 	   "   /   \\\n";
		
		JOptionPane.showMessageDialog(null, forca);
		
		
	}
}
