package com.springacademy.pointofsale.util.mappers;

import com.springacademy.pointofsale.dto.ItemDTO;
import com.springacademy.pointofsale.dto.request.ItemSaveRequestDTO;
import com.springacademy.pointofsale.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item requestDToToEntity(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemDTO> entityListToDtoList(List<Item> items);
}
