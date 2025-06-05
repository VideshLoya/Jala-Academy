# 6. STRINGS

# 1. Different ways of creating strings
print("1. Different Ways of Creating Strings:")
str1 = "Using double quotes"
str2 = 'Using single quotes'
str3 = """Using triple double quotes"""
str4 = '''Using triple single quotes'''
str5 = str("Using str() constructor")
print(f"String 1: {str1}")
print(f"String 2: {str2}")
print(f"String 3: {str3}")

# 2. Concatenating strings using + operator
print("\n2. String Concatenation:")
first_name = "John"
last_name = "Doe"
full_name = first_name + " " + last_name
print(f"Full name: {full_name}")

# 3. Finding length of string
print("\n3. String Length:")
sample_string = "Hello World"
print(f"String: '{sample_string}'")
print(f"Length: {len(sample_string)}")

# 4. Extract string using substring
print("\n4. Substring Extraction:")
text = "Python Programming"
substring = text[7:18]  # Extract "Programming"
print(f"Original: {text}")
print(f"Substring: {substring}")

# 5. Searching in strings using index()
print("\n5. String Searching:")
text = "Hello World"
try:
    index = text.index("World")
    print(f"'World' found at index: {index}")
except ValueError:
    print("Substring not found")

# 6. Matching string against regular expression
print("\n6. Regular Expression Matching:")
import re
text = "The price is $25.99"
pattern = r'\$\d+\.\d+'
if re.search(pattern, text):
    print("Price pattern found in text")

# 7. Comparing strings
print("\n7. String Comparison:")
str1 = "Hello"
str2 = "Hello"
str3 = "World"
print(f"'{str1}' == '{str2}': {str1 == str2}")
print(f"'{str1}' == '{str3}': {str1 == str3}")

# 8. startsWith(), endsWith() and compareTo()
print("\n8. String Methods:")
text = "Python Programming"
print(f"Starts with 'Python': {text.startswith('Python')}")
print(f"Ends with 'ing': {text.endswith('ing')}")
# Python doesn't have compareTo, but we can simulate it
def compare_to(s1, s2):
    if s1 < s2:
        return -1
    elif s1 > s2:
        return 1
    else:
        return 0

print(f"Compare 'Apple' to 'Banana': {compare_to('Apple', 'Banana')}")

# 9. Trimming strings with strip()
print("\n9. String Trimming:")
text_with_spaces = "   Hello World   "
trimmed = text_with_spaces.strip()
print(f"Original: '{text_with_spaces}'")
print(f"Trimmed: '{trimmed}'")

# 10. Replacing characters in strings
print("\n10. String Replacement:")
text = "Hello World"
replaced = text.replace("World", "Python")
print(f"Original: {text}")
print(f"Replaced: {replaced}")

# 11. Splitting strings
print("\n11. String Splitting:")
text = "apple,banana,orange,grape"
fruits = text.split(",")
print(f"Original: {text}")
print(f"Split result: {fruits}")

# 12. Converting integer to string
print("\n12. Integer to String Conversion:")
number = 42
str_number = str(number)
print(f"Integer: {number}, Type: {type(number)}")
print(f"String: {str_number}, Type: {type(str_number)}")

# 13. Converting to uppercase and lowercase
print("\n13. Case Conversion:")
text = "Hello World"
print(f"Original: {text}")
print(f"Uppercase: {text.upper()}")
print(f"Lowercase: {text.lower()}")
