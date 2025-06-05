# 11. FILES

# 1. Read text file
print("1. File Operations:")
file_content = "This is a sample text file content.\nLine 2 of the file.\nLine 3 of the file."

# Create a sample file
with open("sample.txt", "w") as file:
    file.write(file_content)

# Read the file
with open("sample.txt", "r") as file:
    content = file.read()
    print("File content:")
    print(content)

# 2. Write text to file using stream
print("\n2. Writing to file using stream:")
stream_content = "Content written using stream"
with open("stream_file.txt", "w") as file:
    file.write(stream_content)
print("Content written to stream_file.txt")

# 3. Read file stream
print("\n3. Reading file stream:")
with open("sample.txt", "r") as file:
    lines = file.readlines()
    print("Lines from file:")
    for i, line in enumerate(lines, 1):
        print(f"Line {i}: {line.strip()}")

# 4. Random access file reading (using seek)
print("\n4. Random access with seek:")
with open("sample.txt", "r") as file:
    file.seek(10)  # Move to position 10
    content_from_pos = file.read(20)  # Read 20 characters
    print(f"Content from position 10: '{content_from_pos}'")

# 5. Seek to particular index
print("\n5. Seek to specific position:")
with open("sample.txt", "r") as file:
    file.seek(0)  # Go to beginning
    first_char = file.read(1)
    print(f"First character: '{first_char}'")
    
    file.seek(5)  # Go to position 5
    char_at_5 = file.read(1)
    print(f"Character at position 5: '{char_at_5}'")

# 6. Check file permissions
print("\n6. File permissions:")
import stat

file_stats = os.stat("sample.txt")
file_mode = file_stats.st_mode

readable = bool(file_mode & stat.S_IRUSR)
writable = bool(file_mode & stat.S_IWUSR)

print(f"File is readable: {readable}")
print(f"File is writable: {writable}")

# Clean up created files
os.remove("sample.txt")
os.remove("stream_file.txt")