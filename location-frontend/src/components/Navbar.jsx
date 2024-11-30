import React from 'react';
import { NavLink } from 'react-router-dom'; // Utilisation de NavLink pour la navigation

function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="container">
        <a className="navbar-brand" href="/">Gestion de Maintenance</a>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              {/* La prop exact n'est plus nécessaire dans v6 */}
              <NavLink className="nav-link" to="/" end>
                Demander une maintenance
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" to="/view-requests">
                Toutes les demandes
              </NavLink>
            </li>
            {/* <li className="nav-item">
              <NavLink className="nav-link" to="/Equipments-list">
                Liste des equipements
              </NavLink>
            </li> */}
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
