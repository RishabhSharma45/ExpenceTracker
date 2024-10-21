package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.User;
import com.example.entity.CityExpenses;
import com.example.service.UserService;

import ch.qos.logback.core.model.Model;


@Controller
public class HomeController {
	
	@Autowired
	UserService us;
	
	private static final Map<String, CityExpenses> cityExpensesMap = new HashMap<>();

    static {
        cityExpensesMap.put("Bangalore", new CityExpenses(0.30, 0.20, 0.10, 0.20, 0.20));
        cityExpensesMap.put("Mumbai", new CityExpenses(0.35, 0.25, 0.15, 0.15, 0.10));
        cityExpensesMap.put("Pune", new CityExpenses(0.28, 0.22, 0.12, 0.18, 0.20));
        cityExpensesMap.put("Delhi", new CityExpenses(0.32, 0.20, 0.10, 0.25, 0.13));
        cityExpensesMap.put("Chennai", new CityExpenses(0.30, 0.20, 0.10, 0.20, 0.20));
        cityExpensesMap.put("Kolkata", new CityExpenses(0.25, 0.20, 0.15, 0.20, 0.20));
        cityExpensesMap.put("Hyderabad", new CityExpenses(0.30, 0.20, 0.10, 0.20, 0.20));
        cityExpensesMap.put("Indore", new CityExpenses(0.20, 0.15, 0.10, 0.25, 0.30));
        cityExpensesMap.put("Ahmedabad", new CityExpenses(0.25, 0.20, 0.15, 0.20, 0.20));
    }
	
	@GetMapping("/home")
	public String Home(Map<String , Object> model) {
		List<User> users = us.getUser();
		model.put("users", users);
		return "home";
	}
	
	@GetMapping("/city-selection.html")
	public String citySelection() {
		return "city-selection";
	}
	
	@GetMapping("/city-selection")
	public String citySelectionbBack() {
		return "city-selection";
	}
	
	@GetMapping("/salary-input")
    public String salaryInput(@RequestParam String city, Map<String , Object> map) {
        map.put("city", city);
        return "salaryInput"; // returns the salaryInput.html
    }

	@PostMapping("/calculate-expenses")
    public String calculateExpenses(@RequestParam String city, @RequestParam double salary, Map<String, Object> model) {
        CityExpenses expenses = cityExpensesMap.get(city);

        // Evaluate if the salary is sufficient
        double rent = salary * expenses.getRentPercentage();
        double food = salary * expenses.getFoodPercentage();
        double entertainment = salary * expenses.getEntertainmentPercentage();
        double savings = salary * expenses.getSavingsPercentage();
        double others = salary * expenses.getOthersPercentage();

        double totalExpenses = rent + food + entertainment + savings + others;

        // Determine if the salary is sufficient
        String sufficiencyMessage;
        if (totalExpenses > salary) {
            sufficiencyMessage = "Your salary is not sufficient to cover the living expenses in " + city + ".";
        } else {
            sufficiencyMessage = "Your salary is sufficient to cover the living expenses in " + city + ".";
        }

        // Adding data to the model
        model.put("city", city);
        model.put("salary", salary);
        model.put("rent", rent);
        model.put("food", food);
        model.put("entertainment", entertainment);
        model.put("savings", savings);
        model.put("others", others);
        model.put("sufficiencyMessage", sufficiencyMessage);

        return "expenseResults"; // returns the expenseResults.html
    }
}

