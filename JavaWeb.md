# 1. JavaScript

## 1.1 基础语法

### 1.1.1 `javascript`变量类型

`Javascript`的变量类型：

| 类型    | 值          |
|-------|------------|
| 数值类型  | `number`   |
| 字符串类型 | `string`   |
| 对象类型  | `object`   |
| 布尔类型  | `boolean`  |
| 函数类型  | `function` |

`javascript`里特殊的值：

| 值           | 说明                                         |
|-------------|--------------------------------------------|
| `undefined` | 未定义，所有javascript变量为赋予初始值的时候，默认值都是undefined |
| `null`      | 空值                                         |
| `NaN`       | 全称是Not a number 非数字，非数值。                   |

`javascript`中定义变量格式：

```javascript
let 变量名 = 值;
const 常量名 = 值;
```

**校正：**

- `var` 不是不能用，但现在新代码通常优先使用 `let` 和 `const`
- 默认优先 `const`，只有变量需要重新赋值时才使用 `let`

```javascript
const userName = "Tom";
let age = 18;
age = 19;
```

### 1.1.2 `javascript`中的关系运算

和`java`类似。

| 运算  | 符号    | 说明                         |
|-----|-------|----------------------------|
| 等于  | `==`  | 等于是简单的左字面值的比较              |
| 全等于 | `===` | 除了左字面值的比较之外，还会比较两个变量的数据类型。 |

比如：

```javascript
let a = 12;
let b = '12';
alert(a == b);//true
alert(a === b);// false
```

### 1.1.3 `javascript`中的逻辑运算

| 运算   | 符号   |
|------|------|
| 且运算  | `&&` |
| 或运算  | `    ||` |
| 取反运算 | `!`  |

在`javascript`语言中，所有的变量，都可以作为一个`boolean`类型的变量去使用。

**但是注意：**

| 值           |
|-------------|
| `0`         |
| `null`      |
| `undefined` |
| `""`（空串）    |

都认为是`false`

示例：

```javascript
let a = 0;
if (a) {
	alert("零为真");
} else {
	alert("零为假");
}               // 返回假
```

> **注意：**

- `&&`：当表达式都为真时，返回最后一个表达式的值；只要有一个为假，就返回第一个为假的值
- `||`：当表达式都为假时，返回最后一个表达式的值；只要有一个为真，就返回第一个为真的值
- `&&` 和 `||` 都有短路特性：前面的表达式已经能决定结果时，后面的表达式不会再执行

示例：

```javascript
let a = "abc";
let b = true;
let d = false;
let c = null;

alert(a && b);      // true
alert(b && a);      // "abc"
```

### 1.1.4 数组

**数组的定义方式：**

`javascript`中数组的定义：

**格式：**

```javascript
const arr1 = [];   // 空数组
const arr2 = [1, "abc", true];  // 定义数组同时赋值元素
```

**注意：**

`javascript`中的数组，只要我们通过数组下标赋值，那么最大的下标值，就会自动地给数组做扩容操作。

**属性：**

`length`

**遍历：**

```javascript
const arr = [10, 20, 30];

for (let i = 0; i < arr.length; i++) {
	console.log(arr[i]);
}
```

### 1.1.5 函数

**函数的定义：**

| 方式                | 定义                                 |
|-------------------|------------------------------------|
| 方法一：使用function关键字 | `function 函数名(形参列表){    函数体     }` |
| 方法二               | `const 函数名 = function(形参列表){函数体}`  |

**示例：**

```javascript
// 定义一个函数
function add(x, y) {
	alert(x + y);
}

// 定义带有返回值的函数
function addReturn(x, y) {
	return x + y;
}

const result = addReturn(1, 2);
alert(result);
```

**重载：**

在`java`中允许重载,但是在`JS`中函数的重载会直接覆盖掉上一次的定义

```javascript
function add(x, y) {
	return x + y;
}

function add(x, y, z) {
	return x + y + z;
}

console.log(add(1, 2));   // NaN，因为 z 是 undefined
```

**校正：**

- 这里不会“报错”，而是后面的同名函数覆盖前面的定义
- `add(1, 2)` 实际等价于 `1 + 2 + undefined`，结果是 `NaN`
- 现代写法更推荐使用剩余参数 `...args`

**函数的 `arguments` 隐形参数（只在`function`函数内部）：**

隐形参数：在`function`函数中不需要定义,但却可以直接用来获取所有参数的变量

隐形参数就很像`java`基础的可变长参数一样

```java
public void fun(Object... args);// 可变长参数其实是一个数组
```

那么`javascript`中的隐形参数也跟`java`的可变长参数一样,操作类似于数组。

**校正：**

- `arguments` 现在仍然可用，但属于偏老的写法
- 新代码更推荐使用剩余参数 `...args`，语义更清晰，也是真数组

示例：

```javascript
function fun() {
	alert(arguments.length); // 查看参数的个数
	for (let i = 0; i < arguments.length; i++) {
		alert(arguments[i]);
	}
	alert("无参函数fun()");
}

fun(1, 'ass', true);
```

现代写法示例：

```javascript
function fun(...args) {
	console.log(args.length);
	for (const arg of args) {
		console.log(arg);
	}
}

fun(1, "ass", true);
```

需求：编写一个函数,用于计算所有参数相加的和并返回

```javascript
function sum(num1, num2) {
	let result = 0;
	for (let i = 0; i < arguments.length; i++) {
		if (typeof arguments[i] == "number") {
			result += arguments[i];
		}
	}
	return result;
}

alert(sum(1, 2, 3, "abc", 4, 5, 6, 7, 8));        // 返回36
```

更推荐的现代写法：

```javascript
function sum(...args) {
	let result = 0;
	for (const item of args) {
		if (typeof item === "number") {
			result += item;
		}
	}
	return result;
}

console.log(sum(1, 2, 3, "abc", 4, 5, 6, 7, 8)); // 36
```

### 1.1.6 自定义对象

- **`Object`形式**的自定义对象：

```javascript
const 变量名 = new Object();     // 对象实例，空对象
变量名.属性名 = 值;                 //定义一个属性
变量名.函数名 = function () {         // 定义一个函数
}
// 对象的访问：
变量名.属性 / 函数名();
```

**校正：**

- `new Object()` 还能用，但现在基本不推荐
- 新代码优先使用对象字面量 `{}`，更简洁

示例：

```javascript
const obj = new Object();
alert(typeof (obj));
obj.name = "二狗子";
obj.age = 19;
obj.add = function () {
	return "obj的add()函数的调用";
};

alert(obj.name);
alert(obj.add());
```

- **`{}`花括号形式：**

```javascript
const 变量名 = {
	属性名: 值, // 定义一个属性
	函数名: function () {
	} // 定义一个函数
};
对象的访问和上个方法是一样的
```

示例：

```javascript
const student = {
	name: "二狗子",
	age: 18,
	add: function () {
		return "add()函数被调用了";
	}
};
```

现代简写：

```javascript
const student = {
	name: "二狗子",
	age: 18,
	add() {
		return "add()函数被调用了";
	}
};
```

### 1.1.7 事件

**常用的事件：**

| 事件                  | 说明                        |
|---------------------|---------------------------|
| `onload` 加载完成事件     | 网页加载完成之后，常用于做页面js代码初始化操作  |
| `onclick` 单击事件      | 常用于按钮的点击响应操作              |
| `onblur` 失去焦点事件     | 常用于输入框离开/失去焦点后验证其输入内容是否合法 |
| `onchange` 内容发生改变事件 | 常用于下拉列表和输入框内容发生改变后的操作     |
| `onsubmit` 表单提交事件   | 常用于表单提交前，验证所有表单项是否合法      |

**事件注册：**

事件注册(绑定)：告诉浏览器，当事件响应后要执行哪些操作代码

静态注册事件：通过`html`标签的事件属性直接赋予事件响应后的代码

动态注册事件：先通过`js`代码得到标签的`dom`对象，再通过`addEventListener()`绑定事件处理函数

**校正：**

- 内联事件（例如 `onclick="..."`）和 `dom对象.onclick = fn` 都属于老写法
- 现代浏览器中更推荐 `addEventListener()`，因为它支持绑定多个监听器，也更容易维护

**现代动态注册的基本步骤：**

1. 获取标签对象
2. 标签对象.`addEventListener("事件名", function(){})`

**`load` / `DOMContentLoaded` 事件：**

```javascript
document.addEventListener("DOMContentLoaded", function () {
	alert("DOM 已经构建完成，适合做初始化");
});

window.addEventListener("load", function () {
	alert("页面资源也已经加载完成");
});
```

**`onclick`事件：**

```javascript
document.addEventListener("DOMContentLoaded", function () {
	const btnObj = document.getElementById("btn01");
	btnObj.addEventListener("click", function () {
		alert("动态注册的onclick事件");
	});
});
```

如果只绑定一次，旧写法也能跑：

```javascript
const btnObj = document.getElementById("btn01");
btnObj.onclick = function () {
	alert("这是旧写法，不推荐继续作为主教学写法");
};
```

**`onblur`事件：**

```javascript
document.addEventListener("DOMContentLoaded", function () {
	const pwd = document.getElementById("password");
	pwd.addEventListener("blur", function () {
		alert("动态注册失去焦点事件");
	});
});
```

**`onchange`事件：**

```javascript
document.addEventListener("DOMContentLoaded", function () {
	const element = document.getElementById("province");
	element.addEventListener("change", function () {
		alert("onchange的动态注册方法---居住地更改");
	});
});
```

**`onsubmit`表单提交事件：**

```javascript
document.addEventListener("DOMContentLoaded", function () {
	const form = document.getElementById("form01");
	form.addEventListener("submit", function (event) {
		const isValid = false;
		if (!isValid) {
			alert("表单不合法，阻止提交");
			event.preventDefault();
		}
	});
});
```

### 1.1.8 `DOM`模型

`DOM`(`Document Object Model`,文档对象模型)：将文档中的所有标签，属性，文本转换成对象来进行管理

**理解：**

- `Document`管理类所有`HTML`文档内容
- `document`是一种树结构的文档，有层级关系。
- 它让我们把所有的标签都对象化
- 可以通过`document`访问所有的标签对象。

**`Document`对象中的方法：**

| 方法                                        | 说明                                            |
|-------------------------------------------|-----------------------------------------------|
| `document.getElementById(elementId)`      | 通过标签的`id`属性查找标签`dom`对象，`elementId`是标签的`id`属性值 |
| `document.getElementsByName(elementName)` | 通过标签的`name`属性查找标签`dom`对象                      |
| `document.getElementsByTagName(tagName)`  | 通过标签名查找标签`dom`对象，`tagName`是标签名                |
| `document.querySelector(selector)`        | 按`CSS`选择器返回第一个匹配元素                            |
| `document.querySelectorAll(selector)`     | 按`CSS`选择器返回所有匹配元素                             |
| `document.createElement(tagName)`         | 通过给定的标签名，创建一个标签对象，`tagName`是要创建的标签名           |

**校正：**

- 上面这几个方法没有所谓“语言层面的优先级”，那只是开发习惯
- 现代前端更常用 `querySelector()` 和 `querySelectorAll()`，因为表达能力更强

现代写法示例：

```javascript
const userInput = document.querySelector("#checkUserName");
const hobbyList = document.querySelectorAll("input[name='hobby']");
```

**`getElementById()`方法的使用：**

```javascript
/*
 * 当用户点击率校验按钮，要获取输入框中的内容，并且验证其是否合法
 * 验证的规则是：必须由字母、数字、下划线组成，并且长度是5~12位
 */
function onclickFunc() {
	let element = document.getElementById("checkUserName");
	console.log("type = " + element.type);
	console.log("value = " + element.value);
	console.log("id = " + element.id);

	let username = element.value;
	// 正则表达式
	let patt = /^\w{5,12}$/;
	// test()方法用于测试某个字符串是不是匹配正则表达式
	// 匹配返回true，不匹配返回false
	if (patt.test(username)) {
		alert("用户名合法");
	} else {
		alert("用户名不合法");
	}
}
```

