# 8. ACCESS MODIFIERS

# 1. Private fields and methods
class PrivateExample:
    def __init__(self):
        self.__private_field = "I am private"  # Private field
    
    def __private_method(self):  # Private method
        return "Private method called"
    
    def access_private(self):
        print(f"Private field: {self.__private_field}")
        print(f"Private method: {self.__private_method()}")

print("1. Private Access:")
private_obj = PrivateExample()
private_obj.access_private()  # Access via public method

# Try to access private members from subclass
class PrivateChild(PrivateExample):
    def try_access_private(self):
        try:
            print(self.__private_field)  # This will cause AttributeError
        except AttributeError:
            print("Cannot access private field from child class")

child = PrivateChild()
child.try_access_private()

# 2. Protected fields and methods
class ProtectedExample:
    def __init__(self):
        self._protected_field = "I am protected"  # Protected field
    
    def _protected_method(self):  # Protected method
        return "Protected method called"

class ProtectedChild(ProtectedExample):
    def access_protected(self):
        print(f"Protected field: {self._protected_field}")
        print(f"Protected method: {self._protected_method()}")

print("\n2. Protected Access:")
protected_obj = ProtectedChild()
protected_obj.access_protected()

# 3. Public fields and methods
class PublicExample:
    def __init__(self):
        self.public_field = "I am public"  # Public field
    
    def public_method(self):  # Public method
        return "Public method called"

print("\n3. Public Access:")
public_obj = PublicExample()
print(f"Public field: {public_obj.public_field}")
print(f"Public method: {public_obj.public_method()}")