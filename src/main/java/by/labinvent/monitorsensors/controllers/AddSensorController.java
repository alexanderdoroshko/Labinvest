package by.labinvent.monitorsensors.controllers;

import by.labinvent.monitorsensors.exceptions.ControllerException;
import by.labinvent.monitorsensors.repository.entity.Sensor;
import by.labinvent.monitorsensors.service.SensorsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/add/sensor")
public class AddSensorController {
    private final SensorsService sensorsService;

    public AddSensorController(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @GetMapping
    public ModelAndView getAddSensorPage() throws ControllerException {

        Sensor sensor = new Sensor();
        ModelMap model = new ModelMap();
        model.addAttribute("sensor", sensor);

        return new ModelAndView("addsensor", model);
    }


    @PostMapping("/new")
    public String addNewSensor(@ModelAttribute("sensor") @Valid Sensor sensor, BindingResult bindingResult, ModelAndView modelAndView)
            throws ControllerException {
        if (bindingResult.hasErrors()) {
            return "addsensor";
        }
        sensorsService.create(sensor);
        return "addsensor";
    }

}

