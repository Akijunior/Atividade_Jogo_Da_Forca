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
		
		while(qtd_palavras == 0){
			qtd_palavras = palavra.nextInt(4);
		}

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
			int contErros = 0;
			String letrasCertas = "";
			String letrasWrong = "";
			String letraDaVez = "";
			String letrasGerais = "";
			
			int contAcerto = 1;
			String forca = "\n--"
				     + " |";
			
			int essaNFoi = 0;

				while(contAcerto != 0){	
					

					String letra = JOptionPane.showInputDialog(msgF + "Diga uma letra: ");
					int contRodada = 0;	
					contAcerto = 0;
					int umParaVerdadeiro = 1;
					
										
					for (int j = 0; j < letrasGerais.length(); j++) {
						letraDaVez = String.valueOf(letrasGerais.charAt(j));
						if(letraDaVez.equals(letra)){
							umParaVerdadeiro = 0;
							break;
							}	
						}
					
					while (letra.length() > 1 || umParaVerdadeiro == 0){
						
						if(letra.length() > 1)
							JOptionPane.showMessageDialog(null, "Não é válido digitar mais"
									+ " de uma letra por tentativa. Tente novamente.");
						
						else if(umParaVerdadeiro == 0){
						
						for (int j = 0; j < letrasGerais.length(); j++) {
							
							letraDaVez = String.valueOf(letrasGerais.charAt(j));
							
							if(letraDaVez.equals(letra)){
								JOptionPane.showMessageDialog(null, "A letra digitada já foi "
										+ "citada antes.");
								umParaVerdadeiro = 0;
								break;
								}
							umParaVerdadeiro ++;
							}
						}
						
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
						letrasGerais += letra + " ";
					}
		
					else{
						letrasWrong += letra + " ";
						letrasGerais += letra + " ";
						contErros ++;
						
						if (contErros == 1 && contRodada == 0)
							forca += "\n  O\n";
						
						if(contErros == 2 && contRodada == 0)
							forca += " / ";
						
						if(contErros == 3 && contRodada == 0)
							forca += "| ";
						
						if(contErros == 4 && contRodada == 0)
							forca += "\\\n";
						
						if(contErros == 5 && contRodada == 0) 
							forca += " / ";
							
						if(contErros == 6 && contRodada == 0) {
							forca += "  \\\n";
							essaNFoi ++;
							break;
							}		
						}
					

					for (i = 0; i < tamanho; i++) 
						msgF += msg[i];

					
					for (i = 0; i < tamanho; i++){
						String letraF = String.valueOf(msgF.charAt(i));
						if(letraF.equals("_")){
							contAcerto ++;
							}
						}

					msgF +=  "\n" + temas[posicaoDaPalavra] + "\n" + forca + "\n" + "Letras Certas { "
							+ letrasCertas + "}\nLetras Erradas { " + letrasWrong + "}\n";	
					}
					
					if(essaNFoi == 1){
						msgF +=  "\n" + temas[posicaoDaPalavra] + "\n" + forca + "\n" + "Letras Certas { "
								+ letrasCertas + "}\nLetras Erradas { " + letrasWrong + "}\n";	
						JOptionPane.showMessageDialog(null, msgF + 
								"\nVocê perdeu essa. Mais sorte na próxima.");
						}
					
					if(essaNFoi == 0)
						JOptionPane.showMessageDialog(null, msgF + "\nParabéns, você venceu!");
						
					msgF = "";
					cont ++;
				}
				
				JOptionPane.showMessageDialog(null, "Fim do Jogo!"
						+ "\nObrigado pela participação e até a próxima!");

	}
}

	
