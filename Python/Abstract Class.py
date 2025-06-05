# 9. ABSTRACT CLASS

from abc import ABC, abstractmethod

# 1. Abstract class with abstract and non-abstract methods
class AbstractExample(ABC):
    def __init__(self):
        self.data = "Abstract class data"
    
    @abstractmethod
    def abstract_method(self):
        pass
    
    def non_abstract_method(self):
        return "Non-abstract method from abstract class"

# 2. Subclass for abstract class
class ConcreteExample(AbstractExample):
    def abstract_method(self):
        return "Abstract method implemented in concrete class"
    
    def concrete_method(self):
        return "Method specific to concrete class"

print("Abstract Class Implementation:")

# 3. Create instance of child class and call abstract methods
concrete_obj = ConcreteExample()
print(concrete_obj.abstract_method())

# 4. Call non-abstract methods
print(concrete_obj.non_abstract_method())
print(f"Data: {concrete_obj.data}")