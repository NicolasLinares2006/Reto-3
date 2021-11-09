package Reto.RetoTres.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaciones {
    @Autowired
    private InterfaceReservaciones crudReservation;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crudReservation.findAll();
    }
    public Optional<Reservaciones> getReservation(int id){
        return crudReservation.findById(id);
    }
    public Reservaciones save(Reservaciones reservation){
        return crudReservation.save(reservation);
    }
    public void delete(Reservaciones reservation){
        crudReservation.delete(reservation);
    }
}
