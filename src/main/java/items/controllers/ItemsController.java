package items.controllers;

import items.entitiesDto.ItemDto;
import items.services.ItemsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/items")
@RestController
public class ItemsController {
    @Autowired
    ItemsService service;

    @ResponseBody
    @GetMapping("getList/{list}")
    public List<ItemDto> getList(@PathVariable String list) throws Exception {
         return service.getList(list);
    }

    @ResponseBody
    @PostMapping("/")
    public ItemDto addNewItem(@RequestBody ItemDto item) throws Exception {
        return service.saveItem(item);
    }

    @ResponseBody
    @PutMapping("/{id}")
    public ItemDto updateOrCreateItem(@RequestBody ItemDto item, @PathVariable UUID id) throws Exception {
        return service.updateOrCreateItem(item, id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) throws Exception {
        service.deleteItem(id);
    }
}
