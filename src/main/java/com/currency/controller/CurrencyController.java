package com.currency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.currency.service.CurrencyService;

@Controller
public class CurrencyController {
	@Autowired
	private CurrencyService currencyService;
	
	@RequestMapping("/currency")
	public String viewCurrencies(Model model)
	{
		model.addAttribute("dropdownItems", currencyService.getCurrencies());
		
		return "allCurrencies";
	}
	
	@GetMapping("/currencyResponse")
	public String convertCurrency(@RequestParam("amount") long amount, @RequestParam("have") String have,
			@RequestParam("want") String want,Model model)
	{
		model.addAttribute("dropdownItems", currencyService.getCurrencies());
		model.addAttribute("object", currencyService.sendAPIcall(amount, have, want));
		
		return "allCurrencies";
	}

}
