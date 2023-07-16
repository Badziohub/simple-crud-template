package badziohub.simplecrudtemplate.firstentity;

import badziohub.simplecrudtemplate.firstentity.dto.FirstEntityRequestDto;
import badziohub.simplecrudtemplate.firstentity.dto.FirstEntityResponseDto;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

class FirstEntityServiceUnitTest {

    private final FirstEntityRepository firstEntityRepository = Mockito.mock(FirstEntityRepository.class);
    private final FirstEntityMapper firstEntityMapper = Mockito.mock(FirstEntityMapper.class);
    private final FirstEntityService firstEntityService = new FirstEntityService(firstEntityRepository,firstEntityMapper);

    //statyczna fabryka jest opcją do dodania, ale dla małej ilości zmiennych nie jest potrzebna

    public static final String TASK = "Do dishes";
    public static final String UPDATED_TASK = "Do dishes twice";
    public static final Long ID = 1L;
    public static final Long NON_EXISTENT_ID = 2L;

    @Test
    void shouldReturnResponseDtoWhenValidRequestDtoGiven() {
        //given
        final var dto = new FirstEntityRequestDto(TASK,Status.TO_DO);
        final var entity = new FirstEntity(TASK,Status.TO_DO);
        final var expected = new FirstEntityResponseDto(1L,TASK,Status.TO_DO);
        when(firstEntityMapper.requestToEntity(dto)).thenReturn(entity);
        when(firstEntityRepository.save(entity)).thenReturn(entity);
        when(firstEntityMapper.entityToResponse(entity)).thenReturn(expected);
        //when
        final var actual = firstEntityService.add(dto);
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturnUpdatedResponseWhenValidRequestDtoAndExistingEntitiesIdGiven() {
        //given
        final var updateDto = new FirstEntityRequestDto(UPDATED_TASK,Status.DONE);
        final var entityWithId = new FirstEntity(ID,TASK,Status.TO_DO);
        final var expected = new FirstEntityResponseDto(ID,UPDATED_TASK,Status.DONE);
        when(firstEntityRepository.findById(ID)).thenReturn(Optional.of(entityWithId));
        when(firstEntityMapper.entityToResponse(entityWithId)).thenReturn(expected);
        //when
        final var actual = firstEntityService.update(ID, updateDto);
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldThrowExceptionWhenNonExistingEntitiesIdGiven() {
        //given
        final var updateDto = new FirstEntityRequestDto(UPDATED_TASK,Status.DONE);
        when(firstEntityRepository.findById(NON_EXISTENT_ID)).thenReturn(Optional.empty());
        //when //then
        assertThatThrownBy(()-> firstEntityService.update(NON_EXISTENT_ID,updateDto)).isInstanceOf(EntityNotFoundException.class);
    }

}