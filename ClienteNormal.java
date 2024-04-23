class ClienteNormal extends Cliente {
    public ClienteNormal(String nombre, String direccion, String correoElectronico) throws ClienteInvalidoException {
        super(nombre, direccion, correoElectronico);
    }
}