package co.edu.udea.logica.Model;

/**
 * @implNote Código reciclado de una práctica del semestre anterior para lógica II
 */
public class NodoDoble {
    private Integer dato;
    private  NodoDoble li;
    private  NodoDoble ld;

    public NodoDoble(Integer dato) {
        this.setDato(dato);
        this.setLi(null);
        this.setLd(null);
    }


    public int getDato() {
        return dato;
    }

    public void setDato(Integer dato) {
        this.dato = dato;
    }

    public NodoDoble getLi() {
        return li;
    }

    public void setLi(NodoDoble li) {
        this.li = li;
    }

    public NodoDoble getLd() {
        return ld;
    }

    public void setLd(NodoDoble ld) {
        this.ld = ld;
    }
}