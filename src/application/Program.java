package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		System.out.println("\n** CarONE-M Motorista**");
		System.out.println("1) Cadastrar nova viagem");
		System.out.println("2) Consultar passageiros");
		System.out.println("3) Verificar avaliações");
		System.out.println("4) Sair");
		System.out.print("Selecione uma opção: ");
	}

	public static void mostrarMenuPassageiro() {
		System.out.println("\n** CarONE-M Passageiro **");
		System.out.println("1) Buscar por carona");
		System.out.println("2) Avaliar uma viagem");
		System.out.println("3) Sair");
		System.out.print("Selecione uma opção: ");
	}

	public static boolean validarNome(String nome) {
		return nome != null && nome.trim().length() > 0 && nome.matches("[a-zA-Z\\s]+");
	}

	public static boolean validarEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean validarTelefone(String telefone) {
		return telefone.matches("\\d{10,11}");
	}

	public static boolean validarSenha(String senha) {
		return senha.length() >= 6;
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Simulação de base de dados existente

		// passageiros
		Passageiro p1 = new Passageiro();
		p1.setNome("Gabriel");
		Passageiro p2 = new Passageiro();
		p2.setNome("Julia");
		Passageiro p3 = new Passageiro();
		p3.setNome("Maria");

		// motoristas
		Motorista m1 = new Motorista();
		m1.setNome("João");
		Motorista m2 = new Motorista();
		m2.setNome("Ronaldo");
		Motorista m3 = new Motorista();
		m3.setNome("Ana");

		// locais
		Local l1 = new Local("São José do Rio Pardo", 0.0, 0.0);
		Local l2 = new Local("Casa Branca", 30.0, 0.0);
		Local l3 = new Local("Mogi Mirim", 100.0, 0.0);
		Local l4 = new Local("Campinas", 180.0, 0.0);
		Local l5 = new Local("Jundiaí", 230.0, 0.0);
		Local l6 = new Local("São Paulo", 290.0, 0.0);

		// Viagens
		// v1
		Viagem v1 = new Viagem(3, l1, l6, "24/05/2024", m1, 0.3);
		v1.addLocal(l1);
		v1.addLocal(l2);
		v1.addLocal(l3);
		v1.addLocal(l4);
		v1.addLocal(l5);
		v1.addLocal(l6);

		// v2
		Viagem v2 = new Viagem(4, l3, l5, "25/05/2024", m2, 0.3);
		v2.addLocal(l3);
		v2.addLocal(l4);
		v2.addLocal(l5);
		
		// v3
		Viagem v3 = new Viagem(1, l1, l2, "01/06/2024", m3, 0.3);
		v3.addLocal(l1);
		v3.addLocal(l2);
		
		// v4
		Viagem v4 = new Viagem(4, l5, l3, "26/05/2024", m2, 0.3);
		v4.addLocal(l5);
		v4.addLocal(l3);
		
		// v5
		Viagem v5 = new Viagem(3, l2, l1, "26/05/2024", m3, 0.3);
		v5.addLocal(l2);
		v5.addLocal(l1);
		
		// v6
		Viagem v6 = new Viagem(3, l4, l6, "26/05/2024", m3, 0.3);
		v6.addLocal(l4);
		v6.addLocal(l5);
		v6.addLocal(l6);

		// Lista das viagens
		List<Viagem> listaDeViagens = new ArrayList<>();
		Collections.addAll(listaDeViagens, v1, v2, v3, v4, v5, v6);
		

		boolean cadastroRealizado = false; // variável que verifica se o cadastro ja foi realizado

		Usuario usuario = null;
		Passageiro passageiro = null;
		Motorista motorista = null;

		while (true) {
			mostrarMenuInicial();
			int opcao = sc.nextInt();

			if (opcao == 1) {
				if (!cadastroRealizado) {
					sc.nextLine();
					System.out.println("\nCADASTRO");

					String nome;
					do {
						System.out.print("Nome: ");
						nome = sc.nextLine();
						if (!validarNome(nome)) {
							System.out.println("Nome inválido! O nome deve conter apenas letras e espaços.");
						}
					} while (!validarNome(nome));

					System.out.print("Endereço: ");
					String endereco = sc.nextLine();

					String email;
					do {
						System.out.print("E-mail: ");
						email = sc.nextLine();
						if (!validarEmail(email)) {
							System.out.println("E-mail inválido! Tente novamente.");
						}
					} while (!validarEmail(email));

					String telefone;
					do {
						System.out.print("Telefone: ");
						telefone = sc.nextLine();
						if (!validarTelefone(telefone)) {
							System.out.println("Telefone inválido! O telefone deve conter 10 ou 11 dígitos.");
						}
					} while (!validarTelefone(telefone));

					String senha;
					do {
						System.out.print("Senha: ");
						senha = sc.nextLine();
						if (!validarSenha(senha)) {
							System.out.println("Senha inválida. A senha deve ter pelo menos 6 caracteres.");
						}
					} while (!validarSenha(senha));

					usuario = new Usuario(nome, endereco, email, telefone, senha);
					passageiro = new Passageiro(nome, endereco, email, telefone, senha);
					motorista = new Motorista(nome, endereco, email, telefone, senha);
					cadastroRealizado = true;
					System.out.println("\nCadastro realizado com sucesso!\n");
				} else {
					System.out.println("Cadastro já realizado.\n");
				}

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
								System.out.print("Passageiro(p) ou Motorista(m): ");
								tipoConta = sc.next().toLowerCase().charAt(0);
							}

							if (tipoConta == 'p') {
								if (passageiro instanceof Passageiro) {
									while (true) {
										mostrarMenuPassageiro();
										int opcaoPassageiro = sc.nextInt();

										if (opcaoPassageiro == 1) {
											System.out.println("\nBUSCAR CARONA");

											// Local: Ponto de partida
											System.out.println("\nPONTO DE PARTIDA");
											sc.nextLine();
											System.out.print("Descrição: ");
											String descricaoPartida = sc.nextLine();
											System.out.print("Digite a longitude: ");
											double longitudePartida = sc.nextDouble();
											System.out.print("Digite a latitude: ");
											double latitudePartida = sc.nextDouble();
											Local partida = new Local(descricaoPartida, longitudePartida,
													latitudePartida);

											// Local: Destino
											System.out.println("\nDESTINO");
											sc.nextLine();
											System.out.print("Descrição: ");
											String descricaoDestino = sc.nextLine();
											System.out.print("Digite a longitude: ");
											double longitudeDestino = sc.nextDouble();
											System.out.print("Digite a latitude: ");
											double latitudeDestino = sc.nextDouble();
											Local destino = new Local(descricaoDestino, longitudeDestino, latitudeDestino);										
											List<Viagem> viagens = passageiro.buscarCarona(listaDeViagens, partida, destino);
											int index = 0;
											if (viagens.size() > 0) {
												System.out.println("\nVIAGENS DISPONÍVEIS");

												for (Viagem viagem : viagens) {
													System.out.println(index + ") " + viagem.resumoViagem() + "\n");
													index++;
												}

												System.out.print("\nInsira o id para solicitar carona ou -1 para cancelar: ");
												int viagemSelecionada = sc.nextInt();
												while (viagemSelecionada > viagens.size() - 1) {
													System.out.println("\nERRO! Por favor, insira um id válido.");
													System.out.print("\nInsira o id para solicitar carona ou -1 para cancelar: ");
													viagemSelecionada = sc.nextInt();
												}
												if (viagemSelecionada != -1) {
													viagens.get(viagemSelecionada).addEspera(passageiro);
													System.out.println("Viagem solicitada ao motorista.");
												}
											} else {
												System.out.println("\nNenhuma carona encontrada.");
											}
										} else if (opcaoPassageiro == 2) {
											List<Viagem> viagensAvaliar = new ArrayList<Viagem>();
											System.out.println("\nAVALIAR VIAGEM");
											if (passageiro.getViagens().isEmpty()) {
												System.out.println(
														"Você ainda não fez nenhuma viagem e, portanto, não pode avaliar uma viagem.");
											} else {
												System.out.println("\nVIAGENS CONCLUIDAS");
												for (Viagem viagem : passageiro.getViagens()) {
													if (viagem.getProgresso() && !viagem.getPassageirosJaAvaliaram()
															.contains(passageiro)) {
														viagensAvaliar.add(viagem);
													}
												}
												int index = 0;
												for (Viagem viagem : viagensAvaliar) {
													System.out.println(index + ") " + viagem.resumoViagem());
													index++;
												}
												if (viagensAvaliar.size() > 0) {
													System.out.print("\nEntre com o ID da viagem a avaliar: ");
													int indiceViagem = sc.nextInt();
													while(indiceViagem > viagensAvaliar.size() - 1) {
														System.out.println("ERRO! Entre com um índice válido.");
														System.out.print("\nEntre com o ID da viagem a avaliar: ");
														indiceViagem = sc.nextInt();
													}
													System.out.println(viagensAvaliar.get(indiceViagem).resumoViagem());
													System.out.print("Nota [0 - 5]: ");
													int nota = sc.nextInt();
													while (nota < 0 || nota > 5) {
														System.out.println("Nota inválida.");
														System.out.print("Nota [0 - 5]: ");
														nota = sc.nextInt();
													}
													System.out.print("Comentário: ");
													sc.nextLine();
													String comentario = sc.nextLine();
													Avaliacao avaliacao = new Avaliacao(nota, comentario);
													viagensAvaliar.get(indiceViagem).addAvaliacao(avaliacao);
													viagensAvaliar.get(indiceViagem).addJaAvaliaram(passageiro);

												} else {
													System.out.println(
															"Você não possúi nenhuma para avaliar ainda.");
												}
											}
										} else if (opcaoPassageiro == 3) {
											System.out.println("\nSessão passageiro encerrada.");
											break;
										}
									}
								}
							} else if (tipoConta == 'm') {
								if (motorista instanceof Motorista) {
									while (true) {
										mostrarMenuMotorista();
										int opcaoMotorista = sc.nextInt();

										if (opcaoMotorista == 1) {
											System.out.println("\nCADASTRAR NOVA VIAGEM");
											int qtdLugares = 0;
											boolean qtdValida = false;
											while (!qtdValida) {
												try {
													System.out.print("Quantidade de lugares: ");
													qtdLugares = sc.nextInt();
													sc.nextLine();
													qtdValida = true;
												} catch (InputMismatchException err) {
													System.out.println(
															"Por favor, insira um número inteiro válido para a quantidade de lugares.");
													sc.nextLine();
												}
											}
											;

											// Local: Ponto de partida
											System.out.println("\nPONTO DE PARTIDA");
											System.out.print("Descrição: ");
											String descricaoPartida = sc.nextLine();
											System.out.print("Digite a longitude: ");
											double xPartida = sc.nextDouble();
											System.out.print("Digite a latitude: ");
											double yPartida = sc.nextDouble();
											Local partida = new Local(descricaoPartida, xPartida, yPartida);

											// Local: Destino
											System.out.println("\nDESTINO");
											sc.nextLine();
											System.out.print("Descrição: ");
											String descricaoDestino = sc.nextLine();
											System.out.print("Digite a longitude: ");
											double xDestino = sc.nextDouble();
											System.out.print("Digite a latitude: ");
											double yDestino = sc.nextDouble();
											Local destino = new Local(descricaoDestino, xDestino, yDestino);

											System.out.print("Data da viagem (dd/MM/yyyy): ");
											String data = sc.next();
											System.out.print("Preço por quilômetro: ");
											double precoPorKm = sc.nextDouble();

											Viagem viagem = new Viagem(qtdLugares, partida, destino, data, motorista,
													precoPorKm);

											// Adicionar parada no trajeto
											char addParada;
											do {
												System.out.print("Adicionar parada (s/n): ");
												addParada = sc.next().toLowerCase().charAt(0);

												if (addParada == 's') {
													sc.nextLine();
													System.out.println("\nPARADA ");
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
											viagem.addLocal(0, partida);
											viagem.addLocal(destino);
											// Como passageiro, busque a própria viagem cadastrada como motorista para testar as duas perspectivas.
											listaDeViagens.add(viagem);
											System.out.println("\nViagem cadastrada com sucesso!");
											System.out.println("\nRESUMO: " + viagem.resumoViagem());
											System.out.println(" - Preço calculado: R$" + viagem.getPreco());

										} else if (opcaoMotorista == 2) {
											System.out.println("\nCONSULTAR PASSAGEIROS");

											for (Viagem viagem : motorista.getViagens()) {
												System.out.print(viagem.resumoViagem());
												viagem.exibirProgresso();
												viagem.exibirPassageiros();

												if (viagem.getEspera().size() > 0) {
													Iterator<Passageiro> iterator = viagem.getEspera().iterator();
													while (iterator.hasNext()) {
														Passageiro solicitante = iterator.next();
														System.out.printf("\n%s está solicitando carona.",
																solicitante.getNome());
														System.out.print("\nAceitar[s/n]: ");
														char resposta = sc.next().toLowerCase().charAt(0);
														if (resposta == 's') {
															motorista.aceitarPassageiro(solicitante, viagem);
															solicitante.addViagem(viagem);
															iterator.remove();
															viagem.concluirViagem();
														} else if (resposta == 'n') {
															iterator.remove();
														}
													}
												}
											}
											if (motorista.getViagens().size() == 0) {
												System.out.println("Você não tem nenhuma viagem cadastrada.");
											}
										} else if (opcaoMotorista == 3) {
											System.out.println("\nAVALIAÇÕES");
											System.out.println("Comentarios:");
											motorista.exibirComentarios();
											System.out.println(motorista.getMediaDeAvaliacoes());
										} else if (opcaoMotorista == 4) {
											System.out.println("\nSESSÃO MOTORISTA ENCERRADA.");
											break;
										}
									}
								}
							}
							System.out.print("\nSair da conta (s/n)? ");
							char sair = sc.next().toLowerCase().charAt(0);
							while (sair != 's' && sair != 'n') {
								System.out.print("ERRO! Insira [s/n]");
								System.out.print("\nSair da conta [s/n]? ");
								sair = sc.next().toLowerCase().charAt(0);
							}
							if (sair == 's') {
								break;
							}
						}

					} else {
						System.out.println("E-mail ou senha inválidos.\n");
					}

				} else {
					System.out.println("\nCadastro ainda não realizado.\n");
				}

			} else if (opcao == 3) {
				System.out.println("\nSaindo...");
				break;
			} else {
				System.out.println("Opção inválida! Tente novamente.\n");
			}
		}

		sc.close();
	}
}
