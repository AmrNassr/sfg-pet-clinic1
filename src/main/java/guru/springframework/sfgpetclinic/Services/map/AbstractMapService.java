package guru.springframework.sfgpetclinic.Services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.management.RuntimeErrorException;

import guru.springframework.sfgpetclinic.model.BaseEntity;

public abstract class  AbstractMapService<T extends BaseEntity,ID> {
   protected Map<Long,T> map = new HashMap<>();
   Set<T>findAll ()
   {
       return new HashSet<>(map.values());
   }
   T findById(ID id)
   {
       return  map.get(id);
   }
   T save( T object) 
   {
	   if(object != null)
	   {
		   if(object.getId() == null)
		   {
			   object.setId(getnextId());
		   }
		   map.put(object.getId(), object);
	   }
	   else
	   {
		   throw new RuntimeException("Object can't be Null");
	   }
      
        return  object;
   }
   void deleteById(Long id)
   {
       map.remove(id);
   }
   void delete(T object)
   {
       map.entrySet().removeIf(idtEntry -> idtEntry.equals(object));
   }
   private Long getnextId()
   {
	   Long nextId	=  null;
	   try
	   {
		   nextId=Collections.max(map.keySet())+1;
	   }
	   catch(Exception ex)
	   {
		   nextId=1L;
	   }
	   
	   return nextId;
   }

   

}
