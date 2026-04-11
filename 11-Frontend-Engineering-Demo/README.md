# 11 前端工程化学习路线

这一部分的目标不是一口气学完所有前端工具，而是按下面的顺序把基础打稳：

1. 先掌握 ES6 基础语法和模块化。
2. 再理解 npm 的职责，以及 `package.json`、脚本、依赖管理。
3. 最后再进入更完整的工程化工具，例如 Vite、Webpack、Babel、TypeScript。

## 当前目录说明

### `demo01-ES6-Basis`

用于学习 ES6 的基础语法和原生模块化，包括：

- `let`、`const`、模板字符串
- 解构赋值
- 深拷贝和浅拷贝
- `export` / `import`
- 分别导出、统一导出、默认导出

### `demo02-NPM-Basis`

用于承接后续 npm 学习，重点放在：

- `package.json` 的结构
- `scripts` 的作用
- 依赖和开发依赖的区别
- `npm install`、`npm run` 的基本使用

## 建议学习顺序

1. 先看 `demo01-ES6-Basis/README.md`
2. 再依次运行各个 ES6 示例
3. 然后进入 `demo02-NPM-Basis/README.md`
4. 等 npm 概念熟悉后，再继续学习构建工具

## 注意

- 浏览器中的 ES Module 导入路径通常需要写完整扩展名，例如 `./module.js`
- `node_modules/` 不应该提交到 Git
- `package-lock.json` 通常应该提交，除非你是做一次性实验目录
