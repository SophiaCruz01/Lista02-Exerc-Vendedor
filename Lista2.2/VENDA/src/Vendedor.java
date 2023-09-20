import java.util.Scanner;

public class Vendedor {
    private int codigo;
    private String nome;
    private double percentualComissao;

    public Vendedor() {
    }

    public Vendedor(int codigo, String nome, double percentualComissao) {
        this.codigo = codigo;
        this.nome = nome;
        this.percentualComissao = percentualComissao;
    }

    public double calcularPagamentoComissao(double valorVenda) {
        return valorVenda * percentualComissao / 100;
    }

    public double calcularPagamentoComissao(double valorVenda, double desconto) {
        return calcularPagamentoComissao(valorVenda) - desconto;
    }

    public String imprimir(double valorVenda, double desconto) {
        double valorComissao = calcularPagamentoComissao(valorVenda);
        double valorAPagar = valorComissao - desconto;

        String info = "Codigo: " + codigo + "\n";
        info += "Nome: " + nome + "\n";
        info += "Valor Venda: " + valorVenda + "\n";
        info += "% Comissão: " + percentualComissao + "\n";
        info += "Desconto: " + desconto + "\n";
        info += "Valor a Pagar: " + valorAPagar + "\n";
        return info;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vendedor vendedor = null;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar Vendedor");
            System.out.println("2 - Calcular venda");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Código: ");
                    int codigo = scanner.nextInt();
                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("Percentual de Comissão: ");
                    double percentualComissao = scanner.nextDouble();

                    vendedor = new Vendedor(codigo, nome, percentualComissao);
                    System.out.println("Vendedor cadastrado com sucesso!");
                    break;
                case 2:
                    if (vendedor != null) {
                        System.out.print("Valor da Venda: ");
                        double valorVenda = scanner.nextDouble();
                        System.out.print("Desconto: ");
                        double desconto = scanner.nextDouble();

                        String resultado = vendedor.imprimir(valorVenda, desconto);
                        System.out.println(resultado);
                    } else {
                        System.out.println("Nenhum vendedor cadastrado ainda.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
