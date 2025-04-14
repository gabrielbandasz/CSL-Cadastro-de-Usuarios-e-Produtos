package br.ulbra.dao;

import br.ulbra.config.ConnectionFactory;
import br.ulbra.entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutoDAO {

    public boolean salvar(Produto prod) {
        String sql = "INSERT INTO Produto (nomeprod, dataCadProd, categoriaprod, valorunitprod, quantestoqueprod) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, prod.getNomeprod());
            stmt.setString(2, prod.getDataCadProd());
            stmt.setString(3, prod.getCategoriaprod());
            stmt.setDouble(4, prod.getValorunitprod());
            stmt.setInt(5, prod.getQuantestoqueprod());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + ex.getMessage());
            return false;
        }
    }

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Produto";

        try (Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setNomeprod(rs.getString("nomeprod"));
                p.setDataCadProd(rs.getString("dataCadProd"));
                p.setCategoriaprod(rs.getString("categoriaprod"));
                p.setValorunitprod(rs.getDouble("valorunitprod"));
                p.setQuantestoqueprod(rs.getInt("quantestoqueprod"));
                lista.add(p);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + ex.getMessage());
        }

        return lista;
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM Produto WHERE idprod = ?";

        try (Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto: " + ex.getMessage());
            return false;
        }
    }

    public boolean excluirPorNome(String nome) {

        String sql = "DELETE FROM Produto WHERE nomeprod = ?";

        try (Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nome);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado com esse nome.");
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto: " + ex.getMessage());
            return false;
        }
    }

}
