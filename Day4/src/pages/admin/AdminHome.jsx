import React from "react";
import "../../assets/css/AdminHome.css";
import { useNavigate } from "react-router-dom";
const AdminHome = () => {
  const navigate = useNavigate();
  const handleadminusers = () => {
    navigate("/userdetails");
  };
  const handleadminadd = () => {
    navigate("/admin/addevents");
  };
  return (
    <div>
      <header>
        <nav id="topbar">
          <div class="container"></div>
          <h2>SPOTLIGHT</h2>
          <ul>
            <h3 onClick={handleadminadd}>Add</h3>
            <h3>Delete</h3>
            <h3>Edit</h3>
            <h3 onClick={handleadminusers}> Users</h3>
            <h3>Logout</h3>
          </ul>
        </nav>
      </header>
    </div>
  );
};

export default AdminHome;
