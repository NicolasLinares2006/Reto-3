package Reto.RetoTres.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMensaje {
    @Autowired
    private InterfaceMensaje crudMessage;
    public List<Mensaje> getAll(){
        return (List<Mensaje>) crudMessage.findAll();
    }
    
    public Optional<Mensaje> getMessage(int id){
        return crudMessage.findById(id);
    }

    public Mensaje save(Mensaje message){
        return crudMessage.save(message);
    }
    
    public void delete(Mensaje message){
        crudMessage.delete(message);
    }
}