**`getElementsByName`方法：**

```javascript
/*
 * 场景：复选框的全选，全不选，反选
 */
function selectAll() {
	// 让所有复选框都选中
	// document.getElementsByName()是根据指定的name属性返回的多个标签对象集合
	// 集合中每个元素都是dom对象
	let eles = document.getElementsByName("hobby");
	for (let i = 0; i < eles.length; i++) {
		// checkbox中的checked表示复选框的选中状态，如果选中为true，不选中为false
		eles[i].checked = true;
	}
}

function selectNone() {
	let eles = document.getElementsByName("hobby");
	for (let i = 0; i < eles.length; i++) {
		eles[i].checked = false;
	}
}

function selectReverse() {
	let eles = document.getElementsByName("hobby");
	for (let i = 0; i < eles.length; i++) {
		eles[i].checked = !eles[i].checked;
	}
}
```

**`getElementsByTagName`方法：**

- 参数：标签名，比如input,div,span...

```javascript
function selectAll() {
	// document.getElementsByTagName("")：按照指定标签名来进行查询并返回集合
	let eles = document.getElementsByTagName("input");
	for (let i = 0; i < eles.length; i++) {
		eles[i].checked = true;
	}
}
```

#### `document`中节点的常用属性和方法

**什么是节点？**

节点就是标签对象

**方法：**（通过具体的元素节点进行调用）

| 方法                        | 说明                                |
|---------------------------|-----------------------------------|
| `getElementsByTagName()`  | 获取当前节点的指定标签名孩子节点                  |
| `appendChild(oChildNode)` | 可以添加一个子节点，其中`oChildNode`是要添加的孩子节点 |

**属性：**

| 属性                  | 说明                       |
|---------------------|--------------------------|
| `childNodes`        | 获取当前节点的所有子节点，元素、文本、注释都算  |
| `firstChild`        | 获取当前节点的第一个子节点，元素、文本、注释都算 |
| `firstElementChild` | 第一个子元素，只看标签元素            |
| `lastChild`         | 获取当前节点的最后一个子节点           |
| `parentNode`        | 获取当前节点的父节点               |
| `nextSibling`       | 获取当前节点的下一个节点             |
| `previousSibling`   | 获取当前节点的上一个节点             |
| `className`         | 用于获取/设置标签的`class`属性值     |
| `innerHTML`         | 表示获取/设置起始标签和结束标签中的内容     |
| `textContent`       | 表示获取/设置起始标签和结束标签中的纯文本    |

**示例：**

```javascript
// 查找#city下的所有li节点
let btn04Ele = document.getElementById("btn04");
btn04Ele.onclick = function () {
	const cityId = document.getElementById("city");
	const liList = cityId.getElementsByTagName("li");
	let result = "";
	for (let i = 0; i < liList.length; i++) {
		result += liList[i].textContent + "    ";
	}
	alert(result);
};

// 返回#phone的第一个子节点
let btn06Ele = document.getElementById("btn06");
btn06Ele.onclick = function () {
	const firstChild = document.getElementById("phone").firstElementChild;
	alert(firstChild.textContent);
};
// 需求：使用javascript代码创建html标签，并且显示在界面上
document.addEventListener("DOMContentLoaded", function () {
	const htmlDivElement = document.createElement("div"); // 在内存中，<div></div>
	// htmlDivElement.textContent = "你好";  // <div>你好</div>，在内存中
	// 创建一个文本节点对象并且作为div标签的子元素
	const text = document.createTextNode("你好");
	htmlDivElement.appendChild(text);

	document.body.appendChild(htmlDivElement);
});
```

**补充：**

- `innerHTML` 适合明确需要插入一段 HTML 时使用
- 只想设置纯文本时，更推荐 `textContent`，更安全也更直接

### 1.1.9 正则表达式

**语法：**

```javascript
let modifiers = "";
let patt = new RegExp(pattern, modifiers);

//或者更简单的写法：
let patt01 = /pattern/g;
```

- `pattern`(模式)：描述了表达式的模式
- `modifiers`(修饰符)：用于指定全局匹配、区分大小写的匹配和多行匹配

**常用修饰符：**

| 修饰符 | 作用           | 修饰符 | 作用     |
|-----|--------------|-----|--------|
| `i` | 执行对大小写不敏感的匹配 | `g` | 执行全局匹配 |
| `m` | 执行多行匹配       |     |        |

**常用字符范围：**

| 表达式     | 说明                      | 表达式                  | 说明                      |
|---------|-------------------------|----------------------|-------------------------|
| `[abc]` | 查找方括号之间的任何字符            | `[^abc]`             | 查找任何不在方括号之间的字符          |
| `[0-9]` | 查找任何从 `0` 至 `9` 的数字     | `[a-z]`              | 查找任何从小写 `a` 到小写 `z` 的字符 |
| `[A-Z]` | 查找任何从大写 `A` 到大写 `Z` 的字符 | `(red\|blue\|green)` | 查找任何指定的选项               |

**常用元字符：**

| 元字符  | 说明                                    | 元字符  | 说明          |
|------|---------------------------------------|------|-------------|
| `.`  | 查找单个字符，除了换行和行结束符                      | `\w` | 查找数字、字母及下划线 |
| `\W` | 查找非单词字符:`a-z,A-Z,0-9以及下划线，包含_(下划线)字符` | `\d` | 查找数字        |
| `\D` | 查找非数字字符                               | `\s` | 查找空白字符      |
| `\S` | 查找非空白字符                               | `\b` | 匹配单词边界      |
| `\B` | 匹配非单词边界                               | `\n` | 查找换行符       |
| `\r` | 查找回车符                                 | `\t` | 查找制表符       |

**常用量词：**

| 量词       | 说明                                 | 示例         |
|----------|------------------------------------|------------|
| `n+`     | 匹配任何**包含**至少一个 `n` 的字符串            | `/a+/`     |
| `n*`     | 匹配任何**包含**零个或多个 `n` 的字符串           | `/bo*/`    |
| `n?`     | 匹配任何**包含**零个或一个 `n` 的字符串           | `/e?le?/`  |
| `n{X}`   | 字符串是否包含连续`X`次的`n`                  | `/a{2}/`   |
| `n{X,}`  | 前面的模式 `n` 连续出现至少 `X` 次时匹配          | `/a{2,}/`  |
| `n{X,Y}` | 前面的模式 `n` 连续出现至少 `X` 次，至多 `Y` 次时匹配 | `/a{1,3}/` |
| `n$`     | 匹配任何结尾为 `n` 的字符串                   | `/a$/`     |
| `^n`     | 匹配任何开头为 `n` 的字符串                   | `/^a/`     |
| `?=n`    | 匹配任何其后紧接指定字符串 `n` 的字符串             | `/a(?=b)/` |
| `?!n`    | 匹配任何其后没有紧接指定字符串 `n` 的字符串           | `/a(?!b)/` |

**`RegExp`对象方法：**

| 方法           | 说明                      | 方法       | 说明                             |
|--------------|-------------------------|----------|--------------------------------|
| `exec()`     | 检索字符串中指定的值，返回找到的值并确定其位置 | `test()` | 检索字符串中指定的值，返回 `true` 或 `false` |
| `toString()` | 返回正则表达式的字符串             |          |                                |

**支持正则表达式的 `String` 对象方法：**

| 方法          | 说明            | 方法        | 说明              |
|-------------|---------------|-----------|-----------------|
| `search()`  | 检索与正则表达式相匹配的值 | `match()` | 找到一个或多个正则表达式的匹配 |
| `replace()` | 替换与正则表达式匹配的子串 | `split()` | 把字符串分割为字符串数组    |

# 2. `jQuery`

## 2.1 基本使用

**为按钮添加点击响应函数的步骤：**

1. 使用`jQuery`查询到标签对象
2. 使用标签对象`.on("click", function(){})`

**校正：**

- `jQuery` 现在仍然能用，但更多见于老项目维护；新项目很多场景直接用原生 `DOM` API 就够了
- `.click(handler)` 这种事件简写写法在 `jQuery 3.3` 已废弃，推荐统一改用 `.on()`

```html
<!-- 注意这里有两组script标签-->
<script
		crossorigin="anonymous"
		integrity="sha256-9fsHeVnKBvqh3FB2HYu7g2xseAZ5MlN6Kz/qnkASV8U="
		src="https://code.jquery.com/jquery-4.0.0.js"></script>
<script>
	// 使用javascript和dom对象方式
	// document.addEventListener("DOMContentLoaded", function () {
	//     let btnObj = document.getElementById("btnId");
	//     btnObj.addEventListener("click", function () {
	//         alert("js原生的单击事件");
	//     });
	// });

	// 表示页面加载完成之后，相当于window.onload
	$(function () {
		const $btnObj = $("#btnId");
		// 推荐写法：使用 on() 绑定事件
		$btnObj.on("click", function () {
			alert("jQuery单击事件");
		});
	});
</script>
```

## 2.2 `jQuery`核心函数

**`$`是`jQuery`的核心函数，能完成`jQuery`的很多功能。`$()`就是调用`$`这个函数**

**当传入参数不一样时，其功能也不一样：**

| 传入参数        | 作用                                                                       |
|-------------|--------------------------------------------------------------------------|
| `[函数]`      | 表示`DOM`准备完成后执行，相当于原生的`document.addEventListener("DOMContentLoaded", fn)` |
| `[HTML字符串]` | 会帮我们创建`HTML`对象                                                           |
| `[选择器字符串]`  | 类似于`CSS`的选择器，根据选择器查询标签对象                                                 |
| `[DOM对象]`   | 将`DOM`对象转化成`jQuery`对象，`DOM`对象`alert`出来的效果就是：`[object HTMLXxxElement]`    |

**`jQuery`对象`[Object object]`：**

- 通过`jQuery`提供的`API`创建的对象
- 通过`jQuery`包装的`DOM`对象
- 通过`jQuery`提供的`API`查询到的对象

**`jQuery`对象的本质：**

`jQuery`对象是`dom`对象的数组 + `jQuery`提供的一系列功能函数

**`jQuery`对象和`DOM`对象使用区别：**

`jQuery`对象不能使用`DOM`对象的属性和方法，同样地，`DOM`对象也不能使用`jQuery`对象的属性和方法。

**`DOM`对象和`jQuery`对象的相互转换：**

| 转换方向                 | 步骤                                        |
|----------------------|-------------------------------------------|
| `DOM`对象转化成`jQuery`对象 | 先有`DOM`对象，使用`$(DOM对象)`就可以转换成为`jQuery`对象   |
| `jQuery`对象转换成`DOM`对象 | 先有`jQuery`对象，`jQuery`对象`[下标]`取出相应的`dom`对象 |

## 2.3 `jQuery`选择器

### 2.3.1 基础选择器

| 选择器        | 写法                     | 说明        |
|------------|------------------------|-----------|
| `id`选择器    | `$("#id")`             | 按`id`查找元素 |
| `class`选择器 | `$(".className")`      | 按类名查找元素   |
| 标签选择器      | `$("div")`             | 按标签名查找元素  |
| 并集选择器      | `$("div, span, #box")` | 同时查找多个目标  |

**重点：并集选择器的返回顺序**

并集选择器选出来的结果，不是按照选择器里书写的先后顺序，而是按照元素在`HTML`文档中出现的顺序。

```html

<div id="one">one</div>
<span id="two">two</span>
<div id="three">three</div>
```

```javascript
const $elements = $("span, div");
```

返回顺序是：

1. `#one`
2. `#two`
3. `#three`

### 2.3.2 层级选择器

| 选择器    | 写法               | 说明               |
|--------|------------------|------------------|
| 后代选择器  | `$("#box li")`   | 查找`#box`内部所有`li` |
| 子元素选择器 | `$("#box > li")` | 只查找`#box`的直接子元素  |

**重点：**

`$("#box li")`会把后代都找出来，层级可以很深；`$("#box > li")`只看亲儿子，不看孙子。

### 2.3.3 基本过滤选择器

