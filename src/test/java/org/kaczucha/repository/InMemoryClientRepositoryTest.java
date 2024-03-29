package org.kaczucha.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.kaczucha.Client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


public class InMemoryClientRepositoryTest {
    private InMemoryClientRepository repository;
    private List<Client> clients;


    @BeforeEach
    public void setup() {
        clients = new ArrayList<>();
        repository = new InMemoryClientRepository(clients);

    }

    @Test
    public void verifyIfUserIsAddingCorrectlyToTheRepository() {
        //given
        final Client client = new Client("Alek", "a@a.pl", 100);
        final Client expectedClient = new Client("Alek", "a@a.pl", 100);
        //when
        repository.save(client);
        //then
        final Client actualClient = clients.stream().findFirst().get();
        assertEquals(expectedClient, actualClient);
    }

}
