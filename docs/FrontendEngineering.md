# 前端工程化

前端工程化不是“学几个命令”，而是把前端代码从零散脚本整理成可维护项目的过程。

对当前这个仓库，更合适的学习顺序是：

1. 先掌握 ES6 基础语法
2. 再理解 ES6 模块化
3. 然后学习 npm 的职责和常用命令
4. 最后再看构建工具和脚手架

## 对应示例目录

- `11-Frontend-Engineering-Demo/demo01-ES6-Basis`
- `11-Frontend-Engineering-Demo/demo02-NPM-Basis`

## 第一阶段：ES6 基础语法

### `let`、`const`、模板字符串

核心结论：

- 新代码优先使用 `const`
- 变量需要重新赋值时再使用 `let`
- `var` 不是不能用，只是不再推荐当作默认选项

#### `let` 和 `var` 的差别

1. `let` 不能重复声明
2. `let` 有块级作用域
3. `let` 不会像 `var` 一样发生变量提升后的“可访问但值为 `undefined`”行为
4. `let` 定义的全局变量不会挂到 `window` 上，

#### `const` 的重点

- `const` 不能重新赋值
- 但如果值是对象或数组，对象内部的数据仍然可以改

```js
const user = { name: "张三" };
user.name = "李四";
```

#### 模板字符串

```js
const userName = "张三";
const message = `${userName}，你好`;
```

模板字符串适合：

- 拼接变量
- 多行字符串
- 构造简单 HTML 片段

### 解构赋值

#### 数组解构

```js
const arr = [11, 22, 33];
const [a, b, c, d = 10] = arr;
```

#### 对象解构

```js
const person = { name: "张三", age: 18 };
const { name, age } = person;
```

#### 函数参数解构

```js
function printUser({ name, age }) {
    console.log(name, age);
}
```

### `rest` 和 `spread`

- `rest` 用在形参位置，用于接收剩余参数
- `spread` 用在实参位置或解包位置，用于展开数组或对象

```js
function sum(...nums) {
    return nums.reduce((total, item) => total + item, 0);
}

const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];
const merged = [...arr1, ...arr2];
```

### 深拷贝和浅拷贝

- 浅拷贝：两个变量仍然指向同一个引用对象
- 深拷贝：复制出新的数据结构

```js
const source = { name: "张三", hobbies: ["code"] };
const shallowCopy = source;
const deepCopy = JSON.parse(JSON.stringify(source));
```

注意：

- `JSON.parse(JSON.stringify(obj))` 适合演示概念
- 真正业务里如果数据复杂，这种方式会丢失函数、`Date`、`undefined` 等内容

## 第二阶段：ES6 模块化

浏览器原生支持 ES Module，但有两个前提：

1. `script` 标签要写 `type="module"`
2. 本地模块导入时路径要写完整，例如 `./module.js`

### 分别导出

```js
const PI = 3.14;
function sum(a, b) {
    return a + b;
}

export { PI, sum };
```

### 统一导出

```js
export const PI = 3.14;
export function sum(a, b) {
    return a + b;
}
```

### 默认导出

```js
export default function createUser(name) {
    return { name };
}
```

### 模块化的核心理解

不管你用哪一种导出方式，都是在向模块暴露“可被外部使用的成员”。

真正要理解的不是语法本身，而是：

- 什么内容应该留在模块内部
- 什么内容应该对外暴露
- 一个模块到底负责哪一件事

## 第三阶段：npm 入门

npm 不等于前端工程化的全部，但它通常是入口。

### npm 主要解决什么问题

1. 管理项目依赖
2. 统一项目脚本命令
3. 配合构建工具组织开发流程

### `package.json` 最常见的几个字段

```json
{
  "name": "demo02-npm-basis",
  "version": "1.0.0",
  "type": "module",
  "scripts": {
    "dev": "node src/main.js"
  }
}
```

字段含义：

- `name`：项目名
- `version`：版本号
- `type`：设为 `module` 后，Node.js 支持 ES Module 语法
- `scripts`：定义可复用命令

### 常用命令

```bash
npm init -y
npm install axios
npm install -D vite
npm run dev
```

### 依赖分类

- `dependencies`
  - 项目运行时需要
- `devDependencies`
  - 开发和构建时需要

### 和当前仓库的关系

建议你把 npm 的学习放在 `11-Frontend-Engineering-Demo/demo02-NPM-Basis` 中继续推进，这样目录会比较顺：

1. 先在浏览器里理解 ES6 模块
2. 再在 Node.js 项目里理解 `package.json` 和脚本
3. 最后再进入 Vite / Webpack

## 后续建议

等 npm 基础稳定后，再继续补下面几块：

- Vite 快速启动
- Babel 的作用
- Webpack 的基本概念
- TypeScript 与类型约束
