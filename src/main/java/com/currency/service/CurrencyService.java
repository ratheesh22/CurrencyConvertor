package com.currency.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CurrencyService {
	private static final String currency="AED-United Arab Emirates Dirham,AMD-Armenian Dram,"
			+ "ANG-Netherlands Antillean Guilder,ARS-Argentine Peso,AUD-Australian Dollar,"
			+ "BAM-Bosnia-Herzegovina Convertible Mark,BDT-Bangladeshi Taka,BGN-Bulgarian Lev,"
			+ "BHD-Bahraini Dinar,BND-Brunei Dollar,BOB-Bolivian Boliviano,BRL-Brazilian Real,"
			+ "BWP-Botswanan Pula,BYN-Belarusian Ruble,CAD-Canadian Dollar,CHF-Swiss Franc,"
			+ "CLP-Chilean Peso,CNY-Chinese Yuan,COP-Colombian Peso,CRC-Costa Rican Colón,"
			+ "CZK-Czech Koruna,DKK-Danish Krone,DOP-Dominican Peso,DZD-Algerian Dinar,"
			+ "EGP-Egyptian Pound,EUR-Euro,FJD-Fijian Dollar,GBP-British Pound Sterling,"
			+ "GEL-Georgian Lari,GHS-Ghanaian Cedi,HKD-Hong Kong Dollar,"
			+ "HRK-Croatian Kuna,HUF-Hungarian Forint,IDR-Indonesian Rupiah,ILS-Israeli New Sheqel,"
			+ "INR-Indian Rupee,IQD-Iraqi Dinar,ISK-Icelandic Króna,JMD-Jamaican Dollar,JOD-Jordanian Dinar,"
			+ "JPY-Japanese Yen,KES-Kenyan Shilling,KRW-South Korean Won,KWD-Kuwaiti Dinar,"
			+ "KZT-Kazakhstani Tenge,LAK-Laotian Kip,LBP-Lebanese Pound,LKR-Sri Lankan Rupee,"
			+ "LTL-Lithuanian Litas,MAD-Moroccan Dirham,MMK-Myanma Kyat,MOP-Macanese Pataca,"
			+ "MUR-Mauritian Rupee,MXN-Mexican Peso,MYR-Malaysian Ringgit,NAD-Namibian Dollar,"
			+ "NGN-Nigerian Naira,NIO-Nicaraguan Córdoba,NOK-Norwegian Krone,NPR-Nepalese Rupee,"
			+ "NZD-New Zealand Dollar,OMR-Omani Rial,PAB-Panamanian Balboa,PEN-Peruvian Nuevo Sol,"
			+ "PHP-Philippine Peso,PKR-Pakistani Rupee,PLN-Polish Zloty,PYG-Paraguayan Guarani,QAR-Qatari Rial,"
			+ "RON-Romanian Leu,RSD-Serbian Dinar,RUB-Russian Ruble,SAR-Saudi Riyal,SEK-Swedish Krona,"
			+ "SGD-Singapore Dollar,SVC-Salvadoran Colón,THB-Thai Baht,TND-Tunisian Dinar,"
			+ "TRY-Turkish Lira,TWD-New Taiwan Dollar,TZS-Tanzanian Shilling,UAH-Ukrainian Hryvnia,"
			+ "UGX-Ugandan Shilling,USD-US Dollar,UYU-Uruguayan Peso,UZS-Uzbekistan Som,"
			+ "VEF-Venezuelan Bolívar (2008-2018),VES-Venezuelan Bolívar,VND-Vietnamese Dong,"
			+ "XCD-East Caribbean Dollar,XOF-CFA Franc BCEAO,XPF-CFP Franc,ZAR-South African Rand";
	
	public List<String> getCurrencies()
	{
		String[] array=currency.split(",");
		List<String> list=new ArrayList<String>();
		list=Arrays.asList(array);
		return list;
	}
	
	public Object sendAPIcall(long amount,String from,String to)
	{
		String url="https://api.api-ninjas.com/v1/convertcurrency?have="+
					from.substring(0, 3)
					+"&want="+
					to.substring(0, 3)
					+"&amount="+
					amount;
		RestTemplate restTemplate=new RestTemplate();
		Object object=restTemplate.getForObject(url,Object.class);
		return object;
	}

}
