package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @GetMapping
    public ArrayList<CustomerDTO> getAll() {
        ArrayList<CustomerDTO> all = new ArrayList<CustomerDTO>();
        all.add(new CustomerDTO("C001", "Ashen", "Kandy", 1000));
        all.add(new CustomerDTO("C002", "Bawantha", "Homagama", 2000));
        all.add(new CustomerDTO("C003", "Chaluka", "Kurunegala", 1000));
        return all;
    }

    @GetMapping(path = "/{id}")
    public CustomerDTO searchCustomer(@PathVariable String id) {
        return new CustomerDTO(id, "Ashen", "Kandy", 1000);
    }

    @PostMapping(consumes = {"application/x-www-form-urlencoded"})
    public CustomerDTO save(CustomerDTO dto) {
        System.out.println(dto.toString());
        return dto;
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO dto) {
        System.out.println(dto.toString());
        return dto;
    }

    @DeleteMapping(params = {"id"})
    public CustomerDTO deleteCustomer(String id){
        return new CustomerDTO(id,"pakaya","paka",000);
    }
}
