package com.xyan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xyan.api.mapper.ScheduleJobMapper;
import com.xyan.api.model.ScheduleJobModel;
import com.xyan.service.ScheduleJobService;


/**
 * @author wangming
 * @description  user service implements
 * @since ctreated at 2015年12月3日 上午9:15:19
 * @update wangming modified at 2015年12月3日 上午9:15:19
 */
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

    @Resource
    private ScheduleJobMapper mapper;

	@Override
	public List<ScheduleJobModel> getAll() {
		return mapper.selectAll();
	}

}
