package Reto.RetoTres.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Room")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorRoom {
      @Autowired
    private ServiciosRoom servicio;
    @GetMapping("/all")
    public List<Rooms> getroom(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Rooms> getroom(@PathVariable("id") int roomId) {
        return servicio.getroom(roomId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Rooms save(@RequestBody Rooms room) {
        return servicio.save(room);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Rooms update(@RequestBody Rooms room) {
        return servicio.update(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int roomId) {
        return servicio.deleteroom(roomId);
    }
    
}
