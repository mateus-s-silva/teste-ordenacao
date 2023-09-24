package br.com.desafio.cartaodecredito.main;


import br.com.desafio.cartaodecredito.modelos.Cartao;
import br.com.desafio.cartaodecredito.modelos.Compra;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limite = leitura.nextDouble();

        Cartao visaQuebrado = new Cartao(limite);


        int end = 1;
        while(end != 0){

            System.out.println("Digite a descrição da compra: ");
            String descricao = leitura.next();

            System.out.println("Digite o valor da compra: ");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(descricao, valor);

            boolean compraEfetuada = visaQuebrado.lancaCompra(compra);
            if (compraEfetuada){
                System.out.println("Compra realizada!\n");
                System.out.println("Digite 0 para sair ou 1 para continuar.");
                end = leitura.nextInt();
            }
            else {
                System.out.println("SALDO INSUFICIENTE!\n");
                System.out.println("*************");
                System.out.println("COMPRAS REALIZADAS: \n");

                Collections.sort(visaQuebrado.getCompras(), new Comparator<Compra>() {
                    @Override
                    public int compare(Compra o1, Compra o2) {
                        if (o1.getValor() > o2.getValor()){
                            return 1;
                        } else if (o2.getValor() > o1.getValor()) {
                            return -1;
                        }
                        else {
                            return 0;
                        }
                    }
                });

                for(Compra compras: visaQuebrado.getCompras()){
                    System.out.println(compras);
                }
                System.out.println("\n*************");
                end = 0;
            }
        }

    }
}
