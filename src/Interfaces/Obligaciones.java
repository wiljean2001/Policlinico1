package Interfaces;
import java.util.List;

public interface Obligaciones <CualquierDato> {
    public boolean create(CualquierDato x);
    public boolean delete(Object key);
    public boolean update(CualquierDato x);
    public CualquierDato read(Object key);
    public List<CualquierDato> readAll();
}
