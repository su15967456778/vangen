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
package 2.service.impl;

import 2.domain.SysRolesMenus;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import 2.repository.SysRolesMenusRepository;
import 2.service.SysRolesMenusService;
import 2.service.dto.SysRolesMenusDto;
import 2.service.dto.SysRolesMenusQueryCriteria;
import 2.service.mapstruct.SysRolesMenusMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
* @website https://el-admin.vip
* @description 服务实现
* @author 苏凌峰
* @date 2020-08-09
**/
@Service
@RequiredArgsConstructor
public class SysRolesMenusServiceImpl implements SysRolesMenusService {

    private final SysRolesMenusRepository sysRolesMenusRepository;
    private final SysRolesMenusMapper sysRolesMenusMapper;

    @Override
    public Map<String,Object> queryAll(SysRolesMenusQueryCriteria criteria, Pageable pageable){
        Page<SysRolesMenus> page = sysRolesMenusRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(sysRolesMenusMapper::toDto));
    }

    @Override
    public List<SysRolesMenusDto> queryAll(SysRolesMenusQueryCriteria criteria){
        return sysRolesMenusMapper.toDto(sysRolesMenusRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public SysRolesMenusDto findById(Long roleId) {
        SysRolesMenus sysRolesMenus = sysRolesMenusRepository.findById(roleId).orElseGet(SysRolesMenus::new);
        ValidationUtil.isNull(sysRolesMenus.getRoleId(),"SysRolesMenus","roleId",roleId);
        return sysRolesMenusMapper.toDto(sysRolesMenus);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysRolesMenusDto create(SysRolesMenus resources) {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        resources.setRoleId(snowflake.nextId()); 
        return sysRolesMenusMapper.toDto(sysRolesMenusRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRolesMenus resources) {
        SysRolesMenus sysRolesMenus = sysRolesMenusRepository.findById(resources.getRoleId()).orElseGet(SysRolesMenus::new);
        ValidationUtil.isNull( sysRolesMenus.getRoleId(),"SysRolesMenus","id",resources.getRoleId());
        sysRolesMenus.copy(resources);
        sysRolesMenusRepository.save(sysRolesMenus);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long roleId : ids) {
            sysRolesMenusRepository.deleteById(roleId);
        }
    }

    @Override
    public void download(List<SysRolesMenusDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (SysRolesMenusDto sysRolesMenus : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}