package br.com.dio.main;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DesafioControleFluxo {

	public static void main(String[] args) {
		System.out.println("SISTEMA DE PROCESSOS SELETIVOS");
		
		String[] candidatos = {"RODRIGO", "JULIA", "PEDRO", "ABNER", "LARISSA"};
		
		for(String candidato: candidatos) {
			entrandoEmContato(candidato);
		}
	}
	
	public static void entrandoEmContato(String candidato) {
		int numeroDeTentativas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		
		do {
			atendeu= atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				numeroDeTentativas++;
			else
				System.out.println("\nContato realizado com sucesso!!");
			
		}while(continuarTentando && numeroDeTentativas < 3);
		
		if(atendeu)
			System.out.println("\nContato com " + candidato + " na " + numeroDeTentativas + " tentativa");
		else
			System.out.println("\nNão foi possível o contato com o candidato " + candidato + ", total de tentativas: " + numeroDeTentativas + " realizadas.");
	}
	
	public static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	public static void imprimirSelecionados() {
			String[] candidatos = {"RODRIGO", "JULIA", "PEDRO", "ABNER", "LARISSA"}; 
			System.out.println("\nImpimindo lista de candidatos");
			
			
			for(int indice=0; indice < candidatos.length; indice++) {
				System.out.println("\nCandidato N° " + (indice+1) + " é: " + candidatos[indice]);
			}
						
			for(String candidato: candidatos) {
				System.out.println("\nO candidato selecionado foi: " + candidato);
			}
		}
	
	public static void selecaoDeCandidados() {
		String[] candidatos = {"RODRIGO", "JULIA", "PEDRO", "ABNER", "LARISSA"};
		int candidatosSelecionados = 0;
		int candidatosAtual = 0;
		double salarioBase = 3000.0;
		
		while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
			String candidato = candidatos[candidatosAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("\nO candidato " + candidato + " solicitou o salario: " + salarioPretendido);
			if(salarioBase >= salarioPretendido) {
				System.out.println("\nO candidato " + candidato + " foi escolhido!");
				candidatosSelecionados++;
			}
			else {
				candidatosAtual++;
			}
		}			
	}
	
	public static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(2800, 3200);
	}
	
	static void analisarCandidatos(double salarioPretendido) {
		double salarioBase = 3000.0;
		if(salarioBase > salarioPretendido) {
			System.out.println("\nLigar para o candidato.");
		}
		else if(salarioBase == salarioPretendido)
			System.out.println("\nLigar para o candidato com contra proposta.");
		else {
			System.out.println("\nAguardando resultado demais candidatos!");
		}
	}

}
