package application;

import java.util.Scanner;

import entities.Avaliacao;
import entities.Local;
import entities.Motorista;
import entities.Passageiro;
import entities.Usuario;
import entities.Viagem;

public class Program {
	public static void mostrarMenuInicial() {
		System.out.println("** CarONE-M **");
		System.out.println("1) Fazer cadastro");
		System.out.println("2) Fazer login");
		System.out.println("3) Sair");
		System.out.print("Selecione uma opção: ");
	}

	public static void mostrarMenuMotorista() {
		System.out.println("** CarONE-M Motorista**");
		System.out.println("1) Cadastrar nova viagem");
		System.out.println("2) Consultar passageiros");
		System.out.println("3) Verificar avaliações");
		System.out.println("4) Sair");
		System.out.print("Selecione uma opção: ");
	}

	public static void mostrarMenuPassageiro() {
		System.out.println("** CarONE-M Passageiro **");
		System.out.println("1) Buscar por carona");
		System.out.println("2) Avaliar uma viagem");
		System.out.println("3) Sair");
		System.out.print("Selecione uma opção: ");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Simulação de base de dados existente

		// passageiros
		Passageiro p1 = new Passageiro();
		p1.setNome("Robirso");

		// motoristas
		Motorista m1 = new Motorista();
		m1.setNome("Jão");

		// locais
		Local l1 = new Local("São Paulo", 0.0, 290.0);
		Local l2 = new Local("São José do Rio Pardo", 0.0, 0.0);
		Local l3 = new Local("Campinas", 0.0, 180.0);
		Local l4 = new Local("Mogi Mirim", 0.0, 100.0);

		boolean cadastroRealizado = false; // variável que verifica se o cadastro ja foi realizado
		// Programa principal
		Usuario usuario = null;
		Passageiro passageiro = null;
		Motorista motorista = null;
		while (true) {
			mostrarMenuInicial();
			int opcao = sc.nextInt();
			// Realizar o cadastro
			if (opcao == 1) {
				if (!cadastroRealizado) {
					sc.nextLine();
					System.out.println("\nCADASTRO");
					System.out.print("Nome: ");
					String nome = sc.nextLine();
					System.out.print("Endereço: ");
					String endereco = sc.nextLine();
					System.out.print("E-mail: ");
					String email = sc.nextLine();
					System.out.print("Telefone: ");
					String telefone = sc.nextLine();
					System.out.print("Senha: ");
					String senha = sc.nextLine();
					usuario = new Usuario(nome, endereco, email, telefone, senha);
					passageiro = new Passageiro(nome, endereco, email, telefone, senha);
					motorista = new Motorista(nome, endereco, email, telefone, senha);
					cadastroRealizado = true;
					System.out.println();
					
					// Viagem v1 = new Viagem(3, l1, l2, m1);
					// Viagem v2 = new Viagem(3, l2, l1, m1);
					// Viagem v3 = new Viagem(3, l2, l3, m1);
					// Viagem v4 = new Viagem(3, l4, l1, m1);
					// v2.concluirViagem();
					// v4.concluirViagem();
					// passageiro.addViagem(v2);
					// passageiro.addViagem(v1);
					// passageiro.addViagem(v3);
					// passageiro.addViagem(v4);
					
				} else {
					System.out.println("Cadastro já realizado.\n");
				}

				// Realizar o login
			} else if (opcao == 2) {
				if (cadastroRealizado) {
					sc.nextLine();
					System.out.println("\nLOGIN");
					System.out.print("E-mail: ");
					String emailLogin = sc.nextLine();
					System.out.print("Senha: ");
					String senhaLogin = sc.nextLine();
					System.out.println();
					if (usuario.getEmail().equals(emailLogin) && usuario.getSenha().equals(senhaLogin)) {
						while (true) {
							System.out.print("Passageiro(p) ou Motorista(m): ");
							char tipoConta = sc.next().toLowerCase().charAt(0);
							while (tipoConta != 'p' && tipoConta != 'm') {
								System.out.println("Tipo inválido. Tente novamente.");
								System.out.println("Passageiro(p) ou Motorista(m): ");
								tipoConta = sc.next().toLowerCase().charAt(0);
							}
							// Menu para o usuário Passageiro
							if (tipoConta == 'p') {
								if (passageiro instanceof Passageiro) {
									while (true) {
										System.out.println();
										mostrarMenuPassageiro();
										int opcaoPassageiro = sc.nextInt();
										if (opcaoPassageiro == 1) {
											System.out.println("\nBuscar carona");
										} else if (opcaoPassageiro == 2) {
											int contador = 0;

											System.out.println("\nAVALIAR VIAGEM");
											System.out.println("\nVIAGENS CONCLUIDAS");
											for (Viagem viagem : passageiro.getViagens()) {
												if (viagem.getProgresso()) {
													System.out.println("[" + contador + "]" + viagem.resumoViagem());
												}
												contador++;
											}
											System.out.print("\nEntre com o índice da viagem a avaliar: ");
											int indiceViagem = sc.nextInt();
											System.out.println();
											System.out
													.println(passageiro.getViagens().get(indiceViagem).resumoViagem());
											System.out.print("Nota [0 - 5]: ");
											int nota = sc.nextInt();
											System.out.print("Comentario: ");
											sc.nextLine();
											String comentario = sc.nextLine();
											Avaliacao avaliacao = new Avaliacao(nota, comentario);
											passageiro.getViagens().get(indiceViagem).addAvaliacao(avaliacao);

										} else if (opcaoPassageiro == 3) {
											System.out.println("\nSessão passageiro encerrada.\n");
											break;
										}
									}
								}
							}
							// Menu para o usuário Motorista
							else if (tipoConta == 'm') {
								if (motorista instanceof Motorista) {
									while (true) {
										System.out.println();
										mostrarMenuMotorista();
										int opcaoMotorista = sc.nextInt();

										// Opção 1
										if (opcaoMotorista == 1) {
											System.out.println("\nCadastrar nova viagem");
											System.out.print("Quantidade de lugares: ");
											int qtdLugares = sc.nextInt();
											sc.nextLine();

											// Local: Ponto de partida
											System.out.println("PONTO DE PARTIDA");
											System.out.print("Descricao: ");
											String descricaoPartida = sc.nextLine();
											System.out.print("Digite a longitude: ");
											double xPartida = sc.nextDouble();
											System.out.print("Digite a latitude: ");
											double yPartida = sc.nextDouble();
											Local partida = new Local(descricaoPartida, xPartida, yPartida);

											// Local: Destino
											System.out.println("DESTINO ");
											sc.nextLine();
											System.out.print("Descricao: ");
											String descricaoDestino = sc.nextLine();
											System.out.print("Digite a longitude: ");
											double xDestino = sc.nextDouble();
											System.out.print("Digite a latitude: ");
											double yDestino = sc.nextDouble();
											Local destino = new Local(descricaoPartida, xDestino, yDestino);
											Viagem viagem = new Viagem(qtdLugares, partida, destino, motorista);
											// Adicionar parada no trajeto
											char addParada;
											do {
												System.out.print("Adicionar parada (s/n): ");
												addParada = sc.next().toLowerCase().charAt(0);
												if (addParada == 's') {
													sc.nextLine();
													System.out.println("PARADA ");
													System.out.print("Descricao: ");
													String descricaoParada = sc.nextLine();
													System.out.print("Digite a longitude: ");
													double xParada = sc.nextDouble();
													System.out.print("Digite a latitude: ");
													double yParada = sc.nextDouble();
													Local parada = new Local(descricaoParada, xParada, yParada);
													viagem.addLocal(parada);
												}
											} while (addParada != 'n');

										}

										// Opção 2
										else if (opcaoMotorista == 2) {
											System.out.println("\nConsultar passageiros");
											for (Viagem viagem : motorista.getViagens()) {
												System.out.print(viagem.resumoViagem());
												viagem.exibirProgresso();
												viagem.exibirPassageiros();
											}
										}

										// Opcão 3
										else if (opcaoMotorista == 3) {
											System.out.println("\nVerificar avaliações");
											motorista.exibirComentarios();
											System.out.println("Nota geral: " + motorista.getMediaDeAvaliacoes());

										}

										// Opção 4
										else if (opcaoMotorista == 4) {
											System.out.println("\nSessão motorista encerrada.\n");
											break;
										}
									}
								}
							}
							System.out.println("Sair da conta (y)?");
							char sair = sc.next().toLowerCase().charAt(0);
							if (sair == 'y') {
								break;
							}
						}
					} else {
						System.out.println("Login incorreto. Tente novamente.\n");
					}

				} else {
					System.out.println("\nRealize o cadastro primeiro.\n");
				}
			}
			// Sair do sistema
			else if (opcao == 3) {
				System.out.println("Programa finalizado.");
				break;
			}

			else {
				System.out.println("\nOpção inválida. Tente novamente.\n");
			}
		}
		sc.close();
	}
}
