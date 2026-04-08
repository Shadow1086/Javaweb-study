const PI = 3.14;
function sum(a, b) {
	return a + b;
}
class Person {
	constructor(name, age) {
		this.name = name;
		this.age = age;
	}

	sayHello() {
		console.log(`hello, my name is ${this.name}, i am ${this.age} years old`);
	}
}
function createUser(name, age) {
	return new Person(name, age);
}

export { PI, sum, Person };

// 默认导出在一个 js 文件中只能有一个
export default createUser;
