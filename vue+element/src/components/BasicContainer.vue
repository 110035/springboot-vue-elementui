<template>
    <div>
        <!-- Table -->
        <el-button type="text" @click="dialogTableVisible = true">打开嵌套表格的 Dialog</el-button>

        <el-dialog title="收货地址" :visible.sync="dialogTableVisible" width="60%">
            <el-table
                    v-loading="loading"
                    element-loading-text="拼命加载中"
                    element-loading-spinner="el-icon-loading"
                    element-loading-background="rgba(0, 0, 0, 0.8)"

                    stripe
                    :data="userlist.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                    :border = true
                    style="margin-top:15px"
                    @selection-change="handleSelectionChange"
            >
                <el-table-column type="selection" width="40px"></el-table-column>
                <el-table-column prop="id" label="ID"></el-table-column>
                <el-table-column prop="userName" label="姓名"></el-table-column>
                <el-table-column prop="password" label="密码"></el-table-column>
                <el-table-column prop="actions" label="操作">
                    <template slot-scope="scope">
                        <el-button size="mini" type="warning" @click="setCurrentUser(scope.row.id)">修改</el-button>
                        <el-button slot="reference" size="mini" type="info" @click="deleteConfirm(scope.row.id)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div style="height:12px"></div>
            <el-pagination
                    width="30%"

                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-sizes="[5,10,20,100]"
                    :page-size="pagesize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total=parseInt(total)>
            </el-pagination>
        </el-dialog>

        <!-- Form -->
        <el-button type="text" @click="dialogFormVisible = true">打开嵌套表单的 Dialog</el-button>

        <el-dialog title="收货地址" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="活动名称" :label-width="formLabelWidth">
                    <el-input v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="活动区域" :label-width="formLabelWidth">
                    <el-select v-model="form.region" placeholder="请选择活动区域">
                        <el-option label="区域一" value="shanghai"></el-option>
                        <el-option label="区域二" value="beijing"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script>

    export default {
        name:'list11',
        data() {
            return {


                dialogTableVisible: false,
                dialogFormVisible: false,
                form: {
                    name: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                },
                formLabelWidth: '120px',
                search_id:'',
                search_username:'',
                //定义查询结果数组
                userlist:[],
                total:0,
                currentPage: 1,
                pagesize: 5,
            };
        } ,
        created:function(){
            this.getList()
        },
        methods: {

            getList(){
                const params = {
                    search_id : this.search_id,
                    search_username : this.search_username,
                }
                this.axios.post('/api/search',params).then(response =>{
                    this.userlist = response.data
                    this.total = this.userlist.length
                })
            },


            tableRowClassName({row, rowIndex}) {
                if (rowIndex === 0) {
                    return 'th';
                }
                return '';
            },




            handleSizeChange(val) {
                this.pagesize = val;
            },
            handleCurrentChange(val) {
                this.currentPage = val;
            },
        },
        dialogTableVisible: false,
        dialogFormVisible: false,
        form: {
            name: '',
            region: '',
            date1: '',
            date2: '',
            delivery: false,
            type: [],
            resource: '',
            desc: ''
        },
        formLabelWidth: '120px'
    };


</script>