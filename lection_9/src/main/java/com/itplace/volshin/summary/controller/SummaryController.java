package com.itplace.volshin.summary.controller;

import com.itplace.volshin.summary.data.SummaryBody;
import com.itplace.volshin.summary.entity.Summary;
import com.itplace.volshin.summary.repository.SummaryRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Резюме", description = "Генерация и сохранение списка резюме")
@RestController
@RequestMapping("/api")
public class SummaryController {

    private SummaryRepository summaryRepository;

    @Autowired
    public SummaryController(SummaryRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    @ApiOperation(value = "Возвращает список всех резюме")
    @GetMapping("/all")
    public List<Summary> getAllSummary() {
        return this.summaryRepository.findAll();
    }

    @ApiOperation(value = "Возвращает резюме по его идентификатору")
    @GetMapping("/summary/{id}")
    public Summary getSummary(@PathVariable(value = "id") Long id) {
        return this.summaryRepository.findSummaryById(id);
    }

    @ApiOperation(value = "Добавляет резюме в репозиторий")
    @PostMapping("/new")
    public void appendSummary(@RequestBody SummaryBody summaryBody) {
        Summary summary = new Summary();
        summary.setFullname(summaryBody.getFullname());
        summary.setBirthday(summaryBody.getBirthday());
        summary.setEmail(summaryBody.getEmail());
        summary.setSkype(summaryBody.getSkype());
        summary.setPhone(summaryBody.getPhone());
        summary.setImage(summaryBody.getImage());
        summary.setTarget(summaryBody.getTarget());
        summary.setExperience(summaryBody.getExperience());
        summary.setEducation(summaryBody.getEducation());
        summary.setAdditional(summaryBody.getAdditional());
        summary.setSkills(summaryBody.getSkills());
        summary.setExample(summaryBody.getExample());
        this.summaryRepository.save(summary);
    }

    @ApiOperation(value = "Изменить резюме в репозитории")
    @PutMapping("/edit/{id}")
    public void editSummary(@PathVariable(value = "id") Long id, @RequestBody SummaryBody summaryBody) {
        Summary summary = new Summary();
        summary.setId(id);
        summary.setFullname(summaryBody.getFullname());
        summary.setBirthday(summaryBody.getBirthday());
        summary.setEmail(summaryBody.getEmail());
        summary.setSkype(summaryBody.getSkype());
        summary.setPhone(summaryBody.getPhone());
        summary.setImage(summaryBody.getImage());
        summary.setTarget(summaryBody.getTarget());
        summary.setExperience(summaryBody.getExperience());
        summary.setEducation(summaryBody.getEducation());
        summary.setAdditional(summaryBody.getAdditional());
        summary.setSkills(summaryBody.getSkills());
        summary.setExample(summaryBody.getExample());
        this.summaryRepository.save(summary);
    }

    @ApiOperation(value = "Удалить резюме из репозитория")
    @DeleteMapping("/delete/{id}")
    public void deleteSummary(@PathVariable(value = "id") Long id) {
        this.summaryRepository.deleteById(id);
    }

}
