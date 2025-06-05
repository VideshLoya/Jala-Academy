# 13. Method Overloading

1. Methods with same name but different number of parameters

class Example:
    def show(self, *args):
        if len(args) == 1:
            print(f"One argument: {args[0]}")
        elif len(args) == 2:
            print(f"Two arguments: {args[0]}, {args[1]}")
        else:
            print("Invalid number of arguments")

obj = Example()
obj.show(10)
obj.show(10, 20)

2. Methods with same name but different number of parameters of different data types

class Example:
    def display(self, *args):
        if len(args) == 1 and isinstance(args[0], str):
            print(f"String: {args[0]}")
        elif len(args) == 2 and isinstance(args[0], int) and isinstance(args[1], float):
            print(f"Integer and Float: {args[0]}, {args[1]}")
        else:
            print("Invalid or unsupported types")

obj = Example()
obj.display("Hello")
obj.display(5, 3.14)


3. Methods with same name and same number of parameters of same type

class Demo:
    def greet(self, name):  # This method gets overridden
        print(f"Hello, {name}!")

    def greet(self, name):  # This method overrides the above one
        print(f"Welcome, {name}!")

d = Demo()
d.greet("Alice")  # Output: Welcome, Alice!


