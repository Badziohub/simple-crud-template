package badziohub.simplecrudtemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/counter")
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
