package Reto.RetoTres.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCliente {
    @Autowired
     private RepositorioCliente metodosCrudClient;
     
     public List<Cliente> getAll(){
        return metodosCrudClient.getAll();
    }
     
      public Optional<Cliente> getClient(int clientId) {
        return metodosCrudClient.getCliente(clientId);
    }

    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return metodosCrudClient.save(client);
        }else{
            Optional<Cliente> e= metodosCrudClient.getCliente(client.getIdClient());
            if(e.isEmpty()){
                return metodosCrudClient.save(client);
            }else{
                return client;
            }
        }
    }

    public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> e= metodosCrudClient.getCliente(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                metodosCrudClient.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrudClient.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
