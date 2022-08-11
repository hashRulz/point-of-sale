package com.springacademy.pointofsale.service;

import com.springacademy.pointofsale.dto.ItemDTO;
import com.springacademy.pointofsale.dto.request.ItemSaveRequestDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemDTO> getAllItems();

    List<ItemDTO> getAllItemsByStateType(boolean status);
}
