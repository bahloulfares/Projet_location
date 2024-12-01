import React, { forwardRef } from 'react';

const InputComponent = forwardRef(({ label }, ref) => {
  return (
    <div style={{ width: '100%' }}>
      <label style={{ display: 'block', marginBottom: '5px' }}>{label}</label>
      <input
        ref={ref}
        type="text"
        style={{
          width: '100%',
          padding: '8px',
          borderRadius: '4px',
          border: '1px solid #ccc',
        }}
      />
    </div>
  );
});

export default InputComponent;
