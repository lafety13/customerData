package ua.goit.customerdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.customerdata.model.Customer;
import ua.goit.customerdata.model.Type;
import ua.goit.customerdata.service.CustomerService;

import java.util.Arrays;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("listCustomer", customerService.findAll());
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("lisType", Arrays.asList(Type.values()));

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer add(@RequestBody Customer customer) {
        if (customer.getId() != null) {
            customerService.update(customer);
        }

        return customer;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("lisType", Arrays.asList(Type.values()));
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("listCustomer", customerService.findAll());

        return "index";
    }

}
