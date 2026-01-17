package com.example.unischedule.controller;

import com.example.unischedule.model.*;
import com.example.unischedule.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Frontend talk
public class ScheduleController {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private YearRepository yearRepository;

    @Autowired
    private ScheduleEntryRepository scheduleEntryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    // 1.Faculties
    @GetMapping("/faculties")
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    // 2.Specialties
    @GetMapping("/faculties/{id}/specialties")
    public List<Specialty> getSpecialtiesByFaculty(@PathVariable Long id) {
        return specialtyRepository.findByFacultyId(id);
    }

    // 3.Year
    @GetMapping("/specialties/{id}/years")
    public List<Year> getYearsBySpecialty(@PathVariable Long id) {
        return yearRepository.findBySpecialtyId(id);
    }

    // 4. Schedule
    @GetMapping("/schedule")
    public List<ScheduleEntry> getScheduleByYear(@RequestParam(name = "yearID") Long yearID) {
        return scheduleEntryRepository.findByYearId(yearID);
    }
    // 5. Admin specialties
    @PostMapping("/admin/specialties")
    public Specialty addSpecialty(@RequestBody Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @DeleteMapping("/admin/specialties/{id}")
    public void deleteSpecialty(@PathVariable Long id) {
        specialtyRepository.deleteById(id);
    }

    // 6. Admin Corse
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @PostMapping("/admin/courses")
    public Course addCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    // 7. Admin ScheduleEntry
    @PostMapping("/admin/schedule")
    public ScheduleEntry addScheduleEntry(@RequestBody ScheduleEntryDTO dto) {
        ScheduleEntry entry = new ScheduleEntry();
        entry.setDayOfWeek(dto.getDayOfWeek());
        entry.setStartTime(dto.getStartTime());
        entry.setEndTime(dto.getEndTime());
        entry.setRoom(dto.getRoom());

        entry.setYear(yearRepository.findById(dto.getYearId()).orElseThrow());
        entry.setCourse(courseRepository.findById(dto.getCourseId()).orElseThrow());
        entry.setInstructor(instructorRepository.findById(dto.getInstructorId()).orElseThrow());

        return scheduleEntryRepository.save(entry);
    }

    @DeleteMapping("/admin/schedule/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        scheduleEntryRepository.deleteById(id);
    }

    // 8. Admin Faculties
    @PostMapping("/admin/faculties")
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @DeleteMapping("/admin/faculties/{id}")
    public void deleteFaculty(@PathVariable Long id) {
        facultyRepository.deleteById(id);
    }

    //9. Admin Edit
    @PutMapping("/admin/schedule/{id}")
    public ScheduleEntry updateScheduleEntry(@PathVariable Long id, @RequestBody ScheduleEntryDTO dto) {
        ScheduleEntry entry = scheduleEntryRepository.findById(id).orElseThrow();

        entry.setDayOfWeek(dto.getDayOfWeek());
        entry.setStartTime(dto.getStartTime());
        entry.setEndTime(dto.getEndTime());
        entry.setRoom(dto.getRoom());

        // Updates
        entry.setYear(yearRepository.findById(dto.getYearId()).orElseThrow());
        entry.setCourse(courseRepository.findById(dto.getCourseId()).orElseThrow());
        entry.setInstructor(instructorRepository.findById(dto.getInstructorId()).orElseThrow());

        return scheduleEntryRepository.save(entry);
    }

    //10. Admin Get Everything
    @GetMapping("/admin/all-entries")
    public List<ScheduleEntry> getAllEntries() {
        return scheduleEntryRepository.findAll();
    }

    @GetMapping("/years")
    public List<Year> getAllYears() {
        return yearRepository.findAll();
    }
    //11. Instrucotrs
    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }
}