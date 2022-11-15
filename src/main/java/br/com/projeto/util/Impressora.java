/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

/**
 *
 * @author jhona
 */
public class Impressora {
    
    private static Impressora instance;
    
     public static Impressora getInstance(){
         if (instance == null){
            instance = new Impressora();
         }

         return instance;
       }
    
     public void imprimir(String texto) {
        try {
            System.err.println(texto);
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

        }

    }
     
}
