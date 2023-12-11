package items.entitiesDto;

import java.util.UUID;

public class ItemDto {

    private UUID id;
    private String list;
    private Object item;

    public ItemDto() {
    }

    public ItemDto(UUID id, String list, Object item) {
        this.id = id;
        this.list = list;
        this.item = item;
    }

    public ItemDto(String list, Object item) {
        this.list = list;
        this.item = item;
    }

    public UUID getId() {
        return id;
    }

    public String getList() {
        return list;
    }

    public Object getItem() {
        return item;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setList(String list) {
        this.list = list;
    }

    public void setItem(Object value) {
        this.item = value;
    }

}
