package com.mihneacristian.project_tracker.EntityConverter;

import com.mihneacristian.project_tracker.DTO.StatusDTO;
import com.mihneacristian.project_tracker.Entities.Status;
import org.springframework.stereotype.Service;

@Service
public class StatusEntityConverter implements EntityConverter<Status, StatusDTO> {

    @Override
    public StatusDTO convertToDTO(Status statusEntity) {
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.statusName = statusEntity.getStatusName();
        statusDTO.statusId = statusEntity.getStatusId();
        return statusDTO;
    }

    @Override
    public Status convertToEntity(StatusDTO statusDTO) {

        Status statusEntity = new Status();
        statusEntity.setStatusName(statusDTO.statusName);
        return statusEntity;
    }
}
