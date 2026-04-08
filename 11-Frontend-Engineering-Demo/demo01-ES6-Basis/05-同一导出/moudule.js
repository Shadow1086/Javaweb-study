export const PI = 3.14;
export function sum(a, b) {
	return a + b;
}
export class Person {
	constructor(name, age) {
		this.name = name;
		this.age = age;
	}

	sayHello() {
		console.log(`hello, my name is ${this.name}, i am ${this.age} years old`);
	}
}
