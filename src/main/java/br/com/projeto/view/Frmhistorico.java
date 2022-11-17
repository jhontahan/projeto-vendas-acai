/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.projeto.view;

import br.com.projeto.dao.ItemVendaDAO;
import br.com.projeto.dao.VendasDAO;
import br.com.projeto.enuns.StatusEnum;
import br.com.projeto.enuns.TipoVendaEnum;
import br.com.projeto.model.ItemVenda;
import br.com.projeto.model.Vendas;
import br.com.projeto.util.Impressora;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jhona
 */
public class Frmhistorico extends javax.swing.JFrame {

     Double receita = 0.0;
     Double despesas = 0.0;
     Double total = 0.0;
     List<Vendas> vendas = new ArrayList<>();
    
    
    /**
     * Creates new form Frmhistorico
     */
    public Frmhistorico() {
        initComponents();
        btnRelatorio.setVisible(false);
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
        txtDataInicial = new javax.swing.JFormattedTextField();
        txtDataFinal = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbStatusVenda = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbmTipoVenda = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorico = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de Vendas");

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Histórico de Vendas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta por data"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Data Inicial:");

        try {
            txtDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataInicial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        try {
            txtDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataFinal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDataFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDataFinalKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Data Final:");

        btnPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Staus de Venda:");

        cmbStatusVenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbStatusVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção", "EFETIVADA", "CANCELADA" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tipo de Venda:");

        cbmTipoVenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbmTipoVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção", "RECEITA", "DESPESA" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbmTipoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbStatusVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(btnPesquisar)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbStatusVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbmTipoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPesquisar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tblHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data da Venda", "Cliente", "Observações", "Forma de Pagamento", "Tipo de Venda", "Status da Venda", "Total da Venda"
            }
        ));
        tblHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistoricoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHistorico);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Total:");

        lblTotal.setText("0");

        btnRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRelatorio.setText("IMPRIMIR RELATÓRIO");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRelatorio)
                .addGap(283, 283, 283)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTotal)
                    .addComponent(btnRelatorio))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       //Recbendo as datas
//        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Date dataInicio = null;  
        Date dataFinal = null;
        try {
            dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(txtDataInicial.getText());
            dataFinal = new SimpleDateFormat("dd/MM/yyyy").parse(txtDataFinal.getText()); 
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Informe a data inicial e a data final.");
            return;
        }
         
//        Date dataFinal = (Date) formato.parse(txtDataInicial.getText());

        String status = (String) cmbStatusVenda.getSelectedItem();
        String tipo = (String) cbmTipoVenda.getSelectedItem();
        
        if (status.equals("Selecione uma opção")){
            status = null;
        }
        if (tipo.equals("Selecione uma opção")){
            tipo = null;
        }
        
        
        vendas = VendasDAO.getInstance().findBy(dataInicio, dataFinal, status, tipo);
        
        if (vendas.isEmpty()){
          JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado!");
          return;
        }
        
        List<Vendas> vendasReceitas = vendas.stream()
                                      .filter(venda -> 
                                             venda.getTipoVenda().equals(TipoVendaEnum.RECEITA.toString()))
                                      .filter(venda ->
                                             venda.getStatus().equals(StatusEnum.EFETIVADA.toString()))
                                      .collect(Collectors.toList());
        
        List<Vendas> vendasDespesas = vendas.stream()
                                      .filter(venda -> 
                                             venda.getTipoVenda().equals(TipoVendaEnum.DESPESA.toString()))
                                      .filter(venda ->
                                             venda.getStatus().equals(StatusEnum.EFETIVADA.toString()))
                                      .collect(Collectors.toList());
        
