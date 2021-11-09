/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto.RetoTres.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMensaje {
    @Autowired
    private RepositorioMensaje metodosCrudMessage;

    public List<Mensaje> getAll(){
        return metodosCrudMessage.getAll();
    }

    public Optional<Mensaje> getMessage(int messageId) {
        return metodosCrudMessage.getMessage(messageId);
    }

    public Mensaje save(Mensaje message){
        if(message.getIdMessage()==null){
            return metodosCrudMessage.save(message);
        }else{
            Optional<Mensaje> e= metodosCrudMessage.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return metodosCrudMessage.save(message);
            }else{
                return message;
            }
        }
    }

    public Mensaje update(Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> e= metodosCrudMessage.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrudMessage.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrudMessage.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
