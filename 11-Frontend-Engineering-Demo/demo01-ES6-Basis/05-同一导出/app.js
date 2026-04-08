// 无论以什么方式导入，都会被当作一个对象进行处理
// 导入moudule.js文件
// * 代表moudule.js的所有成员

import * as m1 from "./moudule.js";
// m1 就是一个对象，其中的类，变量就会变成m1的属性
console.log(m1.PI);
console.log("命名空间导入 sum =", m1.sum(3, 4));

// 通过解构表达式,通过as可以设置别名,
import { PI as pi, sum, Person } from "./moudule.js";

console.log("按需导入 PI =", pi);
console.log("按需导入 sum =", sum(10, 20));

const user = new Person("李四", 20);
user.sayHello();
