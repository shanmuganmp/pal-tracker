package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private HashMap<Long, TimeEntry> hashMaptimeEntries = new HashMap<>();
    long id=0L;

    private long createId(){

        return ++id;

    }

    public TimeEntry create(TimeEntry timeEntry) {

        long createdId=createId();

        hashMaptimeEntries.put(createdId,new TimeEntry(createdId,timeEntry.getProjectId(),timeEntry.getUserId(), timeEntry.getDate(),timeEntry.getHours()));

        return hashMaptimeEntries.get(createdId);

    }

    /*
    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId((long) (hashMaptimeEntries.size() + 1));
        hashMaptimeEntries.put(timeEntry.getId(), timeEntry);
        for (Long i : hashMaptimeEntries.keySet()) {
            System.out.println("key: " + i + " value: " + hashMaptimeEntries.get(i));
        }
        return timeEntry;
    }
*/
    @Override
    public TimeEntry find(long id) {
        return hashMaptimeEntries.get(id);
    }


    @Override
    public List<TimeEntry> list() {

        return new ArrayList<>(hashMaptimeEntries.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {

        hashMaptimeEntries.replace(id,new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours()));

        return hashMaptimeEntries.get(id);



    }

    @Override
    public void delete(long timeEntryId) {
        hashMaptimeEntries.remove(timeEntryId);

    }



}
