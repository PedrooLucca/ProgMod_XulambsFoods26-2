import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PizzaTest {

    Pizza pizza;
    int ingredientesPadrao;

    @BeforeEach
    public void setup() {
        ingredientesPadrao = 4;
        pizza = new Pizza(ingredientesPadrao);
    }

    @Test
    public void adicionaIngredientesCorretamente(){
        //Act
        int quantos = pizza.adicionarIngredientes(4);

        //Assert
        assertEquals(8, quantos);
    }
    
    @Test
    public void calculaValorDaPizzaComAdicionais(){
        double valor = pizza.valorFinal();
        assertEquals(49, valor, 0.01);
    }

    @Test
    public void calculaValorDaPizzaSemAdicionais(){
        Pizza pizza = new Pizza();
        double valor = pizza.valorFinal();
        assertEquals(29, valor, 0.01);
    }

    @Test
    public void cupomContemDetalhamento(){
        String cupom = pizza.gerarCupom();

        assertTrue(
            cupom.contains("4 ingredientes") &&
            cupom.contains("29,00") &&
            cupom.contains("20,00") &&
            cupom.contains("49,00")
        );
    }
}