| 旧选择器写法          | 推荐替代写法            | 说明                |
|-----------------|-------------------|-------------------|
| `$("li:first")` | `$("li").first()` | 取匹配到的第一个元素        |
| `$("li:last")`  | `$("li").last()`  | 取匹配到的最后一个元素       |
| `$("li:eq(2)")` | `$("li").eq(2)`   | 取指定下标的元素，下标从`0`开始 |
| `$("li:odd")`   | `$("li").odd()`   | 取索引为奇数的元素         |
| `$("li:even")`  | `$("li").even()`  | 取索引为偶数的元素         |

**校正：**

- `:first`、`:last`、`:eq()`、`:odd`、`:even` 这类作为选择器后缀的写法，在 `jQuery 3.4` 已被废弃
- 推荐先用纯 CSS 选择器选中，再调用 `.first()`、`.last()`、`.eq()`、`.odd()`、`.even()` 继续过滤

```javascript
const $firstLi = $("#city li").first();
const $eqLi = $("#city li").eq(2);
const $oddLi = $("#city li").odd();
```

### 2.3.4 内容过滤选择器

| 选择器    | 写法                  | 说明               |
|--------|---------------------|------------------|
| 包含指定文本 | `:contains('text')` | 查找文本内容中包含指定内容的元素 |
| 空元素    | `:empty`            | 查找没有子节点的元素       |
| 含有子元素  | `:has(selector)`    | 查找内部包含指定元素的元素    |

```javascript
let $containsObj = $("div:contains('hello')");
let $hasObj = $("div:has(span)");
```

### 2.3.5 属性过滤选择器

| 选择器     | 写法                | 说明             |
|---------|-------------------|----------------|
| 存在指定属性  | `[name]`          | 查找包含指定属性的元素    |
| 属性等于某值  | `[name='value']`  | 查找属性值等于指定值的元素  |
| 属性不等于某值 | `[name!='value']` | 查找属性值不等于指定值的元素 |

```javascript
let $nameObj = $("input[name]");
let $checkedType = $("input[type='checkbox']");
```

### 2.3.6 表单过滤选择器

| 选择器         | 对应含义                        |
|-------------|-----------------------------|
| `:input`    | 所有表单项                       |
| `:text`     | `input`的`type='text'`       |
| `:password` | `input`的`type='password'`   |
| `:radio`    | `input`的`type='radio'`对象    |
| `:checkbox` | `input`的`type='checkbox'`对象 |
| `:submit`   | `input`的`type='submit'`对象   |
| `:checked`  | 选中的表单项                      |
| `:selected` | 选中的下拉项                      |

**使用时最容易混淆的地方：**

| 场景              | 正确写法          | 说明                     |
|-----------------|---------------|------------------------|
| 事件中的当前元素        | `$(this)`     | `this`本身通常是`DOM`对象     |
| 想调用`jQuery`方法   | `$(dom对象)`    | 先包装成`jQuery`对象         |
| 想调用`DOM`原生属性/方法 | `jQuery对象[0]` | 先从`jQuery`对象中取出`DOM`对象 |

## 2.4 `jQuery`的方法

### 2.4.1 `html()`、`text()`、`val()`

| 方法       | 作用                    | 对应`DOM`属性     |
|----------|-----------------------|---------------|
| `html()` | 可以设置或获取起始标签和结束标签中的内容  | `innerHTML`   |
| `text()` | 可以设置和获取起始标签和结束标签中的文本  | `textContent` |
| `val()`  | 可以设置和获取表单项的`value`属性值 | `value`       |

**重点：**

在`()`中不填写值就是获取，填写值就是设置。

```javascript
$(function () {
	// 不传参数是获取，传入参数是设置
	$("div").html();

	$("button").on("click", function () {
		$("#username").val("超级程序员"); // 设置值
		alert($("#username").val());     // 获取值
	});

	// 可以通过[]的形式操作多个数据
	$(":radio,:checkbox").val(["radio1", "radio2", "radio3", "checkbox01", "checkbox02"]);
});
```

### 2.4.2 `attr()`和`prop()`

| 方法       | 作用          | 说明                                              |
|----------|-------------|-------------------------------------------------|
| `attr()` | 可以设置和获取属性的值 | 还可以操作非标准属性，比如自定义属性：`abc`、`cc`                   |
| `prop()` | 可以设置和获取属性的值 | 推荐操作`checked`、`readOnly`、`selected`、`disabled`等 |

**重点：**

- `attr()`不推荐操作`checked`、`readOnly`、`selected`、`disabled`等属性
- `prop()`更适合操作这类有选中状态、布尔状态的属性

```javascript
$(function () {
	// 传入一个参数是获取值，传入两个参数是设置值
	$(":checkbox").first().attr("name");        // 获取name的值
	$(":checkbox").first().attr("name", "abc"); // 设置name的值

	// checkbox01有属性：checked="checked"，checkbox02没有checked属性。
	alert($(":checkbox").attr("checked"));   // 设置属性了的就是属性值
	alert($("#checkbox02").attr("checked")); // 未设置属性是undefined
	alert($("#checkbox02").prop("checked")); // 使用prop()返回false

	// 设置自定义的属性
	$(":checkbox").first().attr("abc", "abcValue");
});
```

### 2.4.3 案例一：全选全不选

```html
<label>
	你爱好的运动是?
	<input id="checkedAllBox" type="checkbox">全选/全不选
</label>
<br>
<input name="items" type="checkbox" value="足球">足球
<input name="items" type="checkbox" value="篮球">篮球
<input name="items" type="checkbox" value="乒乓球">乒乓球
<input name="items" type="checkbox" value="羽毛球">羽毛球
<br>
<button>全选</button>
<button>全不选</button>
<button>反选</button>
<button>提交</button>
```

```javascript
$(function () {
	// 全选按钮
	$(":button").first().on("click", function () {
		$(":input").prop("checked", true);
	});
	// 全不选按钮
	$(":button").eq(1).on("click", function () {
		$(":input").prop("checked", false);
	});
	// 反选按钮
	$(":button").eq(2).on("click", function () {
		let $checkbox = $(":checkbox[name='items']");
		$checkbox.each(function () {
			// 在each遍历的function函数中，有一个this对象，是当前遍历到的dom对象
			this.checked = !this.checked;
		});
		// 检查是否全选/全不选
		// 获取全部的球类个数，再获取选中的球类个数
		if ($checkbox.length === $(":checkbox[name='items']:checked").length) {
			$("#checkedAllBox").prop("checked", true);
		} else {
			$("#checkedAllBox").prop("checked", false);
		}
	});
	// 提交
	$(":button").last().on("click", function () {
		$(":input[name='items']").each(function () {
			if (this.checked === true) {
				alert(this.value);
			}
		});
	});

	// 全选/全不选的单选框
	$("#checkedAllBox").on("click", function () {
		// 在事件的function函数中，有一个this对象，这个this对象是当前正在响应事件的dom对象
		$(":checkbox[name='items']").prop("checked", this.checked);
	});
	// 给全部球类绑定单击事件
	$(":checkbox[name='items']").on("click", function () {
		let allCheckLength = $(":checkbox[name='items']").length;
		let selectLength = $(":checkbox[name='items']:checked").length;
		$("#checkedAllBox").prop("checked", allCheckLength === selectLength);
	});
});
```

## 2.5 `DOM`增删改

**`jQuery`写法：**

| 分类   | 方法               | 写法                  | 说明                        |
|------|------------------|---------------------|---------------------------|
| 内部插入 | `appendTo()`     | `a.appendTo(b)`     | 把`a`插入到`b`子元素末尾，成为最后一个子元素 |
| 内部插入 | `prependTo()`    | `a.prependTo(b)`    | 把`a`插入到`b`子元素的前面，成为第一个子元素 |
| 外部插入 | `insertAfter()`  | `a.insertAfter(b)`  | 得到`ba`                    |
| 外部插入 | `insertBefore()` | `a.insertBefore(b)` | 得到`ab`                    |
| 替换   | `replaceWith()`  | `a.replaceWith(b)`  | 用`b`替换掉`a`                |
| 替换   | `replaceAll()`   | `a.replaceAll(b)`   | 用`a`替换掉所有的`b`             |
| 删除   | `remove()`       | `a.remove()`        | 删除`a`标签                   |
| 删除   | `empty()`        | `a.empty()`         | 清除`a`标签内的内容               |

**现代原生 `DOM` 更常用的方法：**

| 场景          | 推荐方法                   | 说明                       |
|-------------|------------------------|--------------------------|
| 末尾插入子元素     | `append()`             | 可以直接插入节点或文本              |
| 开头插入子元素     | `prepend()`            | 比 `prependTo()` 更自然      |
| 在元素前插入兄弟元素  | `before()`             | 比 `insertBefore()` 更直观   |
| 在元素后插入兄弟元素  | `after()`              | 比 `insertAfter()` 更直观    |
| 替换当前元素      | `replaceWith()`        | 原生 `DOM` 也支持             |
| 删除当前元素      | `remove()`             | 原生 `DOM` 也支持             |
| 清空子元素       | `replaceChildren()`    | 比手动 `innerHTML = ""` 更清晰 |
| 插入一段 `HTML` | `insertAdjacentHTML()` | 插入结构化内容时很常见              |

```html
<!-- 演示中的div -->
<div id="box" style="border: 1px solid gray">1234</div>
```

**`jQuery`演示：**

```javascript
$(function () {
	$("<h1>appendTo()方法插入</h1>").appendTo("#box");
	$("<h1>prependTo()方法插入</h1>").prependTo($("#box"));
	$("<h2>insertAfter()方法插入</h2>").insertAfter("#box");
	$("<h2>insertBefore()方法插入</h2>").insertBefore("#box");
});
```

**现代原生 `DOM` 演示：**

```javascript
const box = document.querySelector("#box");

const title = document.createElement("h1");
title.textContent = "append()方法插入";
box.append(title);

const firstTitle = document.createElement("h1");
firstTitle.textContent = "prepend()方法插入";
box.prepend(firstTitle);

box.before(document.createElement("hr"));
box.after(document.createElement("hr"));

const newBox = document.createElement("section");
newBox.textContent = "replaceWith()替换后的内容";
box.replaceWith(newBox);
```

**插入 `HTML` 字符串的现代写法：**

```javascript
const list = document.querySelector("#list");
list.insertAdjacentHTML("beforeend", "<li>新节点</li>");
```

## 2.6 `CSS`样式的操作

**`jQuery`写法：**

| 方法              | 作用         |
|-----------------|------------|
| `addClass()`    | 添加样式       |
| `removeClass()` | 删除样式       |
| `toggleClass()` | 有就删除，没有就添加 |
| `offset()`      | 获取和设置元素的坐标 |

```javascript
$(function () {
	const $divEle = $("div").first();

	$("#btn01").on("click", function () {
		$divEle.addClass("reDiv blueBorder");
	});
	$("#btn02").on("click", function () {
		$divEle.removeClass("reDiv blueBorder");
	});
	$("#btn03").on("click", function () {
		$divEle.toggleClass("reDiv");
	});
	$("#btn04").on("click", function () {
		const offset = $divEle.offset();
		console.log(offset);
	});
});
```

**现代原生 `DOM` 推荐写法：**

| 场景      | 推荐方法                              | 说明            |
|---------|-----------------------------------|---------------|
| 添加类名    | `element.classList.add()`         | 可一次添加多个类      |
| 删除类名    | `element.classList.remove()`      | 可一次删除多个类      |
| 切换类名    | `element.classList.toggle()`      | 常用于高亮、展开收起    |
| 判断类名    | `element.classList.contains()`    | 判断是否已存在某个类    |
| 获取位置尺寸  | `element.getBoundingClientRect()` | 更适合现代布局测量     |
| 直接改样式   | `element.style.xxx`               | 适合少量内联样式修改    |
| 设置自定义变量 | `style.setProperty()`             | 适合配合 `CSS` 变量 |

