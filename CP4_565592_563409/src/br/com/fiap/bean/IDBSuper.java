//Nome: André Emygdio Ferreira | RM: 565592
//Nome: João Victor Nascimento Adão | RM: 563409

package br.com.fiap.bean;

import java.io.IOException;

/**
 * Interface para operações de leitura e gravação de dados do personagem de Dragon Ball Super
 * @author João Victor, André Emygdio
 * @version 1.0
 */

public interface IDBSuper {
    /**
     * Lê os dados do personagem a partir de um arquivo
     * @author João Victor, André Emygdio
     * @param path - caminho a ser informado
     * @return DragonBallSuper
     * @throws IOException
     */
    public DragonBallSuper ler(String path)throws IOException;

    /**
     * Grava os dados do personagem em um arquivo
     * @author João Victor, André Emygdio
     * @param path - caminho a ser informado
     * @return String
     */
    public String gravar(String path);
}