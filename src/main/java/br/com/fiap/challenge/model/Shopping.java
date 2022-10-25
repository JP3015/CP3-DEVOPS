package br.com.fiap.challenge.model;


import javax.persistence.*;

@Entity
@Table(name= "TB_SHOPPING_CP3")
@SequenceGenerator(name="shopping", sequenceName = "TB_SHOPPING", allocationSize = 1)
public class Shopping {

	// ATRIBUTOS
	
	@Id
	@GeneratedValue(generator = "shopping", strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column (name="nm_shopping")
    private String nm_shopping;
	
    @Column (name="endereco")
    private String endereco;



	// METODOS GET E SET
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNm_shopping() {
        return nm_shopping;
    }

    public void setNm_shopping(String nm_shopping) {
        this.nm_shopping = nm_shopping;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
}