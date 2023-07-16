package badziohub.simplecrudtemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/counter")
@CrossOrigin(origins = "http://localhost:4200")
public class Counter {

    private final JdbcTemplate jdbcTemplate;

    @PutMapping("")
    public void updateCounter(){
        jdbcTemplate.execute("update counter set counter=(select counter from counter order by counter desc fetch first row only) + 1;");
    }

    @GetMapping("")
    public Long getCounter(){
        return jdbcTemplate.queryForObject("select counter from counter order by counter desc fetch first row only;", Long.class);
    }

}