```javascript
const box = document.querySelector("#box");

box.classList.add("reDiv", "blueBorder");
box.classList.remove("blueBorder");
box.classList.toggle("active");

if (box.classList.contains("active")) {
	console.log("当前处于激活状态");
}

const rect = box.getBoundingClientRect();
console.log(rect.top, rect.left, rect.width, rect.height);

box.style.left = "50px";
box.style.top = "20px";
box.style.setProperty("--main-color", "#409eff");
```

## 2.7 `jQuery`动画

**`jQuery`传统动画方法：**

| 方法             | 作用                  |
|----------------|---------------------|
| `show()`       | 将隐藏的元素显示            |
| `hide()`       | 将可见的元素隐藏            |
| `toggle()`     | 可见就隐藏，不可见就显示        |
| `fadeIn()`     | 淡入（慢慢可见）            |
| `fadeOut()`    | 淡出（慢慢消失）            |
| `fadeTo()`     | 在指定时长内将透明度慢慢修改到指定的值 |
| `fadeToggle()` | 淡入/淡出切换             |

**校正：**

- `jQuery` 动画现在还能用，但新项目里更常见的是 `CSS Transition / Animation`
- 如果需要通过 `JavaScript` 精细控制动画，现代浏览器更推荐 `Web Animations API`，也就是 `element.animate()`

**现代方案一：用 `CSS` 过渡做显示隐藏**

```css
.panel {
    opacity: 0;
    transform: translateY(8px);
    transition: opacity 0.3s ease, transform 0.3s ease;
}

.panel.is-visible {
    opacity: 1;
    transform: translateY(0);
}
```

```javascript
const panel = document.querySelector(".panel");
panel.classList.toggle("is-visible");
```

**现代方案二：用 `element.animate()`**

```javascript
const card = document.querySelector(".card");

card.animate(
	[
		{opacity: 0, transform: "translateY(12px)"},
		{opacity: 1, transform: "translateY(0)"}
	],
	{
		duration: 300,
		easing: "ease-out",
		fill: "forwards"
	}
);
```

## 2.8 `JS`和`jQuery`页面加载完成之后的区别

- `jQuery`：`$(function(){})`
- 原生`JavaScript`：`document.addEventListener("DOMContentLoaded", fn)`

| 对比项  | `jQuery`             | 原生`JavaScript`                                       |
|------|----------------------|------------------------------------------------------|
| 触发时机 | 浏览器解析完页面并构建好`DOM`后执行 | `DOMContentLoaded` 也是在`DOM`构建完成后执行                   |
| 推荐程度 | 老项目里仍常见              | 现代前端更推荐直接使用原生 `addEventListener("DOMContentLoaded")` |
| 执行次数 | 会按顺序执行全部注册函数         | `addEventListener()` 也可以注册多个监听器                      |

**校正：**

- 现在不应该再把 `window.onload = fn` 当成原生 `JS` 的主要对照写法
- 更合适的对照是 `document.addEventListener("DOMContentLoaded", fn)`
- 如果脚本是 `<script type="module">` 或 `<script defer>`，很多初始化代码甚至可以直接写在文件里

```html

<script defer src="./main.js"></script>
```

```javascript
document.addEventListener("DOMContentLoaded", function () {
	console.log("DOM 已准备完成");
});
```

## 2.9 `jQuery`和现代 `DOM` 事件处理

### 2.9.1 常用事件处理方法

一般就是 `JavaScript` 中的事件去掉 `on` 前缀，比如：

- `onblur` =\> `blur`
- `onclick` =\> `click`
- `onsubmit` =\> `submit`

**过时写法与现代替代：**

| 旧写法                                | 状态                     | 推荐替代                                           |
|------------------------------------|------------------------|------------------------------------------------|
| `.click()`、`.change()`、`.submit()` | `jQuery 3.3` 已废弃简写绑定方式 | `.on("click")`、`.on("change")`、`.on("submit")` |
| `.bind()`、`.unbind()`              | `jQuery 3.0` 已废弃       | `.on()`、`.off()`                               |
| `.delegate()`                      | `jQuery 3.0` 已废弃       | `.on(type, selector, handler)`                 |
| `.live()`                          | `jQuery 1.9` 已移除       | 事件委托 + `.on()`                                 |

**推荐保留的方法：**

| 方法          | 用途           |
|-------------|--------------|
| `on()`      | 绑定事件，也支持事件委托 |
| `off()`     | 解绑事件         |
| `one()`     | 事件只执行一次      |
| `trigger()` | 主动触发事件       |

**`jQuery`现代写法示例：**

```javascript
$(function () {
	$("#saveBtn").on("click", function () {
		console.log("点击了保存按钮");
	});

	$("#list").on("click", "li", function () {
		console.log("点击了动态列表项：", $(this).text());
	});

	$("#saveBtn").one("mouseenter", function () {
		console.log("这个提示只出现一次");
	});

	$("#saveBtn").trigger("click");
	$("#saveBtn").off("click");
});
```

**现代原生 `DOM` 对照写法：**

```javascript
const saveBtn = document.querySelector("#saveBtn");
const list = document.querySelector("#list");

saveBtn.addEventListener("click", function () {
	console.log("点击了保存按钮");
});

saveBtn.addEventListener(
	"mouseenter",
	function () {
		console.log("这个提示只出现一次");
	},
	{once: true}
);

list.addEventListener("click", function (event) {
	const li = event.target.closest("li");
	if (!li) {
		return;
	}
	console.log("点击了动态列表项：", li.textContent);
});
```

### 2.9.2 事件的冒泡

事件冒泡：当触发子元素事件时，同类型事件会继续向父元素传播。

**阻止事件冒泡的现代写法：**

- `event.stopPropagation()`：阻止继续冒泡
- `event.preventDefault()`：阻止默认行为
- `return false`：在 `jQuery` 事件里虽然还能用，但不推荐再作为主教学写法

```javascript
$("#parent").on("click", function () {
	console.log("父元素被点击");
});

$("#child").on("click", function (event) {
	event.stopPropagation();
	console.log("子元素被点击");
});
```

```javascript
document.querySelector("#child").addEventListener("click", function (event) {
	event.stopPropagation();
	console.log("子元素被点击");
});
```

### 2.9.3 `JavaScript`事件对象

事件对象：是封装有触发事件相关信息的一个 `JavaScript` 对象。

如何获取事件对象：
在给元素绑定事件时，在事件处理函数的参数列表中添加一个参数，通常命名为 `event`。

**常用属性：**

| 属性                              | 说明                                     |
|---------------------------------|----------------------------------------|
| `event.type`                    | 事件类型，比如 `click`                        |
| `event.target`                  | 真正触发事件的元素                              |
| `event.currentTarget`           | 当前正在绑定事件的元素                            |
| `event.pageX / event.pageY`     | 鼠标相对页面的位置                              |
| `event.clientX / event.clientY` | 鼠标相对视口的位置                              |
| `event.which`                   | 老项目里常见，现代项目更推荐按场景使用 `key`、`button` 等属性 |
| `event.originalEvent`           | `jQuery` 包装后的原生 `DOM` 事件对象             |

**原生 `JavaScript` 获取事件对象：**

```javascript
document.addEventListener("DOMContentLoaded", function () {
	document.getElementById("box").addEventListener("click", function (event) {
		console.log(event);
		console.log(event.type);
		console.log(event.target);
	});
});
```

**`jQuery` 获取事件对象：**

```javascript
$(function () {
	$("#box").on("click", function (event) {
		console.log(event);
		console.log(event.type);
		console.log(event.target);
		console.log(event.originalEvent);
	});
});
```

# 3. XML

## 3.1 XML 简介

- XML 是可扩展标记语言。
- 作用：
    - 保存具有自我描述性的数据
    - 作为项目或模块的配置文件
    - 作为网络传输数据的格式之一（现在更常见的是 JSON）

## 3.2 XML 语法

1. 文档声明
2. 元素（标签）
3. XML 属性
4. XML 注释
5. 文本区域（CDATA 区）

### 3.2.1 注释

- 和 HTML 注释语法相同。

### 3.2.2 元素标签

- XML 元素：从开始标签到结束标签的完整部分。
- 元素可以包含其他元素、文本，或者两者混合。

### 3.2.3 XML 属性

- 属性可以提供元素的额外信息。
- 一个标签上可以写多个属性。
- 每个属性值都必须使用引号。

### 3.2.4 文本区域（CDATA 区）

- CDATA 中的内容会被当作纯文本，不按 XML 语法解析。

语法：

`<![CDATA[ 文本 ]]>`

## 3.3 XML 的解析技术

- 早期解析技术：
    - DOM：W3C 制定的标准
    - SAX：基于事件回调，一行一行读取 XML，不会创建大量 DOM 对象
- 对比：
    - SAX 在内存占用和性能上通常优于 DOM
- 第三方解析：
    - JDOM：基于 DOM 的封装
    - dom4j：在 JDOM 思路上继续封装
    - Pull：常用于 Android 开发，也是事件驱动解析

## 3.4 dom4j 解析技术

### 3.4.1 dom4j 使用步骤

1. 先加载 XML 文件，创建 `Document` 对象
2. 通过 `Document` 获取根元素对象
3. 通过根元素的 `elements(标签名)` 获取指定子元素集合
4. 找到目标子元素后进行查询、修改或删除
5. 最后保存到硬盘

### 3.4.2 dom4j 示例

```java
public void test02() throws DocumentException {
	// 1. 读取 books.xml 文件
	SAXReader reader = new SAXReader();
	// 在 JUnit 测试中，相对路径从模块名开始计算
	Document document = reader.read("src/xml/01-books.xml");

	// 2. 通过 Document 对象获取根元素
	Element rootElement = document.getRootElement();
	// 3. 通过根元素获取 book 标签对象
	// element() 和 elements() 方法都可以通过标签名查找子元素
	List<Element> books = rootElement.elements("book");
	// 4. 遍历并处理每个 book 标签
	for (Element book : books) {
		Element name = book.element("name");

		// asXML()：把标签对象转换为标签字符串
		// System.out.println(name.asXML());
		// getText()：获取标签中的文本内容
		String nameText = name.getText();
		String price = book.elementText("price");
		String author = book.elementText("author");
		// 获取属性值
		String snValue = book.attributeValue("sn");
		System.out.println(new Book(snValue, nameText, Double.parseDouble(price), author));
	}
}
```

# 4. Tomcat

## 4.1 基本概念

- JavaWeb：所有通过 Java 编写、可以通过浏览器访问的程序总称。
- JavaWeb 开发基于请求和响应。
- 请求（Request）：客户端向服务器发送数据。
- 响应（Response）：服务器向客户端返回数据。
- 请求和响应总是成对出现。

## 4.2 Web 资源分类

- 静态资源：`html`、`css`、`js`、`txt`、`jpg`、`mp4`
- 动态资源：`jsp`、`servlet`

## 4.3 常见 Web 服务器

- Tomcat：最常用，免费，适合学习和中小型项目
- JBoss / WildFly
- GlassFish
- Resin
- WebLogic

## 4.4 Tomcat 目录结构

- `bin`：启动、停止 Tomcat 的脚本
- `conf`：配置文件目录
    - `server.xml`：端口、连接器等核心配置
    - `tomcat-users.xml`：管理账号配置
    - `web.xml`：全局 Web 默认配置
- `lib`：Tomcat 自带依赖库
- `logs`：运行日志
- `temp`：运行时临时文件
- `webapps`：默认部署目录
- `work`：JSP 编译结果、部分运行时缓存

## 4.5 上下文路径、部署目录与 Root 工程

- 上下文路径（Context Path）就是浏览器访问路径中的项目名部分。
- 例如访问 `http://localhost:8080/examples/index.html`：
    - `examples` 是上下文路径
    - `webapps/examples` 是部署目录
- 如果项目直接放在 `webapps` 下，Tomcat 默认会用目录名或 `war` 包名作为上下文路径。
- 两者通常同名，但不是必须同名。
- 访问 `http://localhost:8080/` 时，默认访问的是 Root 工程。
- 访问 `http://localhost:8080/工程名/` 且没有写具体资源时，Tomcat 会按欢迎页规则查找 `index.html`、`index.jsp` 等文件。

## 4.6 Web 应用标准结构

### 4.6.1 传统 Java Web 工程结构

