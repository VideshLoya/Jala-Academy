// ===== 1. Single & Multi-line Comments =====
// Single-line comment
/* Multi-line comment
   spanning multiple lines */

// ===== 2. Sortable Fruits Array =====
const fruits = ["Apple", "Mango", "Banana", "Orange"];
function sortFruits() {
    console.log([...fruits].sort((a, b) => b.localeCompare(a)));
}
// Note: Connect this to button click in HTML: <button onclick="sortFruits()">Sort</button>

// ===== 3. FOR/IN Loop =====
const car = {make: "Toyota", model: "Camry", year: 2025};
for (let key in car) {
    console.log(`${key}: ${car[key]}`);
}

// ===== 4. Person Object =====
const person = {
    firstname: "Rahul",
    lastname: "Sharma"
};
console.log(person.firstname);    // Dot notation
console.log(person["lastname"]);  // Bracket notation

// ===== 5. Variable Hoisting =====
x = 5; // Initialization
console.log(x); // 5
var x; // Declaration

// ===== 6. Strict Mode =====
function strictExample() {
    "use strict";
    try {
        undeclaredVar = 42; // Throws ReferenceError
    } catch (err) {
        console.error("Strict mode error:", err.message);
    }
}
strictExample();

/* 
Explanation:
- Strict mode prevents accidental global variables
- FOR/IN iterates over enumerable properties
- var declarations are hoisted but initializations are not
- Array.sort() with localeCompare handles alphabetical sorting
*/
