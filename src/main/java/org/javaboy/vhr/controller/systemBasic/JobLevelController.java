package org.javaboy.vhr.controller.systemBasic;


import org.javaboy.vhr.bean.JObLevel;
import org.javaboy.vhr.services.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/basic/jobLevel")
public class JobLevelController {
    @Autowired
    private JobLevelService jobLevelService;

    @GetMapping("/getGrades")
    public List<JObLevel> getGrades(){
        return jobLevelService.getGrades();
    }
}
