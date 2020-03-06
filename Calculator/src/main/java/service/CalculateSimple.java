package service;

import org.springframework.stereotype.Service;
import models.OperationalModel;

@Service
public class CalculateSimple {

    public int add(OperationalModel model){
        return model.getA() + model.getB();
    }

    public int subtract(OperationalModel model){
        return model.getA() - model.getB();
    }

    public int multiply(OperationalModel model){
        return model.getA() * model.getB();
    }

    public double divide(OperationalModel model){
        if(model.getA() == 0) return 0;
        if(model.getB() == 0) return 0;
        return (double) model.getA() / model.getB();
    }



    public double sqrt(OperationalModel model){
        return Math.sqrt(model.getC());
    }

    public int power(OperationalModel model){
        return model.getC() * model.getC();
    }

    public OperationalModel clearSimple(OperationalModel model){
        model.setA(0);
        model.setB(0);
        return model;
    }

    public OperationalModel clearAdvanced(OperationalModel model){
        model.setC(0);
        return model;
    }
}
