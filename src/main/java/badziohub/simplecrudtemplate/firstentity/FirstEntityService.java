package badziohub.simplecrudtemplate.firstentity;

import badziohub.simplecrudtemplate.firstentity.dto.FirstEntityRequestDto;
import badziohub.simplecrudtemplate.firstentity.dto.FirstEntityResponseDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FirstEntityService {

    private final FirstEntityRepository firstEntityRepository;
    private final FirstEntityMapper firstEntityMapper;

    public List<FirstEntityResponseDto> getAll(){
        return firstEntityRepository.findAll().stream().map(firstEntityMapper::entityToResponse).toList();
    }

    @Transactional
    public FirstEntityResponseDto update(Long id, FirstEntityRequestDto requestDto){
        final var foundEntity = firstEntityRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity with id %s was not found".formatted(id)));
        if(requestDto.content() != null )foundEntity.setContent(requestDto.content());
        if(requestDto.status() != null ) foundEntity.setStatus(requestDto.status());
        return firstEntityMapper.entityToResponse(foundEntity);
    }

    public FirstEntityResponseDto add(FirstEntityRequestDto requestDto){
        final var savedEntity = firstEntityRepository.save(firstEntityMapper.requestToEntity(requestDto));
        return firstEntityMapper.entityToResponse(savedEntity);
    }

    public void delete(Long id){
        firstEntityRepository.deleteById(id);
    }

}
