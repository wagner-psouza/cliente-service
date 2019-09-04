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

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Tolerate;

@Data
@Builder
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
    @CPF
    @Column(name = "cpf", nullable = false, unique = true)
    
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    @ApiModelProperty(example = "10/01/2019", notes = "O formato da data deve ser dd/MM/yyyy")
    private Date dataNascimento;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente", orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Endereco> enderecos;
    
    @Tolerate
    public Cliente() {
        super();
    }

}
