
package agenda12024;

import java.sql.DriverManager; //
import java.sql.Connection; //
import java.sql.Statement; //criar um estado de espeirito, interação entre lingaugem e o vbahnco de dados
import java.sql.ResultSet; //Insere e recupera

/**
 *
 * @author 2830482221022 - Samuel Ramos dos Santos
 */
public class BancoDeDados {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null; // resultado da seleção, do que foi inserido no banco  


    public void conectar(){
        String servidor = "jdbc:mysql://localhost:3306/Agenda";//endereço completo do banco----qual é o banco/qual é a porta/nome do banco
        String usuario = "root";
        String senha = "root";
        String driver = "com.mysql.cj.jdbc.Driver";//aqui faz toda a interação com o banco
        
        try{
            Class.forName(driver); //acessar a classe pelo nome Driver
            this.connection = DriverManager.getConnection(servidor, usuario, senha);
            this.statement = this.connection.createStatement();
            System.out.println("Conectado");
        }
        catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public void desconectar(){
        try{
            this.connection.close();
            System.out.println("Desconectado do banco com sucesso");
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());        
        } 
    }
    
       public void inserir(){
        try{
            String query = "INSERT INTO `agenda`.`cadastro` (`nome`, `email`, `telefone`) VALUES ('Luna ', 'luna@gmail.com ', '119975789865');";
            System.out.println(query);
            this.statement.execute(query);
            System.out.println("Inserido com sucesso no DB!");
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());        
        } 
    }
       
       public void inserirAtributo(String nome, String email, String telefone){
        try{
            String query = "INSERT INTO `agenda`.`cadastro` (`nome`, `email`, `telefone`) VALUES ('" + nome +"','" + email +"','" + telefone +"');";
            System.out.println(query);
            this.statement.execute(query);
            System.out.println("Inserido com sucesso no DB!");
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());        
        } 
    }
       
       public void listar(){
        try{
            String query = "select*from Agenda.cadastro order by id asc";
            System.out.println(query);
            this.resultset = this.statement.executeQuery(query);
            while(this.resultset.next()){//next é o indice: exemplo: 1,2,3,4....
                System.out.println("ID: " + this.resultset.getString("id") + 
                                   " NOME: " + this.resultset.getString("nome") + 
                                   "E-MAIL: " + this.resultset.getString("email") + 
                                   " TELEFONE: " + this.resultset.getString("telefone"));
            }                     
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());        
        }       
    }       
       
       public void apagar(){
            try{
                String query = "delete from `agenda`.`cadastro` where (`id` = '16');";
                System.out.println(query);
                this.statement.execute(query);
            } catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        } 
       
       public void alterar(){
           try{
                String query = "update `agenda`.`cadastro` set `nome` = 'Levi', `email` = 'levi@gmail.com',`telefone` = '11956482573' where (`id` = 5);";
                System.out.println(query);
                this.statement.executeUpdate(query);
            } catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
       }
}
