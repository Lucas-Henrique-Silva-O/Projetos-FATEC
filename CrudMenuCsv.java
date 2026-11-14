import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrudMenuCsv {
    //Cria ou indica um arquivo na pasta chamado "usuarios.csv"
    private static final String filePath = "usuarios.csv";

    public static void main(String[] args) {
        //As opções disponíveis ao usuário para manipular a base de dados
        while (true) {
            String[] options = {"Adicionar", "Listar", "Atualizar", "Remover", "Sair"};
            int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); //Exibe as opções em janelas interativas

            //Um switch para as opções disponíveis ao usuário para manipular a base de dados
            switch (choice) {
                case 0 -> adicionarRegistro();
                case 1 -> listarRegistros();
                case 2 -> atualizarRegistro();
                case 3 -> removerRegistro();
                case 4 -> {
                    JOptionPane.showMessageDialog(null, "FIM!");
                    System.exit(0);
                }
                default -> JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }

    //Essa função adiciona usuários com seus campos à base de dados
    private static void adicionarRegistro() {
        String telefone = JOptionPane.showInputDialog("Digite o telefone: ");
        String cep = JOptionPane.showInputDialog("Digite o CEP: ");
        String cpf = JOptionPane.showInputDialog("Digite o CPF: ");
        String email = JOptionPane.showInputDialog("Digite o email: ");
        String senha = JOptionPane.showInputDialog("Digite a senha: ");

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(telefone).append(";").append(cep).append(";").append(cpf).append(";").append(email).append(";").append(senha).append("\n");
            JOptionPane.showMessageDialog(null, "Registro adicionado com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar no arquivo.");
            e.printStackTrace();
        }
    }

    //Essa função lista os usuários com seus dados a partir da base de dados
    private static void listarRegistros() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder registros = new StringBuilder("Registros:\n");
            String linha;
            while ((linha = reader.readLine()) != null) {
                registros.append(linha).append("\n");
            }
            JOptionPane.showMessageDialog(null, registros.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }

    //Essa função atualiza e altera registros da base de dados a partir do telefone
    private static void atualizarRegistro() {
        List<String> registros = lerRegistros();
        if (registros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado.");
            return;
        }

        String telefoneBusca = JOptionPane.showInputDialog("Digite o telefone a ser alterado:");
        boolean encontrado = false;
        for (int i = 0; i < registros.size(); i++) {
            String[] dados = registros.get(i).split(";");
            if (dados[0].equalsIgnoreCase(telefoneBusca)) {
                String novoTelefone = JOptionPane.showInputDialog("Digite o novo telefone:", dados[0]);
                String novoCep = JOptionPane.showInputDialog("Digite o novo CEP:", dados[1]);
                String novoCpf = JOptionPane.showInputDialog("Digite o novo CPF:", dados[2]);
                String novoEmail = JOptionPane.showInputDialog("Digite o novo email: ", dados[3]);
                String novoSenha = JOptionPane.showInputDialog("Digite a nova senha: ", dados[4]);
                registros.set(i, novoTelefone + ";" + novoCep + ";" + novoCpf + ";" + novoEmail + ";" + novoSenha);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            escreverRegistros(registros);
            JOptionPane.showMessageDialog(null, "Registro atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Registro não encontrado.");
        }
    }

    //Essa função remove/deleta registros da base de dados a partir do telefone
    private static void removerRegistro() {
        List<String> registros = lerRegistros();
        if (registros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado.");
            return;
        }

        String telefoneBusca = JOptionPane.showInputDialog("Digite o telefone que será deletado:");
        boolean encontrado = registros.removeIf(registro -> registro.split(";")[0].equalsIgnoreCase(telefoneBusca));

        if (encontrado) {
            escreverRegistros(registros);
            JOptionPane.showMessageDialog(null, "Registro removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Registro não encontrado.");
        }
    }

    private static List<String> lerRegistros() {
        List<String> registros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                registros.add(linha);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo.");
            e.printStackTrace();
        }
        return registros;
    }

    private static void escreverRegistros(List<String> registros) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String registro : registros) {
                writer.append(registro).append("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }
}
