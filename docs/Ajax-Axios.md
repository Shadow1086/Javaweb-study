# 1. AJAX

## 1.1 HTTP 

### 1.1.1 请求报文

- 请求行		GET / URL 	HTTP/1.1 协议版本
- 请求头
  - Host:
  - Cookies : name = guigu
  - Content-type : application/text
- 空行
- 请求体
  - GET请求，请求体为空
  - POST请求，请求体不为空，存储数据



### 1.1.2 响应报文

- 请求行
- 请求头
- 空行
- 请求体

## 1.2 Ajax基本使用

1. 创建`xmlHttpRequest`对象
2. 初始化，设置类型与URL，`open('POST','url')`
   - 传参：在url后接`?`,比如：`http://localhost:8080/server?a=100&b=200`
3. 发送请求：`send()`
   - 在send()中可以设置请求体内容，但是只在post请求时有效
   - 如：`send('a=100&b=200')`/`send('a:100&b:200')`
4. 进行事件绑定，使用回调函数:`onreadystatechange`函数
   - 在函数体内，`.readyState`表示状态：0，1，2，3，4。其中4表示成功
   - `status`是响应状态码，200表示服务器成功返回了参数

- 基本方法：
  - 取消请求：`request.abort()`

### 1.2.1 设置请求体

- 在`request.send()`中可以设置请求体

```typescript
const request = XmlHttpRequest();
request.open('POST','http://localhost:8080');
// 设置请求体
request.send('a=100&b=200');

request.onreadystatechange = ()=>{
	if(request.readyState === 4 && request.status === 200){
        console.log("请求成功");
    }
}
```



### 1.2.2 设置请求头

- `request.setRequestHeader()`方法
- 常见的设置：
  - `request.setRequestHeader('Content-Type','application/x-www-form-urlencoded')`：允许跨域操作
  - `request.setRequestHeader('Access-Control-Allow-Headers','*')`:接受所有类型的头信息
- 示例：

```typescript
const request = XmlHttpRequest();
request.open('POST','http://localhost:8080');
// 设置请求头
request.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
// 表示允许跨域操作
request.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
// 表示所有类型的头信息都可以接受，比如自定义的name属性等等
request.setRequestHeader('Access-Control-Allow-Headers','*');
request.send();
request.onreadystatechange = ()=>{
	if(request.readyState === 4 && request.status === 200){
        console.log("请求成功");
    }
}
```

## 1.3 处理JSON数据

1. 手动转换：使用`let data =JSON.prase(request.response)`即可获得
2. 自动转换：`request.responseType='json'`

- 假设返回的JSON为：

```json
{
    name:'zhangsan',
    age:19
}
```

```typescript
const request = XmlHttpRequest();
request.open('POST','http://localhost:8080');
// 设置请求体
request.send();
// 方式二：自动转换
request.responseType='json';

request.onreadystatechange = ()=>{
	if(request.readyState === 4 && request.status === 200){
        // 方式一：手动转换
		let data = JSON.parse(request.response);
        console.log(data.name);				// zhangsan
        
        // 自动转换
        console.log(request.response.name);	//zhangsan
    }
}
```

## 1.4 IE浏览器缓存问题

- IE会自动进行数据的缓存，导致AJAX返回的数据不能及时的响应在浏览器上，所以需要控制

示例：

```typescript
const request = XmlHttpRequest();

// 添加设置，取消IE的缓存
request.open('POST','http://localhost:8080?t='+Date.now());

request.send();
request.onreadystatechange = ()=>{
	if(request.readyState === 4 && request.status === 200){
        console.log("请求成功");
    }
}
```

## 1.5 响应超时与网络异常处理

- 使用`request.timeout = 2000`设置超时时间即可，单位为毫秒，2000即为2秒
- 超时回调函数：`request.ontimeout`，超时后自动执行的函数
- 网络异常回调函数：`request.onerror`

