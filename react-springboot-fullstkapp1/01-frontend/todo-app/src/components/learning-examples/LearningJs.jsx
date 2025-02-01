import React from "react";

const person = {
  name: "Ranga",
  address: {
    street: "123 street",
    city: "bbsr",
    country: "India",
  },
  profiles: ["Twitter", "LinkedIn"],
  printProfile: () => {
    person.profiles.map((profile) => console.log(profile));
  },
};

export default function LearningJs() {
  return (
    <>
      <div>{person.name}</div>
      <div>{person.address.street}</div>
      <div>{person.profiles[1]}</div>
      <div>{person.printProfile()}</div>
    </>
  );
}
