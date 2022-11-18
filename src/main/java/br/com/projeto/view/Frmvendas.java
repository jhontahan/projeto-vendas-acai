/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.projeto.view;

import br.com.projeto.dao.ItemVendaDAO;
import br.com.projeto.dao.ProdutoDAO;
import br.com.projeto.dao.VendasDAO;
import br.com.projeto.enuns.StatusEnum;
import br.com.projeto.enuns.TipoVendaEnum;
import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.ItemVenda;
import br.com.projeto.model.Produto;
import br.com.projeto.model.Vendas;
import br.com.projeto.util.Impressora;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jhona
 */
public class Frmvendas extends javax.swing.JFrame {
    
    private Boolean modoEdicao = false;
    
    double total, preco, subTotal;
    
    Vendas vendas = new Vendas();
    
    Boolean novaVenda = false;
    
    Funcionarios funcionario = new Funcionarios();
    
    List<ItemVenda> itens = new ArrayList<>();
    
    DefaultTableModel carrinho;

    public Boolean getModoEdicao() {
        return modoEdicao;
    }

    public void setModoEdicao(Boolean modoEdicao) {
        this.modoEdicao = modoEdicao;
    }
    
    /**
     * Creates new form Frmcliente
     */
    public Frmvendas() {
        UIManager.put("OptionPane.yesButtonText", "Sim"); 
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        initComponents();
        btnSegundaVia.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbProdutos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnAddItem = new javax.swing.JButton();
        txtPreco = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrinho = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cmbTipoVenda = new javax.swing.JComboBox<>();
        txtDinheiro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAddItem1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTroco = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSegundaVia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Vendas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ponto de Vendas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da venda"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome do cliente:");

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Produto:");

        cmbProdutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbProdutos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cmbProdutosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Preço:");

        btnAddItem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAddItem.setText("Adicionar Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        txtPreco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });
        txtPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbProdutos, javax.swing.GroupLayout.Alignment.LEADING, 0, 206, Short.MAX_VALUE)
                            .addComponent(txtPreco, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnAddItem)))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddItem)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Carrinho de compras"));

        tblCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Nome cliente", "Valor"
            }
        ));
        tblCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCarrinhoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCarrinho);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Forma de pagamento:"));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Forma de pagamento:");

        cmbTipoVenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbTipoVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DINHEIRO", "PIX", "DEBITO", "CREDITO" }));

        txtDinheiro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDinheiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDinheiroKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Valor dado pelo cliente:");

        btnAddItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddItem1.setText("Calcular");
        btnAddItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbTipoVenda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddItem1)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbTipoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddItem1))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Total da Venda"));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Total da venda:");

        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTotal.setEnabled(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Troco:");

        txtTroco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTroco.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal)
                    .addComponent(txtTroco))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFinalizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFinalizar.setText("FINALIZAR VENDA");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setText("CANCELAR VENDA");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSegundaVia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSegundaVia.setText("IMPRIMIR 2 VIA");
        btnSegundaVia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSegundaViaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSegundaVia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinalizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(40, 40, 40)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnFinalizar)
                    .addComponent(btnSegundaVia))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        reset();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        //Realização da venda.
        itens = new ArrayList<>();
        BarraCarregar carregar = new BarraCarregar();
        carregar.setVisible(true);
        
        Frmvendas tela = this;
        
        Thread t = new Thread(){
            public void run(){
                
                //Setando o objeto do tipo venda.
            vendas.setNomeCliente(txtNome.getText());
            vendas.setDataVenda(new Date());
            vendas.setTotalVenda(total);
            vendas.setFormaPagamento((String) cmbTipoVenda.getSelectedItem());
            vendas.setStatus(StatusEnum.EFETIVADA.toString());
            vendas.setTipoVenda(TipoVendaEnum.RECEITA.toString());

            VendasDAO.getInstance().persist(vendas);

            //Retorna o id última venda realizada;
            vendas.setId(VendasDAO.getInstance().ultimaVenda());

            //Cadastrando os produtos na tabela itemVendas
            for(int i = 0; i < carrinho.getRowCount(); i++){
                ItemVenda item = new ItemVenda();
                Produto prod = ProdutoDAO.getInstance().getById(Long.parseLong(carrinho.getValueAt(i, 0).toString()));

                item.setVenda(vendas);
                item.setProduto(prod);
                item.setSubTotal(Double.parseDouble(carrinho.getValueAt(i, 3).toString()));

                ItemVendaDAO.getInstance().persist(item);

                itens.add(item);

            }

            Impressora.getInstance().imprimir(texto());

            carregar.setVisible(false);

            JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");

            btnFinalizar.setEnabled(false);
            btnSegundaVia.setVisible(true);
            btnCancelar.setText("NOVA VENDA");
               
                
            }
        };
        
        t.start();
        
        
        
        
        //Busca por datas.
