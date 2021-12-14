
package uk.ac.solent.devops.impl.rest.party;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.ac.solent.devops.impl.dao.party.springdata.PartyRepository;
import uk.ac.solent.devops.impl.rest.base.ControllerBase;
import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.party.dto.PartyRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
public class PartyController implements ControllerBase<Party> {

    private final PartyRepository partyRepository;

    private static final List<Party> partyData = new ArrayList<>();

    public PartyController(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    static {
        partyData.add(Party.builder().uuid(UUID.randomUUID()).role(PartyRole.SELLER).active(true).name("Test").build());
    }

    @Override
    @PostMapping("/api/party")
    public void add(Party model) {
        partyData.add(model);
    }

    @Override
    @GetMapping(value = "/api/party", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public List<Party> get() {
        return partyData;
    }

    @Override
    @GetMapping(value = "/api/party/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public Party get(@PathVariable long id) {
        return partyData.stream().filter(party -> party.getId() == id).findFirst().orElse(null);
    }

    @Override
    @GetMapping(value = "/api/party/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public Party get(@PathVariable UUID uuid) {
        return partyData.stream().filter(party -> party.getUuid() == uuid).findFirst().orElse(null);
    }

    @Override
    @DeleteMapping(value = "/api/party/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable long id) {
        partyData.stream().filter(party -> party.getId() == id).findFirst().ifPresent(partyData::remove);
    }

    @Override
    @DeleteMapping(value = "/api/party/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable UUID uuid) {
        partyData.stream().filter(party -> party.getUuid() == uuid).findFirst().ifPresent(partyData::remove);
    }

    @Override
    @PutMapping(value = "/api/party", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Party update(Party updateModel) {
        Party party1 = partyData.stream().filter(party -> Objects.equals(party.getId(), updateModel.getId())).findFirst().orElse(null);
        partyData.set(partyData.indexOf(party1), updateModel);
        return updateModel;
    }
}