import React, { useEffect, useState } from "react";
import axios from "axios";

const ViewRequests = () => {
  const [requests, setRequests] = useState([]);

  useEffect(() => {
    const fetchRequests = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/api/maintenances"
        );
        setRequests(response.data);
      } catch (error) {
        console.error("Erreur lors de la récupération des données");
      }
    };

    fetchRequests();
  }, []);


  return (
    <div className="container my-4">
      <h2 className="text-center">Liste des demandes de maintenance</h2>
      <table className="table table-striped mt-4">
        <thead>
          <tr>
          <th scope="col">ID</th>
            <th scope="col">Description</th>
            <th scope="col">Matériel</th>
            <th scope="col">Catégorie</th>
            <th scope="col">Statut</th>
            <th scope="col">Date</th>
          </tr>
        </thead>
        <tbody>
          {requests.map((request) => (
            <tr key={request.id}>
             <td>{request.id}</td>
              <td>{request.description}</td>
              <td>{request.equipment?.name || "Non défini"}</td>
              <td>{request.equipment?.category || "Non défini"}</td>
              <td>{request.status}</td>
              <td>{new Date(request.dateDemande).toLocaleDateString()}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ViewRequests;
