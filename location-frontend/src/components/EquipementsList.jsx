import React, { useEffect, useState } from "react";
import { getEquipments, updateEquipmentState } from "../services/EquipementService";

const EquipmentsList = () => {
    const [equipments, setEquipments] = useState([]);
    const [loading, setLoading] = useState(true);
    const [selectedEquipment, setSelectedEquipment] = useState(null); // Pour le modal
    const [newState, setNewState] = useState("");

    useEffect(() => {
        fetchEquipments();
    }, []);

    const fetchEquipments = async () => {
        try {
            const data = await getEquipments();
            setEquipments(data);
        } catch (error) {
            console.error("Erreur lors de la récupération des équipements", error);
        } finally {
            setLoading(false);
        }
    };

    const handleOpenModal = (equipment) => {
        setSelectedEquipment(equipment);
        setNewState(equipment.state); // Préremplir avec l'état actuel
    };

    const handleUpdateState = async () => {
        if (newState && selectedEquipment) {
            try {
                const updatedEquipment = await updateEquipmentState(
                    selectedEquipment.id,
                    newState
                );
                setEquipments((prevEquipments) =>
                    prevEquipments.map((equip) =>
                        equip.id === updatedEquipment.id ? updatedEquipment : equip
                    )
                );
                alert("État mis à jour avec succès !");
            } catch (error) {
                console.error("Erreur lors de la mise à jour de l'état", error);
            } finally {
                setSelectedEquipment(null); // Fermer le modal
            }
        }
    };

    if (loading) {
        return <div className="text-center mt-5">Chargement des équipements...</div>;
    }

    return (
        <div className="container mt-5">
            <h1 className="text-center mb-4">Liste des Équipements</h1>
            <table className="table table-striped table-bordered">
                <thead className="thead-dark">
                    <tr>
                        <th>Nom</th>
                        <th>État</th>
                        <th>Catégorie</th>
                        <th>Prix par jour</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {equipments.map((equip) => (
                        <tr key={equip.id}>
                            <td>{equip.name}</td>
                            <td>{equip.state}</td>
                            <td>{equip.category}</td>
                            <td>{equip.rentalPricePerDay} €</td>
                            <td>
                                <button
                                    onClick={() => handleOpenModal(equip)}
                                    className="btn btn-primary btn-sm"
                                >
                                    Changer l'état
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>

            {selectedEquipment && (
                <div className="modal show d-block" tabIndex="-1" style={{
                    // width: "300px",
                    // height: "300px",
                    // position: "absolute",
                    // left: "50%",
                    top: "5%",
                    // marginLeft: "-150px",  // Remplacer "margin-left" par "marginLeft"
                    // marginTop: "-150px",   // Remplacer "margin-top" par "marginTop"
                }}
                >
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title">Changer l'état</h5>
                                <button
                                    type="button"
                                    className="btn-close"
                                    onClick={() => setSelectedEquipment(null)}
                                ></button>
                            </div>
                            <div className="modal-body">
                                <p>
                                    <strong>Équipement :</strong> {selectedEquipment.name}
                                </p>
                                <label htmlFor="state-select">Nouvel état :</label>
                                <select
                                    id="state-select"
                                    className="form-select"
                                    value={newState}
                                    onChange={(e) => setNewState(e.target.value)}
                                >
                                    <option value="Neuf">Neuf</option>
                                    <option value="Occasion">Occasion</option>
                                    <option value="Usé">Usé</option>
                                </select>
                            </div>
                            <div className="modal-footer">
                                <button
                                    type="button"
                                    className="btn btn-secondary"
                                    onClick={() => setSelectedEquipment(null)}
                                >
                                    Annuler
                                </button>
                                <button
                                    type="button"
                                    className="btn btn-primary"
                                    onClick={handleUpdateState}
                                >
                                    Enregistrer
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
};

export default EquipmentsList;
