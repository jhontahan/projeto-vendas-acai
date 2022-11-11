package br.com.projeto.model;

import br.com.projeto.model.ItemVenda;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-11T09:57:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Vendas.class)
public class Vendas_ { 

    public static volatile SingularAttribute<Vendas, Date> dataVenda;
    public static volatile ListAttribute<Vendas, ItemVenda> itensVenda;
    public static volatile SingularAttribute<Vendas, Double> total_venda;
    public static volatile SingularAttribute<Vendas, Long> id;
    public static volatile SingularAttribute<Vendas, String> nomeCliente;
    public static volatile SingularAttribute<Vendas, String> tipo_venda;

}