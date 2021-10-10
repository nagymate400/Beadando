package hu.me.iit.webalk.Entity.Beadando;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ComicServiceImpl implements ComicService {
    private final int MAXIMUM_COMIC_COUNT = 10;
    private final ComicRepository comicRepository;

    public ComicServiceImpl(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    @Override
    public List<ComicDto> findAll() {
        return comicRepository.findAll();
    }

    @Override
    public ComicDto getById(Long id) {
        return comicRepository.getById(id);
    }

    @Override
    public Long save(ComicDto comicDto) {
        if (comicRepository.findAll().size() >= MAXIMUM_COMIC_COUNT) {
            throw new TooMuchComicException();
        }
        return comicRepository.save(comicDto);
    }

    @Override
    public void deleteById(Long id) {
        comicRepository.deleteById(id);
    }
}
