
package br.com.psouza;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import br.com.psouza.entity.Cliente;
import br.com.psouza.exception.ObjectNotFoundException;
import br.com.psouza.exception.ParameterInvalidException;
import br.com.psouza.repository.ClienteRepository;
import br.com.psouza.service.ClienteService;

/**
 * 
 * Classe responsável por testar os metodos do serviço de cliente.
 *
 */
@RunWith(MockitoJUnitRunner.Silent.class)
@PrepareForTest(ClienteService.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;
    private ClienteService clienteService;
    private Cliente cliente;
    private Cliente clienteEndereco;

    @Before
    public void setup() {
        cliente = DataGenerator.buildCliente();
        clienteEndereco = DataGenerator.buildClienteEndereco();
        clienteService = Mockito.spy(new ClienteService(clienteRepository));
    }

    @Test(expected = ParameterInvalidException.class)
    public void test_01_deve_ser_obrigatorio_passar_um_objeto_para_salvar() {
        clienteService.save(null);
    }

    @Test
    public void test_02_deve_salvar_um_cliente_com_sucesso() {
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        clienteService.save(cliente);
        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }

    @Test
    public void test_03_deve_salvar_um_cliente_endereco_com_sucesso() {
        when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteEndereco);
        clienteService.save(clienteEndereco);
        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }

    @Test(expected = ObjectNotFoundException.class)
    public void test_04_deve_retornar_um_erro_caso_cliente_nao_exista_no_bd() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        clienteService.update(clienteEndereco);
    }

    @Test
    public void test_05_deve_alterar_um_cliente_com_sucesso() {
        when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteEndereco);
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(clienteEndereco));
        clienteService.update(clienteEndereco);
        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }

    @Test(expected = ParameterInvalidException.class)
    public void test_06_deve_ser_obrigatorio_passar_o_id_do_cliente_para_deletar() {
        clienteService.delete(null);
    }

    @Test
    public void test_07_deve_remover_um_cliente_com_sucesso() {
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(clienteEndereco));
        clienteService.delete(clienteEndereco.getId());
        verify(clienteRepository, times(1)).delete(any(Cliente.class));
    }

    @Test(expected = ObjectNotFoundException.class)
    public void test_08_deve_retornar_um_erro_caso_cliente_nao_exista_no_bd() {
        when(clienteRepository.findById(2L)).thenReturn(Optional.ofNullable(null));
        clienteService.delete(2L);
    }

}
