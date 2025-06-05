# 2. OPERATORS
# ========================================

# 1. Arithmetic operators function
print("1. Arithmetic Operators:")
def arithmetic_operations(a, b):
    print(f"Addition: {a} + {b} = {a + b}")
    print(f"Subtraction: {a} - {b} = {a - b}")
    print(f"Multiplication: {a} * {b} = {a * b}")
    print(f"Division: {a} / {b} = {a / b}")
    print(f"Floor Division: {a} // {b} = {a // b}")
    print(f"Modulus: {a} % {b} = {a % b}")
    print(f"Exponentiation: {a} ** {b} = {a ** b}")

arithmetic_operations(10, 3)

# 2. Increment and decrement operators (Python doesn't have ++/--, but we can simulate)
print("\n2. Increment and Decrement:")
def increment_decrement():
    x = 5
    print(f"Original value: {x}")
    x += 1  # Increment
    print(f"After increment: {x}")
    x -= 1  # Decrement
    print(f"After decrement: {x}")

increment_decrement()

# 3. Check if two numbers are equal
print("\n3. Equality Check:")
def check_equality(num1, num2):
    if num1 == num2:
        print(f"{num1} and {num2} are equal")
    else:
        print(f"{num1} and {num2} are not equal")

check_equality(5, 5)
check_equality(5, 10)

# 4. Relational operators
print("\n4. Relational Operators:")
def relational_operators(a, b):
    print(f"{a} < {b}: {a < b}")
    print(f"{a} <= {b}: {a <= b}")
    print(f"{a} > {b}: {a > b}")
    print(f"{a} >= {b}: {a >= b}")
    print(f"{a} == {b}: {a == b}")
    print(f"{a} != {b}: {a != b}")

relational_operators(5, 10)

# 5. Find smaller and larger number
print("\n5. Smaller and Larger Number:")
def find_smaller_larger(a, b):
    if a < b:
        print(f"Smaller: {a}, Larger: {b}")
    elif a > b:
        print(f"Smaller: {b}, Larger: {a}")
    else:
        print(f"Both numbers are equal: {a}")

find_smaller_larger(15, 25)
