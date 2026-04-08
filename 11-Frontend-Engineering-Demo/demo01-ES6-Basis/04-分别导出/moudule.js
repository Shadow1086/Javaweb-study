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
export { PI, sum, Person };
