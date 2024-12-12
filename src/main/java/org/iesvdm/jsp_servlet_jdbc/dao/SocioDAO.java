package org.iesvdm.jsp_servlet_jdbc.dao;

import org.iesvdm.jsp_servlet_jdbc.model.Socio;

import java.util.List;
import java.util.Optional;

public interface SocioDAO {

    public void create(Socio socio);

    public List<Socio> getAll();
    public Optional<Socio> find(int id);

    public void update(Socio socio);

    public void delete(int id);
}
