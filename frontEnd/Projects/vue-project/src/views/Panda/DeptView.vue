<template>
    <div>
    <el-container style="height: 700px; border: 1px solid #eee">
    <el-header style="font-size: 40px; background-color: rgb(238, 241, 246)">スクール管理システム</el-header>
    <el-container>
        <el-aside width="250px" style="background-color: rgb(238, 241, 246); border: 1px solid #eee">
        <el-menu :default-openeds="['1', '3']">
            <el-submenu index="1">
                <template slot="title"><i class="el-icon-message"></i>システムインフォメーション</template>
                    <el-menu-item index="1-1">
                        <router-link to="/dept">デパートメント</router-link>
                    </el-menu-item>
                    <el-menu-item index="1-2">
                        <router-link to="/emp">従業員</router-link>
                    </el-menu-item>
                </el-submenu>
        </el-menu>
    </el-aside>

    <el-main>
        <!-- 主要表单 -->
        <el-form :inline="true" :model="searchForm" class="demo-form-inline">
            <el-form-item label="名前">
                <el-input v-model="searchForm.name" placeholder="名前"></el-input>
            </el-form-item> 
            <el-form-item label="性別">
                <el-select v-model="searchForm.gender" placeholder="性別">
                <el-option label="男" value="1"></el-option>
                <el-option label="女" value="2"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">検索</el-button>
            </el-form-item>
            <el-date-picker
                v-model="searchForm.entrydate"
                type="daterange"
                range-separator="日"
                start-placeholder="から"
                end-placeholder="まで">
            </el-date-picker>

        </el-form>
        <!-- 主要表格 -->
        <el-table :data="tableData" border>
            <el-table-column prop="name" label="名前" width="180"></el-table-column>
            <el-table-column prop="image" label="プロファイル" width="180">
                <template slot-scope="scope">
                    <img :src="scope.row.image" width="100px" height="70px">
                </template>
            </el-table-column>
            <el-table-column prop="gender" label="性别" width="140">
                <template slot-scope="scope">
                    {{scope.row.gender == '1' ? '男' : '女'}}
                </template>
            </el-table-column>
            <el-table-column prop="job" label="職位" width="140">
            </el-table-column>
            <el-table-column prop="entrydate" label="入職日" width="180"></el-table-column>
            <el-table-column prop="updatetime" label="アップデート時間" width="230"></el-table-column>
            <el-table-column label="オペレーション" >
            <el-button type="primary" size="mini">編集</el-button>
            <el-button type="danger" size="mini">削除</el-button>
            </el-table-column>
        </el-table>
        <br>
        <!-- 分页条 -->
        <el-pagination
        background
        layout="prev, pager, next, jumper, sizes"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :total="1000">
        </el-pagination>
    </el-main>
    </el-container>
    </el-container>
    </div>
</template>

<script>
import axios from 'axios';
    export default {
        data() {
            return{
                tableData : [],
                searchForm : {
                    name:"",
                    gender:"",
                    entrydate:[]
                }
            }
        },
        methods: {
            onsubmit(){
                alert(JSON.stringify(this.searchForm))
            },
            handleSizeChange(val){
                alert(val)
            },
            handleCurrentChange(val){
                alert(val)
            }
        },
        mounted(){
            axios.get("https://yapi.pro/mock/366542/users/information/basic_1714275658425").then((result)=>{
                this.tableData = result.data.data;
            });
        }
}
</script>

<style>

</style>