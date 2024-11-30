import React from 'react';
import { BrowserRouter as Router, Route, Routes  } from 'react-router-dom';
import RequestMaintenance from './components/RequestMaintenance';
import ViewRequests from './components/ViewRequests';
import Navbar from './components/Navbar';
// import EquipmentList from './components/EquipmentList';

function App() {
  return (
    <Router>
      <Navbar/>
      <div className="container mt-4">
        {/* <h1 className="text-center mb-4">Gestion de Maintenance</h1> */}
        <Routes >
        <Route path="/" element={<RequestMaintenance />} />
        <Route path="/view-requests" element={<ViewRequests />} />
        {/* <Route path="/Equipments-list" element={<EquipmentList/>} /> */}
        </Routes >
      </div>
    </Router>
  );
}

export default App;
