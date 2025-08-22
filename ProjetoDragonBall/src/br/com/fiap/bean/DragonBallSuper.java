package br.com.fiap.bean;

import java.io.*;

public class DragonBallSuper implements IDBSuper{
    private String nome;
    private String KI;
    private String tecnica;
    private String velocidade;
    private String transformacao;

    public DragonBallSuper(){

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getKI() {
        return KI;
    }

    public void setKI(String KI) {
        this.KI = KI;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(String velocidade) {
        this.velocidade = velocidade;
    }

    public String getTransformacao() {
        return transformacao;
    }

    public void setTransformacao(String transformacao) {
        this.transformacao = transformacao;
    }


    public DragonBallSuper ler(String path)throws IOException{
        BufferedReader br = new BufferedReader(
            new FileReader(path + "/" + nome + ".txt"));
        nome = br.readLine();
        tecnica = br.readLine();
        velocidade = br.readLine();
        transformacao = br.readLine();
        br.close();
        return this;
    }


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

        }catch (IOException e){
            return "Falha ao gravar o arquivo: " + e.getMessage();
        }

    }
}
