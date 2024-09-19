package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Event;

import java.util.ArrayList;
import java.util.List;


@Repository
public class EventDaoImpl implements EventDao {
    List<Event> eventList;

    @PostConstruct
    public void init() {
        eventList = new ArrayList<>();
        eventList.add(Event.builder()
                .id(123L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("kat Laydee")
                .build());
        eventList.add(Event.builder()
                .id(456L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petAllowed(true)
                .organizer("Fern Pollin")
                .build());
        eventList.add(Event.builder()
                .id(841L)
                .category("sustainability")
                .title("Beach Cleanup")
                .description("Help pick up trash along the shore.")
                .location("Playa Del Carmen")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .organizer("Carey Wales")
                .build());
        eventList.add(Event.builder()
                .id(843L)
                .category("sustainability")
                .title("Park Reforestation")
                .description("Join us in planting trees in the local park.")
                .location("Central Park")
                .date("August 15, 2022")
                .time("09:00")
                .petAllowed(true)
                .organizer("Jordan Smith")
                .build());
    }

    @Override
    public Integer getEventSize() {
        return eventList.size();
    }

    @Override
    public List<Event> getEvents(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? eventList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return eventList.subList(firstIndex, firstIndex + pageSize);
    }

    @Override
    public Event getEvent(Long id) {
        return eventList.stream().filter(event -> event.getId().equals(id)).findFirst().orElse(null);
    }
}