//        List<Vendas> vendasReceitas = VendasDAO.getInstance().
//                                      findBy(dataInicio, dataFinal, 
//                                      status, tipo);
//        
//        List<Vendas> vendasDespesas = VendasDAO.getInstance().
//                                      findBy(dataInicio, dataFinal, 
//                                      status, tipo);
        
        receita = vendasReceitas.stream().mapToDouble(Vendas::getTotalVenda).sum();
        despesas = vendasDespesas.stream().mapToDouble(Vendas::getTotalVenda).sum();
        total = receita - despesas;
        
        DefaultTableModel historico = (DefaultTableModel) tblHistorico.getModel();
        historico.setNumRows(0);
        
        for (Vendas v : vendas){
            //String dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format((TemporalAccessor) v.getDataVenda());
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            historico.addRow(new Object[]{
                v.getId(),
                dateFormat.format(v.getDataVenda()),
                !StringUtils.isBlank(v.getNomeCliente()) ? v.getNomeCliente() : "Não informado",
                v.getObservacoes(),
                v.getFormaPagamento(),
                v.getTipoVenda(),
                v.getStatus(),
                v.getTotalVenda()
            });
        }
        
        lblTotal.setText("" + total);
        btnRelatorio.setVisible(true);
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tblHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistoricoMouseClicked
        //Opções para detalhar ou cancelar a venda.
        Object[] options = { "Detalhar", "Cancelar venda", "Impimir 2 Via", "Sair" };
        int opcao = JOptionPane.showOptionDialog(null, "Sobre a venda", "Venda", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
       
        //Detalhar venda
        if(opcao == 0){
            Frmdetalhe telaDetalhe = new Frmdetalhe();
            //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
            String observacao;
            
            if (tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 3) != null 
                    && !StringUtils.isBlank(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 3).toString())){
                observacao = tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 3).toString();
            }
            else{
                observacao = "";
            }
            
            telaDetalhe.lblNome.setText(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 2).toString());
            telaDetalhe.lblData.setText(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 1).toString());
            telaDetalhe.lblTotal.setText(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 7).toString());
            telaDetalhe.lblPagamento.setText(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 4).toString());
            telaDetalhe.lblStatus.setText(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 6).toString());
            telaDetalhe.txtObservacoes.setText(observacao);
            
            Long id = Long.parseLong(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 0).toString());
            
            List<ItemVenda> itens = ItemVendaDAO.getInstance().findBy(id);
            
            DefaultTableModel dados = (DefaultTableModel) telaDetalhe.tblItens.getModel();
            dados.setNumRows(0);

            for (ItemVenda v : itens){
                //String dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format((TemporalAccessor) v.getDataVenda());
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                dados.addRow(new Object[]{
                    v.getProduto().getDescricao(),
                    !StringUtils.isBlank(v.getVenda().getNomeCliente()) ? v.getVenda().getNomeCliente() : "Não informado",
                    v.getSubTotal()
                });
            }
            
            
            telaDetalhe.setVisible(true);
            
        }
        //Cancelar venda
        if (opcao == 1){
            try {
                Vendas v = new Vendas();
                
                Long id = Long.parseLong(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 0).toString());
                v.setId(id);
                v.setDataVenda(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 1).toString()));
                v.setNomeCliente(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 2).toString());
                v.setFormaPagamento(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 3).toString());
                v.setTipoVenda(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 4).toString());
                v.setStatus(StatusEnum.CANCELADA.toString());
                v.setTotalVenda(Double.parseDouble(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 6).toString()));
                
                VendasDAO.getInstance().merge(v);
                
                btnPesquisarActionPerformed(null);
                
            } catch (ParseException ex) {
                Logger.getLogger(Frmhistorico.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        //Imprimir segunda via
        if (opcao == 2){
            Long id = Long.parseLong(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 0).toString());
            Vendas venda = VendasDAO.getInstance().getById(id);
            
            Impressora.getInstance().imprimir(texto2via(venda));
        }
        
        
    }//GEN-LAST:event_tblHistoricoMouseClicked

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        Impressora.getInstance().imprimir(texto());
        
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void txtDataFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataFinalKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            btnPesquisarActionPerformed(null);
        }
        
        
    }//GEN-LAST:event_txtDataFinalKeyPressed

    public String cabecalho(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String horaAtual = formatter.format(new Date());
        
        return "             ACAI MORENA\n\r" + 
               "            Avenida principal, 10\n\r" +
               "            (98) 98832-3987\n\r" +
               "            Cnpj: 222.222.222-22\n\r" +
               "-----------------------------------------------\n\r"+
               "      IMPRESSO EM " + horaAtual + "\n\n\r"+
               "  Relatorio de (" + txtDataInicial.getText() + ") a (" + txtDataFinal.getText() + ")\n\n\r";
             
    }
    
    public String texto(){
        String texto = cabecalho();
        
        texto += "VALOR DAS RECEITAS: " + receita + "\n\n\r";
        texto += "VALOR DAS DESPESAS: " + despesas + "\n\n\r";
        texto += "VALOR RESTANTE: " + total + "\n\n\r";
        
        texto +="-----------------------------------------------\n\r"+
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
    
    public String cabecalho2via(Vendas vendas){
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
    
    public String texto2via(Vendas venda){
        String texto = cabecalho2via(venda);
        
        if (!StringUtils.isBlank(venda.getNomeCliente())){
            texto += "Cliente: " + venda.getNomeCliente() + "\n\r";
        }
        else{
            texto += "Cliente: Nao Informado\n\r";
        }
        
        texto += "Forma de pagamento: " + venda.getFormaPagamento() + "\n\r";
        
        texto += "ITEM (V.UNIT)                           Total\n\r";
        
        
        ItemVenda itemVenda = new ItemVenda();
            
        Long id = Long.parseLong(tblHistorico.getValueAt(tblHistorico.getSelectedRow(), 0).toString());

        List<ItemVenda> itens = ItemVendaDAO.getInstance().findBy(id);
        
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
            java.util.logging.Logger.getLogger(Frmhistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frmhistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frmhistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frmhistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frmhistorico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JComboBox<String> cbmTipoVenda;
    private javax.swing.JComboBox<String> cmbStatusVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblHistorico;
    private javax.swing.JFormattedTextField txtDataFinal;
    private javax.swing.JFormattedTextField txtDataInicial;
    // End of variables declaration//GEN-END:variables
}
