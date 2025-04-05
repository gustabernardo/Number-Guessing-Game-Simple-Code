package gameadivinhação;

import java.util.Scanner;

public class GameAdivinhação {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        boolean jogarNovamente = true;

        while (jogarNovamente) {
            //Classes
            int escolha = 0;
            int chances = 0;
            int numeroSecreto = (int) (Math.random() * 101);

            //Menu
            System.out.printf("Bem vindo ao jogo de adivinhação\n");
            Thread.sleep(700);
            System.out.printf("Descubra o numero escondido entre 0 a 100 números\n");
            Thread.sleep(700);
            System.out.printf("Por favor, selecione a dificuldade:\n");
            Thread.sleep(700);

            System.out.printf("1. Fácil(10 chances)\n");
            Thread.sleep(400);

            System.out.printf("2. Médio(5 chances)\n");
            Thread.sleep(400);

            System.out.printf("3. Difícil(3 chances)\n");
            Thread.sleep(400);

            System.out.printf("Escolha a dificuldade: (1,2 ou 3)\n");
            Thread.sleep(400);

            escolha = sc.nextInt();

            //dificuldades
            if (escolha == 1) {
                chances = 10;
            } else if (escolha == 2) {
                chances = 5;
            } else if (escolha == 3) {
                chances = 3;
            } else {
                System.out.printf("Opção inválida! Definindo como fácil...\n");
                chances = 10;
            }

            System.out.printf("Ótimo, escolheu " + chances + " chances!\n");
            Thread.sleep(400);
            System.out.printf("--- Vamos Começar ---\n");
            Thread.sleep(400);

            boolean acertou = false;
            int tentativasUsadas = 0;
            
            // loop das tentivas
            for (int i = 0; i < chances; i++) {
                System.out.println("Escolha um número:");
                int palpite = sc.nextInt();

                if (palpite == numeroSecreto) {
                    System.out.println("Parabéns! Voce acertou. \n");
                    System.out.println("Você acertou em " + (i + 1) + " tentativa(s)!\n");
                    acertou = true;
                    break;
                } else if (palpite < numeroSecreto) {
                    System.out.println("O numero é maior, tente novamente");

                    Thread.sleep(400);
                } else {
                    System.out.println("O numero é menor, tente novamente");
                }
                Thread.sleep(400);

                System.out.println("❤️ Chances restantes: " + (chances - i - 1));

                Thread.sleep(400);

            }

            Thread.sleep(400);
            //Mensagem se perdeu
            if (!acertou) {
                System.out.println("💥Você Perdeu! O numero correto era : " + numeroSecreto);
                Thread.sleep(400);
            }
            //Pergunta se quer jogar de novo
            System.out.print("\nDeseja jogar novamente? (s/n): ");
            char resposta = sc.next().toLowerCase().charAt(0);
            jogarNovamente = (resposta == 's');
            System.out.println();
            //Fim do jogo
            if (!jogarNovamente) {
                System.out.println("👋 Obrigado por jogar! Até a próxima!");
            }
        }
    }
}
