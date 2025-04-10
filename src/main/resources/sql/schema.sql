CREATE TABLE IF NOT EXISTS solicitud (
    id SERIAL PRIMARY KEY,
    codigo_generado VARCHAR(20),
    marca VARCHAR(100),
    tipo_solicitud VARCHAR(100),
    fecha_envio DATE,
    numero_contacto VARCHAR(15),
    nombre_contacto VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS contacto (
    id SERIAL PRIMARY KEY,
    solicitud_id INTEGER REFERENCES solicitud(id),
    nombre VARCHAR(100),
    numero VARCHAR(15)
);