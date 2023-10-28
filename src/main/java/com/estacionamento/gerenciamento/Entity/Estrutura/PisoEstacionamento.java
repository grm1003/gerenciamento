package com.estacionamento.gerenciamento.Entity.Estrutura;

import com.estacionamento.gerenciamento.Entity.Fabrica.Carro;

public class PisoEstacionamento {
    private String nome;
   private  Vaga[] vagas;
   public int tamanhoEstacionamento(){
       return vagas.length;
   }
   public PisoEstacionamento(String nome,int numVagas) {
       this.nome = nome;
       vagas = new Vaga[numVagas];
       for (int i = 0; i < vagas.length; i++) {
           vagas[i] = new Vaga(true, null);
       }
   }
   public void PreencheVaga(int vaga, Carro carro){
       for (int i = 0; i<vagas.length;i++) {
           if(i == vaga && vagas[i].isVazia()){
              vagas[i].setVazia(false);
              vagas[i].setCarro(carro);

           }else throw new IllegalArgumentException("Vaga já está preenchida!");
       }
   }

    public void LiberaVaga(int vaga, Carro carro){
        for (int i = 0; i<vagas.length;i++) {
            if(i == vaga && !vagas[i].isVazia()){
                vagas[i].setVazia(true);
                vagas[i].setCarro(null);
            }else throw new IllegalArgumentException("Vaga já vazia!");
        }
    }

    public int ContaVagasDisponiveis(){
       int vazias = 0;
        for (Vaga vaga : vagas) {
            if (vaga.isVazia()) vazias += 1;
        }
       return vazias;
    }

    public boolean EstaCheio(){
        return ContaVagasDisponiveis() == 0;
    }


}
