package by.labinvent.monitorsensors.controllers;


import by.labinvent.monitorsensors.exceptions.ControllerException;
import by.labinvent.monitorsensors.repository.entity.Sensor;
import by.labinvent.monitorsensors.repository.impl.SearchSensorRepositoryImpl;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchSensorController {

    private final SearchSensorRepositoryImpl searchSensorRepository;

    public SearchSensorController(SearchSensorRepositoryImpl searchSensorRepository) {
        this.searchSensorRepository = searchSensorRepository;
    }


    @GetMapping("/result")
    public ModelAndView getResultSearchPage(@RequestParam(required = false) String searchSensorParam, HttpSession session) throws ControllerException {

        session.setAttribute("searchParams", searchSensorParam);

        int currentPage = 1;
        int recordsPerPage = 4;

        List<Sensor> sensorList = searchSensorRepository.findSensorListByParams(searchSensorParam, currentPage, recordsPerPage);

        ModelMap model = new ModelMap();
        model.addAttribute("sensorsList", sensorList);

        return new ModelAndView("sensors", model);
    }

    @GetMapping("/result/page")
    public ModelAndView getResultSearchPageShow(@RequestParam() int currentPage,
                                                HttpSession session) throws ControllerException {

        String searchSensorParam = (String) session.getAttribute("searchParams");
        int recordsPerPage = 4;
        List<Sensor> sensorList = searchSensorRepository.findSensorListByParams(searchSensorParam, currentPage, recordsPerPage);

        ModelMap model = new ModelMap();
        model.addAttribute("sensorsList", sensorList);

        return new ModelAndView("sensors", model);
    }


}
