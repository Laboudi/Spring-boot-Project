package com.architeo.ehiringapp.Service;

import com.architeo.ehiringapp.Model.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAllClient();
    public Client saveClient(Client client);
}
