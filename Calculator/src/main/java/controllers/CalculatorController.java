package controllers;

import models.OperationalModel;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CalculateSimple;

@Controller
public class CalculatorController {


    OperationalModel operationalModel = new OperationalModel();

    @Autowired
    private CalculateSimple calculateSimple;

    @RequestMapping ("/calculator")
    public String getCalculatorPage(Model model){
        model.addAttribute("operationalModel", operationalModel);
        return "calculator";
    }

    @RequestMapping (value = "/calculator",params = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute ("operationalModel") OperationalModel operationalModel, Model model ){
        model.addAttribute("result",calculateSimple.add(operationalModel));
        return "calculator";
    }
    @RequestMapping(value="/calculator", params="subtract", method = RequestMethod.POST)
    public String subtract(@ModelAttribute("operationModel")  OperationalModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.subtract(operationalModel));
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="multiply", method = RequestMethod.POST)
    public String multiply(@ModelAttribute("operationModel")  OperationalModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.multiply(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="divide", method = RequestMethod.POST)
    public String divide(@ModelAttribute("operationModel")  OperationalModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.divide(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="sqrt", method = RequestMethod.POST)
    public String sqrt(@ModelAttribute("operationModel")  OperationalModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.sqrt(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="power", method = RequestMethod.POST)
    public String power(@ModelAttribute("operationModel")  OperationalModel operationModel, Model model ) {
        model.addAttribute("result", calculateSimple.power(operationModel));
        return "calculator";
    }
    @RequestMapping(value="/calculator", params="clearSimple", method = RequestMethod.POST)
    public String clearSimple(@ModelAttribute("operationModel")  OperationalModel operationModel, Model model ){
        model.addAttribute("operationModel",  calculateSimple.clearSimple(operationModel));
        model.addAttribute("result", 0);
        return "calculator";
    }
    @RequestMapping(value="/calculator", params="clearAdvanced", method = RequestMethod.POST)
    public String clearAdvanced(@ModelAttribute("operationModel")  OperationalModel operationModel, Model model ){
        model.addAttribute("operationModel",  calculateSimple.clearAdvanced(operationModel));
        model.addAttribute("result", 0);
        return "calculator";
    }
}
