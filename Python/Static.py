# 5. STATIC 

# 1. Access static variable through class
print("1. Access static variable through class:")
print(f"Static variable via class: {StaticExample.static_var}")

# 2. Access static variable through instance
print("\n2. Access static variable through instance:")
obj1 = StaticExample()
print(f"Static variable via instance: {obj1.static_var}")

# 3. Change static variable within instance
print("\n3. Change static variable within instance:")
obj1.change_static_via_instance("Changed via instance")
print(f"Static variable after change: {StaticExample.static_var}")

# 4. Change static variable within class
print("\n4. Change static variable within class:")
StaticExample.change_static_via_class("Changed via class")
print(f"Static variable after class change: {StaticExample.static_var}")
