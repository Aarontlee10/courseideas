package com.courseideas.model;
import java.util.*;
/**
 * Created by Aarontlee10 on 8/5/17.
 */
public interface CourseIdeasDAO {
    boolean add(CourseIdea idea);
    List<CourseIdea> findAll();
}
