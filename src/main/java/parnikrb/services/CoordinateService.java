package parnikrb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parnikrb.entities.Coordinate;
import parnikrb.repositories.CoordinateRepository;
import java.util.List;

/**
 * Created by klymenko.ruslan on 16.05.2015.
 */
@RestController
@RequestMapping(CoordinateService.SERVICE_PATH)
public class CoordinateService {

    public static final String SERVICE_PATH = "/coordinate";

    @Autowired
    CoordinateRepository coordinateRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getCoordinates() {
        List<Coordinate> coordinates = coordinateRepository.getAll();
        return new ResponseEntity<List<Coordinate>>(coordinates, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity addCoordinate(@RequestBody String coordinate) {
        String [] params = coordinate.split("&");
        byte x = Byte.parseByte(params[0].charAt(2) + "");
        byte y = Byte.parseByte(params[1].charAt(2) + "");
        Long id = coordinateRepository.add(new Coordinate(x, y)).getId();
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void deleteCoordinate(@PathVariable("id") Long id) {
        coordinateRepository.delete(id);
    }
}
