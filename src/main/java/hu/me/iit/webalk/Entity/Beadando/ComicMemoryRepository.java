package hu.me.iit.webalk.Entity.Beadando;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class ComicMemoryRepository implements ComicRepository {
    private final List<ComicDto> comics = new ArrayList<>();

    private int findComicById(Long id) {
        int found = -1;
        for (int i = 0; i < comics.size(); i++) {
            if (comics.get(i).getTitle().equals(id)) {
                found = i;
                break;
            }
        }
        return found;
    }

    @Override
    public List<ComicDto> findAll() {
        return comics;
    }

    @Override
    public ComicDto getById(Long id) {
        return null;
    }

    @Override
    public Long save(ComicDto comicDto) {
        int found = findComicById(comicDto.getId());

        if (found != -1) {
            ComicDto foundComic = comics.get(found);
            foundComic.setAuthor(comicDto.getAuthor());
            foundComic.setPages(comicDto.getPages());
        } else {
            comics.add(comicDto);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        int found = findComicById(id);

        if (found != -1) {
            comics.remove(found);
        }
    }
}

