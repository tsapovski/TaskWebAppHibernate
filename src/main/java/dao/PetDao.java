package dao;


import database.ConnectDataBase;
import entity.Pets;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PetDao{
    public Pets getPet(long id){
        Session session = ConnectDataBase.getSession();
        Pets pet = session.get(Pets.class, id);
        ConnectDataBase.closeSession(session);
        return pet;
    }
    public void insert(Pets pet){
        Session session = ConnectDataBase.getSession();
        session.save(pet);
        ConnectDataBase.closeSession(session);
    }
    public void update (Pets pet){
        Session session = ConnectDataBase.getSession();
        session.update(pet);
        ConnectDataBase.closeSession(session);
    }
    public  void delete(Pets pet){
        Session session = ConnectDataBase.getSession();
        session.delete(pet);
        ConnectDataBase.closeSession(session);
    }

    public List<Pets> getAll(){
        Session session = ConnectDataBase.getSession();
        String sqlStr = "FROM Pets";
        Query<Pets> query = session.createQuery(sqlStr, Pets.class);
        List<Pets> petsList = query.list();
        return petsList;
    }
}
