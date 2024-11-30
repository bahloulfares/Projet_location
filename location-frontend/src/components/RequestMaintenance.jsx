import React, { useEffect, useState } from 'react';
import axios from 'axios';

const RequestMaintenance = () => {
    const [description, setDescription] = useState('');
    const [equipmentId, setEquipmentId] = useState('');
    const [equipments, setEquipments] = useState([]);
    const [message, setMessage] = useState('');

    useEffect(() => {
        // Fetch list of equipments from the API
        const fetchEquipments = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/equipements');
                setEquipments(response.data); // Update state with equipments list
            } catch (error) {
                console.error('Error fetching equipments:', error);
            }
        };

        fetchEquipments();
    }, []);  // Run only once when the component mounts

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        // Ensure that the equipmentId and description are not empty
        if (!equipmentId || !description.trim()) {
            setMessage('Please select an equipment and provide a description.');
            return;
        }

        try {
            const response = await axios.post('http://localhost:8080/api/maintenances', {
                description,
                equipment: { id: parseInt(equipmentId) },  // Send the selected equipment's ID
            });

            setMessage(`Maintenance request submitted successfully! ID: ${response.data.id}`);
            setDescription('');  // Clear description
            setEquipmentId('');  // Clear selected equipment ID
        } catch (error) {
            console.error('Error submitting maintenance request:', error);
            setMessage('Error submitting the request. Please try again.');
        }
    };

    return (
        <div className="container my-4">
            <h2 className="text-center">Request Maintenance</h2>
            <div className="form-group" style={{width:"300px"}}>
                    <label htmlFor="equipmentId">Select Equipment:</label>
                    <select
                        id="equipmentId"
                        className="form-control"
                        value={equipmentId}
                        onChange={(e) => setEquipmentId(e.target.value)}
                        required
                    >
                        <option value="">Choose Equipment</option>
                       
                        {equipments.map((equipment) => (
                            <option key={equipment.id} value={equipment.id}>
                                {equipment.id} - {equipment.name}
                            </option>
                        ))}
                    </select>
                </div> <br/>

            <form onSubmit={handleSubmit} className="mt-4">
                <div className="form-group" style={{width:"800px"}}>
                    <label htmlFor="description">Maintenance Description:</label>
                    <textarea
                        id="description"
                        className="form-control"
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                        rows="4"
                        required
                        style={{height:"250px"}}
                    />
                </div>

                {/* Dropdown to select equipment */}
                

                <button type="submit" className="btn btn-primary btn-block mt-3">
                    Submit Request
                </button>
            </form>

            {message && <div className="alert mt-3">{message}</div>}
        </div>
    );
};

export default RequestMaintenance;
