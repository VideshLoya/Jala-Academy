# 12. Constructors

1. Class with Multiple Constructors

class MyClass:
    def __init__(self, name="Default", age=None):
        self.name = name
        self.age = age

    @classmethod
    def one_arg_constructor(cls, name):
        return cls(name=name)

    @classmethod
    def two_arg_constructor(cls, name, age):
        return cls(name=name, age=age)


# Instantiating with all three variations
obj1 = MyClass()  # Default constructor
obj2 = MyClass.one_arg_constructor("Alice")  # One-arg
obj3 = MyClass.two_arg_constructor("Bob", 30)  # Two-arg

print(obj1.__dict__)
print(obj2.__dict__)
print(obj3.__dict__)

 2. Call Superclass Constructor from Child Class

class Parent:
    def __init__(self, value):
        print("Parent constructor called")
        self.value = value

class Child(Parent):
    def __init__(self, value, extra):
        super().__init__(value)  # Call parent constructor
        print("Child constructor called")
        self.extra = extra

child_obj = Child("parent_value", "child_value")
print(child_obj.__dict__)

 3. Access Modifiers in Constructors

class AccessDemo:
    def __init__(self):          # Public constructor
        print("Public constructor")

    def _protected_init(self):   # Simulated protected method
        print("Protected constructor (not enforced)")

    def __private_init(self):    # Private method
        print("Private constructor (name mangled)")


obj = AccessDemo()
obj._protected_init()            # Can still call, just a convention
# obj.__private_init()          # This will raise AttributeError

# Accessing private method via name mangling
obj._AccessDemo__private_init()

4. Attributes of Constructor

class Employee:
    def __init__(self, emp_id, name):
        self.emp_id = emp_id
        self.name = name
        print(f"Employee created with ID: {self.emp_id} and Name: {self.name}")

emp = Employee(101, "John Doe")
print(emp.__dict__)  # Showing attributes initialized by constructor


