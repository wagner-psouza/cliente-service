package br.com.psouza;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import br.com.psouza.entity.Cliente;
import br.com.psouza.entity.Endereco;

/**
 * Classe responsável por criar os objetos usados nos testes.
 *
 */
public class DataGenerator {

    public static Cliente buildCliente() {
        Date dataNascimento = convertToDateViaInstant(LocalDate.parse("2018-05-05"));
        return Cliente.builder()
                .id(1L)
                .nome("Fulado da Silva")
                .cpf("123.456.789-60")
                .dataNascimento(dataNascimento)
                .build();
    }

    public static Cliente buildClienteEndereco() {
        Cliente cliente = DataGenerator.buildCliente();
        Endereco endereco = Endereco.builder()
                .id(1L)
                .cidade("Campinas")
                .uf("SP")
                .numero("100")
                .rua("Teste")
                .cliente(cliente)
                .build();
        cliente.setEnderecos(Arrays.asList(endereco));
        return cliente;
    }

    private static Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
}
