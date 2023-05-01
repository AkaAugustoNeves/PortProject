package br.com.augusto.PortProject.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertService {

	public static String  convertDataFormat(Date data) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(data);		
	}
	
	public static Date convertStringToDate(String dateString) throws ParseException {
		if(dateString == "") {
			return null;
		}else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.parse(dateString);
		}
	}
	
}