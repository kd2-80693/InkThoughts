package com.app.dao;

import java.util.List;

import com.app.entity.Thought;

public interface ThoughtDao {
	public void saveThought(Thought t);
	public List<Thought> getThoughts();
	public void delete(Long deleteId);
	public void update(Thought t, Long id);
}
