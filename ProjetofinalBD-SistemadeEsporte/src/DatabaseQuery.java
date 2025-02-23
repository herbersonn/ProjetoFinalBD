import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseQuery {

    public static void insertData() {
        // Conecta ao banco e cria um scanner para coletar dados do usuário
        try (Connection connection = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            // Solicita os dados ao usuário
            System.out.print("Digite o ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            System.out.print("Digite o título: ");
            String titulos = scanner.nextLine();

            System.out.print("Digite a cor: ");
            String cor = scanner.nextLine();

            // Define o comando SQL para inserir os dados
            String insertQuery = "INSERT INTO Fortaleza (id, titulos, cores) VALUES (?, ?, ?)";

            // Prepara a instrução e define os valores nos parâmetros
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, titulos);
                preparedStatement.setString(3, cor);

                // Executa a inserção
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Dados inseridos com sucesso!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }
    }

    public static void selectData() {
        String query = "SELECT * FROM Fortaleza";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Título: " + resultSet.getString("titulos"));
                System.out.println("Cor: " + resultSet.getString("cores"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao realizar consulta: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Chama o método para inserir dados
        insertData();

        // Chama o método para exibir os dados
        selectData();
    }
}
