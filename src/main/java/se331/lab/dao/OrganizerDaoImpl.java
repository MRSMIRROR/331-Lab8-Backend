package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
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
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizersList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Organizer>(organizersList.subList(firstIndex, firstIndex + pageSize), PageRequest.of(page, pageSize), organizersList.size());
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizersList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizersList.get(organizersList.size() - 1).getId() + 1);
        organizersList.add(organizer);
        return organizer;
    }
}
