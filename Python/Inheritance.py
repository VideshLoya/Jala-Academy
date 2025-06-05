# 7. INHERITANCE

class A:
    def __init__(self):
        self.data_a = "Data from class A"
    
    def method_a1(self):
        print("Method A1 from class A")
    
    def method_a2(self):
        print("Method A2 from class A")
    
    def common_method(self):
        print("Common method from class A")

class B(A):
    def __init__(self):
        super().__init__()
        self.data_b = "Data from class B"
    
    def method_b1(self):
        print("Method B1 from class B")
    
    def method_b2(self):
        print("Method B2 from class B")
    
    def common_method(self):
        print("Common method from class B (overridden)")

class C(B):
    def __init__(self):
        super().__init__()
        self.data_c = "Data from class C"
    
    def method_c1(self):
        print("Method C1 from class C")
    
    def method_c2(self):
        print("Method C2 from class C")
    
    def common_method(self):
        print("Common method from class C (overridden)")

# Create objects and call methods
print("Creating objects and calling methods:")
obj_a = A()
obj_b = B()
obj_c = C()

# Call methods using respective objects
print("\nCalling methods with class A object:")
obj_a.method_a1()
obj_a.method_a2()
obj_a.common_method()

print("\nCalling methods with class B object:")
obj_b.method_a1()  # Inherited
obj_b.method_b1()
obj_b.method_b2()
obj_b.common_method()

print("\nCalling methods with class C object:")
obj_c.method_a1()  # Inherited
obj_c.method_b1()  # Inherited
obj_c.method_c1()
obj_c.method_c2()
obj_c.common_method()

# Runtime Polymorphism
print("\nRuntime Polymorphism:")
a_ref = obj_b  # Super class reference to B object
a_ref.common_method()

a_ref = obj_c  # Super class reference to C object
a_ref.common_method()