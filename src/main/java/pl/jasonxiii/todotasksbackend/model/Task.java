package pl.jasonxiii.todotasksbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task
{
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "completed", nullable = false)
	private Boolean completed;

	public Task()
	{

	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setCompleted(Boolean completed)
	{
		this.completed = completed;
	}

	public Integer getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public Boolean getCompleted()
	{
		return completed;
	}
}