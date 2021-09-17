package by.labinvent.monitorsensors;

import by.labinvent.monitorsensors.exceptions.ServiceException;
import by.labinvent.monitorsensors.service.SensorsService;
import org.springframework.stereotype.Component;

@Component
public class PageBySensor {
    private final SensorsService sensorsService;

    public PageBySensor(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    public int[] getArrayPage(int pageSize) throws ServiceException {
        int countSensor = sensorsService.getCountSensor();  //Расчет количетва страниц и создание массива
        int pageCount = countSensor / pageSize;
        if (countSensor % pageSize != 0) {
            pageCount = pageCount + 1;
        }
        int[] countPageArray = new int[pageCount];
        for (int i = 0; i < countPageArray.length; i++) {
            countPageArray[i] = i + 1;
        }
        return countPageArray;
    }

    public int getPreviousPage(int pageNumber) {
        int previousPage;
        if (pageNumber == 1) {
            previousPage = 1;
        } else {
            previousPage = pageNumber - 1;
        }
        return previousPage;
    }

    public int getNextPage(int pageNumber, int countPageArraySize) {
        int nextPage;
        if (pageNumber == countPageArraySize) {
            nextPage = pageNumber;
        } else {
            nextPage = pageNumber + 1;
        }
        return nextPage;
    }

}
