package com.architeo.ehiringapp.api;

import com.architeo.ehiringapp.Model.Client;
import com.architeo.ehiringapp.ServiceImpl.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api")
public class ClientController {
    private final ClientServiceImpl clientService;

    @PostMapping("/api/saveClient")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        return ResponseEntity.ok().body(clientService.saveClient(client));
    }
    @GetMapping("/api/clients")
    public ResponseEntity<List<Client>> getAllClient(){
        return ResponseEntity.ok().body(clientService.getAllClient());
    }
}
