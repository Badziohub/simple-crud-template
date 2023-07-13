package badziohub.simplecrudtemplate.firstentity;

import badziohub.simplecrudtemplate.firstentity.dto.FirstEntityRequestDto;
import badziohub.simplecrudtemplate.firstentity.dto.FirstEntityResponseDto;
import org.springframework.stereotype.Component;

@Component
public class FirstEntityMapper {

    public FirstEntityResponseDto entityToResponse(FirstEntity entity){
        return new FirstEntityResponseDto(entity.getId(), entity.getContent(), entity.getStatus());
    }

    public FirstEntity requestToEntity(FirstEntityRequestDto requestDto){
        return new FirstEntity(requestDto.content(),requestDto.status());
    }

}