//        try {
//            // Finalizar venda
//            
//            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//            Date data = formato.parse("11/11/2022");
//            
//            Date dataFim = formato.parse("12/11/2022");
//            
//            List<Vendas> listaProdutos = VendasDAO.getInstance().findBy(data, dataFim);
//            
//            double soma = listaProdutos.stream().mapToDouble(Vendas::getTotal_venda).sum();
//            
//            System.out.println("soma: " + soma);
//        } catch (ParseException ex) {
//            Logger.getLogger(Frmvendas.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }//GEN-LAST:event_btnFinalizarActionPerformed

    public void reset(){
        txtNome.setText("");
        txtPreco.setText("");
        txtDinheiro.setText("");
        txtTotal.setText("");
        txtTroco.setText("");
        carrinho = (DefaultTableModel) tblCarrinho.getModel();
        int quantidade = carrinho.getRowCount();
        for(int i = 0; i < quantidade; i++){
            carrinho.removeRow(0);
        }
        total = 0;
        subTotal = 0;
        
        btnSegundaVia.setVisible(false);
        btnFinalizar.setEnabled(true);
        btnCancelar.setText("CANCELAR VENDA");
        vendas = new Vendas();
        
    }
    
     public String cabecalho(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String horaAtual = formatter.format(new Date());
        
        return "             ACAI MORENA\n\r" + 
               "            Avenida principal, 10\n\r" +
               "            (98) 98832-3987\n\r" +
               "            Cnpj: 222.222.222-22\n\r" +
               "-----------------------------------------------\n\r"+
               "      IMPRESSO EM " + horaAtual + "\n\n\r"+
               "        ** NAO E DOCUMENTO FISCAL **\n\n\r" +
               "                (Pedido N.: " + vendas.getId() + ")\n\n\r";
             
    }
    
    public String texto(){
        String texto = cabecalho();
        
        if (!StringUtils.isBlank(txtNome.getText())){
            texto += "Cliente: " + txtNome.getText() + "\n\r";
        }
        else{
            texto += "Cliente: Nao Informado\n\r";
        }
        
        texto += "Forma de pagamento: " + vendas.getTipoVenda() + "\n\r";
        
        texto += "ITEM (V.UNIT)                           Total\n\r";
        
        for (ItemVenda item : itens){
            texto += item.getProduto().getDescricao() + "                                    " + item.getSubTotal()+"\n\r";
        }
        texto += "-----------------------------------------------\n\r";
        
        texto += "TOTAL A PAGAR:                          " + itens.stream().mapToDouble(ItemVenda::getSubTotal).sum() + "\n\n\r";
        
        texto += "            *Obrigado pela preferencia* \n\r"
                + "                   Volte Sempre!\n\r"
                + "-----------------------------------------------\n\r"+
                "                                    \n\r" + 
                "                                    \n\r" +
                "                                    \n\r" +
                "                                    \n\r" +
                "                                    \n\r" +
                "                                    \n\r" +
                "                                    \n\r" +
                "                                    \n\r" +
                "                                    \n\r" +
                "                                    \n\r" ;
                
        
        
        return texto;
        
    }
    
   
    
    
    private void cmbProdutosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cmbProdutosAncestorAdded
        List<Produto> listaProdutos = ProdutoDAO.getInstance().findAll();
        
        cmbProdutos.removeAll();
        
        for (Produto p : listaProdutos){
            cmbProdutos.addItem(p);
        }
        
        
    }//GEN-LAST:event_cmbProdutosAncestorAdded

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        // Adicionando ITENS no carrinho.
        if(!StringUtils.isBlank(txtPreco.getText())){
                adicionarItem();
        }
        else{
            JOptionPane.showMessageDialog(null, "Adicione um preço!");
        }
        
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void btnAddItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItem1ActionPerformed
        if(!StringUtils.isBlank(txtDinheiro.getText())){
                double troco = 0;
                troco = Double.parseDouble(txtDinheiro.getText()) - total;
                txtTroco.setText(""+troco);
        }
        else{
            JOptionPane.showMessageDialog(null, "Informe um valor.");
        }
    }//GEN-LAST:event_btnAddItem1ActionPerformed

    private void txtDinheiroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDinheiroKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            if(!StringUtils.isBlank(txtDinheiro.getText())){
                double troco = 0;
                troco = Double.parseDouble(txtDinheiro.getText()) - total;
                txtTroco.setText(""+troco);
            }
            else{
                JOptionPane.showMessageDialog(null, "Informe um valor.");
            }
        }
    }//GEN-LAST:event_txtDinheiroKeyPressed

    private void txtPrecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            if(!StringUtils.isBlank(txtPreco.getText())){
                adicionarItem();
            }
            else{
                JOptionPane.showMessageDialog(null, "Adicione um preço!");
            }
                
        }
        
    }//GEN-LAST:event_txtPrecoKeyPressed

    private void btnSegundaViaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSegundaViaActionPerformed
        this.imprimir(texto());
        
    }//GEN-LAST:event_btnSegundaViaActionPerformed

    private void tblCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCarrinhoMouseClicked
        String codigo = tblCarrinho.getValueAt(tblCarrinho.getSelectedRow(), 0).toString();
        String produto = tblCarrinho.getValueAt(tblCarrinho.getSelectedRow(), 1).toString();
        String valor = tblCarrinho.getValueAt(tblCarrinho.getSelectedRow(), 3).toString();
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja remover o item? \n" + produto + "\nValor: " + valor + "R$", "Remover item", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (opcao == 0){
            total -= Double.parseDouble(valor);
            txtTotal.setText(String.valueOf(total));
            carrinho.removeRow(tblCarrinho.getSelectedRow());
        }
        
    }//GEN-LAST:event_tblCarrinhoMouseClicked

    private void adicionarItem(){
        preco = Double.parseDouble(txtPreco.getText());
        
            subTotal = 1 * preco;

            total += subTotal;

            txtTotal.setText(String.valueOf(total));

            carrinho = (DefaultTableModel) tblCarrinho.getModel();

            Produto produto = (Produto) cmbProdutos.getSelectedItem();
            
            carrinho.addRow(new Object[]{
                produto.getId(),
                produto.getDescricao(),
                !StringUtils.isBlank(txtNome.getText()) ? txtNome.getText() : "Não informado",
                txtPreco.getText()
            });
            
            txtPreco.setText("");
    }
    
    public void imprimir(String texto) {
        try {
            
            InputStream print = new ByteArrayInputStream(texto.getBytes());
            DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

            SimpleDoc documentoTexto = new SimpleDoc(print, docFlavor, null);

            PrintService impressora = PrintServiceLookup.lookupDefaultPrintService();

            PrintRequestAttributeSet printerAttributes = new HashPrintRequestAttributeSet();
            printerAttributes.add(new JobName("Impressao", null));
            printerAttributes.add(OrientationRequested.PORTRAIT);
            printerAttributes.add(MediaSizeName.ISO_A4);

            DocPrintJob printJob = impressora.createPrintJob();

            try {
                printJob.print(documentoTexto, (PrintRequestAttributeSet) printerAttributes);
            } catch (PrintException e) {
                System.err.println(e.getMessage());
            }
            
            print.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frmvendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frmvendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frmvendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frmvendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frmvendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnAddItem1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnSegundaVia;
    private javax.swing.JComboBox<Produto> cmbProdutos;
    private javax.swing.JComboBox<String> cmbTipoVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCarrinho;
    private javax.swing.JTextField txtDinheiro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTroco;
    // End of variables declaration//GEN-END:variables
}
