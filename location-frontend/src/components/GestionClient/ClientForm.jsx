import React, { useRef } from 'react';
import InputComponent from '../InputComponent';
import useAddClient from '../hooks/useAddClient';

function ClientForm() {

  const nom = useRef();
  const prenom = useRef();
  const adresse = useRef();
  const email = useRef();
  const fax = useRef();
  const telephone = useRef();
  const matriculeFiscale = useRef();

  const addClient = useAddClient();

  return (
    <div style={{ display: 'flex', justifyContent: 'center', marginTop: '20px' }}>
      {addClient.error && <h5>{addClient.error.message}</h5>}
      <form
        style={{ width: '600px' }}
        onSubmit={(event) => {
          event.preventDefault();
          addClient.mutate({
            nom: nom.current.value,
            prenom: prenom.current.value,
            telephone: telephone.current.value,
            email: email.current.value,
            matriculeFiscale: matriculeFiscale.current.value,
            adresse: adresse.current.value,
            fax: fax.current.value,
          });
        }}
      >
        <div style={{ display: 'flex', gap: '10px', marginBottom: '10px' }}>
          <InputComponent ref={nom} label="Nom" />
          <InputComponent ref={prenom} label="Prénom" />
        </div>
        <div style={{ display: 'flex', gap: '10px', marginBottom: '10px' }}>
          <InputComponent ref={telephone} label="Téléphone" />
          <InputComponent ref={email} label="Email" />
        </div>
        <div style={{ display: 'flex', gap: '10px', marginBottom: '10px' }}>
          <InputComponent ref={adresse} label="Adresse" />
          <InputComponent ref={fax} label="Fax" />
        </div>
        <div style={{ display: 'flex', gap: '10px', marginBottom: '10px' }}>
          <InputComponent ref={matriculeFiscale} label="Matricule Fiscale" />
        </div>
        <button type="submit" className="btn btn-primary" style={{ width: '25%' }}>
          Valider
        </button>
      </form>
    </div>
  );
}

export default ClientForm;
