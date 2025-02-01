import React, { useState } from "react";
import "./TodoApp.css";
import {
  BrowserRouter,
  Route,
  Routes,
  useNavigate,
  useParams,
} from "react-router-dom";

export default function TodoApp() {
  return (
    <div className="TodoApp">
      TodoApp
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LoginComponent />} />
          <Route path="/login" element={<LoginComponent />} />
          <Route path="/welcome/:username" element={<WelcomeComponent />} />
          <Route path="/todos" element={<ListTodosComponent />} />
          <Route path="*" element={<ErrorComponent />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

function LoginComponent() {
  const [userName, setUserName] = useState("Sid");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  function handleUserNameChange(event) {
    setUserName(event.target.value);
  }
  function handlePaswordChange(event) {
    setPassword(event.target.value);
  }

  function handleLogin() {
    if (userName === "Sid" && password === "1234") {
      navigate(`/welcome/${userName}`);
    }
  }

  return (
    <div className="Login">
      Login Component
      <div className="LoginForm">
        <div>
          <label>User Name</label>
          <input
            type="text"
            name="username"
            value={userName}
            onChange={handleUserNameChange}
          />
        </div>
        <div>
          <label>Password</label>
          <input
            type="password"
            name="password"
            value={password}
            onChange={handlePaswordChange}
          />
        </div>
        <div>
          <button type="button" name="login" onClick={handleLogin}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
}

function WelcomeComponent() {
  const { username } = useParams();
  return <div className="Welcome">Welcome {username}</div>;
}

function ErrorComponent() {
  return <div className="Error">Error Component 404</div>;
}

function ListTodosComponent() {
  return(
    <div className="ListTodos">
        <h1>Todos</h1>
        <div className="Todos">
        </div>
    </div>
  );
}
