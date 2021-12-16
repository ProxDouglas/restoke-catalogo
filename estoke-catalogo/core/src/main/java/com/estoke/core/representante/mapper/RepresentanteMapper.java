package com.estoke.core.representante.mapper;

import com.estoke.api.representante.model.RepresentanteStub;
import com.estoke.core.representante.domain.Representante;
import com.estoke.core.representante.model.RepresentanteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author vitor.alves
 */
@Mapper(componentModel = "spring")
public interface RepresentanteMapper {

    @Mapping(target = "identificador", source = "id")
    @Mapping(target = "id", ignore = true)
    Representante toEntity(RepresentanteStub stub);

    Representante toEntity(RepresentanteDTO model);

    RepresentanteDTO toModel(Representante entity);
}