```text
project
├── src
└── web
    ├── static
    │   ├── css
    │   ├── js
    │   └── img
    ├── WEB-INF
    │   ├── classes
    │   ├── lib
    │   └── web.xml
    └── index.html
```

### 4.6.2 Maven Java Web 工程结构

```text
project
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   ├── resources
    │   └── webapp
    │       ├── static
    │       │   ├── css
    │       │   ├── js
    │       │   └── img
    │       ├── WEB-INF
    │       │   ├── views
    │       │   └── web.xml
    │       └── index.html
    └── test
        ├── java
        └── resources
```

### 4.6.3 `WEB-INF` 目录说明

- `WEB-INF` 下的资源不能被浏览器直接访问。
- 常见内容：
    - `web.xml`
    - `classes`
    - `lib`
    - `views` 或其他受保护页面目录

## 4.7 部署方式

### 4.7.1 放到 `webapps` 目录

1. 直接把解压后的 Web 工程目录放进 `webapps`
2. 或者把项目打成 `war` 包后放进 `webapps`
3. 开发阶段放目录最直观，发布阶段更常见的是 `war`

### 4.7.2 通过外部目录映射部署

- 可以在 `Tomcat/conf/Catalina/localhost` 下创建 XML 配置文件，把外部目录映射为一个 Web 应用。

```xml

<Context path="/app" docBase="~/study/java/appProject"/>
```

### 4.7.3 IDEA 中的 `war exploded`

1. IDEA 会先把 Web 项目组装成一个可部署产物，常见是 `war exploded`
2. 再把这个产物部署到一个由 IDEA 管理的 Tomcat 实例中
3. 如果项目结构改了，但 Artifact 或 Web Facet 还指向旧目录，就会出现“源码是新的，Tomcat 跑的还是旧的”这种事

## 4.8 Maven 中的 Servlet 依赖与 `web.xml`

### 4.8.1 版本对应关系

- Tomcat 9：
    - 依赖一般用 `javax.servlet-api`
    - `web.xml` 一般用 `4.0`
- Tomcat 10.0：
    - 依赖一般用 `jakarta.servlet-api`
    - `web.xml` 一般用 `5.0`
- Tomcat 10.1：
    - 依赖一般用 `jakarta.servlet-api`
    - `web.xml` 一般用 `6.0`
- Tomcat 11：
    - 依赖一般用 `jakarta.servlet-api`
    - `web.xml` 一般用 `6.1`

### 4.8.2 Maven 中的依赖写法

- 在 Maven 项目中，Servlet API 通常要写成 `provided`，因为运行时由 Tomcat 提供。
- 如果把 `servlet-api` 打进 `WEB-INF/lib`，轻则重复，重则类冲突。

```xml

<dependency>
	<groupId>jakarta.servlet</groupId>
	<artifactId>jakarta.servlet-api</artifactId>
	<version>6.0.0</version>
	<scope>provided</scope>
</dependency>
```

## 4.9 启动与常见配置

### 4.9.1 启动 Tomcat

- 进入 Tomcat 安装目录下的 `bin`
- 执行 `catalina run`
- Windows 下也常直接使用 `startup.bat` / `shutdown.bat`
- macOS / Linux 下通常使用 `startup.sh` / `shutdown.sh`

### 4.9.2 修改端口号

1. 进入 `tomcat/conf`
2. 打开 `server.xml`
3. 修改 `<Connector>` 标签的 `port` 属性
4. 保存后重启 Tomcat

### 4.9.3 本地打开 HTML 与服务器访问的区别

- 直接双击 HTML 文件，走的是 `file://` 协议
- 通过 Tomcat 访问，走的是 `http://` 协议
- 很多与请求、响应、Servlet、Session 相关的功能，只有经过服务器访问才成立

# 5. HTTP

## 5.1 HTTP 简介

**HTTP 超文本传输协议** (HTTP-Hyper Text transfer protocol)

- 是一个属于应用层的面向对象的协议，由于其简捷、快速的方式，适用于分布式超媒体信息系统。
- 是一种详细规定了浏览器和万维网服务器之间互相通信的规则**，通过因特网传送万维网文档的数据传送协议
- 客户端与服务端通信时传输的内容我们称之为**报文**。**HTTP协议就是规定报文的格式**

**客户端发送给服务器的称为"请求报文**"，**服务器发送给客户端的称为"响应报文"**。

**HTTP/1.1**

+ HTTP 的第一个标准化版本 HTTP/1.1 ( RFC 2068 ) 于 1997 年初发布，支持七种请求方法：OPTIONS，GET，HEAD，POST，PUT，DELETE，和TRACE

+ HTTP/1.1 是 HTTP 1.0 的增强：

    + 虚拟主机允许从单个 IP 地址提供多个域。

    + 持久连接和流水线连接允许 Web 浏览器通过单个持久连接发送多个请求。

    + 缓存支持节省了带宽并使响应速度更快。

+ HTTP/1.1 在接下来的 15 年左右将非常稳定。

+ 在此期间，出现了 HTTPS（安全超文本传输协议）。它是使用 SSL/TLS 进行安全加密通信的 HTTP 的安全版本。

## 5.2 HTTP 作用

1. 客户端和服务器段交互的方式
    - 请求：客户端向服务端发送
    - 响应：服务端向客户端返回
2. 客户端和服务端交互的数据的格式
    - 请求报文：请求是发送的数据
    - 响应报文：相应时返回的数据
    - 报文是有规定的格式的：
        - 报文首部，如：请求报文
        - 行 如：请求行，响应行
        - 头 如：请求头，响应头
        - 报文主体

## 5.3 HTTP 长连接和短连接

- HTTP 是应用层协议，底层通常基于 TCP 传输。
- 短连接：一次请求响应完成后就断开连接，早期 HTTP/1.0 更常见。
- 长连接：同一个 TCP 连接可以复用多次请求响应，HTTP/1.1 默认支持 `keep-alive`。
- 长连接减少了频繁建立 TCP 连接的成本，但不代表一个连接永远不关，它仍然会受超时、服务端配置等影响。

## 5.4 TCP 连接

每次客户端和服务端连接时，需要经过：

1. 三次握手
2. 创建连接
3. 四次挥手

## 5.5 请求和响应报文

### 5.5.1 报文的格式

