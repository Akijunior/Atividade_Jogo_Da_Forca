import java.util.Iterator;

import java.util.Random;

import javax.swing.JOptionPane;



public class Armazem_de_Nomes {

	public static void main(String[] args) {

		

		String[] bancoDePalavras = {"Peixe", "Arvore", "Fome", "Amor", "Empreendedorismo"};

		String[] temas = {"Animal", "Natureza", "Condição sensitiva", "Sentimento", "Negócios"};
		
		String[] letrasErradas = {};
		String[] letrasCorretas = {};
		

		int cont = 0, i;

		

		Random palavra = new Random();

		int qtd_palavras = palavra.nextInt(4);

		String[] listaDasSelecionadas = new String[qtd_palavras];

		

		while(cont < qtd_palavras) {

			
			int posicaoDaPalavra = palavra.nextInt(bancoDePalavras.length);
			int tamanho = bancoDePalavras[posicaoDaPalavra].length();

			String[] msg = new String[tamanho];
			String msgF = "";
			JOptionPane.showMessageDialog(null,"Qtd de palavras restantes "
												+ "da rodada: " + (qtd_palavras-cont));
			
			JOptionPane.showMessageDialog(null,"Tamanho da palavra: " + tamanho + "\n");


			for (i = 0; i < tamanho; i++) {

				msg[i] = "_ ";
				msgF += msg[i];
				}

			msgF +=  "\n" + temas[posicaoDaPalavra] + "\n";
				
			String palavraEscolhida = bancoDePalavras[posicaoDaPalavra];
			listaDasSelecionadas[cont] = palavraEscolhida;
			String letrasCertas = "";
			String letrasWrong = "";
			String letraDaVez = "";
			
			int contAcerto = 1;

				while(contAcerto != 0){	

					String letra = JOptionPane.showInputDialog(msgF + "Diga uma letra: ");
					int contRodada = 0;	
					contAcerto = 0;
					
					while (letra.length() > 1){
	
						JOptionPane.showMessageDialog(null, "Não é válido digitar mais"
								+ " de uma letra por tentativa. Tente novamente.");
						letra = JOptionPane.showInputDialog(msgF + "Diga uma letra: ");
						}
					
					msgF = "";
					

					for(i = 0; i < tamanho; i++){

						letraDaVez = String.valueOf(palavraEscolhida.charAt(i));
						
						if(letra.equalsIgnoreCase(letraDaVez)){
							msg[i] = letraDaVez;
							contRodada = 1;
							}
						}
						
					if(contRodada == 1){
						letrasCertas += letra + " ";
					}
		
					else{
						letrasWrong += letra + " ";
					}
					

					for (i = 0; i < tamanho; i++) 
						msgF += msg[i];

					
					for (i = 0; i < tamanho; i++){
						String letraF = String.valueOf(msgF.charAt(i));
						if(letraF.equals("_")){
							contAcerto ++;
							}
						}

					msgF +=  "\n" + temas[posicaoDaPalavra] + "\n" + "Letras Certas { "
							+ letrasCertas + "}\nLetras Erradas { " + letrasWrong + "}\n";	
						}
					JOptionPane.showMessageDialog(null, msgF + "\nParabéns, você venceu!");
					msgF = "";
					cont ++;

				}
		JOptionPane.showMessageDialog(null, "Fim do Jogo!"
				+ "\nObrigado pela participação e até a próxima!");

		

		String forca = "\n    O\n"
				+      "   / | \\\n" 
				+ 	   "   /   \\\n";


		JOptionPane.showMessageDialog(null, forca);
	}
}
