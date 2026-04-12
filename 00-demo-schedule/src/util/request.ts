import axios, {type AxiosResponse, type InternalAxiosRequestConfig} from "axios";

const request = axios.create({
		baseURL: 'http://localhost:8080/'
	}
);
request.interceptors.request.use(
	(config: InternalAxiosRequestConfig) => {
		return config;
	},
	(error) => {
		return Promise.reject(error)
	}
)
request.interceptors.response.use(
	(response: AxiosResponse) => {
		return response;
	},
	(error) => {
		return Promise.reject(error)
	}
)

export default request;