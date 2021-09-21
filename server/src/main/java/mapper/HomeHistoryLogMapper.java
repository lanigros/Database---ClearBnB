package mapper;

import datatransforobject.HomeHistoryDTO;
import model.HomeHistoryLog;

public class HomeHistoryLogMapper {
        public static HomeHistoryDTO convertToCore(HomeHistoryLog historyLog) {

            HomeHistoryDTO dto = new HomeHistoryDTO();
            dto.setId(historyLog.getId());
            dto.setPricePerNight(historyLog.getPricePerNight());
            dto.setImages(historyLog.getImages());
            dto.setStartDate(historyLog.getStartDate());
            dto.setEndDate(historyLog.getEndDate());
            dto.setCreatedDate(historyLog.getCreatedDate());

            return dto;

        }

    }



