package com.springacademy.pointofsale.controller;

import com.springacademy.pointofsale.dto.CustomerDTO;
import com.springacademy.pointofsale.dto.ItemDTO;
import com.springacademy.pointofsale.dto.request.CustomerSaveRequest;
import com.springacademy.pointofsale.dto.request.ItemSaveRequestDTO;
import com.springacademy.pointofsale.entity.Item;
import com.springacademy.pointofsale.service.ItemService;
import com.springacademy.pointofsale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String id =itemService.saveItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"item succesddfully saved",id),HttpStatus.CREATED);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<StandardResponse> getAllItems() {
        List<ItemDTO> allItems = itemService.getAllItems();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",allItems),HttpStatus.OK);
    }

    @GetMapping(path = "/getAll-ny-state",params ="state" )
    public ResponseEntity<StandardResponse> getAllItemsByState(@RequestParam(value = "state") String state) {

        if(state.equalsIgnoreCase("active") || state.equalsIgnoreCase("inactive")){
            boolean status = state.equalsIgnoreCase("active") ? true : false;
            List<ItemDTO> allItems = itemService.getAllItemsByStateType(status);
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200,"success",allItems),HttpStatus.OK);
        }else {
            List<ItemDTO> allItems = itemService.getAllItems();
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200,"success",allItems),HttpStatus.OK);
        }
    }

}
