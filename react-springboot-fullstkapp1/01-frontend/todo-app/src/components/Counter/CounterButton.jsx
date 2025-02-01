export default function CounterButton({ by, incrementCount, decrementCount }) {
  return (
    <>
      <button
        className="counterButton"
        onClick={() => {
          incrementCount(by);
        }}
      >
        +{by}
      </button>
      <button
        className="counterButton"
        onClick={() => {
          decrementCount(by);
        }}
      >
        -{by}
      </button>
    </>
  );
}
