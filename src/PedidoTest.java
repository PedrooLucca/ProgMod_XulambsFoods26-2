import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    Pedido pedido;
    Pizza pizzaVazia;
    Pizza pizzaDoisIngredientes;

    @BeforeEach
    public void setup(){
        pizzaVazia = new Pizza();
        pizzaDoisIngredientes = new Pizza(2);
        pedido = new Pedido();
        pedido.adicionarPizza(pizzaDoisIngredientes);
    }


    @Test
    public void naoAdicionaPizzaEmPedidoFechado(){
        //Arrange
        pedido.adicionarPizza(pizzaVazia);
        pedido.fecharPedido();

        //Act
        int quantidade = pedido.adicionarPizza(pizzaVazia);
    
        //Assert
        assertEquals(2, quantidade);
    }

    @Test
    public void adicionaPizzaEmPedidoAberto(){
        //Arrange
        pedido.adicionarPizza(pizzaVazia);

        //Act
        int quantidade = pedido.adicionarPizza(pizzaVazia);
    
        //Assert
        assertEquals(3, quantidade);
    }

    @Test 
    public void verificaValorAPagar(){
        pedido.adicionarPizza(pizzaVazia);
        pedido.adicionarPizza(pizzaVazia);
        pedido.adicionarPizza(pizzaDoisIngredientes);

        double valor = pedido.precoAPagar();

        assertEquals(136.00, valor, 0.001);
    }

    @Test 
    public void verificarRelatorio(){
        pedido.adicionarPizza(pizzaDoisIngredientes);
        String relatorio = pedido.relatorio();
        String valor =  String.valueOf(pedido.precoAPagar());
        valor = valor.replace(".", ",");

        assertTrue(
            relatorio.contains(valor) &&
            relatorio.contains("2 pizzas")
        );

    }
}
