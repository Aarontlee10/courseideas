package com.courseideas.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aarontlee10 on 8/5/17.
 */
public class SimpleCourseIdeasDAO implements CourseIdeasDAO {
    private List<CourseIdea> ideas;

    public SimpleCourseIdeasDAO() {
        ideas = new ArrayList<>();
    }

    @Override
    public boolean add(CourseIdea idea) {
        return ideas.add(idea);
    }

    @Override
    public List<CourseIdea> findAll() {
        return new ArrayList<>(ideas);
    }
}
