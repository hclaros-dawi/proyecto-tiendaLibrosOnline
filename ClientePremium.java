class ClientePremium extends Cliente {
    public ClientePremium(String nombre, String direccion, String correoElectronico) throws ClienteInvalidoException {
        super(nombre, direccion, correoElectronico);
    }
}