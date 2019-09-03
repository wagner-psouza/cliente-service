package br.com.psouza.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Endereco implements BaseEntity {

    /**
     * Serial Version ID.
     */
    private static final long serialVersionUID = -6094217140995077140L;

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "endereco_seq", sequenceName = "endereco_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "endereco_seq")
    private Long id;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "uf", nullable = false)
    private String uf;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
