package menu1.xsj.com.agenda2;

/**
 * Created by final on 28/03/2015.
 */
public class Contacto {
}

DatabaseTable
public class Contacto {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String nombre;

    @DatabaseField
    private String email;

    @DatabaseField
    private String telefono;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nome) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + "[ " + telefono + " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacto contacto = (Contacto) o;

        if (!id.equals(contacto.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

