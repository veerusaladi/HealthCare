package com.app.service;

import java.util.List;

import com.app.model.Project;

public interface IProjectService {
	public int saveProject(Project pro);
	  public void updateProject(Project pro);
	  public void deleteProject(int pid);
	  public Project getOneProjectById(int pid);
	  public List<Project> getAllProjects();
}
