package com.springacademy.pointofsale.service.impl;

import com.springacademy.pointofsale.dto.CustomerDTO;
import com.springacademy.pointofsale.dto.ItemDTO;
import com.springacademy.pointofsale.dto.request.ItemSaveRequestDTO;
import com.springacademy.pointofsale.entity.Customer;
import com.springacademy.pointofsale.entity.Item;
import com.springacademy.pointofsale.exception.EntryDuplicateException;
import com.springacademy.pointofsale.repo.ItemRepo;
import com.springacademy.pointofsale.service.ItemService;
import com.springacademy.pointofsale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = itemMapper.requestDToToEntity(itemSaveRequestDTO);
//        Item item = modelMapper.map(itemSaveRequestDTO,Item.class);
        item.setActiveState(true);
        if (!itemRepo.existsById(item.getItemId())){
            return itemRepo.save(item).getItemName();
        }else {
            throw new EntryDuplicateException("alredy in database");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepo.findAll();
        List<ItemDTO> itemDTOS = itemMapper.entityListToDtoList(items);
        return itemDTOS;
    }

    @Override
    public List<ItemDTO> getAllItemsByStateType(boolean status) {
        List<Item> items = itemRepo.findAllByActiveStateEquals(status);
        List<ItemDTO> itemDTOS = itemMapper.entityListToDtoList(items);
        return itemDTOS;
    }
}
