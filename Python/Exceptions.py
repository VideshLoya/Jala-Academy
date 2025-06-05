# 14. Exceptions

# 1. Generate Arithmetic Exception without exception handling
print("1. Arithmetic Exception without handling")
# Uncomment the next line to see the actual exception
# result = 10 / 0
# print(result)

# 2. Handle the Arithmetic exception using try-except
print("\n2. Arithmetic Exception with handling")
try:
    result = 10 / 0
except ZeroDivisionError:
    print("Caught Arithmetic Exception: Division by zero")

# 3. Method which throws exception, called without try block
print("\n3. Method throws exception, no try block")
def risky_operation():
    raise Exception("An error occurred inside risky_operation")

# Uncomment below line to see unhandled exception
# risky_operation()

# 4. Multiple except blocks
print("\n4. Multiple except blocks")
try:
    x = int("abc")  # Will raise ValueError
except ZeroDivisionError:
    print("Caught ZeroDivisionError")
except ValueError:
    print("Caught ValueError")
except Exception as e:
    print("Caught general Exception:", e)

# 5. Throw exception with your own message
print("\n5. Throw custom exception message")
try:
    raise Exception("This is my custom exception message")
except Exception as e:
    print(e)

# 6. Create your own exception
print("\n6. Create and raise your own exception")
class MyCustomException(Exception):
    pass

def check_value(x):
    if x < 0:
        raise MyCustomException("Negative values are not allowed")

try:
    check_value(-1)
except MyCustomException as e:
    print("Caught MyCustomException:", e)

# 7. Program with finally block
print("\n7. Finally block example")
try:
    print("Try block executing")
    result = 10 / 0
except ZeroDivisionError:
    print("Caught exception in try")
finally:
    print("Finally block executed")

# 8. Generate Arithmetic Exception
print("\n8. Generate Arithmetic Exception")
try:
    x = 5 / 0
except ZeroDivisionError as e:
    print("Arithmetic Exception occurred:", e)

# 9. Generate FileNotFoundError
print("\n9. Generate FileNotFoundException (FileNotFoundError in Python)")
try:
    with open("nonexistent_file.txt", "r") as f:
        content = f.read()
except FileNotFoundError as e:
    print("FileNotFoundError occurred:", e)

# 10. Generate ClassNotFoundException (Python equivalent: ImportError)
print("\n10. Generate ClassNotFoundException (ImportError in Python)")
try:
    import nonexistentmodule
except ImportError as e:
    print("ImportError occurred:", e)

# 11. Generate IOException (Python's built-in IOError / OSError)
print("\n11. Generate IOException")
try:
    with open("/root/protectedfile.txt", "w") as f:
        f.write("test")
except (IOError, OSError) as e:
    print("IOError/OSError occurred:", e)

# 12. Generate NoSuchFieldException (Python equivalent: AttributeError)
print("\n12. Generate NoSuchFieldException (AttributeError in Python)")
class TestClass:
    def __init__(self):
        self.name = "Test"

obj = TestClass()
try:
    print(obj.age)  # This field does not exist
except AttributeError as e:
    print("AttributeError (NoSuchFieldException) occurred:", e)
