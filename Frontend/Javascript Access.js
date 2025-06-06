<!DOCTYPE html>
<html>
<body>

<!-- === 1. Disappearing Button === -->
<button onclick="this.style.display='none'">Click to Disappear</button>

<!-- === 3. & 4. Counter === -->
<p>Count: <span id="counter">0</span></p>
<button onclick="increment()">Count</button>
<button onclick="setCounter(10)">Reset to 10</button>

<script>
// === 2. call() vs apply() ===
const user = { name: "Alice" };
function greet(greeting, punctuation) {
    console.log(`${greeting} ${this.name}${punctuation}`);
}

// call() executes with individual arguments
greet.call(user, "Hello", "!");  // Hello Alice!

// apply() executes with array arguments
greet.apply(user, ["Hi", "!!"]); // Hi Alice!!

// Difference: call() takes arguments separately, apply() takes array


// === 3. Counter Closure ===
let count = 0;
function increment() {
    document.getElementById("counter").textContent = ++count;
}

// === 4. Getter/Setter Counter ===
const counterObj = {
    _value: 0,
    get count() {
        return this._value;
    },
    set count(value) {
        if(value >= 0) this._value = value;
        document.getElementById("counter").textContent = this._value;
    }
};

function setCounter(value) {
    counterObj.count = value;
}

// === 5. Prototype Properties ===
function Vehicle(type) {
    this.type = type;
}

// Add prototype method
Vehicle.prototype.honk = function() {
    console.log(`${this.type} honks!`);
};

// Add prototype property
Vehicle.prototype.wheels = 4;

const car = new Vehicle("Car");
car.honk(); // Car honks!
console.log(car.wheels); // 4
</script>

</body>
</html>
