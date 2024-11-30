import axios from 'axios';

const API_URL = "http://localhost:8080/api/equipements";

export const getEquipments = async () => {
    const response = await axios.get(API_URL);
    return response.data;
};

export const updateEquipmentState = async (id, newState) => {
    const response = await axios.put(`${API_URL}/${id}/state`, null, {
        params: { newState },
    });
    return response.data;
};
