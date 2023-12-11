package items.services;

import items.Handlers.ObjectToStringConvertor;
import items.Handlers.StringToObjectConvertor;
import items.entities.Item;
import items.entitiesDto.ItemDto;
import items.repositories.ItemsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemsService {

    @Autowired
    ItemsRepository repository;

    private ModelMapper modelMapper = new ModelMapper();

    public ItemsService(){
        modelMapper.addConverter(new StringToObjectConvertor());
        modelMapper.addConverter(new ObjectToStringConvertor());
    }


    public List<ItemDto> getList(String list) throws Exception {
        return repository.findItemsByList(list).stream()
                .map(item -> modelMapper.map(item, ItemDto.class))
                .collect(Collectors.toList());
    }

    public ItemDto saveItem(ItemDto item) throws Exception {
        return modelMapper.map(repository.save(modelMapper.map(item, Item.class)), ItemDto.class);
    }

    public ItemDto updateOrCreateItem(ItemDto newItemDto, UUID id) throws Exception {
        Item newItem = modelMapper.map(newItemDto, Item.class);
        return modelMapper.map(repository.findById(id)
                .map(item -> {
                    item.setList(newItem.getList());
                    item.setItem(newItem.getItem());
                    return repository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return repository.save(newItem);
                }), ItemDto.class);
    }

    @Transactional
    public void deleteItem(UUID id){
        repository.deleteById(id);
    }
}
