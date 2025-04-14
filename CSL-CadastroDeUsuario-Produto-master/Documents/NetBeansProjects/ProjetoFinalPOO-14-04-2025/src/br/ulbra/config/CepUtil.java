
package br.ulbra.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.google.gson.*;


public class CepUtil {
    private static final String URL_VIACEP = "https://viacep.com.br/ws/";

    public static String buscarEnderecoPorCep(String cep) {
        try {
            URL url = new URL(URL_VIACEP + cep + "/json/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000); // Tempo limite para conexão
            conn.setReadTimeout(5000); // Tempo limite para resposta

            if (conn.getResponseCode() != 200) {
                JOptionPane.showMessageDialog(null, "Erro ao conectar na API. Código: " + conn.getResponseCode());
                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String linha;
            while ((linha = br.readLine()) != null) {
                response.append(linha);
            }
            br.close();

            String json = response.toString();

            // Verifica se o JSON contém erro
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

            if (jsonObject.has("erro") && jsonObject.get("erro").getAsBoolean()) {
                JOptionPane.showMessageDialog(null, "CEP não encontrado!");
                return null;
            }

            return json;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
        }
    }

    public static EnderecoCompleto converterJsonParaEndereco(String json) {
        if (json == null || json.isEmpty()) {
            return null;
        }
        
        Gson gson = new Gson();
        return gson.fromJson(json, EnderecoCompleto.class);
    }

   public static void consultarEnderecoPorCEP(String cep, JTextField txtLogradouro, JTextField txtBairro, JTextField txtCidade, JTextField txtEstado) {
    String json = buscarEnderecoPorCep(cep);

    if (json != null) {
        EnderecoCompleto endereco = converterJsonParaEndereco(json);

        if (endereco != null) {
            txtLogradouro.setText(endereco.logradouro);
            txtBairro.setText(endereco.bairro);
            txtCidade.setText(endereco.localidade);
            txtEstado.setText(endereco.uf);
            
        }
    }
}


    public static class EnderecoCompleto {

        public String cep;
        public String logradouro;
        public String bairro;
        public String localidade;
        public String uf;

        @Override
        public String toString() {
            return "CEP: " + cep + "\nLogradouro: " + logradouro + "\nBairro: " + bairro + "\nLocalidade: " + localidade + "\nUF: " + uf;
        }
    }
    
   
}
