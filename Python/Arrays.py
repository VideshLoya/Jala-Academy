# 4. ARRAYS

print("\n\n=== 4. ARRAYS (Lists) ===")

# 1. Add integer values of an array
print("1. Sum of Array Elements:")
def sum_array(arr):
    return sum(arr)

numbers = [1, 2, 3, 4, 5]
print(f"Array: {numbers}")
print(f"Sum: {sum_array(numbers)}")

# 2. Calculate average of array
print("\n2. Average of Array:")
def average_array(arr):
    return sum(arr) / len(arr) if arr else 0

avg = average_array(numbers)
print(f"Average: {avg}")

# 3. Find index of array element
print("\n3. Find Index of Element:")
def find_index(arr, element):
    try:
        return arr.index(element)
    except ValueError:
        return -1

element = 3
index = find_index(numbers, element)
print(f"Index of {element}: {index}")

# 4. Test if array contains specific value
print("\n4. Check if Array Contains Value:")
def contains_value(arr, value):
    return value in arr

value = 4
print(f"Array contains {value}: {contains_value(numbers, value)}")

# 5. Remove specific element from array
print("\n5. Remove Specific Element:")
def remove_element(arr, element):
    new_arr = arr.copy()
    if element in new_arr:
        new_arr.remove(element)
    return new_arr

original = [1, 2, 3, 4, 3, 5]
modified = remove_element(original, 3)
print(f"Original: {original}")
print(f"After removing 3: {modified}")

# 6. Copy array to another array
print("\n6. Copy Array:")
def copy_array(arr):
    return arr.copy()

copied = copy_array(numbers)
print(f"Original: {numbers}")
print(f"Copied: {copied}")

# 7. Insert element at specific position
print("\n7. Insert Element at Position:")
def insert_at_position(arr, element, position):
    new_arr = arr.copy()
    new_arr.insert(position, element)
    return new_arr

inserted = insert_at_position(numbers, 99, 2)
print(f"After inserting 99 at position 2: {inserted}")

# 8. Find minimum and maximum values
print("\n8. Min and Max Values:")
def find_min_max(arr):
    return min(arr), max(arr)

min_val, max_val = find_min_max(numbers)
print(f"Min: {min_val}, Max: {max_val}")

# 9. Reverse array
print("\n9. Reverse Array:")
def reverse_array(arr):
    return arr[::-1]

reversed_arr = reverse_array(numbers)
print(f"Original: {numbers}")
print(f"Reversed: {reversed_arr}")

# 10. Find duplicate values
print("\n10. Find Duplicates:")
def find_duplicates(arr):
    seen = set()
    duplicates = set()
    for item in arr:
        if item in seen:
            duplicates.add(item)
        else:
            seen.add(item)
    return list(duplicates)

arr_with_dups = [1, 2, 3, 2, 4, 3, 5]
dups = find_duplicates(arr_with_dups)
print(f"Array: {arr_with_dups}")
print(f"Duplicates: {dups}")

# 11. Common values between two arrays
print("\n11. Common Values Between Arrays:")
def find_common_values(arr1, arr2):
    return list(set(arr1) & set(arr2))

arr1 = [1, 2, 3, 4, 5]
arr2 = [3, 4, 5, 6, 7]
common = find_common_values(arr1, arr2)
print(f"Array 1: {arr1}")
print(f"Array 2: {arr2}")
print(f"Common values: {common}")

# 12. Remove duplicate elements
print("\n12. Remove Duplicates:")
def remove_duplicates(arr):
    return list(dict.fromkeys(arr))  # Preserves order

arr_with_dups = [1, 2, 2, 3, 3, 4, 5, 5]
unique_arr = remove_duplicates(arr_with_dups)
print(f"With duplicates: {arr_with_dups}")
print(f"Without duplicates: {unique_arr}")

# 13. Second largest number
print("\n13. Second Largest Number:")
def second_largest(arr):
    unique_arr = list(set(arr))
    if len(unique_arr) < 2:
        return None
    unique_arr.sort(reverse=True)
    return unique_arr[1]

test_arr = [1, 5, 3, 9, 2, 8]
second_max = second_largest(test_arr)
print(f"Array: {test_arr}")
print(f"Second largest: {second_max}")

# 15. Count even and odd numbers
print("\n15. Count Even and Odd Numbers:")
def count_even_odd(arr):
    even_count = sum(1 for x in arr if x % 2 == 0)
    odd_count = len(arr) - even_count
    return even_count, odd_count

even, odd = count_even_odd(numbers)
print(f"Array: {numbers}")
print(f"Even numbers: {even}, Odd numbers: {odd}")

# 16. Difference of largest and smallest value
print("\n16. Difference of Max and Min:")
def max_min_difference(arr):
    return max(arr) - min(arr)

diff = max_min_difference(numbers)
print(f"Difference between max and min: {diff}")

# 17. Verify if array contains two specified elements
print("\n17. Check for Specific Elements (12, 23):")
def contains_elements(arr, elem1, elem2):
    return elem1 in arr and elem2 in arr

test_arr = [10, 12, 15, 23, 30]
has_both = contains_elements(test_arr, 12, 23)
print(f"Array contains both 12 and 23: {has_both}")