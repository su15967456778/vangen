<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container">
      <!--如果想在工具栏加入更多按钮，可以使用插槽方式， slot = 'left' or 'right'-->
      <crudOperation :permission="permission" />
      <!--表单组件-->
      <el-dialog :close-on-click-modal="false" :before-close="crud.cancelCU" :visible.sync="crud.status.cu > 0" :title="crud.status.title" width="500px">
        <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">
          <el-form-item label="菜单ID" prop="menuId">
            <el-input v-model="form.menuId" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="角色ID" prop="roleId">
            <el-input v-model="form.roleId" style="width: 370px;" />
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="text" @click="crud.cancelCU">取消</el-button>
          <el-button :loading="crud.cu === 2" type="primary" @click="crud.submitCU">确认</el-button>
        </div>
      </el-dialog>
      <!--表格渲染-->
      <el-table ref="table" v-loading="crud.loading" :data="crud.data" size="small" style="width: 100%;" @selection-change="crud.selectionChangeHandler">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="menuId" label="菜单ID" />
        <el-table-column prop="roleId" label="角色ID" />
        <el-table-column v-permission="['admin','sysRolesMenus:edit','sysRolesMenus:del']" label="操作" width="150px" align="center">
          <template slot-scope="scope">
            <udOperation
              :data="scope.row"
              :permission="permission"
            />
          </template>
        </el-table-column>
      </el-table>
      <!--分页组件-->
      <pagination />
    </div>
  </div>
</template>

<script>
import crudSysRolesMenus from '@/api/sysRolesMenus'
import CRUD, { presenter, header, form, crud } from '@crud/crud'
import rrOperation from '@crud/RR.operation'
import crudOperation from '@crud/CRUD.operation'
import udOperation from '@crud/UD.operation'
import pagination from '@crud/Pagination'

const defaultForm = { menuId: null, roleId: null }
export default {
  name: 'SysRolesMenus',
  components: { pagination, crudOperation, rrOperation, udOperation },
  mixins: [presenter(), header(), form(defaultForm), crud()],
  cruds() {
    return CRUD({ title: '2', url: 'api/sysRolesMenus', sort: 'roleId,desc', crudMethod: { ...crudSysRolesMenus }})
  },
  data() {
    return {
      permission: {
        add: ['admin', 'sysRolesMenus:add'],
        edit: ['admin', 'sysRolesMenus:edit'],
        del: ['admin', 'sysRolesMenus:del']
      },
      rules: {
        menuId: [
          { required: true, message: '菜单ID不能为空', trigger: 'blur' }
        ],
        roleId: [
          { required: true, message: '角色ID不能为空', trigger: 'blur' }
        ]
      }    }
  },
  methods: {
    // 钩子：在获取表格数据之前执行，false 则代表不获取数据
    [CRUD.HOOK.beforeRefresh]() {
      return true
    }
  }
}
</script>

<style scoped>

</style>
