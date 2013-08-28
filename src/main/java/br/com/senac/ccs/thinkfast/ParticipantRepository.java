package br.com.senac.ccs.thinkfast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class ParticipantRepository {

    private final ConcurrentHashMap<String, Participant> participants;
    
    public ParticipantRepository() {
        this.participants = new ConcurrentHashMap<String, Participant>();
    }
    
    public void save(Participant participant) {
        this.participants.put( participant.getId(), participant );
    }
    
    public Participant find(String id) {
        return this.participants.get( id );
    }

    public Collection<Participant> findAll() {
        return new ArrayList<Participant>(participants.values());
    }
}