![](https://cdn.jsdelivr.net/gh/Shadow1086/myPicture@master/uPic/2026/04/02/20-10-CB5uE5)

### form表单发送GET请求特点

1、由于请求参数在请求首行中已经携带了，所以没有请求体，也没有请求空行
2、请求参数拼接在url地址中，地址栏可见\[url?name1=value1\&name2=value2]，不安全
3、由于参数在地址栏中携带，所以由大小限制\[地址栏数据大小一般限制为4k]，只能携带纯文本
4、get请求参数只能上传文本数据
5、没有请求体。所以封装和解析都快，效率高， 浏览器默认提交的请求都是get请求比如：地址栏输入回车,超链接,表单默认的提交方式

> 查看GET请求行,请求头,请求体

+ 请求行组成部分
    + 请求方式 GET
    + 访问服务器的资源路径?参数1=值1&参数2=值2 ... ...
    + 协议及版本 HTTP/1.1

``` http
GET /05_web_tomcat/login_success.html?username=admin&password=123213 HTTP/1.1
```

+ 请求头

+ 请求空行

+ 请求体
    + GET请求数据不放在请求体

### form表单发送post请求特点

1、POST请求有请求体，而GET请求没有请求体。
2、post请求数据在请求体中携带，请求体数据大小没有限制，可以用来上传所有内容\[文件、文本]
3、只能使用post请求上传文件
4、post请求报文多了和请求体相关的配置\[请求头]
5、地址栏参数不可见，相对安全
6、post效率比get低

+ POST请求要求将form标签的method的属性设置为post

![1681525012046](/Volumes/study/02-java/JavaWeb/笔记/images/1681525012046.png)

> 查看post的请求行 请求头 请求体

+ 请求行组成部分
    + 请求方式 POST
    + 访问服务器的资源路径?参数1=值1&参数2=值2 ... ...
    + 协议及版本 HTTP/1.1

### 3.2.3 响应报文

> 响应报文格式

- 响应首行（**响应行**）； 协议/版本 状态码 状态码描述
- 响应头信息（**响应头**）；
- 空行；
- 响应体；

![1681525347456](/Volumes/study/02-java/JavaWeb/笔记/images/1681525347456.png)

![1681525384347](/Volumes/study/02-java/JavaWeb/笔记/images/1681525384347.png)

+ 响应行组成部分
    + 协议及版本 HTTP/1.1
    + 响应状态码 200
    + 状态描述 OK  (在tomcat10+就省略了)

``` http
HTTP/1.1 200 OK    说明：响应协议为HTTP1.1，响应状态码为200，表示请求成功； 
```

+ 响应头
    + Content-type：
        + MIME类型响应头：媒体类型，文件类型，相应的数据类型
        + MIME类型用于告诉客户端响应的数据都是什么类型的数据，客户端以此类型决定用什么方法解析响应体
        + tomcat/conf/web.xml中记录类几乎所有的文件类型对应的MIME类型

``` http
Server: Apache-Coyote/1.1   服务器的版本信息
Accept-Ranges: bytes
ETag: W/"157-1534126125811"
Last-Modified: Mon, 13 Aug 2018 02:08:45 GMT
Content-Type: text/html,image/png,text/javascript    MIME类型：响应体数据的类型[浏览器根据类型解析响应体数据]
Content-Length: 157   响应体内容的字节数，用于检验传输过程中有没有损失
Date: Mon, 13 Aug 2018 02:47:57 GMT  响应的时间，这可能会有8小时的时区差
```

+ 响应体

``` html
<!--需要浏览器解析使用的内容[如果响应的是html页面，最终响应体内容会被浏览器显示到页面中]-->
```

### 响应码

+ **200：** 请求成功，浏览器会把响应体内容（通常是html）显示在浏览器中；
+ **302：** 重定向，当响应码为302时，表示服务器要求浏览器重新再发一个请求，服务器会发送一个响应头Location指定新请求的URL地址；
+ **304：** 使用了本地缓存
+ **404：** 请求的资源没有找到，说明客户端错误的请求了不存在的资源；
+ **405：** 请求的方式不允许，比如要求Get,使用Post，就会显示405
+ **500：** 请求资源找到了，但服务器内部出现了错误；

# 6. `Servlet`

## 6.1 `Servlet` 简介

- `Servlet` 是 Java Web 三大组件之一，另外两个是 `Filter` 和 `Listener`
- 本质上是运行在服务器上的 Java 程序，用来接收请求并返回响应
- 在老版本中常见包名是 `javax.servlet.*`，在 `Tomcat` 10+ 中通常使用 `jakarta.servlet.*`

### 6.1.1 `Servlet`运行流程

1. `Tomcat`接收到请球后，会将请求报文的信息转换成一个`HttpServletRequest`对象，该对象中包含了请求中的所有信息，包括：请求行，请求头，请求体
2. `Tomcat`同时床架呢了一个`HttpServletResponse`对象，该对象用于承装要响应给客户端的信息。后面该对象会被转换成响应的报文：相应行，响应头，响应体
3. `Tomcat`根据请求中的资源路径找到对应的`Servlet`，将`Servlet`实例化，调用`service()`方法，同时将`HttpServletRequest`和
   `TttpServletResponse`对象传入
    1. 从`request`对象中获取请求的所有信息(参数)
    2. 根据参数生成要响应给客户端的数据
    3. 将相应的数据放入`response`对象

```java
public class ServletDemo implements Servlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
	}
}
```

## 6.2 如何实现 `Servlet` 程序

1. 编写一个类去实现 `Servlet` 接口，或者更常见地继承 `HttpServlet`
2. 根据请求处理业务逻辑并返回响应
3. 通过 `web.xml` 或 `@WebServlet` 配置访问路径

```java
public class UserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 从request对象中获取请求中的任何信息(如：username参数)
		String username = request.getParameter("username");//根据惨书名获取参数值，无论参数是在url?后还是在请求体中

		// 2. 处理业务的代码
		String info = "<h1>YES</h1>";
		if ("atguigu".equals(username)) {
			info = "NO";
		}
		// 3. 将要响应的数据放到response中
		// 应该设置Content-type响应头,如果设置错了，浏览器就不会识别相应的格式
		// 方法：setHeader("Content-Type","Value")/setContentType("Value");
		response.setHeader("Content-Type", "text/html");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();//该方法返回的是一个向相应体中打印字符串的打印流
		writer.write(info);

	}
}
```

## 6.2.1 `Servlet` 开发流程

1. 创建javaweb项目，同时将`Tomcat`添加为当前项目的依赖
2. 重写`service(HttpServletRequest req, HttpServletResponse resp)`方法
3. 在`service()`方法中，定义业务处理代码
4. 在`web.xml`中，配置`Servlet`对应的请求映射路径

### 6.2.2 使用 `web.xml` 配置

> **注意：**

- 一个 `servlet-name` 可以有多个 `url-pattern`
- 一个 `<servlet>` 标签可以有多个 `servlet-mapping` 标签，但是少见，可以直接按照方法一来写

```xml

<web-app>
	<display-name>Archetype Created Web Application</display-name>

	<servlet>
		<!--	servlet-name标签：给servlet程序起一个别名(一般是类名)-->
		<servlet-name>HelloServlet</servlet-name>
		<!--	servlet-class是servlet程序的全类名	-->
		<servlet-class>com.study.HelloServlet</servlet-class>
	</servlet>
	<!--	servlet-mapping：给servlet程序配置访问地址-->
	<servlet-mapping>
		<!--	servlet-name：告诉服务器，我的那给钱配置的地址是给那个Servlet程序使用的	-->
		<servlet-name>HelloServlet</servlet-name>
		<!--	url-pattern：配置访问地址
			/       斜杠  在服务器解析的时候，表示地址为：http://ip:port/工程路径
			/hello  表示地址为：http://ip:port/工程路径/hello
			-->
		<url-pattern>/hello</url-pattern>
	</servlet-mapping>
</web-app>
```

### 6.2.3 设置Content-Type

通过调用 `response` 的 `setHeader("Content-Type","Value")` 和 `setContentType("value")` 方法即可设置响应头中的
`Content-type` 属性

- 其中value可以通过在`Tomcat/conf/web.xml`中查询可知，常见：text/html,text/css,image/png...

```java
        // 应该设置Content-type响应头,如果设置错了，浏览器就不会识别相应的格式
// 方法：setHeader("Content-Type","Value")/setContentType("Value");
		response.setHeader("Content-Type","text/html");
		response.

setContentType("text/html");
```

### 6.2.4 关于url-pattern的精准匹配和模糊匹配

- 精确匹配：
    - `/servlet1`
- 模糊匹配(*作为通配符)：
    - ` / `：匹配全部，但是不包含jsp文件,/xxx,/index.html 都匹配这个
    - ` /* `：匹配全部，包括jsp文件
    - `/a/*`：匹配前缀，后缀模糊，比如：/ax,/abc
    - `*.action`：匹配后缀，前缀是模糊的，比如：/aaaaction
      示例：

```xml

<servlet-mapping>
	<servlet-name>servlet1</servlet-name>
	<!--    模糊匹配，无论输入什么都是servlet1这个文件，比如：http://localhost:8080/xxx /index 也不例外-->
	<url-pattern>/</url-pattern>

	<url-pattern>/a/*</url-pattern>

	<url-pattern>*.action</url-pattern>
</servlet-mapping>
```

### 6.2.5 使用 `@WebServlet` 注解

- 现代项目里更常见的是直接使用注解映射，不一定非要写到 `web.xml`。但是两者只能二选一，如果使用注解就不能使用web.xml文件方式了
- 如果`@WebServlet`("")中少写了'/'，就会报错：`IllegalStateException:启动子级时报错`
- 其他属性：
    - String name：起别名,如：`@WebServlet(name="servlet1")`
    - String[] value()
    - String[] urlPatterns()：和value()方法一致，比如：`@WebServlet(urlPattern={"/s1","/servlet1"})`
    - `int loadOnStartp()`：默认为-1，含义是：`Tomcat`启动时，实例化该 `Servlet` 的顺序
        - 默认值是-1，含义是：`Tomcat`启动时不会实例化该 `Servlet`
        - 其他正整数：含义是：`Tomcat`在启动时，实例化改 `Servlet` 的顺序，如果序号冲突了，`Tomcat`会自动协调启动顺序
        - 注意：`Tomcat`中某些服务自己就占据了一些序号，比如：1，3，4，5.这些都是已经被占用的了
    - `WebInitParam[] initParams()`：

```java

@WebServlet("/report")
public class ReportServlet extends HttpServlet {
}
```

### 6.2.6 `javax.servlet` 和 `jakarta.servlet`

- `Tomcat` 9 及以前，常见的是 `javax.servlet.*`
- `Tomcat` 10 及以后，常见的是 `jakarta.servlet.*`
- 从 9 升到 10，不只是换 `web.xml` 版本，导包通常也要一起改

## 6.3 `Servlet` 的生命周期

1. 创建 `Servlet` 实例：构造器 第一次请求/服务启动时
2. 调用 `init()` 初始化 构造完毕
3. 每次请求到来时调用 `service()`               每次请求
4. 容器关闭或卸载应用时调用 `destroy()`          关闭服务

> **注意：**

- `Servlet`在`Tomcat`中是单例的
- `Servlet`的成员变量在多个线程栈之中是共享的
- 不建议在`service()`方法中修改成员变量，在并发请求时，

> **补充：**

- 默认情况下，`Servlet` 往往在第一次请求到来时创建
- 如果配置了 `load-on-startup`，也可以在服务器启动时创建
- `init()` 只执行一次，`service()` 会执行多次，`destroy()` 通常只执行一次

## 6.4 `default-servlet`

- **作用：**
    - 当浏览器请求静态资源时，比如：`aaa.html/a.png/a.js/a.css`，浏览器会查找 `所有的Servlet`
    - 如果这个资源并不匹配任何一个 `Servlet`，那么 `default-servlet` 就会找到该静态资源，并将其填写到 `response`
      响应中，再返回给客户端
- **当使用SpringMVC时:**
    - `SpringMVC`会让`default-servlet`失效，也就是说如果不对静态资源文件做特殊处理，客户端请求的**所有静态资源**
      时就会找不到，报404

## 6.5 `Servlet`继承结构

### 6.5.1 `Servlet`接口

- 顶级接口：`Servlet`
- 方法：
    - `void init(ServletConfig var1)`：初始化方法，构造完毕后哦，有`Tomcat`自动调用完成初始化功能的方法
    - `ServletConfig getServletConfig()`：获取`ServletConfig`对象的方法
    - `void service()`：接受用户请求，向用户响应信息的方法
    - `String getServletInfo()`：返回`Servlet`字符串形式描述信息的方法，不关注
    - `void destroy()`：`Servlet`在回收前，有`Tomcat`调用的销毁方法，往往用于做资源的释放工作

- `Servlet`的直接实现抽象类：`GenericServlet`，侧重除了`service()`方法以外的其他方法的处理
    - 属性：
        - `private transient ServletConfig config;`
          -方法：
        - `void destory()`：将抽象方法，重写为普通方法，在方法内部没有任何的实现代码，这种方法叫做：**平庸实现**
            - 平庸方法好处：该类的子类就不需要必须重写该方法了
        - `void init(ServletConfig config)`：`Tomcat`在调用`init()`方法时，会读取配置信息进入一个`ServletConfig`对象，并将该对象传入
          `init()`方法。
            - `this.config = config;`：将`config`对象存储为当前的属性，就是`GenericServlet`的属性`ServletConfig`
            - `this.init();`：调用重载的无参`init()`方法
        - `public void init()`
          ：重载的无参初始化方法，我们重写的就是这个方法，通过重写这个无参的初始方法，我们可以省略需要处理的`config`
          对象，由上面有参的`init()`
          方法处理即可
        - `ServletConfig getServletConfig(){return this.config;}`：返回`ServletConfig`方法
        - `abstract void service(ServletRequest req, ServletResponse res)`：再次抽象声明`service()`方法。
- `HttpServlet`抽象类
    - 主要关注`service()`方法的实现：
    - `public void service(ServletRequest req, ServletResponse res)`：
        - 进行了一个参数的父转子，将`ServletRequest`父接口转换成`HttpServletRequest`子接口，让可以使用的API更加丰富
        - 在调用重载的`service()`方法
    - `protected void service(HttpServletRequest req, HttpServletResponse resp)`：重载的`service()`方法：
        - `String method = req.getMethod();`：获取请求的方式：`GET`/`POST`/`PUT`/`DELETE`/`OPTIONS`...
        - 根据请求方式，调用对应的do方法：get->`doGet()`，post->`doPost()`，put->`doPut()`...
    - `doGet()`方法：
        - `String protocol = req.getProtocol();` / `String msg = lStrings.getString("http.method_get_not_supported");`
            - 获取状态码和信息字符串
        - 通过`resp.sendError(getMethodNotSupportedCode(protocol), msg)`方法，故意响应异常状态码

![](https://cdn.jsdelivr.net/gh/Shadow1086/myPicture@master/uPic/2026/04/03/20-06-js2MCO)

## 6.6 `ServletConfig` 和 `ServletContext` 的使用

### 6.6.1 `ServletConfig`

- 方法一：在`web.xml`中通过使用 `<servlet>` 的子标签 `init-param`，可以设置 `servletConfig` 的初始化配置，就会生成一个
  `ServletConfig` 对象
- 方法二：通过注解：`@WebServlet(initParams={@WebInitParam(name="encoding",value="UTF-8")})`
- 在`HttpServlet`中，`ServletConfig`属性就是这个对象(通过`init`方法的`this.config = config`)
    - 方法：
        - `getInitParameter("value")`：获取value对应的值，其中value是键名
        - `hasMoreElements()`：判断有没有下一个参数，如果有返回true,如果没有返回false
        - `nextElement()`：取出下一个元素，向下移动游标(指针)
- 注意：每个`Servlet`都有自己的`ServletConfig`对象，比如`Servlet1`创建的`Config`对象，`Servlet2`使用不了

### 6.6.2 `ServletContext`

- 容器会为每个app创建一个独立的唯一的`ServletContext`对象
- `ServletContext`对象为所有的`Servlet`所共享,并且可以为所有的`Servlet`提供初始配置参数
- 内存上的差异：`config`是多例的，而`context`是单例的

> **两者用法示例(基本上是一样的)：**

```xml

<web-app>
	<!-- 配置context上下文	-->
	<context-param>
		<param-name>encoding</param-name>
		<param-value>UTF-8</param-value>
	</context-param>
	<context-param>
		<param-name>username</param-name>
		<param-value>zhangsan</param-value>
	</context-param>

	<servlet>
	<servlet-name>servlet1</servlet-name>
	<servlet-class>com.study.Servlet1</servlet-class>

	<!--	配置servlet的初始参数	-->
	<init-param>
		<param-name>keya</param-name>
		<param-value>valueA</param-value>
	</init-param>
	<init-param>
		<param-name>keyB</param-name>
		<param-value>valueB</param-value>
	</init-param>

</web-app>
```

```java
// 使用方法二：通过注解，多对参数使用,隔开，写多个@WebInitParam()

//@WebServlet(
//		urlPatterns = "/servlet1",
//		initParams = {@WebInitParam(name = "keya", value = "vluea"), @WebInitParam(name = "keyb", value = "valueb")}
//)
public class Servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("----------------------------ServletConfig获取参数---------------------------------");
		ServletConfig servletConfig = this.getServletConfig();
		// 获取初始配置信息即可
		// 根据参数名获取参数值
		String keya = servletConfig.getInitParameter("keya");
		System.out.println("keya = " + keya);

		// 获取所有初始参数的名字，早期的遍历器
		// hasMoreElement()：判断有没有下一个参数，如果有返回true,如果没有返回false
		// nextElement()：取出下一个元素，向下移动游标(指针)

		Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
		while (initParameterNames.hasMoreElements()) {
			String keyName = initParameterNames.nextElement();
			System.out.println("keyName = " + keyName + "\t value = " + getInitParameter(keyName));
		}
		System.out.println("---------------------------ServletContext获取参数----------------------------------");
		// 获取ServletContext对象,三种方式，前两者的本质是都是通过config对象获取，在内存上都是同一个
		ServletContext servletContext = getServletContext();
		ServletContext servletContext1 = servletConfig.getServletContext();
		ServletContext servletContext2 = req.getServletContext();

		// 获取参数
		String encoding = servletContext.getInitParameter("encoding");
		System.out.println("encoding = " + encoding);
		Enumeration<String> initParameterNames1 = servletContext.getInitParameterNames();

		while (initParameterNames1.hasMoreElements()) {
			String nextElement = initParameterNames1.nextElement();
			System.out.println("keyName = " + nextElement + "\tvalue = " + servletContext.getInitParameter(nextElement));
		}
	}
}

```

### 6.6.3 `ServletContext` 常用API

- 获取文件路径：`getRealPath()`
- 获取项目部署的上下文路径：`getContextPath()`

```java

@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();

		// 向upload目录中写入一个文件
		// 1. getRealPath()：获得一个只想项目部署位置下的某个文件/目录的磁盘真是路径的API
		String path = servletContext.getRealPath("upload");
		System.out.println(path);

		// 2.获取项目部署的上下文路径，即项目的访问路径
		// 后续我们会学习在项目中使用相对和绝对路径赵目标资源
		// getContextPath()：获取项目的上下文路径，项目的访问路径
		String contextPath = servletContext.getContextPath();
		System.out.println(contextPath);
	}
}
```

## 6.7 域对象的相关API

- 域对象：一些用于存储数据和传递数据的对象，传递数据不同的方位，我们称之为不同的域，不用的域对想代表不同的域，共享数据的范围也不同
- Webapp中的三大域对象：应用域，会话域，请求域
- 应用域：`ServletContext`代表应用，`ServletContext`域代表应用域，是webapp中最大的域，可以在本应用内实现数据的共享和传递

| API                                         | 功能解释       |
|---------------------------------------------|------------|
| void setAttribute(String key,Object value); | 向域中存储/修改数据 |
| Object getAttribute(String key);            | 获得域中的数据    |
| void removeAttribute(String key);           | 移除域中的数据    |

> **示例：**

```java

@WebServlet("/scope")
public class ContextScope extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 作为域对象，一定会有的API
		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("keya", "valuea");           // 存储数据
		servletContext.setAttribute("keya", "valueaaa");         // 修改数据：替换掉上面的valuea这个值

		Object keya = servletContext.getAttribute("keya");// 获取数据

		servletContext.removeAttribute("keya");
	}
}

// 读取域对象的数据
@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 从域对象中读取数据
		String keya = (String) servletContext.getAttribute("keya");
		System.out.println(keya);
	}
}

```

## 6.8 `HttpServletRequest`

- `HttpServletRequest` 是一个接口，其父接口是 `ServletRequest`
- `Tomcat`将请求报文转成封装而来的对象，在`Tomcat`调用 `service()` 方法时传入
- `HttpServletRequest`代表客户端发来的请求，所有请求中的信息都可以通过该对象获得

+ **获取请求行信息相关**(方式,请求的url,协议及版本)

| API                             | 功能解释            |
|---------------------------------|-----------------|
| `StringBuffer getRequestURL();` | 获取客户端请求的url     |
| `String getRequestURI();`       | 获取客户端请求项目中的具体资源 |
| `int getServerPort();`          | 获取客户端发送请求时的端口   |
| `int getLocalPort();`           | 获取本应用在所在容器的端口   |
| `int getRemotePort();`          | 获取客户端程序的端口      |
| `String getScheme();`           | 获取请求协议          |
| `String getProtocol();`         | 获取请求协议及版本号      |
| `String getMethod();`           | 获取请求方式          |

+ **获得请求头信息相关**

| API                                     | 功能解释                |
|-----------------------------------------|---------------------|
| `String getHeader(String headerName);`  | 根据头名称获取请求头          |
| `Enumeration<String> getHeaderNames();` | 获取所有的请求头名字          |
| `String getContentType();`              | 获取`content-type`请求头 |

+ **获得请求参数相关**

| API                                                       | 功能解释               |
|-----------------------------------------------------------|--------------------|
| `String getParameter(String parameterName);`              | 根据请求参数名获取请求单个参数值   |
| `String[] getParameterValues(String parameterName);`      | 根据请求参数名获取请求多个参数值数组 |
| `Enumeration<String> getParameterNames();`                | 获取所有请求参数名          |
| `Map<String, String[]> getParameterMap();`                | 获取所有请求参数的键值对集合     |
| `BufferedReader getReader() throws IOException;`          | 获取读取请求体的字符输入流      |
| `ServletInputStream getInputStream() throws IOException;` | 获取读取请求体的字节输入流      |
| `int getContentLength();`                                 | 获得请求体长度的字节数        |

+ **其他API**

| API                                           | 功能解释                 |
|-----------------------------------------------|----------------------|
| `String getServletPath();`                    | 获取请求的`Servlet`的映射路径  |
| `ServletContext getServletContext();`         | 获取`ServletContext`对象 |
| `Cookie[] getCookies();`                      | 获取请求中的所有`Cookie`     |
| `HttpSession getSession();`                   | 获取`Session`对象        |
| `void setCharacterEncoding(String encoding);` | 设置请求体字符集             |

## 6.9 `HttpServletResponse`

+ **设置响应行相关**

| API                         | 功能解释    |
|-----------------------------|---------|
| `void setStatus(int code);` | 设置响应状态码 |

+ **设置响应头相关**

| API                                                      | 功能解释                                |
|----------------------------------------------------------|-------------------------------------|
| `void setHeader(String headerName, String headerValue);` | 设置/修改响应头键值对                         |
| `void setContentType(String contentType);`               | 设置`content-type`响应头及响应字符集(设置MIME类型) |

+ **设置响应体相关**

| API                                                         | 功能解释                                |
|-------------------------------------------------------------|-------------------------------------|
| `PrintWriter getWriter() throws IOException;`               | 获得向响应体放入信息的字符输出流                    |
| `ServletOutputStream getOutputStream() throws IOException;` | 获得向响应体放入信息的字节输出流                    |
| `void setContentLength(int length);`                        | 设置响应体的字节长度,其实就是在设置content-length响应头 |

+ **其他API**

| API                                                            | 功能解释                       |
|----------------------------------------------------------------|----------------------------|
| `void sendError(int code, String message) throws IOException;` | 向客户端响应错误信息的方法,需要指定响应码和响应信息 |
| `void addCookie(Cookie cookie);`                               | 向响应体中增加`Cookie`            |
| `void setCharacterEncoding(String encoding);`                  | 设置响应体字符集                   |

> **示例：**

```java

@WebServlet("/s5")
public class Servlet5 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置相应行相关的API  http/1.1  200/404/405...    状态描述
		resp.setStatus(200);
		String info = "<h1>hello</h1>";
		// 设置响应头相关的API
		resp.setHeader("aaa", "valuea");
		resp.setHeader("Content-Type", "text/html");
		resp.setContentType("text/html");
		resp.setContentLength(info.getBytes().length);

		// 设置响应体内容API
		// 获得一个向响应体中输入文本字符输出流
		PrintWriter writer = resp.getWriter();
		writer.write(info);
		// 获得一个系哪个响应体中输入二进制信息的字节输出流
		ServletOutputStream outputStream = resp.getOutputStream();
	}
}
```

## 6.10 请求转发和响应重定向

+ **请求转发**和**响应重定向**是web应用中间接访问项目资源的两种手段,也是Servlet控制页面跳转的两种手段

+ 请求转发通过 `HttpServletRequest` 实现，响应重定向通过 `HttpServletResponse` 实现
+ 同样能够实现页面跳转时，优先使用**响应重定向**

### 6.10.1 请求转发

> **请求转发的特点：**

+ 请求转发通过 `HttpServletRequest` 对象获取请求转发器实现
+ 请求转发是服务器内部的行为,对客户端是屏蔽的
+ 客户端只发送了一次请求,客户端地址栏不变
+ 服务端只产生了一对请求和响应对象,这一对请求和响应对象会继续传递给下一个资源
+ 因为全程只有一个`HttpServletRequset`对象,所以请求参数可以传递,请求域中的数据也可以传递
+ 请求转发可以转发给其他`Servlet`动态资源,也可以转发给一些静态资源以实现页面跳转
+ 请求转发可以转发给WEB-INF下受保护的资源
+ 请求转发不能转发到本项目以外的外部资源

示例：

```java

@WebServlet("/sa")
public class ServletA extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servletA 执行了");
		// 获得请求转发器
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("sb");
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("a.html");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/b.html");
		requestDispatcher.forward(req, resp);
	}
}
```

### 6.10.2 响应重定向

> **相应重定向**特点：

+ 响应重定向通过 `HttpServletResponse` 对象的 `sendRedirect()` 方法实现
+ 响应重定向是服务端通过302响应码和路径,告诉客户端自己去找其他资源,是在服务端提示下的,客户端的行为
+ 客户端至少发送了两次请求,客户端地址栏是要变化的
+ 服务端产生了多对请求和响应对象,且请求和响应对象不会传递给下一个资源
+ 因为全程产生了多个`HttpServletRequset`对象,所以请求参数不可以传递,请求域中的数据也不可以传递
+ 重定向可以是其他`Servlet`动态资源,也可以是一些静态资源以实现页面跳转
+ 重定向不可以到给WEB-INF下受保护的资源
+ 重定向可以到本项目以外的外部资源

```java

@WebServlet("/s1")
public class Servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 接受用户请求
		System.out.println("servlet1 执行了");
		// 响应重定向        设置相应状态码为302，同时设置location响应头
		resp.sendRedirect("s2");
	}
}
```

## 6.11 乱码问题

> **产生的根本原因：**

- 数据的编码和解码使用的不是同一个字符集
- 使用了不支持某个语言文字的字符集

### 6.11.1 GET请求乱码

## 6.12 路径问题

## 6.13 会话管理

### 6.13.1 什么是会话管理?

- 管理的是客户端的状态
- 实现的手段：
    - `Cookies`
    - `Session`

### 6.13.2 `Cookies`

- 时效：默认有效期是一次会话范围内，可以通过 `setMaxAge(int time)` 方法持久化 `Cookie`，单位默认为秒
- 会话范围时 `Cookie` 保存在内村上，持久化时则保存在硬盘上

> **示例：**

```java

@WebServlet("/sa")
public class Servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 创建Cookies
		Cookie cookieA = new Cookie("keyA", "valueA");
		// 设置cookies的持久化时间
		cookieA.setMaxAge(60 * 5);
		// 设置cookie的提交路径
		cookieA.setPath("/sb");
		Cookie cookieB = new Cookie("keyB", "valueB");
		// 将Cookies放入response对象中
		resp.addCookie(cookieA);
		resp.addCookie(cookieB);
	}
}

public class Servlet2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取请求中携带的cookie
		Cookie[] cookies = req.getCookies();
		// 请求中的多个cookies会进入该数组，请求中如果没有cookie,cookies数组为：null
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName() + "=" + cookie.getValue());
			}
		}
	}
}
```

### 6.13.3 `Session`

- `Session` 的使用需要 `Cookie` 配合
- `Session` 的存活时间可以在 `web.xml` 中设置，如下：

```xml

<session-config>
	<!--  以分钟为单位  -->
	<session-timeout>30</session-timeout>
</session-config> 
```

> **使用示例：**

```java

@WebServlet("/s1")
public class Servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接受请求中的username参数
		String username = req.getParameter("username");
		// 获得session对象
		HttpSession session = req.getSession();
		// 判断请求中有没有一个特殊的cookie，称为：JSESSIONID    值 *** ***
		// 有,根据JSESSIONID找对应的session对象,找到则返回旧的session对象，找不到就创建新的session对象
		// 没有，创建一个新的session返回，并且想response对象中存放一个JSESSIONID的cookie
		System.out.println(session.getId());
		System.out.println(session.isNew());
		// 将username存入session
		session.setAttribute("username", username);
		// 客户端响应信息
		resp.setContentType("text/html;charset= UTF-8");
		resp.getWriter().write("成功");
	}
}

@WebServlet("/s2")
public class Servlet2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获得session对象
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(120);    //最大存活时间：秒
		System.out.println(session.getId());
		System.out.println(session.isNew());
		// 读取session中存储的用户名
		String username = (String) session.getAttribute("username");

		System.out.println("servlet2 got username:" + username);

	}
}
```

## 6.14 三大域对象

### 6.14.1 域对象概述

> 域对象: 一些用于存储数据和传递数据的对象,传递数据不同的范围,我们称之为不同的域,不同的域对象代表不同的域,共享数据的范围也不同

+ web项目中,我们一定要熟练使用的域对象分别是 请求域,会话域,应用域
+ **请求域**对象是`HttpServletRequest` ,传递数据的范围是一次请求之内及请求转发
+ **会话域**对象是`HttpSession`，传递数据的范围是一次会话之内,可以跨多个请求
+ **应用域**对象是`ServletContext`，传递数据的范围是本应用之内,可以跨多个会话

### 6.14.2 三大域存放的数据

- 请求转发时，请求域可以传递数据，请求域内一般存放**本次请求业务有关的数据**，比如：查询到的所有的部门信息
- 同一个会话内，不用请求转发，会话域可以传递数据，会话域内一般放**本次会话的客户端有关的数据**，比如：当前客户端登录的用户
- 同一个app内，不同的客户端，应用域可以传递数据，应用域内一般放**本程序应用有关的数据**，比如：Spring框架的IOC容器

### 6.14.3 三大域的通用API

| API                                         | 功能           |
|---------------------------------------------|--------------|
| void setAttribute(String name,String value) | 向域对象中添加/修改数据 |
| Object getAttribute(String name);           | 从域对象中获取数据    |
| removeAttribute(String name);               | 移除域对象中的数据    |

- 请求域：

<img src="https://cdn.jsdelivr.net/gh/Shadow1086/myPicture@master/uPic/2026/04/06/14-38-5zIsCu" style="zoom: 50%;" />

- 会话域：

<img src="https://cdn.jsdelivr.net/gh/Shadow1086/myPicture@master/uPic/2026/04/06/14-39-0huOEh" style="zoom:50%;" />

- 应用域：

<img src="https://cdn.jsdelivr.net/gh/Shadow1086/myPicture@master/uPic/2026/04/06/14-39-qRHnrO" style="zoom:50%;" />

## 6.15 `Filter`过滤器

### 6.15.1 过滤器概述

- 作用：对目标资源的请求进行过滤
- 过滤器的实现：分为三步，简单理解，就是以`chain.doFilter()`为界
    1. 请求到达目标资源前的代码：比如判断用户是否登录
    2. 放行，其实就一行 `chain.doFilter(req, reps)`
    3. 响应之前，`response`转换为响应报文之前
- 过滤器的配置方式：
    - `web.xml` 方式
    - 注解方式：`@WebFilter()`，可以通过看源码理解参数
- 图解：

<img src="https://cdn.jsdelivr.net/gh/Shadow1086/myPicture@master/uPic/2026/04/06/15-04-l4q4nz" style="zoom:60%;" />

使用示例：

```java

@WebServlet(value = "/s1", name = "servlet1")
public class Servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet1 service invoked");
		resp.getWriter().write("servlet1 message");
	}
}

// 过滤器
// 注解方式：
@WebFilter(
		filterName = "loggingFilter",
		initParams = {@WebInitParam(name = "dateTimePattern", value = "yyyy-MM-dd HH:mm:ss")},
		urlPattern = {"/s1", "*.html"},
		servletNames = {"servlet1"}
)
public class LoggingFilter implements Filter {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 过滤请求和响应的方法
	 * 1. 请求到达目标资源之前，先经过该方法
	 * 2. 该方法有能力控制请求是否继续向后到达目标资源，可以在该方法内直接像客户端做响应处理
	 * 3. 请求达到目标资源后，响应之前，还会经过该方法
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		// 参数父传子
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// 1. 请求到达目标资源之前的功能代码，比如：判断是否登录，校验权限是否满足。。。
		// 请求到达目标资源之前，打印日志， yyyy-MM-dd HH:mm:ss ：*** 被访问了
		String requestURI = request.getRequestURI();
		String dateTime = dateFormat.format(new Date());
		System.out.println(requestURI + "在" + dateTime + "被访问了");
		// 2. 放行代码
		long before = System.currentTimeMillis();

		chain.doFilter(request, response);

		long after = System.currentTimeMillis();
		// 3. 响应之前，HttpServletResponse 转换为响应报文之前的功能代码，  资源在yyyy-MM-dd HH:mm:ss的请求：耗时。。毫秒
		System.out.print(requestURI + "资源在" + dateTime + "的请求耗时" + (after - before) + "毫秒");
	}
}
```

```xml

<filter>
	<filter-name>loggingFilter</filter-name>
	<filter-class>com.practice.filter.LoggingFilter</filter-class>
</filter>
		<!--	配置过滤器的过滤资源柜子，路径servlet-name-->
<filter-mapping>
<filter-name>loggingFilter</filter-name>
<!--两种方式：
1.url-pattern       根据请求的资源路径，对指定的请求进行过滤
        /*          过滤全部资源
        /a/*        过滤以a开头的资源
        *.html      过滤以html为后缀的资源
        /servlet1   对servlet1的请求进行过滤
 2.servlet-name     根据请求的servlet的别名，对指定的servlet资源进行过滤
    需要在java类中的@WebServlet()中定义value和name两个属性，value是访问路径，name是servlet-name填写的

 一个filter-mapping中，可以同时存在多个url-pattern和servlet-name
-->
<url-pattern>/*</url-pattern>
<servlet-name>servlet1</servlet-name>
</filter-mapping>
```

### 6.15.2 `Filter` 生命周期：

| 阶段    | 对应方法                                                                                                     | 执行时机     | 执行次数 |
|-------|----------------------------------------------------------------------------------------------------------|----------|------|
| 创建对象  | 构造器                                                                                                      | web应用启动时 | 1    |
| 初始化方法 | `void init(FilterConfig filterConfig)`                                                                   | 构造完毕     | 1    |
| 过滤请求  | `void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)` | 每次请求     | 多次   |
| 销毁    | `default void destroy()`                                                                                 | web应用关闭时 | 1次   |

> **示例：**

```java
public class LifeCycleFilter implements Filter {
	public LifeCycleFilter() {
		System.out.println("filter 构造器");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 其中filterConfig是过滤器的初始配置，在web.xml中配置
		System.out.println("初始化");
		System.out.println(filterConfig.getInitParameter("dateTimePattern"));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤方法");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("销毁方法");
	}
}
```

```xml
<!--filterConfig,Filter的初始化配置-->
<filter>
	<filter-name>lifeCycleFilter</filter-name>
	<filter-class>com.practice.filter.LifeCycleFilter</filter-class>
	<init-param>
		<param-name>dateTimePattern</param-name>
		<param-value>yyyy-MM-dd HH:mm:ss</param-value>
	</init-param>
</filter>
<filter-mapping>
<filter-name>lifeCycleFilter</filter-name>
<url-pattern>/*</url-pattern>
</filter-mapping>
```

## 6.16 过滤器链的使用-`FilterChain`

- 过滤链是通过多个过滤器对**同一个资源进行过滤**就会出现

+ 过滤器链中的过滤器的**顺序由 `filter-mapping` 决定**
+ 每个过滤器过滤的范围不同,针对同一个资源来说,过滤器链中的过滤器个数可能是不同的
+ 如果某个`Filter`是使用`ServletName`进行匹配规则的配置，那么这个`Filter`执行的优先级要更低

![](https://cdn.jsdelivr.net/gh/Shadow1086/myPicture@master/uPic/2026/04/06/16-56-95Nk0B)

## 6.17 `Servlet` 请求的分发处理

- 根据请求的类型：`POST`/`GET`，执行不同的功能方法

> **示例：**

```java

@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	System.out.println(" 3. service方法Hello Servlet 被访问了");
	// 强制类型转换，ServletRequest是接口，而HttpServletRequest是其实现类
	HttpServletRequest servletRequest = (HttpServletRequest) req;
	// 获取请求的方式，是post还是get
	String method = servletRequest.getMethod();
	System.out.println(method);
	if ("GET".equals(method)) {
		doGet();
	} else if ("POST".equals(method)) {
		doPost();
	}
}

/**
 * 做get请求的操作
 */
public void doGet() {
	System.out.println("get请求函数");
}

/**
 * 做get请求的操作
 */
public void doPost() {
	System.out.println("Post请求函数");
}
```

## 6.18 通过继承 `HttpServlet` 实现 `Servlet` 程序

- 一般在实际项目开发中，更常见的是继承 `HttpServlet`

1. 编写一个类去继承 `HttpServlet`
2. 根据业务需要重写 `doGet()` / `doPost()` 方法
3. 通过 `web.xml` 或 `@WebServlet` 配置访问地址

## 监听器

- 监听器只监听域对象的相关事件

### 监听器的分类

+ web中定义八个监听器接口作为监听器的规范,这八个接口按照不同的标准可以形成不同的分类

+ 按监听的对象划分
    + application域监听器 ServletContextListener ServletContextAttributeListener
    + session域监听器 HttpSessionListener HttpSessionAttributeListener HttpSessionBindingListener
      HttpSessionActivationListener
    + request域监听器 ServletRequestListener ServletRequestAttributeListener
+ 按监听的事件分
    + 域对象的创建和销毁监听器 ServletContextListener HttpSessionListener ServletRequestListener
    + 域对象数据增删改事件监听器 ServletContextAttributeListener HttpSessionAttributeListener
      ServletRequestAttributeListener
    + 其他监听器 HttpSessionBindingListener HttpSessionActivationListener

- 详细请查看：/Volumes/study/02-java/JavaWebStudy/09-Listener-Demo/src/main/java/com/study/listener/MyApplicationListener.java

### session域监听器拓展

- HttpSessionBindingListener：当前监听器实例 放入/移除 某个session中作为数据
- HttpSessionActivationListener：监听session的钝化与活化

#### 钝化与活化

- 当服务器中太多的session占用内存时，将session序列化存储到硬盘上，就是钝化，反之，从硬盘上取出到内存上，就是活化

如何配置钝化?

- 在webapp/WEB-INF/context.xml中配置如下信息

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Context>
	<Manager className="org.apache.catalina.session.PersistentManager" maxIdleSwap="1">
		<Store className="org.apache.catalina.session.FileStore" directory="file/example"></Store>
	</Manager>
</Context>
```

## AJAX的基本使用

示例：

```html

<script>
	$(function () {
		$("button").on("click", function () {
			// 实例化一个xmlHttpRequest对象
			let request = new XMLHttpRequest();
			// 设置对象的回调函数
			// request.readyState 1 2 3 4,其中4:代表后端返回了数据
			// request.status：响应状态码
			request.onreadystatechange = function () {
				if (request.readyState === 4 && request.status === 200) {
					// 接受响应的结果，处理结果
					// alert("后端响应了")
					// request.responseText 后端响应回来的响应体中的数据
					// console.log(request.responseText);
					// // 将信息放到指定的位置
					// $("#message").val(request.responseText)
					window.location.href = "https://www.baidu.com"
				}
			}
			// 设置发送请求的方式和请求的资源路径
			request.open("GET", "/hello?username=zhangsan");
			// 发送请求
			request.send();
		})
	})
</script>
```

## JSON
```json
{
  // 业务状态码，本次请求是否成功，如果失败了，是什么原因
  "code": "",
  "message": "",
  // 业务状态码的补充说明/描述
  "data": {}
  // 本次响应的数据
}
```

