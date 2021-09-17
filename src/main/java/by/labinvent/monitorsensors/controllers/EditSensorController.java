package by.labinvent.monitorsensors.controllers;

import by.labinvent.monitorsensors.exceptions.ControllerException;
import by.labinvent.monitorsensors.repository.entity.Sensor;
import by.labinvent.monitorsensors.service.SensorsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/edit/sensor")
public class EditSensorController {
    private final SensorsService sensorsService;

    public EditSensorController(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @GetMapping
    public ModelAndView getEditSensorPage(@RequestParam int idSensor) throws ControllerException {
        Sensor sensorForm = new Sensor();
        ModelMap model = new ModelMap();
        model.addAttribute("sensor", sensorForm);

        Optional<Sensor> sensorDAO = sensorsService.read(idSensor);
        String nameSensor = sensorDAO.get().getName();
        String modelSensor = sensorDAO.get().getModel();
        String typeSensor = sensorDAO.get().getType();
        String locationSensor = sensorDAO.get().getLocation();
        String descriptionSensor = sensorDAO.get().getDescription();

        model.addAttribute("sensor", sensorForm);
        model.addAttribute("nameSensor", nameSensor);
        model.addAttribute("modelSensor", modelSensor);
        model.addAttribute("typeSensor", typeSensor);
        model.addAttribute("locationSensor", locationSensor);
        model.addAttribute("descriptionSensor", descriptionSensor);
        return new ModelAndView("editsensor", model);
    }

    @PostMapping("/action")
    public String EditSensor(@ModelAttribute("sensor") @Valid Sensor sensor, BindingResult bindingResult, ModelAndView modelAndView) throws ControllerException {
        if (bindingResult.hasErrors()) {
            return "editsensor";
        }
        sensorsService.update(sensor);
        return "editsensor";
    }


}
