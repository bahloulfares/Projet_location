import React from 'react';
import ClientForm from './ClientForm';
import useClients from '../hooks/useClients'


function ClientList() {
    

    const { data: clients, error, isLoading } = useClients();

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error.message}</div>;
    }

    return (
        <div>
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nom et Prénom</th>
                        <th scope="col">Adresse</th>
                        <th scope="col">Matricule Fiscale</th>
                        <th scope="col">Téléphone</th>
                        <th scope="col">Fax</th>
                        <th scope="col">Email</th>
                    </tr>
                </thead>
                <tbody>
                    {clients?.map(client => (
                        <tr key={client.id}>
                            <th scope="row">{client.id}</th>
                            <td>{client.nom} {client.prenom}</td>
                            <td>{client.adresse}</td>
                            <td>{client.matriculeFiscale}</td>
                            <td>{client.telephone}</td>
                            <td>{client.fax}</td>
                            <td>{client.email}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <ClientForm />
        </div>
    );
}

export default ClientList;
