package br.edu.ifs.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormataData {

	public static SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	public static Date toSqlDate(String strData) throws ParseException {
		java.util.Date data = formatador.parse(strData);  
		return new Date( data.getTime() );
	}
	public static String toString(Date sqlData) {
		String strData = formatador.format(sqlData);  
		return strData;
	}
	
}
