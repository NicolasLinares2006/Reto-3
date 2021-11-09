package Reto.RetoTres.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCategoria {
    @Autowired
    private RepositorioCategoria metodosCrudCategory;

    public List<Categoria> getAll() {
        return metodosCrudCategory.getAll();
    }

    public Optional<Categoria> getCategoria(int CategoriaId) {
        return metodosCrudCategory.getCategoria(CategoriaId);
    }

    public Categoria save(Categoria categoria) {
        if (categoria.getId()== null) {
            return metodosCrudCategory.save(categoria);
        } else {
            Optional<Categoria> categoria1 = metodosCrudCategory.getCategoria(categoria.getId());
            if (categoria1.isEmpty()) {
                return metodosCrudCategory.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria>g=metodosCrudCategory.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return metodosCrudCategory.save(g.get());
            }
        }
        return categoria;
    }
    public boolean deletecategoria(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            metodosCrudCategory.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}
