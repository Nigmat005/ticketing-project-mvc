package com.cydeo.service.serviceimpl;

import com.cydeo.service.CrudService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService<T,ID>{
    protected Map<ID,T> map=new HashMap<>();

    T save(ID id,T object){
        map.put(id,object);
        return object;
    }

    List<T> findAll(){
        List<T> list=new ArrayList<>();

        for(Map.Entry<ID,T> entry: map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
//        return new ArrayList<>(map.values());

//        map.forEach((ID,T)->list.add(T));
//        return list;
    }

    T findByID(ID id){
      return map.get(id);
    }

    void deleteByID(ID id){
        map.remove(id);
    }

}
