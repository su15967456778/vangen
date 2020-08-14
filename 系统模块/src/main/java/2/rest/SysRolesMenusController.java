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
package 2.rest;

import me.zhengjie.annotation.Log;
import 2.domain.SysRolesMenus;
import 2.service.SysRolesMenusService;
import 2.service.dto.SysRolesMenusQueryCriteria;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @author 苏凌峰
* @date 2020-08-09
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "2管理")
@RequestMapping("/api/sysRolesMenus")
public class SysRolesMenusController {

    private final SysRolesMenusService sysRolesMenusService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('sysRolesMenus:list')")
    public void download(HttpServletResponse response, SysRolesMenusQueryCriteria criteria) throws IOException {
        sysRolesMenusService.download(sysRolesMenusService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询2")
    @ApiOperation("查询2")
    @PreAuthorize("@el.check('sysRolesMenus:list')")
    public ResponseEntity<Object> query(SysRolesMenusQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(sysRolesMenusService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增2")
    @ApiOperation("新增2")
    @PreAuthorize("@el.check('sysRolesMenus:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody SysRolesMenus resources){
        return new ResponseEntity<>(sysRolesMenusService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改2")
    @ApiOperation("修改2")
    @PreAuthorize("@el.check('sysRolesMenus:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody SysRolesMenus resources){
        sysRolesMenusService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除2")
    @ApiOperation("删除2")
    @PreAuthorize("@el.check('sysRolesMenus:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Long[] ids) {
        sysRolesMenusService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}