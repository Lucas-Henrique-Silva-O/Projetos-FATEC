/*
 * @Lucas as regras para o cadastro
RN001: O sistema deve permitir a confirmação de cadastro apenas se todos os campos do formulário estiverem preenchidos. 

RN002: O sistema só deve aceitar o cadastro com CPFs ou CNPJs que são válidos no sistema nacional. 

RN003: O sistema só deve aceitar o cadastro com uma senha que tenha 8 caracteres sendo obrigatório 1 letra maiúscula e minúscula, 1 número e 1 caractere especial. 

RN004: O sistema deve apenas aceitar o cadastro com CEP válidos. 

RN005: O sistema deve permitir o cadastro de telefones que constam o DDD do estado de São Paulo. 

RN006: O sistema só deve permitir o cadastro com e-mail que consta no final gmail.com ou hotmail.com ou outlook.com.

 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

public class CsvPopulator {

    //Cria o arquivo "usuarios.csv"
    private static final String filePath = "usuarios.csv";
    //Valores para gerar 60 usuários para preencher ou popular o arquivo gerado
    private static final String[] telefones = {
        "(11) 91234-5678", "(11) 98765-4321", "(12) 99123-4567", "(12) 98111-2233", "(13) 97401-9988", 
        "(13) 99654-3210", "(14) 99876-5432", "(14) 98123-8899", "(15) 99102-0304", "(15) 97234-5678", 
        "(16) 99345-6789", "(16) 98877-6655", "(17) 99567-8901", "(17) 97112-2334", 
        "(18) 99789-0123", "(18) 98990-0112", "(19) 99012-3456", "(19) 97554-4332", "(11) 96123-4567", 
        "(11) 95432-1098", "(12) 96876-5432", "(12) 97100-2030", "(13) 96543-2109", "(13) 98800-1122", 
        "(14) 96210-9876", "(14) 99334-4556", "(15) 96789-0123", "(15) 98223-3445", "(16) 96456-7890", 
        "(16) 99445-5667", "(17) 96012-3456", "(17) 98667-7889", "(18) 96901-2345", "(18) 99221-1009", 
        "(19) 96345-6789", "(19) 98543-2100", "(11) 94001-0022", "(11) 93210-9876", "(12) 94556-6778", 
        "(13) 93667-7889", "(14) 94778-8990", "(15) 93889-9001", "(16) 94990-0112", "(17) 93112-2334", 
        "(18) 94223-3445", "(19) 93334-4556", "(11) 92111-0000", "(12) 92222-1111", "(13) 92333-2222", 
        "(19) 92999-8888"
    };
    private static final String[] ceps = {
        "01001-000", "01002-000", "01010-000", "01020-000", "01030-000", "01040-000", "01050-000", "01101-000", 
        "01102-000", "01110-000", "01201-000", "01202-000", "01210-000", "01301-000", "01302-000", "01310-000", 
        "01401-000", "01402-000", "01410-000", "01501-000", "02001-000", "02002-000", "02010-000", "02101-000", 
        "02201-000", "03001-000", "03002-000", "03010-000", "03101-000", "03201-000", "04001-000", "04002-000", 
        "04010-000", "04101-000", "04201-000", "05001-000", "05002-000", "05010-000", "05101-000", "05201-000", 
        "08001-000", "08002-000", "08010-000", "08101-000", "08201-000", "09001-000", "09002-000", "09010-000", 
        "09101-000", "09201-000"
    };    
    private static final String[] cpfs = {
        "11144477735", "22255588846", "33366699957", "44477700068", "55588811179", "66699922280", 
        "77700033391", "88811144402", "99922255513", "00033366624", "12345678909", "98765432100", 
        "23456789017", "87654321098", "34567890125", "76543210987", "45678901233", "65432109876", 
        "56789012341", "54321098765", "11223344556", "22334455667", "33445566778", "44556677889", 
        "55667788990", "66778899001", "77889900112", "88990011223", "99001122334", "00112233445", 
        "10293847560", "20394857670", "30495867780", "40596877890", "50697887900", "60798897010", 
        "70899807120", "80900817230", "90011827340", "01122837450", "13579246801", "24680135792", 
        "35791357933", "46802468044", "57913579155", "68024680266", "79135791377", "80246802488", 
        "91357913599", "02468024600"
    };

    private static final String[] emails = {
        "usuario1@gmail.com", "cliente2@hotmail.com", "contato3@outlook.com", "dev4@gmail.com", 
        "teste5@hotmail.com", "admin6@outlook.com", "suporte7@gmail.com", "vendas8@hotmail.com", 
        "financeiro9@outlook.com", "marcos10@gmail.com", "ana.silva11@hotmail.com", 
        "carla.souza12@outlook.com", "lucas.oliveira13@gmail.com", "mariana.santos14@hotmail.com", 
        "pedro.costa15@outlook.com", "juliana.lima16@gmail.com", "rodrigo.alves17@hotmail.com", 
        "fernanda.pereira18@outlook.com", "gabriel.rodrigues19@gmail.com", "camila.ferreira20@hotmail.com", 
        "bruno.gomes21@outlook.com", "beatriz.martins22@gmail.com", "thiago.barbosa23@hotmail.com", 
        "larissa.ribeiro24@outlook.com", "diego.carvalho25@gmail.com", "amanda.melo26@hotmail.com", 
        "rafael.cardoso27@outlook.com", "leticia.teixeira28@gmail.com", "gustavo.marques29@hotmail.com", 
        "patricia.mendes30@outlook.com", "felipe.ramos31@gmail.com", "vanessa.nascimento32@hotmail.com", 
        "vinicius.lima33@outlook.com", "natalia.araujo34@gmail.com", "eduardo.ribeiro35@hotmail.com", 
        "jessica.almeida36@outlook.com", "leonardo.lopes37@gmail.com", "aline.machado38@hotmail.com", 
        "mateus.gomes39@outlook.com", "monique.freitas40@gmail.com", "renato.cardoso41@hotmail.com", 
        "sabrina.dias42@outlook.com", "victor.moreira43@gmail.com", "tania.nunes44@hotmail.com", 
        "samuel.vieira45@outlook.com", "priscila.correia46@gmail.com", "daniel.santana47@hotmail.com", 
        "carolina.moraes48@outlook.com", "caio.tavares49@gmail.com", "bianca.farias50@hotmail.com"
    };

    private static final String[] senhas = {
        "Senha@12", "Teste#34", "System$56", "Java%78", "Code&90", "Admin!12", "User#56", "Segredo$78", 
        "Pass@90", "Senha#2026", "Teste!abc", "Alpha$123", "Beta#456", "Gamma%789", "Delta&111", "Echo@222", 
        "Foxtrot#333", "Golf$444", "Hotel%555", "India&666", "Juliett@777", "Kilo#888", "Lima$999", 
        "Mike%101", "November&202", "Oscar@303", "Papa#404", "Quebec$505", "Romeo%606", "Sierra&707", 
        "Tango@808", "Uniform#909", "Victor$123", "Whiskey%234", "Xray&345", "Yankee@456", "Zulu#567", 
        "Code$678", "Dev%789", "Script&890", "Token@135", "Key#246", "Access$357", "Login%468", "User&579", 
        "Pass@680", "System#791", "Admin$802", "Root%913", "Safe&024"
    };

    public static void popularArquivoCsv() {
        Random random = new Random();

        //Estrutura para escrever no arquivo os registros gerados de forma pseudoaleatória

        try (FileWriter writer = new FileWriter(filePath, true)) {
            for (int i = 0; i < 60; i++) {
                String telefone = telefones[random.nextInt(telefones.length)]+ ";" +ceps[random.nextInt(ceps.length)] + ";" +emails[random.nextInt(emails.length)] + ";" + senhas[random.nextInt(senhas.length)];
                
                
                String cpf = cpfs[random.nextInt(cpfs.length)];

                writer.append(telefone).append(";").append(cpf).append("\n");
            }
            JOptionPane.showMessageDialog(null, "60 registros aleatórios adicionados com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar no arquivo.");
            e.printStackTrace();
        }
    }
    // A função para popular o arquivo (inserir os registros gerados) é acionada
    public static void main(String[] args) {
        popularArquivoCsv();
    }
}
