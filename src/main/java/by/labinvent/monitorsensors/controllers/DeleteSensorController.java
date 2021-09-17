package by.labinvent.monitorsensors.controllers;

import by.labinvent.monitorsensors.exceptions.ControllerException;
import by.labinvent.monitorsensors.repository.entity.Sensor;
import by.labinvent.monitorsensors.service.SensorsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/delete/sensor")
public class DeleteSensorController {
    private final SensorsService sensorsService;

    public DeleteSensorController(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @GetMapping
    public String deleteSensor(@RequestParam int idSensor) throws ControllerException {
        Optional<Sensor> sensor = sensorsService.read(idSensor);
        sensorsService.delete(sensor.get());
        return "login";
    }
}
