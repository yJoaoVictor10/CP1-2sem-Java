package br.com.fiap.main;

import javax.swing.JOptionPane;
import br.com.fiap.bean.DragonBallSuper;
import java.io.IOException;

public class UsaDBSuper {
    public static void main(String[] args) {
        String aux, nome, KI, tecnica, velocidade, transformacao, path;
        int opcao;
        DragonBallSuper dragonBall;
        do {
            try {

                dragonBall = new DragonBallSuper();
                opcao = Integer.parseInt(JOptionPane.showInputDialog("(1) Cadastrar\n(2) Consultar"));
                path = JOptionPane.showInputDialog("Digite o caminho");

                switch (opcao){
                    case 1:
                        nome = JOptionPane.showInputDialog("Digite o nome");
                        KI = JOptionPane.showInputDialog("Digite o KI");
                        tecnica = JOptionPane.showInputDialog("Digite a quantidade de técnicas");
                        velocidade = JOptionPane.showInputDialog("Digite a velocidade");
                        transformacao = JOptionPane.showInputDialog("Digite a quantidade de transformações");
                        dragonBall.setNome(nome);
                        dragonBall.setKI(KI);
                        dragonBall.setTecnica(tecnica);
                        dragonBall.setVelocidade(velocidade);
                        dragonBall.setTransformacao(transformacao);
                        JOptionPane.showMessageDialog(null, dragonBall.gravar(path));
                        break;
                    case 2:
                        nome = JOptionPane.showInputDialog("Digite o nome");
                        dragonBall.setNome(nome);
                        dragonBall = dragonBall.ler(path);
                        if(dragonBall == null){
                            JOptionPane.showMessageDialog(null, "Caminho e/ou código informado inexistente");
                        }else{
                            JOptionPane.showMessageDialog(null,"Caminho: " + path + "\nArquivo: " + path + "/" + dragonBall.getNome() + ".txt" + "\nKI: " + dragonBall.getKI() + "\nTécnica: " + dragonBall.getTecnica() + "\nVelocidade: " + dragonBall.getVelocidade() + "\nTransformações: " + dragonBall.getTransformacao());
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Erro!");
                        break;
                }
                JOptionPane.showMessageDialog(null, "Escolha incorreta");
                }
             catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro de Conversão!\n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao Acessar Arquivo!\n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de programa");
    }
}

