package pl.jasonxiii.todotasksbackend.controller;

import pl.jasonxiii.todotasksbackend.model.Task;
import pl.jasonxiii.todotasksbackend.service.TaskService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost/3000")
public class TaskController
{
	private TaskService taskService;

	@Autowired
	public void setTaskService(TaskService ts)
	{
		taskService = ts;
	}

	@PostMapping("/tasks")
	public ResponseEntity<Task> createTask(@RequestBody Task task)
	{
		try
		{
			return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
		}
		catch (Exception e)
		{
			e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id)
	{
		Task searchedTask = taskService.getTaskById(id);

		if(searchedTask == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(searchedTask, HttpStatus.OK);
	}

	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getAllTasks()
	{
		try
		{
			List<Task> tasks = taskService.getAllTasks();

			return new ResponseEntity<>(tasks, HttpStatus.OK);
		}
		catch (Exception e)
		{
			e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task task)
	{
		Task searchedTask = taskService.updateTask(id, task);

		if(searchedTask == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(searchedTask, HttpStatus.OK);
	}

	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<HttpStatus> deleteTask(@PathVariable("id") Long id)
	{
		try
		{
			taskService.deleteTask(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e)
		{
			e.printStackTrace();

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}