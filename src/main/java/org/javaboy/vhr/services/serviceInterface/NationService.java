package org.javaboy.vhr.services.serviceInterface;

import com.baomidou.mybatisplus.extension.service.IService;
import org.javaboy.vhr.bean.Nation;

import java.util.List;

public interface NationService extends IService<Nation> {
    public List<Nation> getNation();
}
