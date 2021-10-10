package hu.me.iit.webalk.Entity.Beadando;

import java.util.List;

public interface ComicService {
    List<ComicDto> findAll();

    ComicDto getById(Long id);

    Long save(ComicDto comicDto);

    void deleteById(Long id);
}
