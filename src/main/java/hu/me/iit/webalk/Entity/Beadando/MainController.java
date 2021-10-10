package hu.me.iit.webalk.Entity.Beadando;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "comic")
public class MainController {
    private final ComicService comicService;

    public MainController(ComicService comicService) {
        this.comicService = comicService;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ComicDto> allComic() {
        return comicService.findAll();
    }

    @PostMapping(path = "")
    public void newComic(@RequestBody @Valid ComicDto comicDto) {
        comicService.save(comicDto);
    }

    @PutMapping(path = "/")
    public void replaceComic(@RequestBody @Valid ComicDto comicDto) {
        comicService.save(comicDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteComic(@PathVariable("id") Long id) {
        comicService.deleteById(id);
    }

}
