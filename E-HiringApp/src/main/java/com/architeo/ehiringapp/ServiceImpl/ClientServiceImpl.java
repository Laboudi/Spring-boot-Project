package com.architeo.ehiringapp.ServiceImpl;

import com.architeo.ehiringapp.Model.Client;
import com.architeo.ehiringapp.Repository.ClientRepository;
import com.architeo.ehiringapp.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
}
