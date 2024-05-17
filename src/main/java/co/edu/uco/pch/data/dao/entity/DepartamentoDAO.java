package co.edu.uco.pch.data.dao.entity;

import co.edu.uco.pch.entity.DepartamentoEntity;
import java.util.UUID;

public interface DepartamentoDAO extends RetriveDAO<DepartamentoEntity> {
    DepartamentoEntity obtenerPorId(UUID id);
}