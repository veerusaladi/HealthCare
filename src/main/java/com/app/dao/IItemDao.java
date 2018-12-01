package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDao {
public int saveItem(Item item);
public void updateItem(Item item);
public void deleteItem(int id);
public Item getOneItemById(int id);
public List<Item> getAllItems();
}
