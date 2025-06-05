# 1. PYTHON BASICS

print("=== 1. PYTHON BASICS ===")

# 1. Program to print your name
print("1. Print Name:")
print("My name is John Doe")

# 2. Single line comment and multi-line comments
print("\n2. Comments Example:")
# This is a single line comment

"""
This is a multi-line comment
It can span multiple lines
Used for documentation
"""

'''
This is another way to write
multi-line comments in Python
'''

# 3. Define variables for different Data Types
print("\n3. Different Data Types:")
# Integer
age = 25
print(f"Integer: {age}, Type: {type(age)}")

# Boolean
is_student = True
print(f"Boolean: {is_student}, Type: {type(is_student)}")

# Character (Python doesn't have separate char type, uses string)
initial = 'A'
print(f"Character: {initial}, Type: {type(initial)}")

# Float
height = 5.9
print(f"Float: {height}, Type: {type(height)}")

# Double (Python float is double precision by default)
pi = 3.141592653589793
print(f"Double: {pi}, Type: {type(pi)}")

# 4. Local and Global variables with same name
print("\n4. Local and Global Variables:")
name = "Global John"  # Global variable

def show_scope():
    name = "Local John"  # Local variable
    print(f"Inside function - Local variable: {name}")

print(f"Outside function - Global variable: {name}")
show_scope()
print(f"After function - Global variable: {name}")
