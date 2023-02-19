package pl.jasonxiii.todotasksbackend.service;

import pl.jasonxiii.todotasksbackend.model.Task;
import pl.jasonxiii.todotasksbackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService
{
	private TaskRepository taskRepository;

	@Autowired
	public void setTaskRepository(TaskRepository tr)
	{
		taskRepository = tr;
	}

	public Task createTask(Task task)
	{
		return taskRepository.save(task);
	}

	public Task getTaskById(Long id)
	{
		Optional<Task> task = taskRepository.findById(id);

		return task.orElse(null);
	}

	public List<Task> getAllTasks()
	{
		return taskRepository.findAll();
	}

	public List<Task> getAllCompletedTasks()
	{
		return taskRepository.findByCompleted(true);
	}

	public Task updateTask(Long id, Task task)
	{
		Optional<Task> searchedTask = taskRepository.findById(id);

		if(searchedTask.isPresent())
		{
			Task foundTask = searchedTask.get();

			foundTask.setName(task.getName());
			foundTask.setDescription(task.getDescription());
			foundTask.setCompleted(task.isCompleted());

			return taskRepository.save(foundTask);
		}

		return null;
	}

	public void deleteTask(Long id)
	{
		taskRepository.deleteById(id);
	}
}