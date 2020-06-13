package org.javaboy.vhr.services.serviceInterface;

import com.baomidou.mybatisplus.extension.service.IService;
import org.javaboy.vhr.bean.Politicsstatus;

import java.util.List;

public interface PoliticService extends IService<Politicsstatus> {
    public List<Politicsstatus> getPoliticStatus();
}
