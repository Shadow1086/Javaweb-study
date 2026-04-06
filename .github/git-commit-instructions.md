# Git Commit Instructions for GitHub Copilot

本仓库是一个 **Java Web 学习项目**。

生成 commit message 时，不要只描述“改了什么文件”，还要说明 **本次学习或整理的知识点**。  
提交信息应该让人一眼看出：

1. 改动属于什么类型
2. 改动的核心内容
3. 对应的 Java Web 学习主题

## 1. 提交格式

统一使用下面的格式：

```text
<类型前缀>: <简短描述>

- 学习主题: <本次涉及的知识点>
- 主要改动: <做了什么>
- 补充说明: <可选，必要时再写>
```

## 2. 类型前缀

优先使用以下前缀：

- `✨ feat`: 新增学习内容、示例、章节、案例
- `📝 docs`: 补充或整理文档、笔记、注释
- `♻️ refactor`: 重构示例代码或文档结构，但不改变核心学习内容
- `🐛 fix`: 修正文档错误、代码错误、示例错误、错别字、错误知识点
- `✅ test`: 补充测试或验证用例
- `🔧 chore`: 杂项维护，例如目录整理、文件重命名、配置调整

## 3. 生成规则

生成 commit message 时必须遵守以下规则：

- 使用**简体中文**
- 标题简洁明确，不要空泛，不要写成“update files”这类废话
- 标题中尽量直接点出本次学习模块，例如：`Servlet`、`HTTP`、`Tomcat`、`Filter`、`Cookie`、`Session`、`jQuery`
- 正文里必须包含一行 `学习主题`
- `学习主题` 不能只写“大而空”的词，应该尽量具体，例如：
  - `Servlet 生命周期与请求处理`
  - `请求转发与响应重定向`
  - `Cookie 和 Session 会话管理`
  - `Filter 过滤器与过滤器链`
  - `jQuery 事件绑定与页面交互`
- 如果本次改动主要是整理笔记，也要说明整理的是哪块知识
- 如果本次改动修复了错误，正文要说明修复的是哪类错误，例如术语格式、代码示例、知识点表述、标题层级
- 不要编造未发生的改动
- 不要写过长标题，建议控制在 `50` 个字符以内
- 如果改动同时涉及多个知识点，优先突出最核心的一个，其他内容放到正文

## 4. 本项目特别要求

因为这是一个学习型仓库，所以 commit message **必须体现知识点**，不能只体现技术动作。

错误示例：

```text
📝 docs: 更新文档
```

```text
✨ feat: 修改几个文件
```

```text
🔧 chore: 调整格式
```

正确方向示例：

```text
📝 docs: 完善 Servlet 生命周期笔记

- 学习主题: Servlet 生命周期与单例线程安全
- 主要改动: 补充 init、service、destroy 的执行流程和注意事项
```

```text
📝 docs: 整理请求转发与响应重定向

- 学习主题: Servlet 页面跳转方式
- 主要改动: 区分 forward 和 sendRedirect 的特点、适用场景与限制
```

```text
🐛 fix: 修正 Filter 章节术语格式

- 学习主题: Filter 过滤器与过滤器链
- 主要改动: 修复文档中术语格式不统一和部分标题不规范的问题
```

```text
✨ feat: 补充 Cookie 和 Session 示例

- 学习主题: 会话管理
- 主要改动: 增加 Cookie 持久化、Session 存值取值的示例代码
```

```text
📝 docs: 完善 jQuery 页面交互笔记

- 学习主题: jQuery 事件绑定与页面跳转
- 主要改动: 补充 click 事件、location 跳转和常见页面操作示例
```

## 5. Copilot 生成时的优先判断

生成 commit message 时，按这个顺序判断：

1. 这次改动的核心知识点是什么
2. 这次改动属于新增、整理、修复、重构还是杂项维护
3. 标题中是否已经清楚体现了学习模块
4. 正文中是否明确写出了 `学习主题`
5. 正文中是否准确描述了主要改动

## 6. 推荐输出风格

推荐生成：

```text
📝 docs: 补充 ServletConfig 与 ServletContext 笔记

- 学习主题: ServletConfig 和 ServletContext 的区别与用法
- 主要改动: 增加初始化参数、共享范围和常用 API 的说明
```

不推荐生成：

```text
📝 docs: update markdown
```

```text
🔧 chore: clean up files
```

```text
✨ feat: add content
```
