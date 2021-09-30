package no.hvl.dat110.rest.counters;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class TodoServiceMap {
    private HashMap<Long, Todo> todoMap;

    public TodoServiceMap() {
        todoMap = new HashMap<>();
    }

    public void addTodo(Todo todo) {
        todoMap.put(todo.getId(), todo);
    }


    public Collection<Todo> getTodos() {
        return todoMap.values();
    }


    public Todo getTodo(Long id) {
        return todoMap.get(id);
    }


    public Todo updateTodo(Todo forUpdate) throws Exception{
        try {
            if (forUpdate.getId() == null)
                throw new Exception("ID cannot be blank");

            Todo toEdit = todoMap.get(forUpdate.getId());

            if (toEdit == null)
                throw new Exception("Todo not found");

            if (forUpdate.getSummary() != null) {
                toEdit.setSummary(forUpdate.getSummary());
            }
            if (forUpdate.getDescription() != null ) {
                toEdit.setDescription(forUpdate.getDescription());
            }

            if (forUpdate.getId() != null) {
                toEdit.setId(forUpdate.getId());
            }

            return toEdit;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }


    public void deleteTodo(Long id) {
        todoMap.remove(id);
    }


    public boolean todoExist(Long id) {
        return todoMap.containsKey(id);
    }


}
