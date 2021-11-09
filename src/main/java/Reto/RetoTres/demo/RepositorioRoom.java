package Reto.RetoTres.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioRoom {
   @Autowired
    private InterfaceRoom crudRoom;

    public List<Rooms> getAll(){
        return (List<Rooms>) crudRoom.findAll();
    }

    public Optional<Rooms> getRoom(int id){
        return crudRoom.findById(id);
    }

    public Rooms save(Rooms room){
        return crudRoom.save(room);
    }
    
    public void delete(Rooms room){
        crudRoom.delete(room);
    } 
}
