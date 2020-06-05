package org.javaboy.vhr.controller.systemBasic;

import org.javaboy.vhr.bean.Position;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/basic/position")
public class positionController {
    @Autowired
    private PositionService positionService;


    @GetMapping("/")
    public List<Position> getAllPosition(){
        return positionService.getAllPosition();
    }

    @GetMapping("/add")
    public RespBean addPosition(@RequestParam(value = "positionName") String name ){
        if (!name.isEmpty()){
            positionService.addPosition(name);
            return RespBean.ok("添加成功");
        }else {
            return RespBean.error("部门为空");
        }
    }

    @PutMapping("/update")
    public RespBean updatePosition(@RequestBody Position position,@RequestParam Integer id){
        if (positionService.updatePosition(position)==1){
            return RespBean.ok("id测试成功");
        }else {
            return RespBean.error("发生错误");
        }
    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable(value = "id") Integer id){
        if (positionService.deletePosition(id)==1){
            return RespBean.ok("删除成功");
        }else {
            return RespBean.error("发生错误");
        }
    }
    /** 接收不到前端传来参数也可以在前端看requestPayload*/
    @DeleteMapping("/deleteAll")
    public RespBean deleteAll(@RequestBody List<Position> positions){
        positionService.deleteAll(positions);
            return RespBean.ok("删除成功");

    }
}
