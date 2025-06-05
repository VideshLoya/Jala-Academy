# 3. LOOPS

# 1. Print "Bright IT Career" ten times using for loop
print("1. For Loop - Print 10 times:")
for i in range(10):
    print(f"{i+1}. Bright IT Career")

# 2. Print 1 to 20 numbers using while loop
print("\n2. While Loop - Numbers 1 to 20:")
i = 1
while i <= 20:
    print(i, end=" ")
    i += 1
print()

# 3. Equal and not equal operators
print("\n3. Equal and Not Equal Operators:")
a, b = 10, 10
c, d = 5, 15
print(f"{a} == {b}: {a == b}")
print(f"{c} != {d}: {c != d}")

# 4. Print odd and even numbers
print("\n4. Odd and Even Numbers (1-20):")
for i in range(1, 21):
    if i % 2 == 0:
        print(f"{i} is Even")
    else:
        print(f"{i} is Odd")

# 5. Largest among three numbers
print("\n5. Largest Among Three Numbers:")
def find_largest(a, b, c):
    if a >= b and a >= c:
        return a
    elif b >= a and b >= c:
        return b
    else:
        return c

largest = find_largest(25, 45, 30)
print(f"Largest number: {largest}")

# 6. Even numbers between 10 and 20 using while
print("\n6. Even Numbers (10-20) using While:")
i = 10
while i <= 20:
    if i % 2 == 0:
        print(i, end=" ")
    i += 1
print()

# 7. Print 1 to 10 using do-while loop (simulated)
print("\n7. Do-While Loop Simulation (1-10):")
i = 1
while True:
    print(i, end=" ")
    i += 1
    if i > 10:
        break
print()

# 8. Armstrong number check
print("\n8. Armstrong Number Check:")
def is_armstrong(num):
    str_num = str(num)
    power = len(str_num)
    sum_of_powers = sum(int(digit) ** power for digit in str_num)
    return sum_of_powers == num

test_num = 153
if is_armstrong(test_num):
    print(f"{test_num} is an Armstrong number")
else:
    print(f"{test_num} is not an Armstrong number")

# 9. Prime number check
print("\n9. Prime Number Check:")
def is_prime(num):
    if num < 2:
        return False
    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:
            return False
    return True

test_num = 17
if is_prime(test_num):
    print(f"{test_num} is a prime number")
else:
    print(f"{test_num} is not a prime number")

# 10. Palindrome check
print("\n10. Palindrome Check:")
def is_palindrome(num):
    str_num = str(num)
    return str_num == str_num[::-1]

test_num = 121
if is_palindrome(test_num):
    print(f"{test_num} is a palindrome")
else:
    print(f"{test_num} is not a palindrome")

# 11. Even or Odd using switch (dictionary simulation)
print("\n11. Even/Odd using Switch-like structure:")
def check_even_odd_switch(num):
    switch = {
        0: "Even",
        1: "Odd"
    }
    return switch.get(num % 2, "Invalid")

test_num = 8
result = check_even_odd_switch(test_num)
print(f"{test_num} is {result}")

# 12. Gender program using switch
print("\n12. Gender Program using Switch:")
def get_gender(char):
    gender_dict = {
        'M': 'Male',
        'm': 'Male',
        'F': 'Female',
        'f': 'Female'
    }
    return gender_dict.get(char, "Invalid input")

gender_input = 'M'
print(f"Gender for '{gender_input}': {get_gender(gender_input)}")