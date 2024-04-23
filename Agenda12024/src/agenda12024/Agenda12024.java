
package agenda12024;

/**
 *
 * @author 2830482221022
 */
public class Agenda12024 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BancoDeDados bancodedados = new BancoDeDados();
        
                     bancodedados.conectar(); //acessando um metodo dentro da classe conectar
                     bancodedados.listar();
                     //bancodedados.inserir();

                     bancodedados.inserirAtributo("Nala", "nala@gmail.com", "119985684931");
                     
                     bancodedados.listar();
                     bancodedados.alterar();                                     
                     
                     bancodedados.listar();
                     bancodedados.apagar();
                                        
                     bancodedados.listar();
                     bancodedados.desconectar();
    }   
}
