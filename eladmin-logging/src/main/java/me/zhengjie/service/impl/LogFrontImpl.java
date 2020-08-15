/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package me.zhengjie.service.impl;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import lombok.RequiredArgsConstructor;
import me.zhengjie.domain.Log;
import me.zhengjie.domain.SysExcepFrontLog;
import me.zhengjie.domain.SysExcepOperDtl;
import me.zhengjie.repository.LogRepository;
import me.zhengjie.repository.SysExcepFrontLogMapper;
import me.zhengjie.repository.SysExcepOperDtlMapper;
import me.zhengjie.service.LogFrontService;
import me.zhengjie.service.LogService;
import me.zhengjie.service.dto.LogQueryCriteria;
import me.zhengjie.service.dto.SysExcepFrontDto;
import me.zhengjie.service.mapstruct.LogErrorMapper;
import me.zhengjie.service.mapstruct.LogSmallMapper;
import me.zhengjie.utils.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Zheng Jie
 * @date 2018-11-24
 */
@Service
@RequiredArgsConstructor
public class LogFrontImpl implements LogFrontService {
    private static final Logger log = LoggerFactory.getLogger(LogFrontImpl.class);

    @Autowired
    private SysExcepFrontLogMapper sysExcepFrontLogMapper;

    @Autowired
    private SysExcepOperDtlMapper sysExcepOperDtlMapper;

    @Override
    public void save(SysExcepFrontDto sysExcepFrontDto) {
        SysExcepFrontLog fromtRecord = sysExcepFrontDto.toSysExcepFrontLog();
        sysExcepFrontLogMapper.save(fromtRecord);
        for (SysExcepOperDtl sysExcepOperDtl : sysExcepFrontDto.getSysExcepOperDtls()) {
            sysExcepOperDtl.setExcepLogId(fromtRecord.getId());
            sysExcepOperDtlMapper.save(sysExcepOperDtl);
        }

    }


}
