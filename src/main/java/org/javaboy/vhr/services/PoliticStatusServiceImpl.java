package org.javaboy.vhr.services;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.javaboy.vhr.bean.Politicsstatus;
import org.javaboy.vhr.mapper.PoliticsstatusMapper;
import org.javaboy.vhr.services.serviceInterface.PoliticService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticStatusServiceImpl extends ServiceImpl<PoliticsstatusMapper, Politicsstatus> implements PoliticService {
    @Override
    public List<Politicsstatus> getPoliticStatus() {
        return list(null);
    }
}
