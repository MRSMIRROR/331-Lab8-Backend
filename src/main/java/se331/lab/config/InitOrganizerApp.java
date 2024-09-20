package se331.lab.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.repository.OrganizerRepository;
import se331.lab.entity.Organizer;

@Component
@RequiredArgsConstructor
public class InitOrganizerApp implements ApplicationListener<ApplicationReadyEvent> {
    final OrganizerRepository organizerRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        organizerRepository.save(Organizer.builder()
                .id(834L)
                .organizationName("askdjakldj")
                .address("al;sdkjkas")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(574L)
                .organizationName("askdjakkjgkfjgj")
                .address("algtiktktk")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(354L)
                .organizationName("askrkljrogjeoig")
                .address("amsdfnklsnf")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(957L)
                .organizationName("aksdjfkjsfoijfsf")
                .address("sldfkoskfsof")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(567L)
                .organizationName("skldfjkojsdof")
                .address("siodfjopfjsfjps")
                .build());
    }
}
