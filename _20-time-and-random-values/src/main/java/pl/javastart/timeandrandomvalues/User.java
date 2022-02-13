package pl.javastart.timeandrandomvalues;

import java.time.Period;
import java.time.ZonedDateTime;

public class User {

    private String name;
    private ZonedDateTime creationDate;

    public User(String name, ZonedDateTime creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public boolean isOlderThanAYear(DateTimeProvider dateTimeProvider) {
        return Period.between(creationDate.toLocalDate(), dateTimeProvider.nowAsZoneDateTime().toLocalDate()).getYears() >= 1;
    }

}
