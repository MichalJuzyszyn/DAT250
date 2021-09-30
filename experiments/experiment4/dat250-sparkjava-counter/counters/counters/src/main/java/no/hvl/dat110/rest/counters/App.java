package no.hvl.dat110.rest.counters;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.put;

import static spark.Spark.delete;
import static spark.Spark.post;


import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {

	
	public static void main(String[] args) {
		final TodoServiceMap todoService = new TodoServiceMap();

		if (args.length > 0) {
			port(Integer.parseInt(args[0]));
		} else {
			port(8080);
		}

		post("/todo", (request, response) -> {
			response.type("application/json");

			Todo todo = new Gson().fromJson(request.body(), Todo.class);
			todoService.addTodo(todo);

			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
		});


        get("/todo", (request, response) -> {
			response.type("application/json");
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(todoService.getTodos())));
		});

		get("/todo/:id", (request, response) -> {
			response.type("application/json");
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(todoService.getTodo(Long.valueOf(request.params(":id"))))));
		});

		put("/todo/:id", (request, response) -> {
			response.type("application/json");

			Todo toEdit = new Gson().fromJson(request.body(), Todo.class);
			Todo updatedTodo = todoService.updateTodo(toEdit);

			if (updatedTodo != null) {
				return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(updatedTodo)));
			} else {
				return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, new Gson().toJson("Todo not found or error in edit")));
			}
		});

		delete("/todo/:id", (request, response) -> {
			response.type("application/json");
			todoService.deleteTodo(Long.valueOf(request.params(":id")));
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "todo deleted"));
		});

    }
    
}
