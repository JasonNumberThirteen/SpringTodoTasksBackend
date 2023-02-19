package pl.jasonxiii.todotasksbackend.repository;

import pl.jasonxiii.todotasksbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>
{
	List<Task> findByCompleted(Boolean completed);
}