import java.util.Scanner;



/*
 * @Lucas as regras para o cadastro
RN001: O sistema deve permitir a confirmação de cadastro apenas se todos os campos do formulário estiverem preenchidos. 

RN002: O sistema só deve aceitar o cadastro com CPFs ou CNPJs que são válidos no sistema nacional. 

RN003: O sistema só deve aceitar o cadastro com uma senha que tenha 8 caracteres sendo obrigatório 1 letra maiúscula e minúscula, 1 número e 1 caractere especial. 

RN004: O sistema deve apenas aceitar o cadastro com CEP válidos. 

RN005: O sistema deve permitir o cadastro de telefones que constam o DDD do estado de São Paulo. 

RN006: O sistema só deve permitir o cadastro com e-mail que consta no final gmail.com ou hotmail.com ou outlook.com.

 */


public class Cadastro {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Digite o seu telefone: ");
        String telefone = reader.nextLine().trim();
        
        String regexTelefone = "1[1-9]9[0-9]{4}-?[0-9]{4}";
        
        while (true) {
            if (telefone.matches(regexTelefone)){
                System.out.println("Telefone válido!");
                break;
            } else{
                System.out.println("Telefone inválido!");
                System.out.println("Digite o seu telefone novamente: ");
                telefone = reader.nextLine().trim();
            }
        }
        
        System.out.println("Digite o seu CEP: ");
        String cep = reader.nextLine().trim();
        
        String regexCep = "[0-9]{5}-?[0-9]{3}";
        
        while (true) {
            if(cep.matches(regexCep)){
                System.out.println("CEP válido!");
                break;
            } else{
                System.out.println("CEP inválido!");
                System.out.println("Insira o seu CEP novamente: ");
                cep = reader.nextLine().trim();
            }
        }

        System.out.print("Digite seu CPF: ");
        String cpf = reader.nextLine().trim();

        // TODO: Criar a regex para o cpf
        String regexCpf = "[0-9]{11}"; 
        
        

        while (true){
            if (cpf.matches(regexCpf)) {
            System.out.println("CPF válido!");
            break;
        } else {
            System.out.println("CPF inválido!");
            System.out.print("Digite seu CPF novamente: ");
            cpf = reader.nextLine().trim();
           }
        }

        System.out.print("Digite seu CNPJ: ");
        System.out.println("Caso não deseje inserir o CNPJ, digite N!");
        String cnpj = reader.nextLine().toUpperCase().trim();

        // TODO: Criar a regex para o CNPJ
        String regexCnpjn = "[0-9A-Z]{12}[0-9]{2}"; 
        
        while (true) {
            if (cnpj.matches(regexCnpjn)) {
            System.out.println("CNPJ válido!");
            break;
        } else if (cnpj.equals("N")) {
                System.out.println("Você escolheu não inserir o CNPJ!");
                break;
        
        } else {
            System.out.println("CNPJ inválido!");
            System.out.print("Digite seu CNPJ novamente: ");
            cnpj = reader.nextLine().toUpperCase().trim();
            }
            
            
        }
        
        
        System.out.println("Digite o seu email: ");
        String email = reader.nextLine().trim();
        
        String regexEmail = "^[-A-Za-z\\d._%+-]+@(gmail\\.com|hotmail\\.com|outlook\\.com)$";
        
        while (true) {
            if(email.matches(regexEmail)){
                System.out.println("Email válido");
                break;
            } else{
                System.out.println("Email inválido");
                System.out.println("Digite o seu email novamente: ");
                email = reader.nextLine().trim();
            }
        }
        System.out.println("Digite sua senha: ");
        String senha = reader.nextLine().trim();
        
        String regexSenha = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[!@$%*?&])[A-Za-z\\d!@%*?&]{8,}$";
        
        while (true) {
            if(senha.matches(regexSenha)){
                System.out.println("Senha válida!");
                break;
            } else{
                System.out.println("Senha inválida!");
                System.out.println("Digite a sua senha novamente: ");
                senha = reader.nextLine().trim();
            }
        }

        

        reader.close();
    }
}