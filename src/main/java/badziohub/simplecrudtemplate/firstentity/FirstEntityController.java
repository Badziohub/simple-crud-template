package badziohub.simplecrudtemplate.firstentity;

import badziohub.simplecrudtemplate.firstentity.dto.FirstEntityRequestDto;
import badziohub.simplecrudtemplate.firstentity.dto.FirstEntityResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class FirstEntityController {

    private final FirstEntityService firstEntityService;


    @GetMapping("")
    public List<FirstEntityResponseDto> getAll(){
        return firstEntityService.getAll();
    }

    @PutMapping("{id}")
    public FirstEntityResponseDto update(@PathVariable Long id,@RequestBody @Valid FirstEntityRequestDto requestDto){
        return firstEntityService.update(id,requestDto);
    }

    @PostMapping("")
    public FirstEntityResponseDto add( @RequestBody @Valid FirstEntityRequestDto requestDto){
        return firstEntityService.add(requestDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        firstEntityService.delete(id);
    }

}
