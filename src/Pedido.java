import java.time.LocalDate;
import java.util.LinkedList;

public class Pedido {
    private static int ultimoPedido;
    private LocalDate data;
    private LinkedList<Pizza> pizzas;
    private int idPedido;
    private boolean aberto;

    public Pedido(){
        ultimoPedido++;
        data = LocalDate.now();
        pizzas = new LinkedList<>();
        idPedido = ultimoPedido;
        aberto = true;
    }

    private boolean podeAdicionar(){
        return aberto;
    }

    public int adicionarPizza(Pizza pizza){
        if(pizza != null && podeAdicionar()){
            pizzas.add(pizza);
        }
        return pizzas.size();
    }

    public void fecharPedido(){
        aberto = false;
    }

    public double precoAPagar(){
        double preco = 0d;
        for (Pizza pizza : pizzas) {
            preco += pizza.valorFinal();
        }
        return preco;
    }

    public String relatorio(){
        StringBuilder cupom = new StringBuilder();
        String estado = aberto ? "aberto" : "fechado";
        
        cupom.append( String.format("Pedido nº %d - %s (%s) com %d pizzas\n", idPedido, data, estado, pizzas.size()));
           
        for (Pizza pizza : pizzas) {
            cupom.append(String.format("----\n%s\n", 
                            pizza.gerarCupom()));
        }
        cupom.append(String.format("VALOR: R$ %.2f", 
                            precoAPagar()));

        return cupom.toString();
    }
}
