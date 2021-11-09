package Reto.RetoTres.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosRoom {
    
    @Autowired
    private RepositorioRoom metodoCrudRoom;

    public List<Rooms> getAll(){
        return metodoCrudRoom.getAll();
    }

    public Optional<Rooms> getroom(int roomId) {
        return metodoCrudRoom.getRoom(roomId);
    }

    public Rooms save(Rooms room){
        if(room.getId()==null){
            return metodoCrudRoom.save(room);
        }else{
            Optional<Rooms> e=metodoCrudRoom.getRoom(room.getId());
            if(e.isEmpty()){
                return metodoCrudRoom.save(room);
            }else{
                return room;
            }
        }
    }

    public Rooms update(Rooms room){
        if(room.getId()!=null){
            Optional<Rooms> e=metodoCrudRoom.getRoom(room.getId());
            if(!e.isEmpty()){
                if(room.getName()!=null){
                    e.get().setName(room.getName());
                }
                if(room.getStars()!=null){
                    e.get().setStars(room.getStars());
                }
                if(room.getHotel()!=null){
                    e.get().setHotel(room.getHotel());
                }
                if(room.getDescription()!=null){
                    e.get().setDescription(room.getDescription());
                }
                if(room.getCategory()!=null){
                    e.get().setCategory(room.getCategory());
                }
                metodoCrudRoom.save(e.get());
                return e.get();
            }else{
                return room;
            }
        }else{
            return room;
        }
    }
    
    public boolean deleteroom(int roomId) {
        Boolean aBoolean = getroom(roomId).map(room -> {
            metodoCrudRoom.delete(room);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}

