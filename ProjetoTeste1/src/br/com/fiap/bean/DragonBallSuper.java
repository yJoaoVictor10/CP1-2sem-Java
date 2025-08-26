//Nome: André Emygdio Ferreira | RM: 565592
//Nome: João Victor Nascimento Adão | RM: 563409

package br.com.fiap.bean;

import java.io.*;

/** Classe que representa um personagem de Dragon Ball Super com atributos de poder, implementando IDBSuper
 * @author João Victor, André Emygdio
 * @version 1.0
 *
 */

public class DragonBallSuper implements IDBSuper{
    private String nome;
    private int KI;
    private int tecnica;
    private int velocidade;
    private int transformacao;


    public DragonBallSuper(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getKI() {
        return KI;
    }

    public void setKI(int KI) {
        this.KI = KI;
    }

    public int getTecnica() {
        return tecnica;
    }

    public void setTecnica(int tecnica) {
        this.tecnica = tecnica;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getTransformacao() {
        return transformacao;
    }

    public void setTransformacao(int transformacao) {
        this.transformacao = transformacao;
    }


    /**
     * Método ler que permite ler um dados de um arquivo .txt com base no caminho informado
     * @author João Victor, André Emygdio
     * @param path - caminho a ser informado
     * @return DragonBallSuper
     * @throws IOException (IOException)
     */
    public DragonBallSuper ler(String path)throws IOException{
        BufferedReader br = new BufferedReader(
                new FileReader(path + "/" + nome + ".txt"));
        nome = br.readLine();
        KI = Integer.parseInt(br.readLine());
        tecnica = Integer.parseInt(br.readLine());
        velocidade = Integer.parseInt(br.readLine());
        transformacao = Integer.parseInt(br.readLine());
        br.close();
        return this;
    }


    /**
     * Método gravar que permite gravar dados escritos pelo usuário em um arquivo .txt com base no caminho informado,
     * se não existir o caminho informado, o programa cria.
     * @author João Victor, André Emygdio
     * @param path - caminho a ser informado
     * @return String
     */
    public String gravar(String path) {
        try {
            File dir = new File(path);
            if(!dir.exists()){
                dir.mkdir();
            }
            PrintWriter pw = new PrintWriter(path + "/" + nome + ".txt");
            pw.println(nome);
            pw.println(KI);
            pw.println(tecnica);
            pw.println(velocidade);
            pw.println(transformacao);
            pw.close();
            return "Arquivo gravado com sucesso";
        } catch (IOException e){
            return "Falha ao gravar o arquivo: " + e.getMessage();
        }
    }

}
