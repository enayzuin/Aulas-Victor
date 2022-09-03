package br.com.enay.dona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BuyImpl {

	public static String NOME_MERCADO = "Mecardinho de 1.99";

	public void efetuarCompra(List<Mercadoria> mercadorias) throws IOException {

		// precisa receber uma lista de mercadoria.
		// substituir todas as propriedades com o input do banco de dados.
		// usuario só vai poder selecionar produtos que está no banco de dados.

		double valorDoProduto = 1.99;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Nome do Cliente: ");
		String userInput = reader.readLine();
		System.out.println("Bem-Vindo ao mercado " + NOME_MERCADO + ", " + userInput);
		System.out.println("Lista de produtos:");
		mercadorias.forEach(
				i -> System.out.println("Produto" + " " + i.getNome() + " " + "Está na promoção" + " " + i.getPromocao()
						+ " " + "Quantidade:" + " " + i.getQuantidade() + " " + "Valor:" + " " + i.getValor()));
		
		//formatar a exibição

		System.out.print("Selecione o produto que deseja comprar: ");
		String produtoDigitado = reader.readLine();
		
		// Verificar se o produto digitado existe na lista
		
		System.out.println("O produto que você escolheu foi: " + produtoDigitado);
		System.out.print("Qual a quantidade? ");
		// Adicionar a uma lista de mercadorias compradas a quantidade 
		// que o cliente deseja
		
		String quantidadeProduto = reader.readLine();

		int quantidade = 0;

		boolean erro = true;
		while (erro) {
			try {
				quantidade = Integer.parseInt(quantidadeProduto);
				erro = false;
			} catch (Exception validandoQnt) {
				erro = true;
				System.out.println("quantidade invalida");
				System.out.println("Dica: Digite uma quantidade usando Numerais.");
				quantidadeProduto = reader.readLine();
			}
		}

		double total = quantidade * valorDoProduto;

		System.out.println("O seu produto é " + produtoDigitado + " a quantidade: " + quantidadeProduto
				+ " o valor de sua compra é R$ " + total);

		// Validar se o cliente deseja comprar outro item da lista
		// exibir a lista sem o item que ele ja escolheu
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		double desconto = total * 10 / 100;
		double totalDesconto = total - desconto;

		System.out.println("Deseja CPF na nota? (S/N)");
		String next = scanner.next();

		List<Character> respostasAceitaveis = Arrays.asList('S', 's', 'N', 'n');

		while (next.length() > 1 || !respostasAceitaveis.contains(next.charAt(0))) {
			System.out.println("Input do usuário inválido, digite novamente (S/N)");
			next = scanner.next();
		}
		char response = next.charAt(0);
		if (response == 'S' || response == 's') {
			System.out.println("Digite o CPF: ");
			System.out.println("Você é Cliente VIP, Sr " + userInput
					+ " Possui 10% de desconto, Está recebendo o desconto de: " + desconto);
			System.out.println("O valor da sua compra com desconto é de: " + totalDesconto);

		} else if (response == 'N' || response == 'n') {
			System.out.println("Vamos prosseguir sem CPF...");
			System.out.println("O Sr não é cliente VIP, o valor de sua compra sem desconto é de: " + total);
		} else {
			System.out.println("Algum erro aconteceu, tente novamente");
		}

	}

}