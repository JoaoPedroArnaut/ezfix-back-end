package br.com.ezfix.api.util;

import br.com.ezfix.api.model.Orcamento;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class Csv {

    public static void gerarCsv(ListaObj<Orcamento> lista){
        FileWriter fileWriter = null;
        Formatter formatter = null;
        String arquivo = "orcamentos.csv";

        try{
            fileWriter = new FileWriter(arquivo, true);
            formatter = new Formatter(fileWriter);
        }catch (IOException e){
            e.printStackTrace();
        }


        try{
            for (int i = 0; i < lista.getTamanho(); i++){
                Orcamento orcamento = lista.getElemento(i);
                formatter.format("%d;%s;%.2f;%s;\n", orcamento.getId(),orcamento.getStatusGeral(),orcamento.getValorTotal(),orcamento.getSolicitante().getNome());
            }
        }catch(FormatterClosedException e){
            e.printStackTrace();
        }
        finally {
            formatter.close();
            try{
                fileWriter.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
