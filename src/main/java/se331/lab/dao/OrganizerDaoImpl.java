package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizersList;
    @PostConstruct
    public void init() {
        organizersList = new ArrayList<>();
        organizersList.add(Organizer.builder()
                .id(123L)
                .organizationName("asdjaojsd")
                .address("skdjaksdj")
                .build());
        organizersList.add(Organizer.builder()
                .id(456L)
                .organizationName("aksdjkasjd")
                .address("aksdjakd")
                .build());
        organizersList.add(Organizer.builder()
                .id(841L)
                .organizationName("asdaiojsdigh")
                .address("askdjajsdi")
                .build());
        organizersList.add(Organizer.builder()
                .id(843L)
                .organizationName("asodjiojioiosjdf")
                .address("asdjaijdsi")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizersList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizersList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return organizersList.subList(firstIndex, firstIndex + pageSize);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizersList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
