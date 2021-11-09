package Reto.RetoTres.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCliente {
    @Autowired
    private InterfaceCliente crudClient;

    public List<Cliente> getAll(){
        return (List<Cliente>) crudClient.findAll();
    }
    
    public Optional<Cliente> getCliente(int id){
        return crudClient.findById(id);
    }

    public Cliente save(Cliente cliente){
        return crudClient.save(cliente);
    }
    
    public void delete(Cliente cliente){
        crudClient.delete(cliente);
    }
}
