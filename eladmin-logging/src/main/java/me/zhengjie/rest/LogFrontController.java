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
package me.zhengjie.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.zhengjie.annotation.Log;
import me.zhengjie.service.LogFrontService;
import me.zhengjie.service.LogService;
import me.zhengjie.service.dto.LogQueryCriteria;
import me.zhengjie.service.dto.SysExcepFrontDto;
import me.zhengjie.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Zheng Jie
 * @date 2018-11-24
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/front/logs")
@Api(tags = "系统：前端日志")
public class LogFrontController {

    @Autowired
    private LogFrontService logFrontService;


    @PostMapping(value = "/save/error")
    @ApiOperation("前端错误日志保存")
    //@PreAuthorize("@el.check()")
    public ResponseEntity<Object> queryErrorLog(@RequestBody SysExcepFrontDto sysExcepFrontDto) {

        logFrontService.save(sysExcepFrontDto);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
