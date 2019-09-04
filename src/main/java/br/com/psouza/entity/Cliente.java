package br.com.psouza.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements BaseEntity {

    /**
     * Serial Version ID.
     */
    private static final long serialVersionUID = 5607228541939938276L;

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cliente_seq")
    private Long id;

    @NotBlank
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotBlank
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente", orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Endereco> enderecos;

}
