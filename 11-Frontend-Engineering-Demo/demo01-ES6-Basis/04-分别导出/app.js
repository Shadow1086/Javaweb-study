// 无论以什么方式导入，都会被当作一个对象进行处理
// 导入moudule.js文件
// * 代表moudule.js的所有成员

import * as m1 from "./moudule.js";
// m1 就是一个对象，其中的类，变量就会变成m1的属性
console.log(m1.PI);
console.log("sum(10, 20) =", m1.sum(10, 20));

const user = new m1.Person("张三", 18);
user.sayHello();
