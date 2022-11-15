package br.com.projeto.model;

import br.com.projeto.model.Produto;
import br.com.projeto.model.Vendas;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-15T11:23:48", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(ItemVenda.class)
public class ItemVenda_ { 

    public static volatile SingularAttribute<ItemVenda, Vendas> venda;
    public static volatile SingularAttribute<ItemVenda, Produto> produto;
    public static volatile SingularAttribute<ItemVenda, Long> id;
    public static volatile SingularAttribute<ItemVenda, Double> subTotal;

}