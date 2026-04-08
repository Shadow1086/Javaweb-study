// 无论以什么方式导入，都会被当作一个对象进行处理
// 导入moudule.js文件
// * 代表moudule.js的所有成员

import createUser, { PI, sum } from "./moudule.js";

console.log("PI =", PI);
console.log("sum(5, 6) =", sum(5, 6));

const user = createUser("王五", 21);
user.sayHello();
