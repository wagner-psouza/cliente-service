
package br.com.psouza.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.psouza.entity.BaseEntity;
import br.com.psouza.exception.ObjectNotFoundException;
import br.com.psouza.exception.ParameterInvalidException;

/**
 * Serviço generico com as operações de CRUD..
 *
 * @param <T> Tipo da entidade.
 */
public abstract class GenericService<T extends BaseEntity> {

    protected JpaRepository<T, Long> repository;
    protected Class<?> clazz;

    public GenericService(JpaRepository<T, Long> repository) {
        final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        clazz = (Class<?>) type.getActualTypeArguments()[0];
        this.repository = repository;
    }

    /**
     * Inclui um novo objeto na camada de persistência.
     *
     * @param object objeto a ser incluído.
     * @return objeto incluído.
     */
    public T save(T object) {
        if (object == null)
            throw new ParameterInvalidException(String.format("Obrigatório o objeto %s para salvar.", clazz.getName()));

        return this.repository.save(object);
    }

    /**
     * Executa a atualização do objeto informado.
     *
     * @param object objeto a ser atualizado.
     * @return objeto atualizado.
     */
    public T update(T object) {
        if (object == null)
            throw new ParameterInvalidException(
                    String.format("Obrigatório o objeto %s para alterar.", clazz.getName()));

        if(!repository.findById(object.getId()).isPresent()) {
            throw new ObjectNotFoundException(String.format("Nenhum objeto foi encontrado com id %s.", object.getId()));
        }

        return this.repository.save(object);
    }

    /**
     * Executa a remoção do objeto pelo id da entidade.
     *
     * @param id objeto a ser removido .
     */
    public void delete(Long id) {
        if (id == null)
            throw new ParameterInvalidException("Para deletar é obrigatório o ID.");
        
        T object = repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(String.format("Nenhum objeto foi encontrado com id %s.", id)));

        this.repository.delete(object);
    }

    /**
     * Executa uma busca pelo id da entidade.
     *
     * @param id objeto a ser buscado.
     * @return objeto encontrado.
     */
    public T findById(Long id) {
        if (id == null)
            throw new ParameterInvalidException("Para buscar é obrigatório o ID.");

        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(String.format("Nenhum objeto foi encontrado com id %s.", id)));
    }

    /**
     * Executa uma busca trazendo todos os itens encontrados, sem paginação e sem
     * filtro.
     *
     * @return lista de objetos encontrados.
     */
    public List<T> findAll() {
        return this.repository.findAll();
    }

}
