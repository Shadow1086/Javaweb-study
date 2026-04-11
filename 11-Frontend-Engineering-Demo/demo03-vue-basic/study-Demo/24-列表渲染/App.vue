<script lang="ts" name="App" setup>
import {reactive} from "vue";

let pro = "产品"
let items = reactive([{
    id: "item1",
    message: "薯片"
}, {
    id: "item2",
    message: "可乐"
}, {
    id: "item3",
    message: "炸鸡"
}
])

let carts = reactive([{
    name: "可乐",
    price: 3,
    number: 10
},
    {
        name: "薯片",
        price: 6,
        number: 5
    }])
// 计算购物车总金额的函数
let sum = () => {
    let total = 0;
    for (let index in carts) {
        total += carts[index].price * carts[index].number;
    }
    return total;
}
// 从购物车中移除商品
let removeCart = (index: number) => {
    carts.splice(index, 1);
}
let removeAll = ()=>{
    carts.splice(0,carts.length);
}
</script>

<template>
    <div>
        <h1>您的购物车如下：</h1>
        <!--     当购物车中有对象时，显示表格-->
        <table border="1px solid">
            <thead>
            <tr>
                <th>序号</th>
                <th>名称</th>
                <th>价格</th>
                <th>数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody v-if="carts.length>0">
            <tr v-for="(cart , index) in carts">
                <td v-text="index+1"></td>
                <td v-text="cart.name"></td>
                <td v-text="cart.price"></td>
                <td v-text="cart.number"></td>
                <td v-text="cart.price * cart.number"></td>
                <td>
                    <button @click="removeCart(index)">删除</button>
                </td>
            </tr>
            </tbody>
            <!--    当购物车为空时显示如下：-->
            <tbody v-else>
            <td colspan="6">购物车空了</td>
            </tbody>
        </table>
        <div>购物车总金额为：{{ sum() }}元</div>
        <button @click="removeAll">一键清空购物车</button>

        <!--        <ul>-->
        <!--            <li v-for="(item,index) in items">{{ pro }}{{ index + 1 }}{{ item.message }}</li>-->
        <!--        </ul>-->
    </div>
</template>


<style scoped>

</style>