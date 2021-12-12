
package uk.ac.solent.devops.impl.rest.party;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.ac.solent.devops.impl.dao.party.springdata.PartyRepository;
import uk.ac.solent.devops.impl.rest.base.ControllerBase;
import uk.ac.solent.devops.model.party.dto.Party;

import java.util.List;
import java.util.UUID;

@RestController
public class PartyController implements ControllerBase<Party> {

    private final PartyRepository partyRepository;

    public PartyController(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    @Override
    @PostMapping("/api/party")
    public void add(Party model) {

    }

    @Override
    @GetMapping(value = "/api/party", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public List<Party> get() {
        return null;
    }

    @Override
    @GetMapping(value = "/api/party/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public Party get(@PathVariable long id) {
        return null;
    }

    @Override
    @GetMapping(value = "/api/party/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public Party get(@PathVariable UUID uuid) {
        return null;
    }

    @Override
    @DeleteMapping(value = "/api/party/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable long id) {

    }

    @Override
    @DeleteMapping(value = "/api/party/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable UUID id) {

    }

    @Override
    @PutMapping(value = "/api/party", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Party update(Party updateModel) {
        return null;
    }
}