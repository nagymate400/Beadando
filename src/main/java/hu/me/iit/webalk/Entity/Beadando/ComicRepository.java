package hu.me.iit.webalk.Entity.Beadando;

import java.util.List;

public interface ComicRepository {
    List<ComicDto> findAll();

    ComicDto getById(Long id);

    Long save(ComicDto articleDto);

    void deleteById(Long id);
}
