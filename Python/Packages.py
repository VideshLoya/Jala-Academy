# 10. PACKAGES

# Simulating package structure
class PackageClass1:
    def __init__(self, name):
        self.name = name
        print(f"PackageClass1 initialized with name: {name}")
    
    def method1(self):
        return f"Method1 from {self.name}"

class PackageClass2:
    def __init__(self, value):
        self.value = value
        print(f"PackageClass2 initialized with value: {value}")
    
    def method2(self):
        return f"Method2 with value: {self.value}"

# Simulate importing and using packages
print("Package Example:")
obj1 = PackageClass1("Object1")
obj2 = PackageClass2(100)

print(obj1.method1())
print(obj2.method2())