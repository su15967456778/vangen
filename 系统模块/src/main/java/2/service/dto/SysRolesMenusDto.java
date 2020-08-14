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
package 2.service.dto;

import lombok.Data;
import java.io.Serializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
* @website https://el-admin.vip
* @description /
* @author 苏凌峰
* @date 2020-08-09
**/
@Data
public class SysRolesMenusDto implements Serializable {

    /** 菜单ID */
    /** 防止精度丢失 */
    @JsonSerialize(using= ToStringSerializer.class)
    private Long menuId;

    /** 角色ID */
    /** 防止精度丢失 */
    @JsonSerialize(using= ToStringSerializer.class)
    private Long roleId;
}