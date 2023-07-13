package badziohub.simplecrudtemplate.firstentity;

import badziohub.simplecrudtemplate.Counter;
import badziohub.simplecrudtemplate.firstentity.dto.FirstEntityRequestDto;
import badziohub.simplecrudtemplate.firstentity.dto.FirstEntityResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class FirstEntityController {

    private final FirstEntityService firstEntityService;
    private final Counter counter;
    // mogłem RestTemplate wstrzyknąć i strzelać na /counter, ale jakieś to brzydkie

    @GetMapping("")
    public List<FirstEntityResponseDto> getAll(){
        counter.updateCounter();
        return firstEntityService.getAll();
    }

    @PutMapping("{id}")
    public FirstEntityResponseDto update(@PathVariable Long id,@RequestBody FirstEntityRequestDto requestDto){
        counter.updateCounter();
        return firstEntityService.update(id,requestDto);
    }

    @PostMapping("")
    public FirstEntityResponseDto add(FirstEntityRequestDto requestDto){
        counter.updateCounter();
        return firstEntityService.add(requestDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        counter.updateCounter();
        firstEntityService.delete(id);
    }

}
