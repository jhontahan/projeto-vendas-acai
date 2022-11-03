package br.com.projeto.model;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-03T13:26:27", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Long> id;
    public static volatile SingularAttribute<Produto, LocalDateTime> dataCadastro;
    public static volatile SingularAttribute<Produto, String> descricao;

}