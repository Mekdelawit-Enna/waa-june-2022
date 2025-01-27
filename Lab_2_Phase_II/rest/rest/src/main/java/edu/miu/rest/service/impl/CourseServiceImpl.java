package edu.miu.rest.service.impl;

import edu.miu.rest.dto.CourseDto;
import edu.miu.rest.entity.Course;
import edu.miu.rest.repository.CourseRepo;
import edu.miu.rest.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public List<CourseDto> findAll() {
        var courses = courseRepo.findAll();
        var result = new ArrayList<CourseDto>();

        for (Course course : courses) {
            CourseDto dto = new CourseDto();
            var courseDto = dto.toDto(course);
            result.add(courseDto);
        }
        return result;

    }

    @Override
    public void create(CourseDto courseDto) {
        Course course = courseDto.toEntity();
        courseRepo.create(course);
    }
    @Override
    public void update(CourseDto courseDto)
    {
        Course course = courseDto.toEntity();
        courseRepo.update(course);
    }

    @Override
    public void delete(CourseDto courseDto)
    {
        Course course = courseDto.toEntity();
        courseRepo.delete(course);
    }
}
