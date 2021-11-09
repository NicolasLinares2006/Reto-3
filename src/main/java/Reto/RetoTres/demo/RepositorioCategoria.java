package Reto.RetoTres.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategoria {
    @Autowired
    private InterfaceCategoria crudCategory;
    public List<Categoria> getAll(){
        return (List<Categoria>) crudCategory.findAll();
    }
    public Optional<Categoria> getCategoria(int id){
        return crudCategory.findById(id);
    }
     
    public Categoria save(Categoria categoria){
        return crudCategory.save(categoria);
    }
    
    public void delete(Categoria categoria){
       crudCategory.delete(categoria);
    }
}