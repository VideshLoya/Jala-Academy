# 15. Dictionery

# 1. Create a Dictionary with at least 5 key-value pairs of Student ID and Name
students = {
    101: "Alice",
    102: "Bob",
    103: "Charlie",
    104: "David",
    105: "Eva"
}
print("1. Initial Dictionary:", students)

# 1.1. Adding values to dictionary
students[106] = "Frank"
print("\n1.1 After Adding (ID:106):", students)

# 1.2. Updating values in dictionary
students[102] = "Bobby"
print("\n1.2 After Updating (ID:102):", students)

# 1.3. Accessing a value in dictionary
print("\n1.3 Accessing ID 103:", students[103])

# 1.4. Create a nested loop dictionary (students with subject and grade)
student_info = {
    201: {"name": "John", "subject": "Math", "grade": "A"},
    202: {"name": "Sara", "subject": "Science", "grade": "B"},
    203: {"name": "Mike", "subject": "English", "grade": "A+"}
}
print("\n1.4 Nested Dictionary:")
for sid, details in student_info.items():
    print(f"ID: {sid}, Info: {details}")

# 1.5. Access values of nested dictionary
print("\n1.5 Accessing Nested Value - Name of ID 202:", student_info[202]["name"])
print("1.5 Accessing Nested Value - Grade of ID 203:", student_info[203]["grade"])

# 1.6. Print keys present in the main student dictionary
print("\n1.6 Keys in student dictionary:", list(students.keys()))

# 1.7. Delete a value from dictionary
del students[101]
print("\n1.7 After Deleting ID 101:", students)
