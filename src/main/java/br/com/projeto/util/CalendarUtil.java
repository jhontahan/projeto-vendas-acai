/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.util;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author jhonathan.cruz
 */
public class CalendarUtil {
    /**
    * Retorna um objeto Calendar configurado
    * para a data informada por parâmetro e
    * com a parte da hora zerada.
    * Caso a data informada por parâmetro seja
    * null, usa a data e hora atuais como
    * parâmetro.
    * 
    * @param dataHora
    * @return
    */
   public static Calendar getDateOnly(Date dataHora) {
           Calendar apenasData = Calendar.getInstance();
           if (dataHora != null) {
                   apenasData.setTime(dataHora);
           }

           apenasData.set(Calendar.HOUR_OF_DAY, 0);
           apenasData.set(Calendar.MINUTE, 0);
           apenasData.set(Calendar.SECOND, 0);
           apenasData.set(Calendar.MILLISECOND, 0);

           return apenasData;
   }

   /**
    * Retorna um objeto Calendar juntando informações de data de um objeto com as informações de
    * hora de outro.
    * 
    * @param data
    *        data (dia, mês e ano) desejada para o objeto data retornado.
    * @param hora
    *        hora desejada para o objeto retornado.
    * @return
    */
   public static Calendar joinDateWithTime(Date data, LocalTime hora) {
           Calendar c = Calendar.getInstance();
           c.setTime(data);

           c.set(Calendar.HOUR_OF_DAY, hora.getHour());
           c.set(Calendar.MINUTE, hora.getMinute());
           c.set(Calendar.SECOND, hora.getSecond());
           c.set(Calendar.MILLISECOND, 0);

           return c;
   }

   /**
    * Retorna a quantidade de dias entre duas datas.
    * 
    * @param dataInicio
    * @param dataFim
    * @return
    */
   public static long getDaysBetween(Date dataInicio, Date dataFim) {
           return TimeUnit.DAYS.convert(
                   dataFim.getTime() - dataInicio.getTime(), TimeUnit.MILLISECONDS
           );
   }

   /**
    * Indica se a data informada corresponde ao dia atual.
    * 
    * @param data
    * @return
    */
   public static boolean isHoje(Date data) {
           Calendar dataInformada = getDateOnly(data);
           Calendar hoje = getDateOnly(new Date());

           return hoje.equals(dataInformada);
   }

   /**
    * Retorna uma data situada em um prazo de 1 ano da data atual.
    * 
    * No que diz respeito à hora, pode retornar o prazo em 1 ano da hora atual
    * ou considerar apenas o dia - com a hora configurada para o fim do dia (23h59min59s).
    * 
    * @param ateFinalDoDia
    * 		Especifica se a data deve considerar um prazo até o fim do dia, com a hora-prazo
    * 		configurada para 23h59min59s ou se será usada a mesma hora da data atual no prazo
    *		de 1 ano.
    * @return
    * 		objeto {@link Date} representando a data final do prazo de 1 ano contado da
    * 		data atual.
    */
   public static Date getDataPrazoEmUmAno(boolean ateFinalDoDia) {
           Calendar dataEmUmAno = Calendar.getInstance();
           dataEmUmAno.roll(Calendar.YEAR, 1);
           if (ateFinalDoDia) {
                   dataEmUmAno.set(Calendar.HOUR_OF_DAY, 23);
                   dataEmUmAno.set(Calendar.MINUTE, 59);
                   dataEmUmAno.set(Calendar.SECOND, 59);
           }
           return dataEmUmAno.getTime();
   }
}