示例：

```typescript
const request = XmlHttpRequest();
// 超时设置
request.timeout=2000;
request.ontimeout = ()=>{
    alert("网络异常，请稍后再试");
}
request.onerror = ()=>{
	alert("你的网络似乎出现了问题");
}
request.send();
request.onreadystatechange = ()=>{
	if(request.readyState === 4 && request.status === 200){
        console.log("请求成功");
    }
}
```

## 1.6 重复请求问题

```typescript
const request = null;
let isSending = false;		// 是否正在发送AJAX请求

button.on('click',()=>{
    // 如果正在发送请求，就将上一个请求取消掉
    if(isSending) request.abort();
    
    request = new XmlHttpRequest();
    isSending = true;
    request.onreadystatechange = ()=>{
	if(request.readyState === 4){
        // 修改表示变量
        isSending= false;
        if( request.status === 200){
            console.log("success")
        }
    }
}
})
```

## 1.7 使用JQuery发送AJAX请求

### 1.7.1 发送get/post请求

Json返回数据：

```json
{name:'zhangsan',age:19}
```

```typescript
// get 和 post 写法一样
$.get('http://localhost:8080',{a:100,b:200},(data)=>{
    console.log(data);	//{name:'zhangsan',age:19}
},'json')
```

### 1.7.2 JQueyr通用方法发送AJAX请求

```typescript
$.ajax({
    // url
    url:'http://localhost:8080',
    // 参数
    data:{a:100,b:200},
    // 请求类型
    type:'GET',
    // 响应体结果：
    dataType:'json',
    // 成功的回调：
    success:()=>{
        console.log(data);
    },
    // 超时事件：
    timout:2000,
    // 失败的回调函数
    error:()=>{
        console.log("超时");
    },
    // 关于头信息(需要设置允许所有类型的请求头)：
    headers:{
        c:300,
        d:400
    }
})
```

# 2. Axios

## 2.1 基础使用：

### 2.1.1 GET请求：

```typescript
// GET请求
axios.get('http://localhost:8080',{
    // url参数
    params:{
        id:100,
        vip:07
    },
    // 请求头信息
    headers:{
        name:'zhangsan',
        age:19
    }
}).then(value=>{
    console.log(value);
});
```

### 2.1.2 POST请求：

```typescript
// POST请求
axios.post('http://localhost:8080',{
    	// 请求体：
        username:'admin',
        password:'admin'
    },
   {
    // url参数
    params:{
        id:100,
        vip:07
    },
    // 请求头信息
    headers:{
        name:'zhangsan',
        age:19
    }
    
})
```

### 2.1.3 Axios函数发送AJAX请求

```typescript
axios({
    //请求方法：
    method:'POST',
    // url
    url:'http://localhost:8080',
    // url参数
    params:{
   	 	vip:10,
    	levle:20
	}，
    // 头信息：
    headers :{
    	a:100,
    	b:200
	},
      // 请求体参数：
      data:{
      	 username:'admin',
     	 password:'admin'
      }
}).then(response=>{
    console.log(response);
    console.log(response.status);                    // 状态码
	console.log(response.statusText);                // 状态字符串
	console.log(response.getAllResponseHeaders());   // 所有响应头
	console.log(response.response);                  // 响应体
})
```

# 3. 跨域

## 3.1 同源策略：

- 同源策略：浏览器的一种安全策略
  - 同源：协议，域名，端口号必须完全相同
  - 跨域：违背同源策略的就是跨域

## 3.2 解决方案：CORS

- 设置response的响应头：

示例：

```typescript
// 允许访问的URL，全部允许的话就是*，或者：http://localhost:5500
response.setHeader("Access-Control-Allow-Origin","*")
// 请求的头信息
response.setHeader("Access-Control-Allow-Headers","*")
// 请求的方式：get,post,delete,put...
response.setHeader("Access-Control-Allow-Method","*")
```













