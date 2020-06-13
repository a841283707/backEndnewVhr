package org.javaboy.vhr.services;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.javaboy.vhr.bean.Nation;
import org.javaboy.vhr.mapper.NationMapper;
import org.javaboy.vhr.services.serviceInterface.NationService;

public class NationServiceImpl extends ServiceImpl<NationMapper,Nation> implements NationService {
}
