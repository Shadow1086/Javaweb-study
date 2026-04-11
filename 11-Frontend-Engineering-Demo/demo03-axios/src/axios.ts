// 使用axios函数创建一个可以发送请求的实例对象
import axios, {type AxiosResponse, type InternalAxiosRequestConfig} from "axios";

const instance = axios.create({
	// 请求的基础路径
	baseURL: "https://api.oick.cn/api/lishi",
	// 超时时间
	timeout: 10000
});

// 设置请求拦截器
instance.interceptors.request.use(
	(config:InternalAxiosRequestConfig) => {
		console.log("请求前拦截器")
		// 请求之前，设置请求信息的方法
		config.headers.set("Accept","application/json,text/plain,text/html")
		// 设置完毕之后，必须返回config
		return config;
	},
	(error) => {
		console.log("请求拦截器异常方法")
		// 返回一个失败状态的promise
		return Promise.reject(error)
	}
)
// 响应的拦截器
instance.interceptors.response.use(
	(response:AxiosResponse)=>{
		// 响应状态码为200时执行的方法
		// 处理响应数据，最后返回response
		console.log("response success",response);
		return response
	},
	(error)=>{
		// 状态码不是200时
		console.log('response fail:',error)
		// 最后一定要响应一个promise
		return Promise.reject(error)
	}
)

// 默认导出，暴露instance
export default instance;
