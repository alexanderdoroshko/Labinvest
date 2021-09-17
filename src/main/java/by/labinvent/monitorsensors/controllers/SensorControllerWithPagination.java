package by.labinvent.monitorsensors.controllers;

import by.labinvent.monitorsensors.PageBySensor;
import by.labinvent.monitorsensors.exceptions.ControllerException;
import by.labinvent.monitorsensors.repository.entity.Sensor;
import by.labinvent.monitorsensors.service.SensorsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@RestController
@RequestMapping("/sensor/pagination")
public class SensorControllerWithPagination {
    private final SensorsService sensorsService;

    public SensorControllerWithPagination(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @GetMapping
    public ModelAndView getSensorPageWithParam(@RequestParam int pageNumber,
                                               @RequestParam int pageSize,
                                               @RequestParam String sortField,
                                               @RequestParam String sortDirection) throws ControllerException {
        ModelMap model = new ModelMap();

        Sort sortOrder = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sortOrder);

        Page<Sensor> sensorList = sensorsService.getAllSensorOnPage(pageable);
        model.addAttribute("sensorsList", sensorList.getContent());
        // Получение пагинации
        PageBySensor pageBySensor = new PageBySensor(sensorsService);
        int[] countPageArray = pageBySensor.getArrayPage(pageSize);
        model.addAttribute("pages", countPageArray);

        int previousPage = pageBySensor.getPreviousPage(pageNumber);
        model.addAttribute("previous", previousPage);

        int nextPage = pageBySensor.getNextPage(pageNumber, countPageArray.length);
        model.addAttribute("next", nextPage);

        return new ModelAndView("sensors", model);
    }
}
