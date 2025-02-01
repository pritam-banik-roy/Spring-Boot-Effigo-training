import React, { useState } from "react";
import "./Counter.css";
import CounterButton from "./CounterButton";

export default function Counter() {
  const [count, setCount] = useState(0);

  function incrementCount(by) {
    setCount(count + by);
  }
  function decrementCount(by) {
    setCount(count - by);
  }
  function resetCount() {
    setCount(0);
  }

  return (
    <div>
      <div>
        <CounterButton
          by={1}
          incrementCount={incrementCount}
          decrementCount={decrementCount}
        />
      </div>
      <div>
        <CounterButton
          by={2}
          incrementCount={incrementCount}
          decrementCount={decrementCount}
        />
      </div>
      <div>
        <CounterButton
          by={5}
          incrementCount={incrementCount}
          decrementCount={decrementCount}
        />
      </div>
      <div className="count">{count}</div>
      <div>
        <button className="counterButton" onClick={resetCount}>
          Reset
        </button>
      </div>
    </div>
  );
}
