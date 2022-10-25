package br.com.fiap.challenge.model;

import javax.persistence.*;

@Entity
@Table(name= "TB_LOJA_CP3")
@SequenceGenerator(name="loja", sequenceName = "TB_LOJA", allocationSize = 1)
public class Loja{

	// ATRIBUTOS
	
	@Id
	@GeneratedValue(generator = "loja", strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="nome")
	private String nome; 
	
	@Column (name="aluguel")
	private Double aluguel;
	
	@Column(name = "id_shopping")
    private int shopping;



	// METODOS GET E SET
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getAluguel() {
		return aluguel;
	}

	public void setAluguel(Double aluguel) {
		this.aluguel = aluguel;
	}

	public int getShopping() {
		return shopping;
	}

	public void setShopping(int shopping) {
		this.shopping = shopping;
	}
	
}