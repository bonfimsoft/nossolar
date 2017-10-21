package br.com.bonfimsoft.nossolar.view.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.format.Formatter;

public class CalendarFormatter implements Formatter<Calendar> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public String print(Calendar calendar, Locale locale) {
		return this.dateFormat.format(calendar.getTime());
	}

	@Override
	public Calendar parse(String data, Locale locale) throws ParseException {
		Calendar c = null;
		if((data != null) && !data.equals("")){
			c = Calendar.getInstance(locale);
			c.setTime(this.dateFormat.parse(data));
		}
		return c;
	}

}
