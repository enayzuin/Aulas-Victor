package br.com.enay.dona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BuyImpl {

	public static String NOME_MERCADO = "Mecardinho de 1.99";

	public void efetuarCompra(Mercadoria mercadoria) throws IOException {

		double valorDoProduto = 1.99;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Nome do Cliente: ");
		String userInput = reader.readLine();

		System.out.println("Bem-Vindo ao mercado " + NOME_MERCADO + ", " + userInput);
		System.out.print("Digite o nome do produto que deseja comprar: ");
		String produtoDigitado = reader.readLine();
		System.out.println("O produto que você escolheu foi: " + produtoDigitado);
		System.out.print("Qual a quantidade? ");
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

		// exercicio:
		// deseja cpf na nota
		// deseja usar desconto

	}

}