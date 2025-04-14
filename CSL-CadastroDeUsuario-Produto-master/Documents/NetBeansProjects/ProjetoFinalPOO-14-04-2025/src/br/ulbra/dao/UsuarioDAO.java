package br.ulbra.dao;

import br.ulbra.config.ConnectionFactory;
import br.ulbra.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    private Connection con;

    public UsuarioDAO() throws SQLException {
        con = new ConnectionFactory().getConnection();
    }

    // Método para validar o login (email e senha)
    public boolean validarLogin(String email, String senha) {

        String sql = "SELECT * FROM usuario WHERE emailusu = ? AND senhausu = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // Substituindo os parâmetros na consulta SQL
            stmt.setString(1, email);
            stmt.setString(2, senha);

            // Executa a consulta
            ResultSet rs = stmt.executeQuery();

            // Se encontrar algum usuário com o email e a senha fornecidos
            if (rs.next()) {
                // O login foi bem-sucedido
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Se não encontrar o usuário, o login falha
        return false;
    }

    // Método para cadastrar um novo usuário no banco de dados
    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nomeusu, emailusu, senhausu, foneusu, cpfusu, cepusu, logradourousu, numerousu, bairrousu, cidadeusu, estadousu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNomeusu());
            stmt.setString(2, usuario.getEmailusu());
            stmt.setString(3, usuario.getSenhausu());
            stmt.setString(4, usuario.getFoneusu());
            stmt.setString(5, usuario.getCpfusu());
            stmt.setString(6, usuario.getCepusu());
            stmt.setString(7, usuario.getLogradourousu());
            stmt.setString(8, usuario.getNumerousu());
            stmt.setString(9, usuario.getBairrousu());
            stmt.setString(10, usuario.getCidadeusu());
            stmt.setString(11, usuario.getEstadousu());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + ex.getMessage());
        }

    }
// Validação de CPF

    public boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int soma = 0, peso = 10;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }
            int digito1 = 11 - (soma % 11);
            if (digito1 > 9) {
                digito1 = 0;
            }

            soma = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }
            int digito2 = 11 - (soma % 11);
            if (digito2 > 9) {
                digito2 = 0;
            }

            return cpf.charAt(9) - '0' == digito1 && cpf.charAt(10) - '0' == digito2;
        } catch (Exception e) {
            return false;
        }

    }
}
