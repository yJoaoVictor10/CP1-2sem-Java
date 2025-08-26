//Nome: André Emygdio Ferreira | RM: 565592
//Nome: João Victor Nascimento Adão | RM: 563409

package br.com.fiap.main;



import javax.swing.JOptionPane;
import br.com.fiap.bean.DragonBallSuper;
import java.io.IOException;

/**
 * Classe principal de execução do programa, permite cadastro ou consulta de dados de personagens de Dragon Ball Super
 * @author João Victor, André Emygdio
 * @version 1.0
 */
public class UsaDBSuper {
    public static void main(String[] args) {
        String path, nome;
        int opcao, KI, tecnica, velocidade, transformacao;
        DragonBallSuper dragonBall;
        do {
            try {

                dragonBall = new DragonBallSuper();
                opcao = Integer.parseInt(JOptionPane.showInputDialog("(1) Cadastrar\n(2) Consultar"));
                path = JOptionPane.showInputDialog("Digite o caminho");

                switch (opcao){
                    case 1:
                        nome = JOptionPane.showInputDialog("Digite o nome");
                        KI = Integer.parseInt(JOptionPane.showInputDialog("Digite o KI"));
                        tecnica = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de técnicas"));
                        velocidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a velocidade"));
                        transformacao = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de transformações"));

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
                            JOptionPane.showMessageDialog(null,
                                    "Caminho: " + path +
                                            "\nArquivo: " + path + "/" + dragonBall.getNome() + ".txt" +
                                            "\nKI: " + dragonBall.getKI() +
                                            "\nTécnica: " + dragonBall.getTecnica() +
                                            "\nVelocidade: " + dragonBall.getVelocidade() +
                                            "\nTransformações: " + dragonBall.getTransformacao()
                            );
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha incorreta!");
                        break;
                }
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

