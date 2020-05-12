package org.javaboy.vhr.controller.systemBasic;


import org.javaboy.vhr.bean.JObLevel;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.services.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addGrade")
    public RespBean addGrade(@RequestBody JObLevel jObLevel){
        if (jobLevelService.addGrade(jObLevel)==1){
            return RespBean.ok("添加成功");
        }else {
            return RespBean.error("添加失败");
        }
    }


    @DeleteMapping("/deleteGrade")
    public RespBean deleteGrade(@RequestParam Integer id){
        if (jobLevelService.deleteGrade(id)==1){
            return RespBean.ok("删除成功");
        }else {
            return RespBean.error("删除失败");
        }
    }

    @PutMapping("/updataGrade")
    public RespBean update(@RequestBody JObLevel jObLevel){

        if (jobLevelService.updateGrade(jObLevel)==1){
            return RespBean.ok("修改成功");
        }else {
            return RespBean.error("修改失败");
        }

    }
}
